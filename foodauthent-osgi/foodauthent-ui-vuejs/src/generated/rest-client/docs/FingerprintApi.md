# FoodAuthentSwaggerApi.FingerprintApi

All URIs are relative to *https://localhost/v0/foodauthent*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFingerprintSet**](FingerprintApi.md#createFingerprintSet) | **POST** /fingerprintset | Create a new fingerprint set.
[**findFingerprintSetByKeyword**](FingerprintApi.md#findFingerprintSetByKeyword) | **GET** /fingerprintset | Finds fingerprint sets by some key words or return all fingerprint sets.
[**getFingerprintSetById**](FingerprintApi.md#getFingerprintSetById) | **GET** /fingerprintset/{fingerprintset-id} | Get the fingerprintset by id.


<a name="createFingerprintSet"></a>
# **createFingerprintSet**
> &#39;String&#39; createFingerprintSet(fingerprintSet)

Create a new fingerprint set.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FingerprintApi();

var fingerprintSet = new FoodAuthentSwaggerApi.FingerprintSet(); // FingerprintSet | A fingerprint set containing fingerprint metadata.


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createFingerprintSet(fingerprintSet, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fingerprintSet** | [**FingerprintSet**](FingerprintSet.md)| A fingerprint set containing fingerprint metadata. | 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findFingerprintSetByKeyword"></a>
# **findFingerprintSetByKeyword**
> FingerprintSetPageResult findFingerprintSetByKeyword(opts)

Finds fingerprint sets by some key words or return all fingerprint sets.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FingerprintApi();

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
apiInstance.findFingerprintSetByKeyword(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**FingerprintSetPageResult**](FingerprintSetPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFingerprintSetById"></a>
# **getFingerprintSetById**
> FingerprintSet getFingerprintSetById(fingerprintsetId)

Get the fingerprintset by id.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FingerprintApi();

var fingerprintsetId = "fingerprintsetId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getFingerprintSetById(fingerprintsetId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fingerprintsetId** | [**String**](.md)|  | 

### Return type

[**FingerprintSet**](FingerprintSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

