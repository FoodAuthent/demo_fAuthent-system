/*
 * 1WorldSync Content1 API
 * Content1 will provide access to accurate, trusted product data sourced directly from the Brand Owners through 1WorldSync’s APIs. This full set of product information is readily available to you through a set of web services, allowing you to get up-to-date, complete product information. <br/><br/>The following APIs are available<ul><li>Product Search API - Performs a search against the product data published in ContentNOW to find products that meet the supplied criteria. For each search result displayed, a basic set of information about the product is provided. While performing a product search only a subset from the entire list of attributes for an item will be returned.</li><li>Product Fetch API - Once a Product Search has been performed, the full set of atrribute information on a given product can be retrieved using the Product Fetch API and the item reference id (obtained through the search).</li></ul><p>This tool features a fully functional form which will call the Content1 API in real time.  To unlock the API call, you must have your client secret key provided through <a href=\"#\" onclick=\"openWindow('https://developer.1worldsync.com', 'Content1')\">developer.1worldsync.com</a>. Enter that key in the top right of this page to unlock the API calls used below.</p><p>Don't have a key but want to read the documenation? Go ahead! Basic API documentation is provided below.</p><div style=\"border: 1px solid transparent;color:#fff;background-color: #00ACC8;padding-left: 10px;height:30px;font-weight:bold;font-size:1.3em;margin:0;font-family: ProximaNova;padding-top:10px\">Search and Fetch Model Schemas</div><ul><li><a href=\"../doc/1WorldSync_Content1_Product_Search_Model_Schema_Guide_v3.1.6.1.pdf\" target=\"_blank\">Search Model Schema</a></li><li><a href=\"../doc/1WorldSync_Content1_Product_Fetch_Model_Schema_Guide_v3.1.6.6.pdf\" target=\"_blank\">Fetch Model Schema</a> </li></ul>
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.foodauthent.oneworldsync.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.foodauthent.oneworldsync.client.model.CodifiedValue;
import org.foodauthent.oneworldsync.client.model.CodifiedValues;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.Values;

/**
 * ChildNutritionLabelDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class ChildNutritionLabelDocument {
	@JsonProperty("contentDescription")
	private LanguageLabels contentDescription = null;

	@JsonProperty("fileCreationProgram")
	private Values fileCreationProgram = null;

	@JsonProperty("fileEffectiveEndDateTime")
	private String fileEffectiveEndDateTime = null;

	@JsonProperty("fileEffectiveStartDateTime")
	private String fileEffectiveStartDateTime = null;

	@JsonProperty("fileFormatDescription")
	private LanguageLabels fileFormatDescription = null;

	@JsonProperty("fileFormatName")
	private String fileFormatName = null;

	@JsonProperty("fileLanguageCode")
	private CodifiedValues fileLanguageCode = null;

	@JsonProperty("fileName")
	private String fileName = null;

	@JsonProperty("fileOptimalViewerName")
	private Values fileOptimalViewerName = null;

	@JsonProperty("fileOriginCountryCode")
	private CodifiedValues fileOriginCountryCode = null;

	@JsonProperty("fileVersion")
	private String fileVersion = null;

	@JsonProperty("isPrimaryFile")
	private String isPrimaryFile = null;

	@JsonProperty("referencedFileTypeCode")
	private CodifiedValue referencedFileTypeCode = null;

	@JsonProperty("uniformResourceIdentifier")
	private String uniformResourceIdentifier = null;

	public ChildNutritionLabelDocument contentDescription(LanguageLabels contentDescription) {
		this.contentDescription = contentDescription;
		return this;
	}

	/**
	 * Get contentDescription
	 * 
	 * @return contentDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(LanguageLabels contentDescription) {
		this.contentDescription = contentDescription;
	}

	public ChildNutritionLabelDocument fileCreationProgram(Values fileCreationProgram) {
		this.fileCreationProgram = fileCreationProgram;
		return this;
	}

	/**
	 * Get fileCreationProgram
	 * 
	 * @return fileCreationProgram
	 **/
	@ApiModelProperty(value = "")
	public Values getFileCreationProgram() {
		return fileCreationProgram;
	}

	public void setFileCreationProgram(Values fileCreationProgram) {
		this.fileCreationProgram = fileCreationProgram;
	}

	public ChildNutritionLabelDocument fileEffectiveEndDateTime(String fileEffectiveEndDateTime) {
		this.fileEffectiveEndDateTime = fileEffectiveEndDateTime;
		return this;
	}

	/**
	 * Get fileEffectiveEndDateTime
	 * 
	 * @return fileEffectiveEndDateTime
	 **/
	@ApiModelProperty(value = "")
	public String getFileEffectiveEndDateTime() {
		return fileEffectiveEndDateTime;
	}

	public void setFileEffectiveEndDateTime(String fileEffectiveEndDateTime) {
		this.fileEffectiveEndDateTime = fileEffectiveEndDateTime;
	}

	public ChildNutritionLabelDocument fileEffectiveStartDateTime(String fileEffectiveStartDateTime) {
		this.fileEffectiveStartDateTime = fileEffectiveStartDateTime;
		return this;
	}

	/**
	 * Get fileEffectiveStartDateTime
	 * 
	 * @return fileEffectiveStartDateTime
	 **/
	@ApiModelProperty(value = "")
	public String getFileEffectiveStartDateTime() {
		return fileEffectiveStartDateTime;
	}

	public void setFileEffectiveStartDateTime(String fileEffectiveStartDateTime) {
		this.fileEffectiveStartDateTime = fileEffectiveStartDateTime;
	}

	public ChildNutritionLabelDocument fileFormatDescription(LanguageLabels fileFormatDescription) {
		this.fileFormatDescription = fileFormatDescription;
		return this;
	}

	/**
	 * Get fileFormatDescription
	 * 
	 * @return fileFormatDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getFileFormatDescription() {
		return fileFormatDescription;
	}

	public void setFileFormatDescription(LanguageLabels fileFormatDescription) {
		this.fileFormatDescription = fileFormatDescription;
	}

	public ChildNutritionLabelDocument fileFormatName(String fileFormatName) {
		this.fileFormatName = fileFormatName;
		return this;
	}

	/**
	 * Get fileFormatName
	 * 
	 * @return fileFormatName
	 **/
	@ApiModelProperty(value = "")
	public String getFileFormatName() {
		return fileFormatName;
	}

	public void setFileFormatName(String fileFormatName) {
		this.fileFormatName = fileFormatName;
	}

	public ChildNutritionLabelDocument fileLanguageCode(CodifiedValues fileLanguageCode) {
		this.fileLanguageCode = fileLanguageCode;
		return this;
	}

	/**
	 * Get fileLanguageCode
	 * 
	 * @return fileLanguageCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValues getFileLanguageCode() {
		return fileLanguageCode;
	}

	public void setFileLanguageCode(CodifiedValues fileLanguageCode) {
		this.fileLanguageCode = fileLanguageCode;
	}

	public ChildNutritionLabelDocument fileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	/**
	 * Get fileName
	 * 
	 * @return fileName
	 **/
	@ApiModelProperty(value = "")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ChildNutritionLabelDocument fileOptimalViewerName(Values fileOptimalViewerName) {
		this.fileOptimalViewerName = fileOptimalViewerName;
		return this;
	}

	/**
	 * Get fileOptimalViewerName
	 * 
	 * @return fileOptimalViewerName
	 **/
	@ApiModelProperty(value = "")
	public Values getFileOptimalViewerName() {
		return fileOptimalViewerName;
	}

	public void setFileOptimalViewerName(Values fileOptimalViewerName) {
		this.fileOptimalViewerName = fileOptimalViewerName;
	}

	public ChildNutritionLabelDocument fileOriginCountryCode(CodifiedValues fileOriginCountryCode) {
		this.fileOriginCountryCode = fileOriginCountryCode;
		return this;
	}

	/**
	 * Get fileOriginCountryCode
	 * 
	 * @return fileOriginCountryCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValues getFileOriginCountryCode() {
		return fileOriginCountryCode;
	}

	public void setFileOriginCountryCode(CodifiedValues fileOriginCountryCode) {
		this.fileOriginCountryCode = fileOriginCountryCode;
	}

	public ChildNutritionLabelDocument fileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
		return this;
	}

	/**
	 * Get fileVersion
	 * 
	 * @return fileVersion
	 **/
	@ApiModelProperty(value = "")
	public String getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}

	public ChildNutritionLabelDocument isPrimaryFile(String isPrimaryFile) {
		this.isPrimaryFile = isPrimaryFile;
		return this;
	}

	/**
	 * Get isPrimaryFile
	 * 
	 * @return isPrimaryFile
	 **/
	@ApiModelProperty(value = "")
	public String getIsPrimaryFile() {
		return isPrimaryFile;
	}

	public void setIsPrimaryFile(String isPrimaryFile) {
		this.isPrimaryFile = isPrimaryFile;
	}

	public ChildNutritionLabelDocument referencedFileTypeCode(CodifiedValue referencedFileTypeCode) {
		this.referencedFileTypeCode = referencedFileTypeCode;
		return this;
	}

	/**
	 * Get referencedFileTypeCode
	 * 
	 * @return referencedFileTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getReferencedFileTypeCode() {
		return referencedFileTypeCode;
	}

	public void setReferencedFileTypeCode(CodifiedValue referencedFileTypeCode) {
		this.referencedFileTypeCode = referencedFileTypeCode;
	}

	public ChildNutritionLabelDocument uniformResourceIdentifier(String uniformResourceIdentifier) {
		this.uniformResourceIdentifier = uniformResourceIdentifier;
		return this;
	}

	/**
	 * Get uniformResourceIdentifier
	 * 
	 * @return uniformResourceIdentifier
	 **/
	@ApiModelProperty(value = "")
	public String getUniformResourceIdentifier() {
		return uniformResourceIdentifier;
	}

	public void setUniformResourceIdentifier(String uniformResourceIdentifier) {
		this.uniformResourceIdentifier = uniformResourceIdentifier;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ChildNutritionLabelDocument childNutritionLabelDocument = (ChildNutritionLabelDocument) o;
		return Objects.equals(this.contentDescription, childNutritionLabelDocument.contentDescription)
				&& Objects.equals(this.fileCreationProgram, childNutritionLabelDocument.fileCreationProgram)
				&& Objects.equals(this.fileEffectiveEndDateTime, childNutritionLabelDocument.fileEffectiveEndDateTime)
				&& Objects.equals(this.fileEffectiveStartDateTime,
						childNutritionLabelDocument.fileEffectiveStartDateTime)
				&& Objects.equals(this.fileFormatDescription, childNutritionLabelDocument.fileFormatDescription)
				&& Objects.equals(this.fileFormatName, childNutritionLabelDocument.fileFormatName)
				&& Objects.equals(this.fileLanguageCode, childNutritionLabelDocument.fileLanguageCode)
				&& Objects.equals(this.fileName, childNutritionLabelDocument.fileName)
				&& Objects.equals(this.fileOptimalViewerName, childNutritionLabelDocument.fileOptimalViewerName)
				&& Objects.equals(this.fileOriginCountryCode, childNutritionLabelDocument.fileOriginCountryCode)
				&& Objects.equals(this.fileVersion, childNutritionLabelDocument.fileVersion)
				&& Objects.equals(this.isPrimaryFile, childNutritionLabelDocument.isPrimaryFile)
				&& Objects.equals(this.referencedFileTypeCode, childNutritionLabelDocument.referencedFileTypeCode)
				&& Objects.equals(this.uniformResourceIdentifier,
						childNutritionLabelDocument.uniformResourceIdentifier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(contentDescription, fileCreationProgram, fileEffectiveEndDateTime,
				fileEffectiveStartDateTime, fileFormatDescription, fileFormatName, fileLanguageCode, fileName,
				fileOptimalViewerName, fileOriginCountryCode, fileVersion, isPrimaryFile, referencedFileTypeCode,
				uniformResourceIdentifier);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ChildNutritionLabelDocument {\n");

		sb.append("    contentDescription: ").append(toIndentedString(contentDescription)).append("\n");
		sb.append("    fileCreationProgram: ").append(toIndentedString(fileCreationProgram)).append("\n");
		sb.append("    fileEffectiveEndDateTime: ").append(toIndentedString(fileEffectiveEndDateTime)).append("\n");
		sb.append("    fileEffectiveStartDateTime: ").append(toIndentedString(fileEffectiveStartDateTime)).append("\n");
		sb.append("    fileFormatDescription: ").append(toIndentedString(fileFormatDescription)).append("\n");
		sb.append("    fileFormatName: ").append(toIndentedString(fileFormatName)).append("\n");
		sb.append("    fileLanguageCode: ").append(toIndentedString(fileLanguageCode)).append("\n");
		sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
		sb.append("    fileOptimalViewerName: ").append(toIndentedString(fileOptimalViewerName)).append("\n");
		sb.append("    fileOriginCountryCode: ").append(toIndentedString(fileOriginCountryCode)).append("\n");
		sb.append("    fileVersion: ").append(toIndentedString(fileVersion)).append("\n");
		sb.append("    isPrimaryFile: ").append(toIndentedString(isPrimaryFile)).append("\n");
		sb.append("    referencedFileTypeCode: ").append(toIndentedString(referencedFileTypeCode)).append("\n");
		sb.append("    uniformResourceIdentifier: ").append(toIndentedString(uniformResourceIdentifier)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
