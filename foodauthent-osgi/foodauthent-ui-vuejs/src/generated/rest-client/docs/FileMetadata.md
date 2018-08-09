# FoodAuthentSwaggerApi.FileMetadata

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**faId** | **String** | A global id within the FoodAuthent-system. | [optional] 
**type** | **String** | The file type. | [optional] 
**name** | **String** | A name for the file. | [optional] 
**uploadName** | **String** | The name of the file as uploaded. Will be set automatically if left empty and a file is uploaded for the first time. | [optional] 
**description** | **String** | A more verbose description of the file. | [optional] 
**author** | **String** | The authors name (TODO - could reference a user in the future). | [optional] 
**_date** | **Date** | The creation date. | [optional] 
**uploadDate** | **Date** | Time and date of the file upload. Will be set automatically. | [optional] 
**version** | **Number** | The file&#39;s version. | [optional] 


<a name="TypeEnum"></a>
## Enum: TypeEnum


* `knime_workflow` (value: `"knime_workflow"`)

* `knime_model` (value: `"knime_model"`)

* `python_script` (value: `"python_script"`)

* `sop_pdf` (value: `"sop_pdf"`)

* `fingerprints_bruker` (value: `"fingerprints_bruker"`)




