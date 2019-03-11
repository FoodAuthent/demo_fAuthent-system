package org.foodauthent.test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetType;
import org.foodauthent.model.FingerprintSetType.NameEnum;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.Product;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.Workflow.WorkflowBuilder;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.foodauthent.rest.api.service.FileRestService;
import org.foodauthent.rest.api.service.FingerprintRestService;
import org.foodauthent.rest.api.service.ModelRestService;
import org.foodauthent.rest.api.service.ProductRestService;
import org.foodauthent.rest.api.service.WorkflowRestService;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */

public class WorkflowTest extends AbstractITTest {
    
    private WorkflowRestService workflowService = restService(WorkflowRestService.class);
    private WebTarget webTarget = webTarget();
    
    @Test
    public void testUploadAndRunPredictionWorkflow() throws InterruptedException {
	UUID predictionWorkflowFileId = uploadPredictionWorkflowFile();
	UUID fingerprintSetId = uploadFingerprintSet();
	UUID modelId = uploadModel();

	// upload workflow metadata
	//TODO make workflow fail when some parameters are not provided (and test that they fail)
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("pred_param1").setRequired(false)
		.setValue("pred_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("pred_param2").setRequired(true)
		.setValue("pred_paramValue2").setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.setFingerprintsetType(FingerprintSetType.builder().setName(FingerprintSetType.NameEnum.BRUKER).build())
		.build();
	Workflow wf = Workflow.builder().setName("my_prediction_workflow").setDescription("desc").setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setFileId(predictionWorkflowFileId)
		.build(); // TODO set more (or even all) properties
	
	UUID wfId = workflowService.createWorkflow(wf).readEntity(UUID.class);

	/* run prediction workflow */
	Response response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId);
	assertThat("Unexpected server response: " + response.readEntity(String.class), response.getStatus(), is(200));
	PredictionJob predictionJob = response.readEntity(PredictionJob.class);
	assertEquals(StatusEnum.RUNNING, predictionJob.getStatus());
	// let the job finish the prediction
	Thread.sleep(2000);

	/* retrieve prediction result */
	predictionJob = workflowService.getPredictionJob(predictionJob.getFaId()).readEntity(PredictionJob.class);
	assertEquals("Execution failed: " + predictionJob.getStatusMessage(), StatusEnum.SUCCESS,
		predictionJob.getStatus());
	Prediction prediction = workflowService.getPredictionResult(predictionJob.getPredictionId())
		.readEntity(Prediction.class);
	assertEquals(prediction.getConfidenceMap().size(), 1);
    }
    
    @Test
    public void testFailInitPredictionWorkflow() {
	
	UUID predictionWorkflowFileId = uploadPredictionWorkflowFile();
	UUID fingerprintSetId = uploadFingerprintSet();
	UUID modelId = uploadModel();
	
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.setFingerprintsetType(FingerprintSetType.builder().setName(FingerprintSetType.NameEnum.BRUKER).build())
		.build();
	WorkflowBuilder wfb = Workflow.builder().setName("inconsistent_prediction_workflow").setDescription("desc")
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		//on purpose not a knime workflow
		.setRepresentation(RepresentationEnum.CWL)
		.setInputTypes(inputTypes)
		.setFileId(predictionWorkflowFileId);
	
	//post workflow
	UUID wfId = workflowService.createWorkflow(wfb.build()).readEntity(UUID.class);

	// try to run prediction job
	Response response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId);
	assertEquals("Unexpected status code", 500, response.getStatus());
	String message = response.readEntity(String.class);
	assertTrue(message.contains("not a knime workflow"));
	//TODO use 'assertThat' instead!
	
	//wrong type
	wfb.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW);
	//post workflow
	wfId = workflowService.createWorkflow(wfb.build()).readEntity(UUID.class);
	
	// try to run prediction job
	response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId);
	assertEquals("Unexpected status code", 500, response.getStatus());
	message = response.readEntity(String.class);
	assertTrue(message.contains("not a prediction workflow"));
    } 
    
    private UUID uploadPredictionWorkflowFile() {
        
        // upload workflow file
        FileMetadata fileMeta = FileMetadata.builder().setName("PredictionWorkflow").setDate(LocalDate.now())
        	.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
        	.setVersion(0).build();
        UUID predictionWorkflowFileId = webTarget.path("file").request(MediaType.APPLICATION_JSON)
        	.post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON), UUID.class);
	Response response = TestUtils.uploadFileData(webTarget, fileMeta.getFaId(),
		new File("files/workflows/PredictionWorkflow.knwf"));
	assertEquals(200, response.getStatus());
	       return predictionWorkflowFileId;
    }


    @Test
    public void testUploadAndRunTrainingWorkflow() throws InterruptedException {

	/* upload workflow */
	
	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("TrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = restService(FileRestService.class).createFileMetadata(fileMeta).readEntity(UUID.class);
	TestUtils.uploadFileData(webTarget, fileId, new File("files/workflows/TrainingWorkflow.knwf"));

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("train_param1").setRequired(false)
		.setValue("train_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("train_param2").setRequired(true)
		.setValue("train_paramValue2")	.setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setFingerprintsetType(FingerprintSetType.builder().setName(FingerprintSetType.NameEnum.BRUKER).build())
		.build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW)
		.setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setOutputTypes(outputTypes)
		.build(); // TODO set more (or even all) properties
	UUID wfId = workflowService.createWorkflow(wf).readEntity(UUID.class);
	
	UUID fingerprintSetId = uploadFingerprintSet();

	/* run training workflow */
	Response response = workflowService.createTrainingJob(wfId, fingerprintSetId);
	assertThat("Unexpected server response: " + response.readEntity(String.class), response.getStatus(), is(200));
	TrainingJob trainingJob = response.readEntity(TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(2000);

	/* retrieve training result */
	trainingJob = workflowService.getTrainingJob(trainingJob.getFaId()).readEntity(TrainingJob.class);
	assertEquals("Execution failed: " + trainingJob.getStatusMessage(),
		org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = restService(ModelRestService.class).getModelById(trainingJob.getModelId()).readEntity(Model.class);
	assertEquals(model.getType().getName(), ModelType.NameEnum.KNIME_WORKFLOW);
    }

    private UUID uploadFingerprintSet() {
        
        //upload product
        Product p = Product.builder().setBrand("my_product").setGtin("1234").build();
        UUID productId = restService(ProductRestService.class).createProduct(p).readEntity(UUID.class);
        
        // upload fingerprint set file
	FileMetadata fileMeta = FileMetadata.builder().setName("fingerprintset")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINTS_BRUKER).build();
	restService(FileRestService.class).createFileMetadata(fileMeta);
	TestUtils.uploadFileData(webTarget, fileMeta.getFaId(), new File("files/bruker-nmr/1.zip"));
      
        // upload fingerprint set
        Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
        FingerprintSet fps = FingerprintSet.builder().setName("myset").setProductId(productId)
        	.setType(FingerprintSetType.builder().setName(NameEnum.BRUKER).build())
        	.setFingerprints(Arrays.asList(fp)).setFileId(fileMeta.getFaId()).build();
        return restService(FingerprintRestService.class).createFingerprintSet(fps).readEntity(UUID.class);
    }

    private UUID uploadModel() {
        
        /* upload model */
	ModelType modelType = ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build();
	Model m = Model.builder().setName("mymodel").setType(modelType).build();
	       return webTarget.path("model").request(MediaType.APPLICATION_JSON)
        	.post(Entity.entity(m, MediaType.APPLICATION_JSON), UUID.class);
        // TODO upload model file
    }

}
