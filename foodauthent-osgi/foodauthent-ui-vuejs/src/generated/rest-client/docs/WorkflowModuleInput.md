# FoodAuthentSwaggerApi.WorkflowModuleInput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**workflowURI** | **String** | URI of the workflow to use. | [optional] 
**moduleType** | **String** | The type of the module. | [optional] 
**moduleParameters** | [**[WorkflowParameter]**](WorkflowParameter.md) | The parameters required for the module. | [optional] 


<a name="ModuleTypeEnum"></a>
## Enum: ModuleTypeEnum


* `read` (value: `"read"`)

* `transform_signal` (value: `"transform_signal"`)

* `binning` (value: `"binning"`)

* `transform_sample` (value: `"transform_sample"`)

* `predict` (value: `"predict"`)

* `train` (value: `"train"`)




