# FoodAuthentSwaggerApi.FileApi

All URIs are relative to *https://localhost/v0/foodauthent*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFileMetadata**](FileApi.md#createFileMetadata) | **POST** /file | Creates a new file by posting the file metadata first.
[**getFileData**](FileApi.md#getFileData) | **GET** /file/{file-id}/data | Let one download the actual file data.
[**getFileMetadata**](FileApi.md#getFileMetadata) | **GET** /file/{file-id} | Returns the file metadata.
[**saveFileData**](FileApi.md#saveFileData) | **PUT** /file/{file-id}/data | Uploads (and replaces) the actual file-data for the given file id


<a name="createFileMetadata"></a>
# **createFileMetadata**
> &#39;String&#39; createFileMetadata(fileMetadata)

Creates a new file by posting the file metadata first.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FileApi();

var fileMetadata = new FoodAuthentSwaggerApi.FileMetadata(); // FileMetadata | The actual metadata object.


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createFileMetadata(fileMetadata, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileMetadata** | [**FileMetadata**](FileMetadata.md)| The actual metadata object. | 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getFileData"></a>
# **getFileData**
> File getFileData(fileId)

Let one download the actual file data.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FileApi();

var fileId = "fileId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getFileData(fileId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | [**String**](.md)|  | 

### Return type

**File**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/binary

<a name="getFileMetadata"></a>
# **getFileMetadata**
> FileMetadata getFileMetadata(fileId)

Returns the file metadata.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FileApi();

var fileId = "fileId_example"; // String | 


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getFileMetadata(fileId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | [**String**](.md)|  | 

### Return type

[**FileMetadata**](FileMetadata.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="saveFileData"></a>
# **saveFileData**
> &#39;String&#39; saveFileData(fileId, upfile)

Uploads (and replaces) the actual file-data for the given file id

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.FileApi();

var fileId = "fileId_example"; // String | 

var upfile = "/path/to/file.txt"; // File | The file to upload.


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.saveFileData(fileId, upfile, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | [**String**](.md)|  | 
 **upfile** | **File**| The file to upload. | 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

