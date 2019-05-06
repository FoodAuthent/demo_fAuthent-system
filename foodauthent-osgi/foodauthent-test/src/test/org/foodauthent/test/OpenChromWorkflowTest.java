package org.foodauthent.test;

import static java.util.Arrays.asList;
import static org.foodauthent.rest.client.FASystemClient.files;
import static org.foodauthent.rest.client.FASystemClient.fingerprints;
import static org.foodauthent.rest.client.FASystemClient.models;
import static org.foodauthent.rest.client.FASystemClient.uploadFileData;
import static org.foodauthent.rest.client.FASystemClient.workflows;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

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
import org.junit.Test;

/**
 * Uploads and runs KNIME-Workflows that contain OpenChrom-nodes.
 */
public class OpenChromWorkflowTest extends AbstractITTest {

    @Test
    public void testUploadAndRunTrainingWorkflow() throws InterruptedException {
	/* upload workflow */

	// upload workflow file
	FileMetadata fileMeta = FileMetadata.builder().setName("TrainingWorkflow").setDate(LocalDate.now())
		.setDescription("file description").setType(org.foodauthent.model.FileMetadata.TypeEnum.KNIME_WORKFLOW)
		.setVersion(0).build();
	UUID fileId = files().createFileMetadata(fileMeta).readEntity(UUID.class);
	uploadFileData(fileId, new File("files/workflows/OpenChromReader.knwf"));

	// upload workflow metadata
	WorkflowParameter wfp1 = WorkflowParameter.builder().setName("train_param1").setRequired(false)
		.setValue("train_paramValue1").setType(TypeEnum.NUMBER).build();
	WorkflowParameter wfp2 = WorkflowParameter.builder().setName("train_param2").setRequired(true)
		.setValue("train_paramValue2").setType(TypeEnum.STRING).build();
	WorkflowIOTypes inputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build()).build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW_64B046CB).setFileId(fileId)
		.setRepresentation(RepresentationEnum.KNIME).setInputTypes(inputTypes).build();

	UUID wfId = workflows().createWorkflow(wf).readEntity(UUID.class);

	UUID fingerprintSetId = uploadFingerprintSet();

	/* run training workflow */
	TrainingJob trainingJob = workflows().createTrainingJob(wfId, asList(fingerprintSetId), true)
		.readEntity(TrainingJob.class);
	assertEquals(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING, trainingJob.getStatus());
	// let the job finish the training
	Thread.sleep(2000);

	/* retrieve training result */
	trainingJob = workflows().getTrainingJob(trainingJob.getFaId()).readEntity(TrainingJob.class);
	assertEquals("Execution failed: " + trainingJob.getStatusMessage(),
		org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS, trainingJob.getStatus());
	Model model = models().getModelById(trainingJob.getModelId())
		.readEntity(Model.class);
	assertEquals(model.getType().getName(), ModelType.NameEnum.KNIME_WORKFLOW);
    }

    private UUID uploadFingerprintSet() {

	// upload product
	Product p = Product.builder().setBrand("my_product").setGtin("1234").build();

	// upload fingerprint set file
	FileMetadata fileMeta = FileMetadata.builder().setName("fingerprintset")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).build();
	files().createFileMetadata(fileMeta);
	uploadFileData(fileMeta.getFaId(), new File("files/bruker-nmr/fingerprintset.zip"));

	// upload fingerprint set
	Fingerprint fp = Fingerprint.builder().setSampleId(UUID.randomUUID()).setFileId(fileMeta.getFaId()).build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setFingerprintIds(Arrays.asList(fp.getFaId()))
		.build();
	return fingerprints().createFingerprintSet(fps).readEntity(UUID.class);
    }

}
