package org.foodauthent.test;

import static org.junit.Assert.assertEquals;
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
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.Product;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.ModelTypeEnum;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.Workflow.WorkflowBuilder;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class WorkflowServiceTest extends AbstractITTest {
    
    private UUID predictionWorkflowFileId;
    private UUID fingerprintSetId;
    private UUID modelId;
    private WebTarget wt = webTarget();
    
    @Before
    public void uploadPredictionWorkflowFile() {
	
	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("PredictionWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	predictionWorkflowFileId = wt.path("file").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON), UUID.class);
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/workflows/PredictionWorkflow.knwf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	Response response = wt.path("/file/" + predictionWorkflowFileId + "/data").request()
		.put(Entity.entity(multiPart, multiPart.getMediaType()));
	assertEquals(200, response.getStatus());
    }
    
    
    @Before
    public void uploadFingerprintSet() {
	
	//upload product
	Product p = Product.builder().setBrand("my_product").setGtin("1234").build();
	UUID productId = wt.path("product").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(p, MediaType.APPLICATION_JSON), UUID.class);
	
	// TODO upload fingerprint set file
	// use some random id for now
	UUID fpsFileId = UUID.randomUUID();
	
	// upload fingerprint set
	Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setProductId(productId)
		.setFingerprints(Arrays.asList(fp)).setFileId(fpsFileId).build();
	fingerprintSetId = wt.path("fingerprintset").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(fps, MediaType.APPLICATION_JSON), UUID.class);
    }
    
    @Before
    public void uploadModel() {
	
	/* upload model */
	Model m = Model.builder().setName("mymodel").setType(org.foodauthent.model.Model.TypeEnum.KNIME_WORKFLOW)
		.build();
	modelId = wt.path("model").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(m, MediaType.APPLICATION_JSON), UUID.class);
	// TODO upload model file
    }
    
    @Test
    public void testUploadAndRunPredictionWorkflow() throws InterruptedException {

	/* upload workflow */

	// upload workflow metadata
	//TODO make workflow fail when some parameters are not provided (and test that they fail)
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("pred_param1").setRequired(false)
		.setValue("pred_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("pred_param2").setRequired(true)
		.setValue("pred_paramValue2").setType(TypeEnum.STRING).build();
	Workflow wf = Workflow.builder().setName("my_prediction_workflow").setDescription("desc").setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		.setRepresentation(RepresentationEnum.KNIME)
		.setModelType(ModelTypeEnum.KNIME_WORKFLOW)
		.setFileId(predictionWorkflowFileId)
		.build(); // TODO set more (or even all) properties
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

	/* run prediction workflow */
	PredictionJob predictionJob = wt.path("workflow/prediction/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fingerprintSetId).queryParam("model-id", modelId)
		.request(MediaType.APPLICATION_JSON).post(null, PredictionJob.class);
	assertEquals(StatusEnum.RUNNING, predictionJob.getStatus());
	// let the job finish the prediction
	Thread.sleep(2000);

	/* retrieve prediction result */
	predictionJob = wt.path("workflow/prediction/job/" + predictionJob.getFaId())
		.request(MediaType.APPLICATION_JSON).get(PredictionJob.class);
	assertEquals("Execution failed: " + predictionJob.getStatusMessage(), StatusEnum.SUCCESS,
		predictionJob.getStatus());
	Prediction prediction = wt.path("prediction/" + predictionJob.getPredictionId())
		.request(MediaType.APPLICATION_JSON).get(Prediction.class);
	assertEquals(prediction.getConfidenceMap().size(), 1);

    }
    
    @Test
    public void testFailInitPredictionWorkflow() {
	
	WorkflowBuilder wfb = Workflow.builder().setName("inconsistent_prediction_workflow").setDescription("desc")
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		//on purpose not a knime workflow
		.setRepresentation(RepresentationEnum.CWL)
		.setModelType(ModelTypeEnum.KNIME_WORKFLOW)
		.setFileId(predictionWorkflowFileId);
	
	//post workflow
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wfb.build(), MediaType.APPLICATION_JSON), UUID.class);
	
	// try to run prediction job
	Response response = wt.path("workflow/prediction/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fingerprintSetId).queryParam("model-id", modelId)
		.request(MediaType.APPLICATION_JSON).post(null);
	assertEquals("Unexpected status code", 500, response.getStatus());
	String message = response.readEntity(String.class);
	assertTrue(message.contains("not a knime workflow"));
	//TODO use 'assertThat' instead!
	
	//wrong type
	wfb.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW);
	//post workflow
	wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wfb.build(), MediaType.APPLICATION_JSON), UUID.class);
	
	// try to run prediction job
	response = wt.path("workflow/prediction/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fingerprintSetId).queryParam("model-id", modelId)
		.request(MediaType.APPLICATION_JSON).post(null);
	assertEquals("Unexpected status code", 500, response.getStatus());
	message = response.readEntity(String.class);
	assertTrue(message.contains("not a prediction workflow"));
    } 

    @Test
    public void testUploadAndRunTrainingWorkflow() throws InterruptedException {

	/* upload workflow */
	
	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("TrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = wt.path("file").request(MediaType.APPLICATION_JSON).post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON),
		UUID.class);
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/workflows/TrainingWorkflow.knwf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	wt.path("file/" + fileId + "/data").request().put(Entity.entity(multiPart, multiPart.getMediaType()));

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("train_param1").setRequired(false)
		.setValue("train_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("train_param2").setRequired(true)
		.setValue("train_paramValue2")	.setType(TypeEnum.STRING).build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW)
		.setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME)
		.setModelType(ModelTypeEnum.KNIME_WORKFLOW).build(); // TODO set more (or even all) properties
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

	/* run training workflow */
	TrainingJob trainingJob = wt.path("workflow/training/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fingerprintSetId).request(MediaType.APPLICATION_JSON)
		.post(null, TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(2000);

	/* retrieve training result */
	trainingJob = wt.path("workflow/training/job/" + trainingJob.getFaId()).request(MediaType.APPLICATION_JSON)
		.get(TrainingJob.class);
	assertEquals("Execution failed: " + trainingJob.getStatusMessage(),
		org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = wt.path("model/" + trainingJob.getModelId()).request(MediaType.APPLICATION_JSON).get(Model.class);
	assertEquals(model.getType(), org.foodauthent.model.Model.TypeEnum.KNIME_WORKFLOW);
    }

}
