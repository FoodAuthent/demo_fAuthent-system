# FoodAuthentSwaggerApi.FingerprintSet

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**faId** | **String** | A global id within the FoodAuthent-system. | [optional] 
**productId** | **String** | The fa-id of the product all fingerprints are associated with. | 
**fingerprints** | [**[Fingerprint]**](Fingerprint.md) | The fingerprints. | [optional] 
**fileId** | **String** | Id referencing the fingerpint-set file. | 
**name** | **String** | A human-readable name of the fingerprint set. | [optional] 
**metadata** | **String** | Placeholder for more (fixed) metadata (including device settings etc.). Possibly automatically determined upon creation of the fingerprint-set. | [optional] 
**additionalProperties** | **{String: String}** | Key-value-map for additional properties. | [optional] 


