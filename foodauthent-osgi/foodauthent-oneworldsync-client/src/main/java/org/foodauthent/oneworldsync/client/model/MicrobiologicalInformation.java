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
import org.foodauthent.oneworldsync.client.model.QualifiedValues;

/**
 * MicrobiologicalInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class MicrobiologicalInformation {
	@JsonProperty("microbiologicalOrganismCode")
	private CodifiedValue microbiologicalOrganismCode = null;

	@JsonProperty("microbiologicalOrganismMaximumValue")
	private QualifiedValues microbiologicalOrganismMaximumValue = null;

	@JsonProperty("microbiologicalOrganismMaximumValueBasis")
	private QualifiedValues microbiologicalOrganismMaximumValueBasis = null;

	@JsonProperty("microbiologicalOrganismMaximumValuePrecisionCode")
	private CodifiedValue microbiologicalOrganismMaximumValuePrecisionCode = null;

	@JsonProperty("microbiologicalOrganismReferenceValue")
	private QualifiedValues microbiologicalOrganismReferenceValue = null;

	@JsonProperty("microbiologicalOrganismReferenceValueBasis")
	private QualifiedValues microbiologicalOrganismReferenceValueBasis = null;

	@JsonProperty("microbiologicalOrganismReferenceValuePrecisionCode")
	private CodifiedValue microbiologicalOrganismReferenceValuePrecisionCode = null;

	@JsonProperty("microbiologicalOrganismWarningValue")
	private QualifiedValues microbiologicalOrganismWarningValue = null;

	@JsonProperty("microbiologicalOrganismWarningValueBasis")
	private QualifiedValues microbiologicalOrganismWarningValueBasis = null;

	@JsonProperty("microbiologicalOrganismWarningValuePrecisionCode")
	private CodifiedValue microbiologicalOrganismWarningValuePrecisionCode = null;

	public MicrobiologicalInformation microbiologicalOrganismCode(CodifiedValue microbiologicalOrganismCode) {
		this.microbiologicalOrganismCode = microbiologicalOrganismCode;
		return this;
	}

	/**
	 * Get microbiologicalOrganismCode
	 * 
	 * @return microbiologicalOrganismCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getMicrobiologicalOrganismCode() {
		return microbiologicalOrganismCode;
	}

	public void setMicrobiologicalOrganismCode(CodifiedValue microbiologicalOrganismCode) {
		this.microbiologicalOrganismCode = microbiologicalOrganismCode;
	}

	public MicrobiologicalInformation microbiologicalOrganismMaximumValue(
			QualifiedValues microbiologicalOrganismMaximumValue) {
		this.microbiologicalOrganismMaximumValue = microbiologicalOrganismMaximumValue;
		return this;
	}

	/**
	 * Get microbiologicalOrganismMaximumValue
	 * 
	 * @return microbiologicalOrganismMaximumValue
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getMicrobiologicalOrganismMaximumValue() {
		return microbiologicalOrganismMaximumValue;
	}

	public void setMicrobiologicalOrganismMaximumValue(QualifiedValues microbiologicalOrganismMaximumValue) {
		this.microbiologicalOrganismMaximumValue = microbiologicalOrganismMaximumValue;
	}

	public MicrobiologicalInformation microbiologicalOrganismMaximumValueBasis(
			QualifiedValues microbiologicalOrganismMaximumValueBasis) {
		this.microbiologicalOrganismMaximumValueBasis = microbiologicalOrganismMaximumValueBasis;
		return this;
	}

	/**
	 * Get microbiologicalOrganismMaximumValueBasis
	 * 
	 * @return microbiologicalOrganismMaximumValueBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getMicrobiologicalOrganismMaximumValueBasis() {
		return microbiologicalOrganismMaximumValueBasis;
	}

	public void setMicrobiologicalOrganismMaximumValueBasis(QualifiedValues microbiologicalOrganismMaximumValueBasis) {
		this.microbiologicalOrganismMaximumValueBasis = microbiologicalOrganismMaximumValueBasis;
	}

	public MicrobiologicalInformation microbiologicalOrganismMaximumValuePrecisionCode(
			CodifiedValue microbiologicalOrganismMaximumValuePrecisionCode) {
		this.microbiologicalOrganismMaximumValuePrecisionCode = microbiologicalOrganismMaximumValuePrecisionCode;
		return this;
	}

	/**
	 * Get microbiologicalOrganismMaximumValuePrecisionCode
	 * 
	 * @return microbiologicalOrganismMaximumValuePrecisionCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getMicrobiologicalOrganismMaximumValuePrecisionCode() {
		return microbiologicalOrganismMaximumValuePrecisionCode;
	}

	public void setMicrobiologicalOrganismMaximumValuePrecisionCode(
			CodifiedValue microbiologicalOrganismMaximumValuePrecisionCode) {
		this.microbiologicalOrganismMaximumValuePrecisionCode = microbiologicalOrganismMaximumValuePrecisionCode;
	}

	public MicrobiologicalInformation microbiologicalOrganismReferenceValue(
			QualifiedValues microbiologicalOrganismReferenceValue) {
		this.microbiologicalOrganismReferenceValue = microbiologicalOrganismReferenceValue;
		return this;
	}

	/**
	 * Get microbiologicalOrganismReferenceValue
	 * 
	 * @return microbiologicalOrganismReferenceValue
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getMicrobiologicalOrganismReferenceValue() {
		return microbiologicalOrganismReferenceValue;
	}

	public void setMicrobiologicalOrganismReferenceValue(QualifiedValues microbiologicalOrganismReferenceValue) {
		this.microbiologicalOrganismReferenceValue = microbiologicalOrganismReferenceValue;
	}

	public MicrobiologicalInformation microbiologicalOrganismReferenceValueBasis(
			QualifiedValues microbiologicalOrganismReferenceValueBasis) {
		this.microbiologicalOrganismReferenceValueBasis = microbiologicalOrganismReferenceValueBasis;
		return this;
	}

	/**
	 * Get microbiologicalOrganismReferenceValueBasis
	 * 
	 * @return microbiologicalOrganismReferenceValueBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getMicrobiologicalOrganismReferenceValueBasis() {
		return microbiologicalOrganismReferenceValueBasis;
	}

	public void setMicrobiologicalOrganismReferenceValueBasis(
			QualifiedValues microbiologicalOrganismReferenceValueBasis) {
		this.microbiologicalOrganismReferenceValueBasis = microbiologicalOrganismReferenceValueBasis;
	}

	public MicrobiologicalInformation microbiologicalOrganismReferenceValuePrecisionCode(
			CodifiedValue microbiologicalOrganismReferenceValuePrecisionCode) {
		this.microbiologicalOrganismReferenceValuePrecisionCode = microbiologicalOrganismReferenceValuePrecisionCode;
		return this;
	}

	/**
	 * Get microbiologicalOrganismReferenceValuePrecisionCode
	 * 
	 * @return microbiologicalOrganismReferenceValuePrecisionCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getMicrobiologicalOrganismReferenceValuePrecisionCode() {
		return microbiologicalOrganismReferenceValuePrecisionCode;
	}

	public void setMicrobiologicalOrganismReferenceValuePrecisionCode(
			CodifiedValue microbiologicalOrganismReferenceValuePrecisionCode) {
		this.microbiologicalOrganismReferenceValuePrecisionCode = microbiologicalOrganismReferenceValuePrecisionCode;
	}

	public MicrobiologicalInformation microbiologicalOrganismWarningValue(
			QualifiedValues microbiologicalOrganismWarningValue) {
		this.microbiologicalOrganismWarningValue = microbiologicalOrganismWarningValue;
		return this;
	}

	/**
	 * Get microbiologicalOrganismWarningValue
	 * 
	 * @return microbiologicalOrganismWarningValue
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getMicrobiologicalOrganismWarningValue() {
		return microbiologicalOrganismWarningValue;
	}

	public void setMicrobiologicalOrganismWarningValue(QualifiedValues microbiologicalOrganismWarningValue) {
		this.microbiologicalOrganismWarningValue = microbiologicalOrganismWarningValue;
	}

	public MicrobiologicalInformation microbiologicalOrganismWarningValueBasis(
			QualifiedValues microbiologicalOrganismWarningValueBasis) {
		this.microbiologicalOrganismWarningValueBasis = microbiologicalOrganismWarningValueBasis;
		return this;
	}

	/**
	 * Get microbiologicalOrganismWarningValueBasis
	 * 
	 * @return microbiologicalOrganismWarningValueBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getMicrobiologicalOrganismWarningValueBasis() {
		return microbiologicalOrganismWarningValueBasis;
	}

	public void setMicrobiologicalOrganismWarningValueBasis(QualifiedValues microbiologicalOrganismWarningValueBasis) {
		this.microbiologicalOrganismWarningValueBasis = microbiologicalOrganismWarningValueBasis;
	}

	public MicrobiologicalInformation microbiologicalOrganismWarningValuePrecisionCode(
			CodifiedValue microbiologicalOrganismWarningValuePrecisionCode) {
		this.microbiologicalOrganismWarningValuePrecisionCode = microbiologicalOrganismWarningValuePrecisionCode;
		return this;
	}

	/**
	 * Get microbiologicalOrganismWarningValuePrecisionCode
	 * 
	 * @return microbiologicalOrganismWarningValuePrecisionCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getMicrobiologicalOrganismWarningValuePrecisionCode() {
		return microbiologicalOrganismWarningValuePrecisionCode;
	}

	public void setMicrobiologicalOrganismWarningValuePrecisionCode(
			CodifiedValue microbiologicalOrganismWarningValuePrecisionCode) {
		this.microbiologicalOrganismWarningValuePrecisionCode = microbiologicalOrganismWarningValuePrecisionCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MicrobiologicalInformation microbiologicalInformation = (MicrobiologicalInformation) o;
		return Objects.equals(this.microbiologicalOrganismCode, microbiologicalInformation.microbiologicalOrganismCode)
				&& Objects.equals(this.microbiologicalOrganismMaximumValue,
						microbiologicalInformation.microbiologicalOrganismMaximumValue)
				&& Objects.equals(this.microbiologicalOrganismMaximumValueBasis,
						microbiologicalInformation.microbiologicalOrganismMaximumValueBasis)
				&& Objects.equals(this.microbiologicalOrganismMaximumValuePrecisionCode,
						microbiologicalInformation.microbiologicalOrganismMaximumValuePrecisionCode)
				&& Objects.equals(this.microbiologicalOrganismReferenceValue,
						microbiologicalInformation.microbiologicalOrganismReferenceValue)
				&& Objects.equals(this.microbiologicalOrganismReferenceValueBasis,
						microbiologicalInformation.microbiologicalOrganismReferenceValueBasis)
				&& Objects.equals(this.microbiologicalOrganismReferenceValuePrecisionCode,
						microbiologicalInformation.microbiologicalOrganismReferenceValuePrecisionCode)
				&& Objects.equals(this.microbiologicalOrganismWarningValue,
						microbiologicalInformation.microbiologicalOrganismWarningValue)
				&& Objects.equals(this.microbiologicalOrganismWarningValueBasis,
						microbiologicalInformation.microbiologicalOrganismWarningValueBasis)
				&& Objects.equals(this.microbiologicalOrganismWarningValuePrecisionCode,
						microbiologicalInformation.microbiologicalOrganismWarningValuePrecisionCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(microbiologicalOrganismCode, microbiologicalOrganismMaximumValue,
				microbiologicalOrganismMaximumValueBasis, microbiologicalOrganismMaximumValuePrecisionCode,
				microbiologicalOrganismReferenceValue, microbiologicalOrganismReferenceValueBasis,
				microbiologicalOrganismReferenceValuePrecisionCode, microbiologicalOrganismWarningValue,
				microbiologicalOrganismWarningValueBasis, microbiologicalOrganismWarningValuePrecisionCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MicrobiologicalInformation {\n");

		sb.append("    microbiologicalOrganismCode: ").append(toIndentedString(microbiologicalOrganismCode))
				.append("\n");
		sb.append("    microbiologicalOrganismMaximumValue: ")
				.append(toIndentedString(microbiologicalOrganismMaximumValue)).append("\n");
		sb.append("    microbiologicalOrganismMaximumValueBasis: ")
				.append(toIndentedString(microbiologicalOrganismMaximumValueBasis)).append("\n");
		sb.append("    microbiologicalOrganismMaximumValuePrecisionCode: ")
				.append(toIndentedString(microbiologicalOrganismMaximumValuePrecisionCode)).append("\n");
		sb.append("    microbiologicalOrganismReferenceValue: ")
				.append(toIndentedString(microbiologicalOrganismReferenceValue)).append("\n");
		sb.append("    microbiologicalOrganismReferenceValueBasis: ")
				.append(toIndentedString(microbiologicalOrganismReferenceValueBasis)).append("\n");
		sb.append("    microbiologicalOrganismReferenceValuePrecisionCode: ")
				.append(toIndentedString(microbiologicalOrganismReferenceValuePrecisionCode)).append("\n");
		sb.append("    microbiologicalOrganismWarningValue: ")
				.append(toIndentedString(microbiologicalOrganismWarningValue)).append("\n");
		sb.append("    microbiologicalOrganismWarningValueBasis: ")
				.append(toIndentedString(microbiologicalOrganismWarningValueBasis)).append("\n");
		sb.append("    microbiologicalOrganismWarningValuePrecisionCode: ")
				.append(toIndentedString(microbiologicalOrganismWarningValuePrecisionCode)).append("\n");
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
