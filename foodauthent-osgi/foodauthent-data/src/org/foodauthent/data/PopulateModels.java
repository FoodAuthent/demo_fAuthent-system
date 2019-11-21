package org.foodauthent.data;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.foodauthent.rest.client.FASystemClientUtil.files;
import static org.foodauthent.rest.client.FASystemClientUtil.fingerprints;
import static org.foodauthent.rest.client.FASystemClientUtil.handleResp;
import static org.foodauthent.rest.client.FASystemClientUtil.products;
import static org.foodauthent.rest.client.FASystemClientUtil.samples;
import static org.foodauthent.rest.client.FASystemClientUtil.uploadFileData;
import static org.foodauthent.rest.client.FASystemClientUtil.workflows;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintType;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.ModelType.NameEnum;
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
    public static List<UUID> populateFingerprints(List<Fingerprint> fingerprints, FASystemClient c) {
	return fingerprints.stream().map(f -> fingerprints(c).createFingerprint(f).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
    
    public static List<UUID> populateFingerprintSets(Collection<FingerprintSet> fingerprintSets, FASystemClient c) {
	return fingerprintSets.stream().map(f -> fingerprints(c).createFingerprintSet(f).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
    
    public static List<UUID> populateRandomProducts(int numProducts, FASystemClient c) {
	return IntStream.range(0, numProducts).mapToObj(i -> {
	    Product p = Product.builder().setBrand(randomAlphabetic(5)).setGtin(randomAlphabetic(5))
		    .setComment(randomAlphabetic(5)).setCompanyName(randomAlphabetic(5)).build();
	    return products(c).createProduct(p).readEntity(UUID.class);
	}).collect(Collectors.toList());
    }
    
    /**
     * 
     * @param products
     * @return the new fa-ids in the same order as the provided products
     */
    public static List<UUID> populateProducts(List<Product> products, FASystemClient c) {
	return products.stream().map(p -> products(c).createProduct(p).readEntity(UUID.class))
		.collect(Collectors.toList());
    }
    
    /**
     * @param  samples
     * @return the new fa-ids in the same order as the provided samples 
     */
    public static List<UUID> populateSamples(List<Sample> samples, FASystemClient c) {
	return samples.stream().map(s -> samples(c).createSample(s).readEntity(UUID.class)).collect(Collectors.toList());
    }
   
    /**
     * 
     * @param c
     * @param signalType
     *            type of signal to be read in - 'fid' to read the raw signal (which
     *            then gets processed), anything else to read in the already
     *            pre-processed signal
     * @return
     */
    public static UUID populateTrainingWorkflowOpenChromRandomForest(FASystemClient c, String signalType) {
	String workflowName = "TrainingWorkflow_OpenChrom_RandomForest";
	String workflowDesc = "Training workflow that uses OpenChrom to read and preprocess the signals and a random forest to learn the model.";
	
        // upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName(workflowName)
		.setDate(LocalDate.now())
		.setDescription(workflowDesc)
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW).setVersion(0).build();
	       UUID fileId = files(c).createFileMetadata(fileMeta).readEntity(UUID.class);
        uploadFileData(fileId, new File("files/workflows/TrainingWorkflow_OpenChrom_RandomForest.knwf"), c);
	
	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("binning_min_ppm").setRequired(true)
		.setValue(".018").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("binning_max_ppm").setRequired(true)
		.setValue("10.5").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp3 = WorkflowParameter.builder().setName("binning_width_ppm").setRequired(true)
		.setValue(".0002").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp4 = WorkflowParameter.builder().setName("signal_type").setRequired(true)
		.setValue(signalType).setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build()).build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_RANDOM_FOREST).build()).build();
	Workflow wf = Workflow.builder().setName(workflowName).setDescription(workflowDesc).setParameters(asList(wfp1, wfp2, wfp3, wfp4))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setOutputTypes(outputTypes)
		.setFileId(fileId)
		.build();
	
	return workflows(c).createWorkflow(wf).readEntity(UUID.class);
    }
    
    /**
     * 
     * @param c
     * @param signalType
     *            type of signal to be read in - 'fid' to read the raw signal (which
     *            then gets processed), anything else to read in the already
     *            pre-processed signal
     * @return
     */
    public static UUID populatePredictionWorkflowOpenChromRandomForest(FASystemClient c, String signalType) {
	String workflowName = "PredictionWorkflow_OpenChrom_RandomForest";
	String workflowDesc = "Prediction workflow that uses OpenChrom to read and preprocess the signals and a random forest for the actual prediction.";
	
        // upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName(workflowName)
		.setDate(LocalDate.now())
		.setDescription(workflowDesc)
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW).setVersion(0).build();
	       UUID fileId = files(c).createFileMetadata(fileMeta).readEntity(UUID.class);
        uploadFileData(fileId, new File("files/workflows/PredictionWorkflow_OpenChrom_RandomForest.knwf"), c);
	
	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("binning_min_ppm").setRequired(true)
		.setValue(".018").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("binning_max_ppm").setRequired(true)
		.setValue("10.5").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp3 = WorkflowParameter.builder().setName("binning_width_ppm").setRequired(true)
		.setValue(".0002").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp4 = WorkflowParameter.builder().setName("signal_type").setRequired(true)
		.setValue(signalType).setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
		.setModelType(ModelType.builder().setName(NameEnum.KNIME_RANDOM_FOREST).build()).build();
	Workflow wf = Workflow.builder().setName(workflowName).setDescription(workflowDesc).setParameters(asList(wfp1, wfp2, wfp3, wfp4))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setFileId(fileId)
		.build();
	
	return workflows(c).createWorkflow(wf).readEntity(UUID.class);
    }
    
    /**
     * 
     * @param c
     * @param signalType
     *            type of signal to be read in - 'fid' to read the raw signal (which
     *            then gets processed), anything else to read in the already
     *            pre-processed signal
     * @return
     */
    public static UUID populateTrainingWorkflowOneClassClassification(FASystemClient c, String signalType) {
	String workflowName = "TrainingWorkflow_OneClassClassification";
	String workflowDesc = "Training workflow that only requires one single class to 'train' a model. Model will be a table of samples.";
	
        // upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName(workflowName)
		.setDate(LocalDate.now())
		.setDescription(workflowDesc)
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW).setVersion(0).build();
	       UUID fileId = files(c).createFileMetadata(fileMeta).readEntity(UUID.class);
        uploadFileData(fileId, new File("files/workflows/TrainingWorkflow_OneClassClassification.knwf"), c);
	
	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("binning_min_ppm").setRequired(true)
		.setValue(".018").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("binning_max_ppm").setRequired(true)
		.setValue("10.5").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp3 = WorkflowParameter.builder().setName("binning_width_ppm").setRequired(true)
		.setValue(".0002").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp4 = WorkflowParameter.builder().setName("signal_type").setRequired(true)
		.setValue(signalType).setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build()).build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		//actually the wrong type!
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_TABLE).build()).build();
	Workflow wf = Workflow.builder().setName(workflowName).setDescription(workflowDesc)
		.setParameters(asList(wfp1, wfp2, wfp3, wfp4))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setOutputTypes(outputTypes)
		.setFileId(fileId)
		.build();
	
	return workflows(c).createWorkflow(wf).readEntity(UUID.class);
    }
    
    /**
     * 
     * @param c
     * @param signalType
     *            type of signal to be read in - 'fid' to read the raw signal (which
     *            then gets processed), anything else to read in the already
     *            pre-processed signal
     * @return
     */
    public static UUID populatePredictionWorkflowOneClassClassification(FASystemClient c, String signalType) {
	String workflowName = "PredictionWorkflow_OneClassClassification";
	String workflowDesc = "Prediction workflow that uses a simple kNN one-class-classification to differentiate inliers and outliers.";

	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName(workflowName).setDate(LocalDate.now())
		.setDescription(workflowDesc).setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = files(c).createFileMetadata(fileMeta).readEntity(UUID.class);
	uploadFileData(fileId, new File("files/workflows/PredictionWorkflow_OneClassClassification.knwf"), c);

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("binning_min_ppm").setRequired(true)
		.setValue(".018").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("binning_max_ppm").setRequired(true)
		.setValue("10.5").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp3 = WorkflowParameter.builder().setName("binning_width_ppm").setRequired(true)
		.setValue(".0002").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp4 = WorkflowParameter.builder().setName("signal_type").setRequired(true)
		.setValue(signalType).setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
		.setModelType(ModelType.builder().setName(NameEnum.KNIME_TABLE).build()).build();
	Workflow wf = Workflow.builder().setName(workflowName).setDescription(workflowDesc)
		.setParameters(asList(wfp1, wfp2, wfp3, wfp4))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME).setInputTypes(inputTypes).setFileId(fileId).build();

	return workflows(c).createWorkflow(wf).readEntity(UUID.class);
    }
   
    public static UUID train(UUID workflowId, List<UUID> fingerprintsetIds, FASystemClient c, boolean async) {
	return handleResp(workflows(c).createTrainingJob(workflowId, fingerprintsetIds, async), TrainingJob.class)
		.getModelId();
    }

    public static UUID predict(UUID workflowId, UUID fingerprintsetId, UUID modelId, FASystemClient c) {
	return handleResp(workflows(c).createPredictionJob(workflowId, fingerprintsetId, modelId, false),
		PredictionJob.class).getPredictionId();
    }

}
