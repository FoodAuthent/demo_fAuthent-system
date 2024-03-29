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
 * PhysiochemicalCharacteristic
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class PhysiochemicalCharacteristic {
	@JsonProperty("physiochemicalCharacteristicCode")
	private CodifiedValue physiochemicalCharacteristicCode = null;

	@JsonProperty("physiochemicalCharacteristicReferenceValue")
	private QualifiedValues physiochemicalCharacteristicReferenceValue = null;

	@JsonProperty("physiochemicalCharacteristicReferenceValueBasis")
	private QualifiedValues physiochemicalCharacteristicReferenceValueBasis = null;

	@JsonProperty("physiochemicalCharacteristicReferenceValuePrecisionCode")
	private CodifiedValue physiochemicalCharacteristicReferenceValuePrecisionCode = null;

	@JsonProperty("physiochemicalCharacteristicValue")
	private QualifiedValues physiochemicalCharacteristicValue = null;

	@JsonProperty("physiochemicalCharacteristicValueBasis")
	private QualifiedValues physiochemicalCharacteristicValueBasis = null;

	@JsonProperty("physiochemicalCharacteristicValuePrecisionCode")
	private CodifiedValue physiochemicalCharacteristicValuePrecisionCode = null;

	@JsonProperty("physiochemicalCharacteristicWarningValue")
	private QualifiedValues physiochemicalCharacteristicWarningValue = null;

	@JsonProperty("physiochemicalCharacteristicWarningValueBasis")
	private QualifiedValues physiochemicalCharacteristicWarningValueBasis = null;

	@JsonProperty("physiochemicalCharacteristicWarningValuePrecisionCode")
	private CodifiedValue physiochemicalCharacteristicWarningValuePrecisionCode = null;

	public PhysiochemicalCharacteristic physiochemicalCharacteristicCode(
			CodifiedValue physiochemicalCharacteristicCode) {
		this.physiochemicalCharacteristicCode = physiochemicalCharacteristicCode;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicCode
	 * 
	 * @return physiochemicalCharacteristicCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getPhysiochemicalCharacteristicCode() {
		return physiochemicalCharacteristicCode;
	}

	public void setPhysiochemicalCharacteristicCode(CodifiedValue physiochemicalCharacteristicCode) {
		this.physiochemicalCharacteristicCode = physiochemicalCharacteristicCode;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicReferenceValue(
			QualifiedValues physiochemicalCharacteristicReferenceValue) {
		this.physiochemicalCharacteristicReferenceValue = physiochemicalCharacteristicReferenceValue;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicReferenceValue
	 * 
	 * @return physiochemicalCharacteristicReferenceValue
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getPhysiochemicalCharacteristicReferenceValue() {
		return physiochemicalCharacteristicReferenceValue;
	}

	public void setPhysiochemicalCharacteristicReferenceValue(
			QualifiedValues physiochemicalCharacteristicReferenceValue) {
		this.physiochemicalCharacteristicReferenceValue = physiochemicalCharacteristicReferenceValue;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicReferenceValueBasis(
			QualifiedValues physiochemicalCharacteristicReferenceValueBasis) {
		this.physiochemicalCharacteristicReferenceValueBasis = physiochemicalCharacteristicReferenceValueBasis;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicReferenceValueBasis
	 * 
	 * @return physiochemicalCharacteristicReferenceValueBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getPhysiochemicalCharacteristicReferenceValueBasis() {
		return physiochemicalCharacteristicReferenceValueBasis;
	}

	public void setPhysiochemicalCharacteristicReferenceValueBasis(
			QualifiedValues physiochemicalCharacteristicReferenceValueBasis) {
		this.physiochemicalCharacteristicReferenceValueBasis = physiochemicalCharacteristicReferenceValueBasis;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicReferenceValuePrecisionCode(
			CodifiedValue physiochemicalCharacteristicReferenceValuePrecisionCode) {
		this.physiochemicalCharacteristicReferenceValuePrecisionCode = physiochemicalCharacteristicReferenceValuePrecisionCode;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicReferenceValuePrecisionCode
	 * 
	 * @return physiochemicalCharacteristicReferenceValuePrecisionCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getPhysiochemicalCharacteristicReferenceValuePrecisionCode() {
		return physiochemicalCharacteristicReferenceValuePrecisionCode;
	}

	public void setPhysiochemicalCharacteristicReferenceValuePrecisionCode(
			CodifiedValue physiochemicalCharacteristicReferenceValuePrecisionCode) {
		this.physiochemicalCharacteristicReferenceValuePrecisionCode = physiochemicalCharacteristicReferenceValuePrecisionCode;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicValue(
			QualifiedValues physiochemicalCharacteristicValue) {
		this.physiochemicalCharacteristicValue = physiochemicalCharacteristicValue;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicValue
	 * 
	 * @return physiochemicalCharacteristicValue
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getPhysiochemicalCharacteristicValue() {
		return physiochemicalCharacteristicValue;
	}

	public void setPhysiochemicalCharacteristicValue(QualifiedValues physiochemicalCharacteristicValue) {
		this.physiochemicalCharacteristicValue = physiochemicalCharacteristicValue;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicValueBasis(
			QualifiedValues physiochemicalCharacteristicValueBasis) {
		this.physiochemicalCharacteristicValueBasis = physiochemicalCharacteristicValueBasis;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicValueBasis
	 * 
	 * @return physiochemicalCharacteristicValueBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getPhysiochemicalCharacteristicValueBasis() {
		return physiochemicalCharacteristicValueBasis;
	}

	public void setPhysiochemicalCharacteristicValueBasis(QualifiedValues physiochemicalCharacteristicValueBasis) {
		this.physiochemicalCharacteristicValueBasis = physiochemicalCharacteristicValueBasis;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicValuePrecisionCode(
			CodifiedValue physiochemicalCharacteristicValuePrecisionCode) {
		this.physiochemicalCharacteristicValuePrecisionCode = physiochemicalCharacteristicValuePrecisionCode;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicValuePrecisionCode
	 * 
	 * @return physiochemicalCharacteristicValuePrecisionCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getPhysiochemicalCharacteristicValuePrecisionCode() {
		return physiochemicalCharacteristicValuePrecisionCode;
	}

	public void setPhysiochemicalCharacteristicValuePrecisionCode(
			CodifiedValue physiochemicalCharacteristicValuePrecisionCode) {
		this.physiochemicalCharacteristicValuePrecisionCode = physiochemicalCharacteristicValuePrecisionCode;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicWarningValue(
			QualifiedValues physiochemicalCharacteristicWarningValue) {
		this.physiochemicalCharacteristicWarningValue = physiochemicalCharacteristicWarningValue;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicWarningValue
	 * 
	 * @return physiochemicalCharacteristicWarningValue
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getPhysiochemicalCharacteristicWarningValue() {
		return physiochemicalCharacteristicWarningValue;
	}

	public void setPhysiochemicalCharacteristicWarningValue(QualifiedValues physiochemicalCharacteristicWarningValue) {
		this.physiochemicalCharacteristicWarningValue = physiochemicalCharacteristicWarningValue;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicWarningValueBasis(
			QualifiedValues physiochemicalCharacteristicWarningValueBasis) {
		this.physiochemicalCharacteristicWarningValueBasis = physiochemicalCharacteristicWarningValueBasis;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicWarningValueBasis
	 * 
	 * @return physiochemicalCharacteristicWarningValueBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getPhysiochemicalCharacteristicWarningValueBasis() {
		return physiochemicalCharacteristicWarningValueBasis;
	}

	public void setPhysiochemicalCharacteristicWarningValueBasis(
			QualifiedValues physiochemicalCharacteristicWarningValueBasis) {
		this.physiochemicalCharacteristicWarningValueBasis = physiochemicalCharacteristicWarningValueBasis;
	}

	public PhysiochemicalCharacteristic physiochemicalCharacteristicWarningValuePrecisionCode(
			CodifiedValue physiochemicalCharacteristicWarningValuePrecisionCode) {
		this.physiochemicalCharacteristicWarningValuePrecisionCode = physiochemicalCharacteristicWarningValuePrecisionCode;
		return this;
	}

	/**
	 * Get physiochemicalCharacteristicWarningValuePrecisionCode
	 * 
	 * @return physiochemicalCharacteristicWarningValuePrecisionCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getPhysiochemicalCharacteristicWarningValuePrecisionCode() {
		return physiochemicalCharacteristicWarningValuePrecisionCode;
	}

	public void setPhysiochemicalCharacteristicWarningValuePrecisionCode(
			CodifiedValue physiochemicalCharacteristicWarningValuePrecisionCode) {
		this.physiochemicalCharacteristicWarningValuePrecisionCode = physiochemicalCharacteristicWarningValuePrecisionCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PhysiochemicalCharacteristic physiochemicalCharacteristic = (PhysiochemicalCharacteristic) o;
		return Objects.equals(this.physiochemicalCharacteristicCode,
				physiochemicalCharacteristic.physiochemicalCharacteristicCode)
				&& Objects.equals(this.physiochemicalCharacteristicReferenceValue,
						physiochemicalCharacteristic.physiochemicalCharacteristicReferenceValue)
				&& Objects.equals(this.physiochemicalCharacteristicReferenceValueBasis,
						physiochemicalCharacteristic.physiochemicalCharacteristicReferenceValueBasis)
				&& Objects.equals(this.physiochemicalCharacteristicReferenceValuePrecisionCode,
						physiochemicalCharacteristic.physiochemicalCharacteristicReferenceValuePrecisionCode)
				&& Objects.equals(this.physiochemicalCharacteristicValue,
						physiochemicalCharacteristic.physiochemicalCharacteristicValue)
				&& Objects.equals(this.physiochemicalCharacteristicValueBasis,
						physiochemicalCharacteristic.physiochemicalCharacteristicValueBasis)
				&& Objects.equals(this.physiochemicalCharacteristicValuePrecisionCode,
						physiochemicalCharacteristic.physiochemicalCharacteristicValuePrecisionCode)
				&& Objects.equals(this.physiochemicalCharacteristicWarningValue,
						physiochemicalCharacteristic.physiochemicalCharacteristicWarningValue)
				&& Objects.equals(this.physiochemicalCharacteristicWarningValueBasis,
						physiochemicalCharacteristic.physiochemicalCharacteristicWarningValueBasis)
				&& Objects.equals(this.physiochemicalCharacteristicWarningValuePrecisionCode,
						physiochemicalCharacteristic.physiochemicalCharacteristicWarningValuePrecisionCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(physiochemicalCharacteristicCode, physiochemicalCharacteristicReferenceValue,
				physiochemicalCharacteristicReferenceValueBasis,
				physiochemicalCharacteristicReferenceValuePrecisionCode, physiochemicalCharacteristicValue,
				physiochemicalCharacteristicValueBasis, physiochemicalCharacteristicValuePrecisionCode,
				physiochemicalCharacteristicWarningValue, physiochemicalCharacteristicWarningValueBasis,
				physiochemicalCharacteristicWarningValuePrecisionCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PhysiochemicalCharacteristic {\n");

		sb.append("    physiochemicalCharacteristicCode: ").append(toIndentedString(physiochemicalCharacteristicCode))
				.append("\n");
		sb.append("    physiochemicalCharacteristicReferenceValue: ")
				.append(toIndentedString(physiochemicalCharacteristicReferenceValue)).append("\n");
		sb.append("    physiochemicalCharacteristicReferenceValueBasis: ")
				.append(toIndentedString(physiochemicalCharacteristicReferenceValueBasis)).append("\n");
		sb.append("    physiochemicalCharacteristicReferenceValuePrecisionCode: ")
				.append(toIndentedString(physiochemicalCharacteristicReferenceValuePrecisionCode)).append("\n");
		sb.append("    physiochemicalCharacteristicValue: ").append(toIndentedString(physiochemicalCharacteristicValue))
				.append("\n");
		sb.append("    physiochemicalCharacteristicValueBasis: ")
				.append(toIndentedString(physiochemicalCharacteristicValueBasis)).append("\n");
		sb.append("    physiochemicalCharacteristicValuePrecisionCode: ")
				.append(toIndentedString(physiochemicalCharacteristicValuePrecisionCode)).append("\n");
		sb.append("    physiochemicalCharacteristicWarningValue: ")
				.append(toIndentedString(physiochemicalCharacteristicWarningValue)).append("\n");
		sb.append("    physiochemicalCharacteristicWarningValueBasis: ")
				.append(toIndentedString(physiochemicalCharacteristicWarningValueBasis)).append("\n");
		sb.append("    physiochemicalCharacteristicWarningValuePrecisionCode: ")
				.append(toIndentedString(physiochemicalCharacteristicWarningValuePrecisionCode)).append("\n");
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
