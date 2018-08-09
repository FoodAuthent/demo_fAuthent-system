# FoodAuthentSwaggerApi.SopApi

All URIs are relative to *https://localhost/v0/foodauthent*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createNewSOP**](SopApi.md#createNewSOP) | **POST** /sop | Creates a new SOP.
[**findSOPByKeyword**](SopApi.md#findSOPByKeyword) | **GET** /sop | Finds SOPs by some key words or return all sop&#39;s.
[**getSOPById**](SopApi.md#getSOPById) | **GET** /sop/{sop-id} | Get the sop an id.
[**removeSOPById**](SopApi.md#removeSOPById) | **DELETE** /sop/{sop-id} | Delete a sop specified by id.


<a name="createNewSOP"></a>
# **createNewSOP**
> &#39;String&#39; createNewSOP(sop)

Creates a new SOP.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.SopApi();

var sop = new FoodAuthentSwaggerApi.SOP(); // SOP | TODO


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createNewSOP(sop, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sop** | [**SOP**](SOP.md)| TODO | 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findSOPByKeyword"></a>
# **findSOPByKeyword**
> SOPPageResult findSOPByKeyword(opts)

Finds SOPs by some key words or return all sop&#39;s.

Muliple tags can be provided with comma separated strings. Use keyword1, keyword2, keyword3 for testing. If no keyword is specified, all entries will be considered.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.SopApi();

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
apiInstance.findSOPByKeyword(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**SOPPageResult**](SOPPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSOPById"></a>
# **getSOPById**
> SOP getSOPById(sopId)

Get the sop an id.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.SopApi();

var sopId = "sopId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getSOPById(sopId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sopId** | [**String**](.md)|  | 

### Return type

[**SOP**](SOP.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeSOPById"></a>
# **removeSOPById**
> removeSOPById(sopId)

Delete a sop specified by id.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.SopApi();

var sopId = "sopId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
apiInstance.removeSOPById(sopId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sopId** | [**String**](.md)|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

