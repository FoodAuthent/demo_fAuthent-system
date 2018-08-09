# FoodAuthentSwaggerApi.ModelApi

All URIs are relative to *https://localhost/v0/foodauthent*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createModel**](ModelApi.md#createModel) | **POST** /model | Creates/adds a new model.
[**findModelByKeyword**](ModelApi.md#findModelByKeyword) | **GET** /model | Finds Models by some key words or return all Models.
[**getModelById**](ModelApi.md#getModelById) | **GET** /model/{model-id} | Get the model by id.


<a name="createModel"></a>
# **createModel**
> &#39;String&#39; createModel(opts)

Creates/adds a new model.

Creates/adds a new model.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.ModelApi();

var opts = { 
  'model': new FoodAuthentSwaggerApi.Model() // Model | TODO
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createModel(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **model** | [**Model**](Model.md)| TODO | [optional] 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="findModelByKeyword"></a>
# **findModelByKeyword**
> ModelPageResult findModelByKeyword(opts)

Finds Models by some key words or return all Models.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.ModelApi();

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

[**ModelPageResult**](ModelPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getModelById"></a>
# **getModelById**
> Model getModelById(modelId)

Get the model by id.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.ModelApi();

var modelId = "modelId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getModelById(modelId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modelId** | [**String**](.md)|  | 

### Return type

[**Model**](Model.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

