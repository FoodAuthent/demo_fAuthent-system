# FoodAuthentSwaggerApi.WorkflowApi

All URIs are relative to *https://localhost/v0/foodauthent*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPredictionJob**](WorkflowApi.md#createPredictionJob) | **POST** /workflow/prediction/job | Starts a prediction for a fingerprint.
[**createTrainingJob**](WorkflowApi.md#createTrainingJob) | **POST** /workflow/training/job | Starts creating a model for a set of fingerprints.
[**createWorkflow**](WorkflowApi.md#createWorkflow) | **POST** /workflow | Creates/adds a new workflow.
[**findModelByKeyword**](WorkflowApi.md#findModelByKeyword) | **GET** /prediction | Finds Prediction by some key words or return all Predictions.
[**findPredictionJobs**](WorkflowApi.md#findPredictionJobs) | **GET** /workflow/prediction/job | Finds predictions jobs by some key words or return all predictions jobs suitable for prediction.
[**findPredictionWorkflows**](WorkflowApi.md#findPredictionWorkflows) | **GET** /workflow/prediction | Finds workflows by some key words or return all workflows suitable for prediction.
[**findTrainingJobs**](WorkflowApi.md#findTrainingJobs) | **GET** /workflow/training/job | Finds training jobs by some key words or return all training jobs.
[**findTrainingWorkflows**](WorkflowApi.md#findTrainingWorkflows) | **GET** /workflow/training | Finds workflows by some key words or return all workflows suitable for training models.
[**findWorkflowByKeyword**](WorkflowApi.md#findWorkflowByKeyword) | **GET** /workflow | Finds Workflow by some key words or return all Workflows.
[**getPredictionJob**](WorkflowApi.md#getPredictionJob) | **GET** /workflow/prediction/job/{job-id} | Lets one to ask for the status of a particular job.
[**getPredictionResult**](WorkflowApi.md#getPredictionResult) | **GET** /prediction/{prediction-id} | Get a specific prediction result.
[**getTrainingJob**](WorkflowApi.md#getTrainingJob) | **GET** /workflow/training/job/{job-id} | Lets one to ask for the status of a particular job.
[**getWorkflowById**](WorkflowApi.md#getWorkflowById) | **GET** /workflow/{workflow-id} | Get the workflow an id.


<a name="createPredictionJob"></a>
# **createPredictionJob**
> PredictionJob createPredictionJob(workflowId, fingerprintsetId, modelId)

Starts a prediction for a fingerprint.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var workflowId = "workflowId_example"; // String | TODO

var fingerprintsetId = "fingerprintsetId_example"; // String | TODO

var modelId = "modelId_example"; // String | The model to be used for prediction. Needs to be compatible with the selected workflow!!


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createPredictionJob(workflowId, fingerprintsetId, modelId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workflowId** | [**String**](.md)| TODO | 
 **fingerprintsetId** | [**String**](.md)| TODO | 
 **modelId** | [**String**](.md)| The model to be used for prediction. Needs to be compatible with the selected workflow!! | 

### Return type

[**PredictionJob**](PredictionJob.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createTrainingJob"></a>
# **createTrainingJob**
> TrainingJob createTrainingJob(workflowId, fingerprintsetId)

Starts creating a model for a set of fingerprints.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var workflowId = "workflowId_example"; // String | TODO

var fingerprintsetId = "fingerprintsetId_example"; // String | TODO


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createTrainingJob(workflowId, fingerprintsetId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workflowId** | [**String**](.md)| TODO | 
 **fingerprintsetId** | [**String**](.md)| TODO | 

### Return type

[**TrainingJob**](TrainingJob.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createWorkflow"></a>
# **createWorkflow**
> &#39;String&#39; createWorkflow(opts)

Creates/adds a new workflow.

Creates/adds a new workflow.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'workflow': new FoodAuthentSwaggerApi.Workflow() // Workflow | TODO
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createWorkflow(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workflow** | [**Workflow**](Workflow.md)| TODO | [optional] 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="findModelByKeyword"></a>
# **findModelByKeyword**
> PredictionPageResult findModelByKeyword(opts)

Finds Prediction by some key words or return all Predictions.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'pageNumber': 56, // Number | 
  'pageSize': 56, // Number | 
  'keywords': ["keywords_example"] // [String] | Keywords to search for
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findModelByKeyword(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**PredictionPageResult**](PredictionPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findPredictionJobs"></a>
# **findPredictionJobs**
> PredictionJobPageResult findPredictionJobs(opts)

Finds predictions jobs by some key words or return all predictions jobs suitable for prediction.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'pageNumber': 56, // Number | 
  'pageSize': 56, // Number | 
  'keywords': ["keywords_example"] // [String] | Keywords to search for
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findPredictionJobs(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**PredictionJobPageResult**](PredictionJobPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findPredictionWorkflows"></a>
# **findPredictionWorkflows**
> WorkflowPageResult findPredictionWorkflows(opts)

Finds workflows by some key words or return all workflows suitable for prediction.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'pageNumber': 56, // Number | 
  'pageSize': 56, // Number | 
  'keywords': ["keywords_example"] // [String] | Keywords to search for
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findPredictionWorkflows(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**WorkflowPageResult**](WorkflowPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findTrainingJobs"></a>
# **findTrainingJobs**
> TrainingJobPageResult findTrainingJobs(opts)

Finds training jobs by some key words or return all training jobs.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'pageNumber': 56, // Number | 
  'pageSize': 56, // Number | 
  'keywords': ["keywords_example"] // [String] | Keywords to search for
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findTrainingJobs(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**TrainingJobPageResult**](TrainingJobPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findTrainingWorkflows"></a>
# **findTrainingWorkflows**
> WorkflowPageResult findTrainingWorkflows(opts)

Finds workflows by some key words or return all workflows suitable for training models.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'pageNumber': 56, // Number | 
  'pageSize': 56, // Number | 
  'keywords': ["keywords_example"] // [String] | Keywords to search for
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findTrainingWorkflows(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**WorkflowPageResult**](WorkflowPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findWorkflowByKeyword"></a>
# **findWorkflowByKeyword**
> WorkflowPageResult findWorkflowByKeyword(opts)

Finds Workflow by some key words or return all Workflows.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var opts = { 
  'pageNumber': 56, // Number | 
  'pageSize': 56, // Number | 
  'keywords': ["keywords_example"] // [String] | Keywords to search for
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findWorkflowByKeyword(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**WorkflowPageResult**](WorkflowPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPredictionJob"></a>
# **getPredictionJob**
> PredictionJob getPredictionJob(jobId)

Lets one to ask for the status of a particular job.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var jobId = "jobId_example"; // String | TODO


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getPredictionJob(jobId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobId** | [**String**](.md)| TODO | 

### Return type

[**PredictionJob**](PredictionJob.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPredictionResult"></a>
# **getPredictionResult**
> Prediction getPredictionResult(predictionId)

Get a specific prediction result.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var predictionId = "predictionId_example"; // String | TODO


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getPredictionResult(predictionId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **predictionId** | [**String**](.md)| TODO | 

### Return type

[**Prediction**](Prediction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTrainingJob"></a>
# **getTrainingJob**
> TrainingJob getTrainingJob(jobId)

Lets one to ask for the status of a particular job.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var jobId = "jobId_example"; // String | TODO


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getTrainingJob(jobId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobId** | [**String**](.md)| TODO | 

### Return type

[**TrainingJob**](TrainingJob.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWorkflowById"></a>
# **getWorkflowById**
> Workflow getWorkflowById(workflowId)

Get the workflow an id.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.WorkflowApi();

var workflowId = "workflowId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getWorkflowById(workflowId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workflowId** | [**String**](.md)|  | 

### Return type

[**Workflow**](Workflow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

