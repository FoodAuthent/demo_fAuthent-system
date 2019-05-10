package org.foodauthent.test;

import static java.util.Arrays.asList;
import static org.foodauthent.rest.client.FASystemClient.entities;
import static org.foodauthent.rest.client.FASystemClient.files;
import static org.foodauthent.rest.client.FASystemClient.fingerprints;
import static org.foodauthent.rest.client.FASystemClient.handleResp;
import static org.foodauthent.rest.client.FASystemClient.models;
import static org.foodauthent.rest.client.FASystemClient.products;
import static org.foodauthent.rest.client.FASystemClient.samples;
import static org.foodauthent.rest.client.FASystemClient.uploadFileData;
import static org.foodauthent.rest.client.FASystemClient.workflows;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintType;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.Product;
import org.foodauthent.model.Sample;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.Workflow.WorkflowBuilder;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowPageResult;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.foodauthent.rest.client.FASystemClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */

public class WorkflowTest extends AbstractITTest {
    
    @Before
    public void clearAllWorkflows() {
	List<Workflow> workflows = workflows().findWorkflowByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(WorkflowPageResult.class).getResults();
	workflows.stream().forEach(wf -> entities().removeEntity(wf.getFaId()));
    }

    @Test
    public void testUploadAndRunPredictionWorkflow() throws InterruptedException {
	UUID wfId = uploadPredictionWorkflow();
	UUID fingerprintSetId = uploadFingerprintSets().get(0);
	UUID modelId = uploadModel();

	/* run prediction workflow */
	PredictionJob predictionJob = handleResp(workflows().createPredictionJob(wfId, fingerprintSetId, modelId, true),
		PredictionJob.class);
	assertEquals(StatusEnum.RUNNING, predictionJob.getStatus());
	// let the job finish the prediction
	Thread.sleep(2000);

	/* retrieve prediction result */
	predictionJob = workflows().getPredictionJob(predictionJob.getFaId()).readEntity(PredictionJob.class);
	assertEquals("Execution failed: " + predictionJob.getStatusMessage(), StatusEnum.SUCCESS,
		predictionJob.getStatus());
	Prediction prediction = workflows().getPredictionResult(predictionJob.getPredictionId())
		.readEntity(Prediction.class);
	assertEquals(prediction.getPredictionMap().size(), 2);
	
	/* retrieve prediction by fingerprintset-id */
	PredictionPageResult predictionPage = handleResp(
		workflows().findPredictionByKeyword(1, 10, Arrays.asList(fingerprintSetId.toString())),
		PredictionPageResult.class);
	assertThat("exactly one entry expected", predictionPage.getResultCount(), is(1));
	assertThat("unexpected prediction", predictionPage.getResults().get(0), is(prediction));

	predictionPage = workflows()
		.findPredictionsByFingerprintSetId(fingerprintSetId, 1, 10, Collections.emptyList())
		.readEntity(PredictionPageResult.class);
	assertThat(predictionPage.getResultCount(), is(1));
	predictionPage = workflows().findPredictionsByFingerprintSetId(fingerprintSetId, 1, 10, asList("blub"))
		.readEntity(PredictionPageResult.class);
	assertThat(predictionPage.getResultCount(), is(0));
    }
    
    private UUID uploadPredictionWorkflow() {
	UUID predictionWorkflowFileId = uploadPredictionWorkflowFile();

	// upload workflow metadata
	// TODO make workflow fail when some parameters are not provided (and test that
	// they fail)
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("pred_param1").setRequired(false)
		.setValue("pred_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("pred_param2").setRequired(true)
		.setValue("pred_paramValue2").setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build()).build();
	Workflow wf = Workflow.builder().setName("my_prediction_workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME).setInputTypes(inputTypes)
		.setFileId(predictionWorkflowFileId).build(); // TODO set more (or even all) properties

	return workflows().createWorkflow(wf).readEntity(UUID.class);
    }
   
    private UUID uploadPredictionWorkflowFile() {
        
        // upload workflow file
        FileMetadata fileMeta = FileMetadata.builder().setName("PredictionWorkflow").setDate(LocalDate.now())
        	.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
        	.setVersion(0).build();
	UUID predictionWorkflowFileId = files().createFileMetadata(fileMeta).readEntity(UUID.class);
	Response response = FASystemClient.uploadFileData(fileMeta.getFaId(),
		new File("files/workflows/PredictionWorkflow.knwf"));
	assertEquals(200, response.getStatus());
	return predictionWorkflowFileId;
    }

    @Test
    public void testFailInitPredictionWorkflow() {
	
	UUID predictionWorkflowFileId = uploadPredictionWorkflowFile();
	UUID fingerprintSetId = uploadFingerprintSets().get(0);
	ModelType modelType = ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build();
	Model m = Model.builder().setName("mymodel").setType(modelType).build();
	UUID modelId = models().createModel(m).readEntity(UUID.class);
	
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
		.build();
	WorkflowBuilder wfb = Workflow.builder().setName("inconsistent_prediction_workflow").setDescription("desc")
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		//on purpose not a knime workflow
		.setRepresentation(RepresentationEnum.CWL)
		.setInputTypes(inputTypes)
		.setFileId(predictionWorkflowFileId);
	
	//post workflow
	UUID wfId = workflows().createWorkflow(wfb.build()).readEntity(UUID.class);

	// try to run prediction job
	Response response = workflows().createPredictionJob(wfId, fingerprintSetId, modelId, true);
	assertEquals("Unexpected status code", 500, response.getStatus());
	String message = response.readEntity(String.class);
	assertTrue(message.contains("not a knime workflow"));
	//TODO use 'assertThat' instead!
	
	//wrong type
	wfb.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB);
	//post workflow
	wfId = workflows().createWorkflow(wfb.build()).readEntity(UUID.class);
	
	// try to run prediction job
	response = workflows().createPredictionJob(wfId, fingerprintSetId, modelId, true);
	assertEquals("Unexpected status code", 500, response.getStatus());
	message = response.readEntity(String.class);
	assertTrue(message.contains("not a prediction workflow"));
	
	//no model file
	wfb.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME);
	// post workflow
	wfId = workflows().createWorkflow(wfb.build()).readEntity(UUID.class);

	// try to run prediction job
	response = workflows().createPredictionJob(wfId, fingerprintSetId, modelId, true);
	assertEquals("Unexpected status code", 500, response.getStatus());
	message = response.readEntity(String.class);
	assertTrue(message.contains("No model file found"));

    } 
    
    @Test
    public void testRunPredictionWorkflowSynchronously() {
	UUID wfId = uploadPredictionWorkflow();
	UUID fingerprintSetId = uploadFingerprintSets().get(0);
	UUID modelId = uploadModel();

	PredictionJob predictionJob = handleResp(
		workflows().createPredictionJob(wfId, fingerprintSetId, modelId, false), PredictionJob.class);
	assertEquals(StatusEnum.SUCCESS, predictionJob.getStatus());
    }
    
    @Test
    public void testUploadAndRunTrainingWorkflow() throws InterruptedException {

	/* upload workflow */
	
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
		.setValue("train_paramValue2")	.setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
		.build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB)
		.setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setOutputTypes(outputTypes)
		.build(); // TODO set more (or even all) properties
	UUID wfId = workflows().createWorkflow(wf).readEntity(UUID.class);
	
	List<UUID> fingerprintSetIds = uploadFingerprintSets();

	/* run training workflow */
	TrainingJob trainingJob = handleResp(workflows().createTrainingJob(wfId, fingerprintSetIds, true), TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(2000);

	/* retrieve training result */
	trainingJob = workflows().getTrainingJob(trainingJob.getFaId()).readEntity(TrainingJob.class);
	assertEquals("Execution failed: " + trainingJob.getStatusMessage(),
		org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = models().getModelById(trainingJob.getModelId()).readEntity(Model.class);
	assertEquals(model.getType().getName(), ModelType.NameEnum.KNIME_WORKFLOW);
    }

    private List<UUID> uploadFingerprintSets() {
        
        //upload product
        Product p = Product.builder().setBrand("my_product").setGtin("1234").build();
        UUID productId = products().createProduct(p).readEntity(UUID.class);
        
        //upload sample
        Sample s = Sample.builder().setProductId(productId).build();
        UUID sampleId = samples().createSample(s).readEntity(UUID.class);
        
        //upload fingerprint files
	FileMetadata fpFile1 = FileMetadata.builder().setName("fingerprint1")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	files().createFileMetadata(fpFile1);
	uploadFileData(fpFile1.getFaId(), new File("files/fingerprints/fp1.zip"));
	FileMetadata fpFile2 = FileMetadata.builder().setName("fingerprint2")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	files().createFileMetadata(fpFile2);
	uploadFileData(fpFile2.getFaId(), new File("files/fingerprints/fp2.zip"));
	FileMetadata fpFile3 = FileMetadata.builder().setName("fingerprint3")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	files().createFileMetadata(fpFile3);
	uploadFileData(fpFile3.getFaId(), new File("files/fingerprints/fp3.zip"));

 
	//upload fingerprints
	Fingerprint fp1 = Fingerprint.builder().setSampleId(sampleId).setFileId(fpFile1.getFaId()).build();
	fingerprints().createFingerprint(fp1);
	Fingerprint fp2 = Fingerprint.builder().setSampleId(sampleId).setFileId(fpFile2.getFaId()).build();
	fingerprints().createFingerprint(fp2);
	Fingerprint fp3 = Fingerprint.builder().setSampleId(sampleId).setFileId(fpFile3.getFaId()).build();
	fingerprints().createFingerprint(fp3);
     
        // upload fingerprint sets
	FingerprintSet fps = FingerprintSet.builder().setName("myset1")
		.setFingerprintIds(Arrays.asList(fp1.getFaId(), fp2.getFaId())).setClassLabel("label1").build();
	FingerprintSet fps2 = FingerprintSet.builder().setName("myset2").setFingerprintIds(Arrays.asList(fp3.getFaId()))
		.setClassLabel("label2").build();
	return asList(fingerprints().createFingerprintSet(fps).readEntity(UUID.class),
		fingerprints().createFingerprintSet(fps2).readEntity(UUID.class));
    }
    
    @Test
    public void testFindWorkflows() {
	Workflow wf1 = Workflow.builder().setDescription("desc1").setName("wf1name")
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME).setFileId(UUID.randomUUID()).build();
	Workflow wf2 = Workflow.builder().setDescription("desc2").setName("wf2name")
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW_E680F8C1)
		.setRepresentation(RepresentationEnum.KNIME).setFileId(UUID.randomUUID()).build();
	Workflow wf3 = Workflow.builder().setDescription("desc3").setName("wf3name")
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB)
		.setRepresentation(RepresentationEnum.KNIME).setFileId(UUID.randomUUID()).build();
	Workflow wf4 = Workflow.builder().setDescription("desc4").setName("wf4name")
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB)
		.setRepresentation(RepresentationEnum.KNIME).setFileId(UUID.randomUUID()).build();

	workflows().createWorkflow(wf1);
	workflows().createWorkflow(wf2);
	workflows().createWorkflow(wf3);
	workflows().createWorkflow(wf4);
	
	WorkflowPageResult wfPage = workflows().findPredictionWorkflows(1, 10, Collections.emptyList())
		.readEntity(WorkflowPageResult.class);
	assertThat(wfPage.getResultCount(), is(2));
	
	wfPage = workflows().findPredictionWorkflows(1, 10, asList("wf1"))
		.readEntity(WorkflowPageResult.class);
	assertThat(wfPage.getResultCount(), is(1));
	
	wfPage = workflows().findPredictionWorkflows(1, 10, asList("wf1blub"))
		.readEntity(WorkflowPageResult.class);
	assertThat(wfPage.getResultCount(), is(0));

	wfPage = workflows().findPredictionWorkflows(1, 10, asList("wf1", "desc2", "desc3"))
		.readEntity(WorkflowPageResult.class);
	assertThat(wfPage.getResultCount(), is(2));
	
	wfPage = workflows().findTrainingWorkflows(1, 10, asList("wf3"))
		.readEntity(WorkflowPageResult.class);
	assertThat(wfPage.getResultCount(), is(1));
    }

    private UUID uploadModel() {
	// upload model file
        FileMetadata fileMeta = FileMetadata.builder().setName("dummy_model").setDate(LocalDate.now())
        	.setDescription("a non-sense model for testing").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_MODEL)
        	.setVersion(0).build();
	UUID modelFileId = files().createFileMetadata(fileMeta).readEntity(UUID.class);
	Response response = FASystemClient.uploadFileData(fileMeta.getFaId(),
		new File("files/models/dummy_model"));
	assertEquals(200, response.getStatus());
	
	/* upload model */
	ModelType modelType = ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build();
	Model m = Model.builder().setName("mymodel").setType(modelType).setFileId(modelFileId).build();
	return models().createModel(m).readEntity(UUID.class);
    }

}
