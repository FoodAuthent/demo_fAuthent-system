package org.foodauthent.test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import javax.ws.rs.client.WebTarget;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.Product;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;
import org.foodauthent.rest.api.service.FileRestService;
import org.foodauthent.rest.api.service.FingerprintRestService;
import org.foodauthent.rest.api.service.ModelRestService;
import org.foodauthent.rest.api.service.ProductRestService;
import org.foodauthent.rest.api.service.WorkflowRestService;
import org.junit.Test;

/**
 * Uploads and runs KNIME-Workflows that contain OpenChrom-nodes.
 */
public class OpenChromWorkflowTest extends AbstractITTest {

    @Test
    public void testUploadAndRunTrainingWorkflow() throws InterruptedException {
	WebTarget webTarget = webTarget();

	/* upload workflow */

	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("TrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = restService(FileRestService.class).createFileMetadata(fileMeta).readEntity(UUID.class);
	TestUtils.uploadFileData(webTarget, fileId, new File("files/workflows/OpenChromReader.knwf"));

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("train_param1").setRequired(false)
		.setValue("train_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("train_param2").setRequired(true)
		.setValue("train_paramValue2").setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build()).build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW).setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME).setInputTypes(inputTypes).build();

	WorkflowRestService workflowService = restService(WorkflowRestService.class);
	UUID wfId = workflowService.createWorkflow(wf).readEntity(UUID.class);

	UUID fingerprintSetId = uploadFingerprintSet(webTarget);

	/* run training workflow */
	TrainingJob trainingJob = workflowService.createTrainingJob(wfId, asList(fingerprintSetId), true)
		.readEntity(TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(2000);

	/* retrieve training result */
	trainingJob = workflowService.getTrainingJob(trainingJob.getFaId()).readEntity(TrainingJob.class);
	assertEquals("Execution failed: " + trainingJob.getStatusMessage(),
		org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = restService(ModelRestService.class).getModelById(trainingJob.getModelId())
		.readEntity(Model.class);
	assertEquals(model.getType().getName(), ModelType.NameEnum.KNIME_WORKFLOW);
    }

    private UUID uploadFingerprintSet(WebTarget webTarget) {

	// upload product
	Product p = Product.builder().setBrand("my_product").setGtin("1234").build();
	UUID productId = restService(ProductRestService.class).createProduct(p).readEntity(UUID.class);

	// upload fingerprint set file
	FileMetadata fileMeta = FileMetadata.builder().setName("fingerprintset")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINTS_BRUKER).build();
	restService(FileRestService.class).createFileMetadata(fileMeta);
	TestUtils.uploadFileData(webTarget, fileMeta.getFaId(), new File("files/bruker-nmr/fingerprintset.zip"));

	// upload fingerprint set
	Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setProductId(productId)
		.setFingerprints(Arrays.asList(fp)).setFileId(fileMeta.getFaId()).build();
	return restService(FingerprintRestService.class).createFingerprintSet(fps).readEntity(UUID.class);
    }

}
