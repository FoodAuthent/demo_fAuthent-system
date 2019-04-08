package org.foodauthent.data;

import static org.foodauthent.data.FASystem.files;
import static org.foodauthent.data.FASystem.uploadFileData;
import static org.foodauthent.data.FASystem.workflows;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FingerprintSetType;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.TypeEnum;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */

public class PopulateWorkflows {

    private PopulateWorkflows() {
	// utility class
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
		.setFingerprintsetType(FingerprintSetType.builder().setName(FingerprintSetType.NameEnum.BRUKER).build())
		.build();
	WorkflowIOTypes outputTypes = WorkflowIOTypes.builder()
		.setModelType(ModelType.builder().setName(ModelType.NameEnum.KNIME_WORKFLOW).build()).build();
	Workflow wf = Workflow.builder().setName("my training workflow").setDescription("desc")
		.setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW).setFileId(fileId)
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
		.setFingerprintsetType(FingerprintSetType.builder().setName(FingerprintSetType.NameEnum.BRUKER).build())
		.build();
	Workflow wf = Workflow.builder().setName("my_prediction_workflow").setDescription("desc").setParameters(Arrays.asList(wfp1, wfp2))
		.setType(org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW)
		.setRepresentation(RepresentationEnum.KNIME)
		.setInputTypes(inputTypes)
		.setFileId(fileId)
		.build(); // TODO set more (or even all) properties
	
	return workflows().createWorkflow(wf).readEntity(UUID.class);
    }

}
