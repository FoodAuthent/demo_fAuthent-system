package org.foodauthent.test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.foodauthent.rest.api.service.FileRestService;
import org.foodauthent.rest.api.service.FingerprintRestService;
import org.foodauthent.rest.api.service.ModelRestService;
import org.foodauthent.rest.api.service.ProductRestService;
import org.foodauthent.rest.api.service.SampleRestService;
import org.foodauthent.rest.api.service.WorkflowRestService;
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
	UUID wfId = uploadPredictionWorkflow();
	UUID fingerprintSetId = uploadFingerprintSets().get(0);
	UUID modelId = uploadModel();

	/* run prediction workflow */
	Response response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId, true);
	try {
	    assertThat("Unexpected server response", response.getStatus(), is(200));
	} catch (AssertionError e) {
	    System.err.println(response.readEntity(String.class));
	    throw e;
	}
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
	assertEquals(prediction.getPredictionMap().size(), 2);
	
	/* retrieve prediction by fingerprintset-id */
	response = workflowService.findPredictionByKeyword(1, 10, Arrays.asList(fingerprintSetId.toString()));
	assertThat("unexpected server response", response.getStatus(), is(200));
	PredictionPageResult predictionPage = response.readEntity(PredictionPageResult.class);
	assertThat("exactly one entry expected", predictionPage.getResultCount(), is(1));
	assertThat("unexpected prediction", predictionPage.getResults().get(0), is(prediction));
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
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		.setRepresentation(RepresentationEnum.KNIME).setInputTypes(inputTypes)
		.setFileId(predictionWorkflowFileId).build(); // TODO set more (or even all) properties

	return workflowService.createWorkflow(wf).readEntity(UUID.class);
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
    public void testFailInitPredictionWorkflow() {
	
	UUID predictionWorkflowFileId = uploadPredictionWorkflowFile();
	UUID fingerprintSetId = uploadFingerprintSets().get(0);
	UUID modelId = uploadModel();
	
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build())
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
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
	Response response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId, true);
	assertEquals("Unexpected status code", 500, response.getStatus());
	String message = response.readEntity(String.class);
	assertTrue(message.contains("not a knime workflow"));
	//TODO use 'assertThat' instead!
	
	//wrong type
	wfb.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW);
	//post workflow
	wfId = workflowService.createWorkflow(wfb.build()).readEntity(UUID.class);
	
	// try to run prediction job
	response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId, true);
	assertEquals("Unexpected status code", 500, response.getStatus());
	message = response.readEntity(String.class);
	assertTrue(message.contains("not a prediction workflow"));
    } 
    
    @Test
    public void testRunPredictionWorkflowSynchronously() {
	UUID wfId = uploadPredictionWorkflow();
	UUID fingerprintSetId = uploadFingerprintSets().get(0);
	UUID modelId = uploadModel();

	Response response = workflowService.createPredictionJob(wfId, fingerprintSetId, modelId, false);
	try {
	    assertThat("Unexpected server response", response.getStatus(), is(200));
	} catch (AssertionError e) {
	    System.err.println(response.readEntity(String.class));
	    throw e;
	}
	PredictionJob predictionJob = response.readEntity(PredictionJob.class);
	assertEquals(StatusEnum.SUCCESS, predictionJob.getStatus());
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
		.setFingerprintType(FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build())
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
	
	List<UUID> fingerprintSetIds = uploadFingerprintSets();

	/* run training workflow */
	Response response = workflowService.createTrainingJob(wfId, fingerprintSetIds, true);
	try {
	    assertThat("Unexpected server response", response.getStatus(), is(200));
	} catch (AssertionError e) {
	    System.err.println(response.readEntity(String.class));
	    throw e;
	}
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

    private List<UUID> uploadFingerprintSets() {
        
        //upload product
        Product p = Product.builder().setBrand("my_product").setGtin("1234").build();
        UUID productId = restService(ProductRestService.class).createProduct(p).readEntity(UUID.class);
        
        //upload sample
        Sample s = Sample.builder().setProductId(productId).build();
        UUID sampleId = restService(SampleRestService.class).createSample(s).readEntity(UUID.class);
        
        //upload fingerprint files
	FileMetadata fpFile1 = FileMetadata.builder().setName("fingerprint1")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	restService(FileRestService.class).createFileMetadata(fpFile1);
	TestUtils.uploadFileData(webTarget, fpFile1.getFaId(), new File("files/fingerprints/fp1.zip"));
	FileMetadata fpFile2 = FileMetadata.builder().setName("fingerprint2")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	restService(FileRestService.class).createFileMetadata(fpFile2);
	TestUtils.uploadFileData(webTarget, fpFile2.getFaId(), new File("files/fingerprints/fp2.zip"));
	FileMetadata fpFile3 = FileMetadata.builder().setName("fingerprint3")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	restService(FileRestService.class).createFileMetadata(fpFile3);
	TestUtils.uploadFileData(webTarget, fpFile3.getFaId(), new File("files/fingerprints/fp3.zip"));

 
	//upload fingerprints
	FingerprintRestService fpService = restService(FingerprintRestService.class);
	Fingerprint fp1 = Fingerprint.builder().setSampleId(sampleId).setFileId(fpFile1.getFaId()).build();
	fpService.createFingerprint(fp1);
	Fingerprint fp2 = Fingerprint.builder().setSampleId(sampleId).setFileId(fpFile2.getFaId()).build();
	fpService.createFingerprint(fp2);
	Fingerprint fp3 = Fingerprint.builder().setSampleId(sampleId).setFileId(fpFile3.getFaId()).build();
	fpService.createFingerprint(fp3);
     
        // upload fingerprint sets
	FingerprintSet fps = FingerprintSet.builder().setName("myset1")
		.setFingerprintIds(Arrays.asList(fp1.getFaId(), fp2.getFaId())).setClassLabel("label1").build();
	FingerprintSet fps2 = FingerprintSet.builder().setName("myset2").setFingerprintIds(Arrays.asList(fp3.getFaId()))
		.setClassLabel("label2").build();
	return asList(fpService.createFingerprintSet(fps).readEntity(UUID.class),
		fpService.createFingerprintSet(fps2).readEntity(UUID.class));
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
