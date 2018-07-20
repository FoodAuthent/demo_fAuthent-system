package org.foodauthent.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.ModelTypeEnum;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.WorkflowModule;
import org.foodauthent.model.WorkflowModuleInput.ModuleTypeEnum;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class WorkflowServiceTest extends AbstractITTest {

    @Test
    public void testUploadAndRunPredictionWorkflow() throws InterruptedException {

	WebTarget wt = webTarget();

	/* upload workflow */

	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("PredictionWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = wt.path("file").request(MediaType.APPLICATION_JSON).post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON),
		UUID.class);
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/PredictionWorkflow.knwf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	wt.path("/file/" + fileId + "/data").request().put(Entity.entity(multiPart, multiPart.getMediaType()));

	// upload workflow metadata
	//TODO make workflow fail when some parameters are not provided (and test that they fail)
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("param1").setRequired(false)
		.setValue("paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("param2").setRequired(true).setValue("paramValue2")
		.setType(TypeEnum.STRING).build();
	Workflow wf = Workflow.builder().setName("my_prediction_workflow").setDescription("desc").setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		.setRepresentation(RepresentationEnum.KNIME)
		.setModelType(ModelTypeEnum.KNIME_WORKFLOW)
		.setFileId(fileId)
		.build(); // TODO set more (or even all) properties
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

	/* upload fingerprint set */
	Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setFingerprints(Arrays.asList(fp)).build();
	UUID fpsId = wt.path("fingerprints").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(fps, MediaType.APPLICATION_JSON), UUID.class);
	// TODO upload fingerprint set file

	/* upload model */
	Model m = Model.builder().setName("mymodel").setType(org.foodauthent.model.Model.TypeEnum.KNIME_WORKFLOW)
		.build();
	UUID modelId = wt.path("model").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(m, MediaType.APPLICATION_JSON), UUID.class);
	// TODO upload model file

	/* run prediction workflow */
	PredictionJob predictionJob = wt.path("workflow/prediction/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fpsId).queryParam("model-id", modelId)
		.request(MediaType.APPLICATION_JSON).post(null, PredictionJob.class);
	assertEquals(StatusEnum.RUNNING, predictionJob.getStatus());
	// let the job finish the prediction
	Thread.sleep(2000);

	/* retrieve prediction result */
	predictionJob = wt.path("workflow/prediction/job/" + predictionJob.getFaId())
		.request(MediaType.APPLICATION_JSON).get(PredictionJob.class);
	assertEquals(StatusEnum.SUCCESS, predictionJob.getStatus());
	Prediction prediction = wt.path("prediction/" + predictionJob.getPredictionId())
		.request(MediaType.APPLICATION_JSON).get(Prediction.class);
	assertEquals(prediction.getConfidenceMap().size(), 1);

    }

    @Test
    public void testUploadAndRunTrainingWorkflow() throws InterruptedException {

	WebTarget wt = webTarget();

	/* upload workflow */
	
	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("TrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = wt.path("file").request(MediaType.APPLICATION_JSON).post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON),
		UUID.class);
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/TrainingWorkflow.knwf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	wt.path("file/" + fileId + "/data").request().put(Entity.entity(multiPart, multiPart.getMediaType()));

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("param1").setRequired(false)
		.setValue("paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("param2").setRequired(true).setValue("paramValue2")
		.setType(TypeEnum.STRING).build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW)
		.setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME)
		.setModelType(ModelTypeEnum.KNIME_WORKFLOW).build(); // TODO set more (or even all) properties
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

	/* upload fingerprint set */
	Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setFingerprints(Arrays.asList(fp)).build();
	UUID fpsId = wt.path("fingerprints").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(fps, MediaType.APPLICATION_JSON), UUID.class);
	// TODO upload fingerprint set file

	/* run training workflow */
	TrainingJob trainingJob = wt.path("workflow/training/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fpsId).request(MediaType.APPLICATION_JSON)
		.post(null, TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(2000);

	/* retrieve training result */
	trainingJob = wt.path("workflow/training/job/" + trainingJob.getFaId()).request(MediaType.APPLICATION_JSON)
		.get(TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = wt.path("model/" + trainingJob.getModelId()).request(MediaType.APPLICATION_JSON).get(Model.class);
	assertEquals(model.getType(), org.foodauthent.model.Model.TypeEnum.KNIME_WORKFLOW);
    }
    
    //@Test
    public void testUploadAndRunModularTrainingWorkflow() throws InterruptedException {
	WebTarget wt = webTarget();

	/* upload workflow modules */
	// upload workflow module file 
	FileMetadata fileMeta = FileMetadata.builder().setName("WorkflowModule").setDate(LocalDate.now())
		.setDescription("file description of the workflow module").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = wt.path("file").request(MediaType.APPLICATION_JSON).post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON),
		UUID.class);
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/WorkflowModule.knwf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	wt.path("file/" + fileId + "/data").request().put(Entity.entity(multiPart, multiPart.getMediaType()));
	
	// create module entitiy 
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("module_param1").setRequired(false)
		.setValue("paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("module_param2").setRequired(true).setValue("paramValue2")
		.setType(TypeEnum.STRING).build();
	WorkflowModule wfModule = WorkflowModule.builder()
		.setModuleParameters(Arrays.asList(wfp1, wfp2))
		.setFileId(fileId)
		.setModuleType(org.foodauthent.model.WorkflowModule.ModuleTypeEnum.BINNING).build();

	/* upload workflow */
	
	// upload workflow file
	fileMeta = FileMetadata.builder().setName("ModularTrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	fileId = wt.path("file").request(MediaType.APPLICATION_JSON).post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON),
		UUID.class);
	multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	filePart = new FileDataBodyPart("upfile", new File("files/ModularTrainingWorkflow.knwf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	wt.path("file/" + fileId + "/data").request().put(Entity.entity(multiPart, multiPart.getMediaType()));
	
	// upload workflow metadata
	wfp1 = WorkflowParameter.builder().setName("param1").setRequired(false)
		.setValue("paramValue1").setType(TypeEnum.NUMBER).build();
	wfp2 = WorkflowParameter.builder().setName("param2").setRequired(true).setValue("paramValue2")
		.setType(TypeEnum.STRING).build();
	Workflow wf = Workflow.builder().setName("my modular_training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW)
		.setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME)
		.setModelType(ModelTypeEnum.KNIME_WORKFLOW)
		.setModules(Arrays.asList(wfModule)).build(); // TODO set more (or even all) properties
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

	/* upload fingerprint set */
	Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setFingerprints(Arrays.asList(fp)).build();
	UUID fpsId = wt.path("fingerprints").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(fps, MediaType.APPLICATION_JSON), UUID.class);
	// TODO upload fingerprint set file

	/* run training workflow */
	TrainingJob trainingJob = wt.path("workflow/training/job").queryParam("workflow-id", wfId)
		.queryParam("fingerprintset-id", fpsId).request(MediaType.APPLICATION_JSON)
		.post(null, TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(3000);

	/* retrieve training result */
	trainingJob = wt.path("workflow/training/job/" + trainingJob.getFaId()).request(MediaType.APPLICATION_JSON)
		.get(TrainingJob.class);
	assertEquals("Workflow execution failed: " + trainingJob.getStatusMessage(),
		org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = wt.path("model/" + trainingJob.getModelId()).request(MediaType.APPLICATION_JSON).get(Model.class);
	assertEquals(model.getType(), org.foodauthent.model.Model.TypeEnum.KNIME_WORKFLOW);
    }

}
