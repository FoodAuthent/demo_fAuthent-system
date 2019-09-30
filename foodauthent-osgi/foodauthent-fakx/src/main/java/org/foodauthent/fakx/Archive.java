package org.foodauthent.fakx;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Tag;
import org.foodauthent.model.Workflow;

public class Archive {

	private List<SOP> sop;
	private List<Product> product;
	private List<FileMetadata> metadata;
	private List<Tag> tag;
	private List<Model> model;
	private List<Prediction> prediction;
	private List<Workflow> workflow;
	private List<Fingerprint> fingerprint;
	private List<FingerprintSet> fingerprintset;
	private List<Path> files;
	private List<Blob> rawFiles;

	private Archive() {
	}

	public SOP getSOP(UUID uuid) {
		return sop.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<SOP> getSOP() {
		return sop;
	}

	public Product getProduct(UUID uuid) {
		return product.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<Product> getProduct() {
		return product;
	}

	public FileMetadata getMetadata(UUID uuid) {
		return metadata.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<FileMetadata> getMetadata() {
		return metadata;
	}

	public Tag getTag(UUID uuid) {
		return tag.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<Tag> getTag() {
		return tag;
	}

	public Model getModel(UUID uuid) {
		return model.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<Model> getModel() {
		return model;
	}

	public Prediction getPrediction(UUID uuid) {
		return prediction.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<Prediction> getPrediction() {
		return prediction;
	}

	public Workflow getWorkflow(UUID uuid) {
		return workflow.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<Workflow> getWorkflow() {
		return workflow;
	}

	public Fingerprint getFingerprint(UUID uuid) {
		return fingerprint.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<Fingerprint> getFingerprint() {
		return fingerprint;
	}

	public FingerprintSet getFingerprintSet(UUID uuid) {
		return fingerprintset.stream().filter(it -> it.getFaId().equals(uuid)).findFirst().orElse(null);
	}

	public List<FingerprintSet> getFingerprintSet() {
		return fingerprintset;
	}

	public Path getFile(UUID uuid) {
		// Files are named with their UUID in fAuthent
		return files.stream().map(Path::getFileName).filter(it -> it.equals(uuid)).findFirst().orElse(null);
	}

	public List<Path> getFile() {
		return files;
	}
	
	public Blob getRawFile(UUID uuid) {
		// Files are named with their UUID in fAuthent
		return rawFiles.stream().filter(it -> it.equals(uuid)).findFirst().orElse(null);
	}

	public List<Blob> getRawFile() {
		return rawFiles;
	}

	public static class Builder {

		private List<SOP> sop = new ArrayList<>();
		private List<Product> product = new ArrayList<>();
		private List<FileMetadata> metadata = new ArrayList<>();
		private List<Tag> tag = new ArrayList<>();
		private List<Model> model = new ArrayList<>();
		private List<Prediction> prediction = new ArrayList<>();
		private List<Workflow> workflow = new ArrayList<>();
		private List<Fingerprint> fingerprint = new ArrayList<>();
		private List<FingerprintSet> fingerprintset = new ArrayList<>();
		private List<Path> files = new ArrayList<>();
		private List<Blob> rawFiles = new ArrayList<>();

		public Builder sop(List<SOP> sop) {
			this.sop = sop;
			return this;
		}

		public Builder product(List<Product> product) {
			this.product = product;
			return this;
		}

		public Builder metadata(List<FileMetadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder files(List<Path> files) {
			this.files = files;
			return this;
		}
		
		public Builder rawFiles(List<Blob> rawFiles) {
			this.rawFiles = rawFiles;
			return this;
		}

		public Builder tag(List<Tag> tag) {
			this.tag = tag;
			return this;
		}

		public Builder model(List<Model> model) {
			this.model = model;
			return this;
		}

		public Builder prediction(List<Prediction> prediction) {
			this.prediction = prediction;
			return this;
		}

		public Builder workflow(List<Workflow> workflow) {
			this.workflow = workflow;
			return this;
		}

		public Builder fingerprint(List<Fingerprint> fingerprint) {
			this.fingerprint = fingerprint;
			return this;
		}

		public Builder fingerprintset(List<FingerprintSet> fingerprintset) {
			this.fingerprintset = fingerprintset;
			return this;
		}

		public Archive build() {
			Archive archive = new Archive();
			archive.sop = sop;
			archive.product = product;
			archive.metadata = metadata;
			archive.files = files;
			archive.rawFiles = rawFiles;
			archive.tag = tag;
			archive.model = model;
			archive.prediction = prediction;
			archive.workflow = workflow;
			archive.fingerprint = fingerprint;
			archive.fingerprintset = fingerprintset;

			return archive;
		}
	}
}
