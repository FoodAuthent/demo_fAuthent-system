package org.foodauthent.storage.impl.s3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.foodauthent.config.ConfigurationService;
import org.foodauthent.storage.FileStorageService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foodauthent.digest.DigestUtil;

import io.minio.MinioClient;
import io.minio.ObjectStat;

@Component(service = FileStorageService.class)
public class FileStorageServiceImpl implements FileStorageService {

	public String SHA256_KEY = "X-SHA256";

	private MinioClient client;

	private String bucketName = "fa-storage";

	public static String DEFAULT_CONTENT_TYPE = "application/octet-stream";

	public static final String CONFIG_ROOT = "storage.s3";

	@Reference(service = ConfigurationService.class, bind = "bindConfigurationService", unbind = "unbindConfigurationService")
	private ConfigurationService configurationService;

	private static final Logger LOG = LoggerFactory.getLogger(FileStorageServiceImpl.class);

	public FileStorageServiceImpl() throws Exception {
	}

	@Override
	public void save(UUID id, InputStream in) throws IOException {
		save(id, in, DEFAULT_CONTENT_TYPE);
	}

	@Override
	public void save(UUID id, InputStream in, String contentType) throws IOException {
		try {
			boolean isExist = client.bucketExists(bucketName);
			if (!isExist) {
				client.makeBucket(bucketName);
			}
			final DigestInputStream input = DigestUtil.sha256DigestInputStream(in);
			client.putObject(bucketName, id.toString(), input, contentType);
			final String sha256 = DigestUtil.toHex(input.getMessageDigest());
			client.putObject(bucketName, id.toString() + ".sha256", new ByteArrayInputStream(sha256.getBytes(StandardCharsets.UTF_8)), "text/plain");
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	@Override
	public String getSHA256(UUID id) throws IOException {
		try {
			try {
				final InputStream in = client.getObject(bucketName, id.toString() + ".sha256");
				if (in != null) {
					return IOUtils.toString(in, StandardCharsets.UTF_8);
				}
			} catch (Exception e) {
				LOG.warn(e.getMessage());
			}
			final InputStream file = client.getObject(bucketName, id.toString());
			if (file != null) {
				final DigestInputStream d = DigestUtil.sha256DigestInputStream(file);
				IOUtils.copy(d, new NullOutputStream());
				final String sha256 = DigestUtil.toHex(d.getMessageDigest());
				client.putObject(bucketName, id.toString() + ".sha256", new ByteArrayInputStream(sha256.getBytes(StandardCharsets.UTF_8)), "text/plain");
				return sha256;
			}
		} catch (Exception e) {
			throw new IOException(e);
		}
		return null;
	}

	@Override
	public InputStream load(UUID id) throws IOException {
		try {
			boolean isExist = client.bucketExists(bucketName);
			if (!isExist) {
				throw new IOException("Bucket " + bucketName + " does not exist");
			}
			return client.getObject(bucketName, id.toString());
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	@Override
	public boolean delete(UUID id) throws IOException {
		if (exists(id)) {
			try {
				client.removeObject(bucketName, id.toString());
			} catch (Exception e) {
				throw new IOException(e);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean exists(UUID id) throws IOException {
		try {
			final ObjectStat stat = client.statObject(bucketName, id.toString());
			return stat.name().equals(id.toString());
		} catch (Exception e) {
			return false;
		}
	}

	public void bindConfigurationService(ConfigurationService configurationService) {
		this.configurationService = configurationService;
		final String endpoint = configurationService.getString(CONFIG_ROOT + ".endpoint");
		final String accessKey = configurationService.getString(CONFIG_ROOT + ".accessKey");
		final String secrectKey = configurationService.getString(CONFIG_ROOT + ".secretKey");
		final String bucketName = configurationService.getString(CONFIG_ROOT + ".bucketName");
		this.bucketName = bucketName;
		try {
			this.client = new MinioClient(endpoint, accessKey, secrectKey);
			LOG.info("configured endpoint " + endpoint);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

	}

	public void unbindConfigurationService(ConfigurationService configurationService) {
		this.configurationService = null;
	}

}
