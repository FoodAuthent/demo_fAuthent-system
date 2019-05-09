package org.foodauthent.data;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.foodauthent.rest.client.FASystemClient.files;
import static org.foodauthent.rest.client.FASystemClient.fingerprints;
import static org.foodauthent.rest.client.FASystemClient.handleResp;
import static org.foodauthent.rest.client.FASystemClient.products;
import static org.foodauthent.rest.client.FASystemClient.samples;
import static org.foodauthent.rest.client.FASystemClient.uploadFileData;
import static org.foodauthent.rest.client.FASystemClient.workflows;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintType;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.Product;
import org.foodauthent.model.Sample;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.foodauthent.rest.client.FASystemClient;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class PopulateModels {
    
    private PopulateModels() {
	//utility class
    }
    
    /**
     * 
     * @param fingerprints
     * @return the new fa-ids in the same order as the provided fingerprints
     */
    public static List<UUID> populateFingerprints(List<Fingerprint> fingerprints) {
	return fingerprints.stream().map(f -> fingerprints().createFingerprint(f).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
    
    public static List<UUID> populateFingerprintSets(List<FingerprintSet> fingerprintSets) {
	return fingerprintSets.stream().map(f -> fingerprints().createFingerprintSet(f).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
    
    public static List<UUID> populateRandomProducts(int numProducts) {
	return IntStream.range(0, numProducts).mapToObj(i -> {
	    Product p = Product.builder().setBrand(randomAlphabetic(5)).setGtin(randomAlphabetic(5))
		    .setComment(randomAlphabetic(5)).setCompanyName(randomAlphabetic(5)).build();
	    return products().createProduct(p).readEntity(UUID.class);
	}).collect(Collectors.toList());
    }
    
    /**
     * 
     * @param products
     * @return the new fa-ids in the same order as the provided products
     */
    public static List<UUID> populateProducts(List<Product> products) {
	return products.stream().map(p -> products().createProduct(p).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
    
    /**
     * @param  samples
     * @return the new fa-ids in the same order as the provided samples 
     */
    public static List<UUID> populateSamples(List<Sample> samples) {
	return samples.stream().map(s -> samples().createSample(s).readEntity(UUID.class)).collect(Collectors.toList());
    }
    
    public static UUID populateTestTrainingWorkflow() {
	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("TrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = files().createFileMetadata(fileMeta).readEntity(UUID.class);
	uploadFileData(fileId, new File("files/workflows/TrainingWorkflow.knwf"));

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("train_param1").setRequired(false)
		.setValue("train_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("train_param2").setRequired(true)
		.setValue("train_paramValue2").setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
		.build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build()).build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB).setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME).setInputTypes(inputTypes).setOutputTypes(outputTypes)
		.build(); // TODO set more (or even all) properties
	return workflows().createWorkflow(wf).readEntity(UUID.class);
    }
    
    public static UUID populateTestPedictionWorkflow() {
        // upload workflow file
        FileMetadata fileMeta = FileMetadata.builder().setName("PredictionWorkflow").setDate(LocalDate.now())
        	.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
        	.setVersion(0).build();
        UUID fileId = files().createFileMetadata(fileMeta).readEntity(UUID.class);
        uploadFileData(fileId, new File("files/workflows/PredictionWorkflow.knwf"));
	
	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("pred_param1").setRequired(false)
		.setValue("pred_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("pred_param2").setRequired(true)
		.setValue("pred_paramValue2").setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
		.build();
	Workflow wf = Workflow.builder().setName("my_prediction_workflow").setDescription("desc").setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setFileId(fileId)
		.build(); // TODO set more (or even all) properties
	
	return workflows().createWorkflow(wf).readEntity(UUID.class);
    }
    
    public static UUID populateTrainingWorkflowOpenChromRandomForest() {
	String workflowName = "TrainingWorkflow_OpenChrom_RandomForest";
	String workflowDesc = "Training workflow that uses OpenChrom to read and preprocess the signals and a random forest to learn the model.";
	
        // upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName(workflowName)
		.setDate(LocalDate.now())
		.setDescription(workflowDesc)
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW).setVersion(0).build();
	       UUID fileId = files().createFileMetadata(fileMeta).readEntity(UUID.class);
        uploadFileData(fileId, new File("files/workflows/TrainingWorkflow_OpenChrom_RandomForest.knwf"));
	
	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("binning_min_ppm").setRequired(true)
		.setValue(".018").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("binning_max_ppm").setRequired(true)
		.setValue("10.5").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp3 = WorkflowParameter.builder().setName("binning_width_ppm").setRequired(true)
		.setValue(".0002").setType(TypeEnum.NUMBER).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build()).build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_RANDOM_FOREST).build()).build();
	Workflow wf = Workflow.builder().setName(workflowName).setDescription(workflowDesc).setParameters(asList(wfp1, wfp2, wfp3))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setOutputTypes(outputTypes)
		.setFileId(fileId)
		.build();
	
	return workflows().createWorkflow(wf).readEntity(UUID.class);
    }
    
    public static UUID train(UUID workflowId, List<UUID> fingerprintsetIds) {
	return handleResp(workflows().createTrainingJob(workflowId, fingerprintsetIds, false), TrainingJob.class)
		.getModelId();
    }

    public static UUID predict(UUID workflowId, UUID fingerprintsetId, UUID modelId) {
	return handleResp(workflows().createPredictionJob(workflowId, fingerprintsetId, modelId, false),
		PredictionJob.class).getPredictionId();
    }

}
