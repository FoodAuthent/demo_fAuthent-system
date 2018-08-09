# FoodAuthentSwaggerApi.Workflow

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**faId** | **String** | A global id within the FoodAuthent-system. | [optional] 
**name** | **String** |  | 
**description** | **String** |  | [optional] 
**representation** | **String** | The workflow representation, e.g. represented by a scripting language, cwl or a KNIME-workflow. | 
**type** | **String** | The type of the workflow. IMPORTANT: This property determines the required workflow input and output, e.g., PredictionWorkflowInput and PredicitonWorkflowOutput-entity. | 
**parameters** | [**[WorkflowParameter]**](WorkflowParameter.md) | The parameters of the workflow, TODO - should maybe be a map. | [optional] 
**tags** | [**[Tag]**](Tag.md) | Descriptive tags/annotations for the workflow. | [optional] 
**fileId** | **String** | id referencing the workflow file. | 
**modules** | [**[WorkflowModule]**](WorkflowModule.md) | The workflow modules (including their parameters) required by this workflow or empty (or null) if none required. | [optional] 
**modelType** | **String** | Type of the model this workflow can consume or produce. Can be left empty, e.g., in case of a preprocessing workflow. Model type must match one of the model&#39;s type property. | [optional] 


<a name="RepresentationEnum"></a>
## Enum: RepresentationEnum


* `cwl` (value: `"cwl"`)

* `r` (value: `"r"`)

* `python` (value: `"python"`)

* `knime` (value: `"knime"`)




<a name="TypeEnum"></a>
## Enum: TypeEnum


* `prediction_workflow` (value: `"prediction_workflow"`)

* `training_workflow` (value: `"training_workflow"`)




<a name="ModelTypeEnum"></a>
## Enum: ModelTypeEnum


* `knime_workflow` (value: `"knime_workflow"`)

* `knime_python` (value: `"knime_python"`)

* `pmml` (value: `"pmml"`)




