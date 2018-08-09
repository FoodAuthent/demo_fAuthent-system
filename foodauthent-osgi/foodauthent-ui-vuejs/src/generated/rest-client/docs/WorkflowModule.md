# FoodAuthentSwaggerApi.WorkflowModule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fileId** | **String** | The file-id that references the actual workflow file. | [optional] 
**moduleType** | **String** | The type of the module. IMPORTANT: This property determines the required workflow input and output. | [optional] 
**moduleParameters** | [**[WorkflowParameter]**](WorkflowParameter.md) | The parameters required for the module. | [optional] 


<a name="ModuleTypeEnum"></a>
## Enum: ModuleTypeEnum


* `read` (value: `"read"`)

* `transform_signal` (value: `"transform_signal"`)

* `binning` (value: `"binning"`)

* `transform_sample` (value: `"transform_sample"`)

* `predict` (value: `"predict"`)

* `train` (value: `"train"`)




