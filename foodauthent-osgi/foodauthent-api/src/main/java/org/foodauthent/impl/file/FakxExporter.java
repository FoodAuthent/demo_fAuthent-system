package org.foodauthent.impl.file;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.fakx.Archive;
import org.foodauthent.fakx.FAKX;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Tag;
import org.foodauthent.model.Workflow;

public class FakxExporter implements Exporter {

    private final PersistenceService service;

    public FakxExporter(PersistenceService service) {
	this.service = service;
    }

    @Override
    public void export(FaObjectSet objectSet, File file) {

	// 1. Retrieve metadata by ID

	Set<UUID> sopId = new LinkedHashSet<>(objectSet.getSops());
	Set<UUID> productId = new LinkedHashSet<>(objectSet.getProducts());
	Set<UUID> metadataId = new LinkedHashSet<>(objectSet.getMetadata());
	Set<UUID> tagId = new LinkedHashSet<>(objectSet.getTags());
	Set<UUID> modelId = new LinkedHashSet<>(objectSet.getModels());
	Set<UUID> predictionId = new LinkedHashSet<>(objectSet.getPredictions());
	Set<UUID> workflowId = new LinkedHashSet<>(objectSet.getWorkflows());
	Set<UUID> fingerprintSetId = new LinkedHashSet<>(objectSet.getFingerprintsets());
	Set<UUID> fileId = new LinkedHashSet<>();

	// 1.1 SOP
	for (UUID id : objectSet.getSops()) {
	    SOP sop = service.getFaModelByUUID(id, SOP.class);

	    // Add file reference in sop
	    if (sop.getFileId() != null) {
		fileId.add(sop.getFileId());
	    }

	    // Add product referenced in sop
	    if (sop.getProductId() != null) {
		productId.add(sop.getProductId());
	    }
	}

	// 1.2 Model
	for (UUID id : objectSet.getModels()) {
	    Model model = service.getFaModelByUUID(id, Model.class);

	    if (model.getFileId() != null) {
		fileId.add(model.getFileId());
	    }

	    if (model.getFingerprintsetIds() != null) {
		fingerprintSetId.addAll(model.getFingerprintsetIds());
	    }

	    if (model.getWorkflowId() != null) {
		workflowId.add(model.getWorkflowId());
	    }
	}

	// 1.3 Prediction
	for (UUID id : objectSet.getPredictions()) {
	    Prediction prediction = service.getFaModelByUUID(id, Prediction.class);

	    if (prediction.getWorkflowId() != null) {
		workflowId.add(prediction.getWorkflowId());
	    }

	    if (prediction.getFingerprintsetId() != null) {
		fingerprintSetId.add(prediction.getFingerprintsetId());
	    }

	    if (prediction.getModelId() != null) {
		modelId.add(prediction.getModelId());
	    }
	}

	// 1.4 Workflow
	for (UUID id : objectSet.getWorkflows()) {
	    Workflow workflow = service.getFaModelByUUID(id, Workflow.class);

	    if (workflow.getFileId() != null) {
		fileId.add(workflow.getFileId());
	    }
	}

	// 1.5 FingerprintSet
	for (UUID id : objectSet.getFingerprintsets()) {
	    FingerprintSet fs = service.getFaModelByUUID(id, FingerprintSet.class);
	    //TODO take fingerprint instead/additionally
	}

	// Create Archive con metadatos
	Archive.Builder builder = new Archive.Builder();

	builder.sop(sopId.stream().map(id -> service.getFaModelByUUID(id, SOP.class)).collect(Collectors.toList()));
	builder.product(
		productId.stream().map(id -> service.getFaModelByUUID(id, Product.class)).collect(Collectors.toList()));
	builder.metadata(metadataId.stream().map(id -> service.getFaModelByUUID(id, FileMetadata.class))
		.collect(Collectors.toList()));
	builder.tag(tagId.stream().map(id -> service.getFaModelByUUID(id, Tag.class)).collect(Collectors.toList()));
	builder.model(
		modelId.stream().map(id -> service.getFaModelByUUID(id, Model.class)).collect(Collectors.toList()));
	builder.prediction(predictionId.stream().map(id -> service.getFaModelByUUID(id, Prediction.class))
		.collect(Collectors.toList()));
	/*
	builder.fingerprintset(fingerprintSetId.stream().map(id -> service.getFaModelByUUID(id, FingerprintSet.class))
		.collect(Collectors.toList()));
		*/

	Archive archive = builder.build();
	
	try {
	    FAKX.write(archive, file.toPath());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
