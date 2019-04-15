package org.foodauthent.impl.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.fakx.Archive;
import org.foodauthent.fakx.FAKX;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.FaObjectSet.FaObjectSetBuilder;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Tag;
import org.foodauthent.model.Workflow;

public class FakxImporter implements Importer {

    private final PersistenceService service;

    public FakxImporter(PersistenceService service) {
	this.service = service;
    }

    @Override
    public FaObjectSet importData(InputStream stream) {

	FaObjectSetBuilder builder = FaObjectSet.builder();

	try {
	    Archive archive = FAKX.read(stream);
	    
	    // Save data in FoodAuthent
	    archive.getSOP().forEach(service::save);
	    archive.getProduct().forEach(service::save);
	    archive.getMetadata().forEach(service::save);
	    archive.getTag().forEach(service::save);
	    archive.getModel().forEach(service::save);
	    archive.getPrediction().forEach(service::save);
	    archive.getWorkflow().forEach(service::save);
	    archive.getFingerprint().forEach(service::save);
	    archive.getFingerprintSet().forEach(service::save);
	    // TODO: files

	    // Collect ids in a FaObjectSet
	    if (!archive.getSOP().isEmpty()) {
		builder.setSops(archive.getSOP().stream().map(SOP::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getProduct().isEmpty()) {
		builder.setProducts(archive.getProduct().stream().map(Product::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getMetadata().isEmpty()) {
		builder.setMetadata(
			archive.getMetadata().stream().map(FileMetadata::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getTag().isEmpty()) {
		builder.setTags(archive.getTag().stream().map(Tag::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getModel().isEmpty()) {
		builder.setModels(archive.getModel().stream().map(Model::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getPrediction().isEmpty()) {
		builder.setPredictions(
			archive.getPrediction().stream().map(Prediction::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getWorkflow().isEmpty()) {
		builder.setWorkflows(
			archive.getWorkflow().stream().map(Workflow::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getFingerprint().isEmpty()) {
		builder.setFingerprints(
			archive.getFingerprint().stream().map(Fingerprint::getFaId).collect(Collectors.toList()));
	    }

	    if (!archive.getFingerprintSet().isEmpty()) {
		builder.setFingerprintsets(
			archive.getFingerprintSet().stream().map(FingerprintSet::getFaId).collect(Collectors.toList()));
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return builder.build();
    }
}
