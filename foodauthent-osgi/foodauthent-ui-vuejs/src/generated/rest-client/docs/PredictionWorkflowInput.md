# FoodAuthentSwaggerApi.PredictionWorkflowInput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parameters** | [**[WorkflowParameter]**](WorkflowParameter.md) | The workflow parameters as given provided by the Workflow-entity. | [optional] 
**fingerprintsetMetadata** | [**FingerprintSet**](FingerprintSet.md) | The fingerprint set metadata. | [optional] 
**fingerprintsetURI** | **String** | URI pointing to the resource containg the fingerprints to predict the labels for. | [optional] 
**modelURI** | **String** | optional model uri (if required by the workflow) pointing to the model to use | [optional] 
**moduleInputs** | [**[WorkflowModuleInput]**](WorkflowModuleInput.md) | optional list of modules used within the prediction workfow. | [optional] 


