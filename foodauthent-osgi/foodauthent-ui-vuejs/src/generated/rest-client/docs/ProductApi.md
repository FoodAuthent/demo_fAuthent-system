# FoodAuthentSwaggerApi.ProductApi

All URIs are relative to *https://localhost/v0/foodauthent*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProduct**](ProductApi.md#createProduct) | **POST** /product | Create a new product entity.
[**findProductByGtin**](ProductApi.md#findProductByGtin) | **GET** /product/findByGtin | Find product by gtin.
[**findProductByKeyword**](ProductApi.md#findProductByKeyword) | **GET** /product | Finds Products by some key words or return all Products.


<a name="createProduct"></a>
# **createProduct**
> &#39;String&#39; createProduct(opts)

Create a new product entity.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.ProductApi();

var opts = { 
  'product': new FoodAuthentSwaggerApi.Product() // Product | TODO
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createProduct(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product** | [**Product**](Product.md)| TODO | [optional] 

### Return type

**&#39;String&#39;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="findProductByGtin"></a>
# **findProductByGtin**
> Product findProductByGtin(gtin)

Find product by gtin.

TODO

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.ProductApi();

var gtin = "gtin_example"; // String | TODO


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findProductByGtin(gtin, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gtin** | **String**| TODO | 

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findProductByKeyword"></a>
# **findProductByKeyword**
> ProductPageResult findProductByKeyword(opts)

Finds Products by some key words or return all Products.

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```javascript
var FoodAuthentSwaggerApi = require('food_authent_swagger_api');

var apiInstance = new FoodAuthentSwaggerApi.ProductApi();

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
apiInstance.findProductByKeyword(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageNumber** | **Number**|  | [optional] 
 **pageSize** | **Number**|  | [optional] 
 **keywords** | [**[String]**](String.md)| Keywords to search for | [optional] 

### Return type

[**ProductPageResult**](ProductPageResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

