# FoodAuthentSwaggerApi.Model

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**faId** | **String** | A global id within the FoodAuthent-system. | [optional] 
**name** | **String** | A name for the model. | [optional] 
**description** | **String** | A more verbose description of the model. | [optional] 
**author** | **String** | The authors name (TODO - could reference a user in the future). | [optional] 
**_date** | **Date** | The creation date. | [optional] 
**version** | **Number** | The model&#39;s version. | [optional] 
**type** | **String** | The type of the model in order to be able to check for compatibility of the workflows using it. | [optional] 
**tags** | [**[Tag]**](Tag.md) | Descriptive tags/annotations for the model. | [optional] 
**fileId** | **String** | id referencing the model file. | [optional] 


<a name="TypeEnum"></a>
## Enum: TypeEnum


* `knime_workflow` (value: `"knime_workflow"`)

* `knime_python` (value: `"knime_python"`)

* `pmml` (value: `"pmml"`)




