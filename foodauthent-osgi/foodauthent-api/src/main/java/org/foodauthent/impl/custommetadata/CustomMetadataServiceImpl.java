package org.foodauthent.impl.custommetadata;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.foodauthent.api.CustomMetadataService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 */
@Component(service = CustomMetadataService.class)
public class CustomMetadataServiceImpl implements CustomMetadataService {

    private PersistenceService persistenceService;

    private ObjectMapper mapper = new ObjectMapper();

    public CustomMetadataServiceImpl() {
    }

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	this.persistenceService = persistenceService;
    }

    @Override
    public String getCustomMetadata(String modelId, String schemaId, UUID faId) {
	// TODO check returned type/schema id
	JsonNode jsonNode = persistenceService.getCustomModelByUUID(faId);
	try {
	    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
	} catch (JsonProcessingException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    @Override
    public String getCustomMetadataSchema(String modelId, String schemaId) {
	URL url = this.getClass().getResource("/json-schemas/" + modelId + "/" + schemaId + ".json");
	try {
	    return IOUtils.toString(url, StandardCharsets.UTF_8);
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<String> getCustomMetadataSchemas(String modelId) {
	URL url = this.getClass().getResource("/json-schemas/" + modelId + "/registry.json");
	try {
	    return mapper.readValue(url.openStream(), List.class);
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    @Override
    public void saveCustomMetadata(String modelId, String schemaId, UUID faId, String body) {
	JsonNode jsonNode;
	try {
	    jsonNode = mapper.readTree(body);
	    persistenceService.saveCustomModel(jsonNode, schemaId);
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

}
