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
import org.foodauthent.oneworldsync.client.model.QualifiedValue;

/**
 * PegMeasurements
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class PegMeasurements {
	@JsonProperty("pegHoleNumber")
	private String pegHoleNumber = null;

	@JsonProperty("pegHoleTypeCode")
	private CodifiedValue pegHoleTypeCode = null;

	@JsonProperty("pegHorizontal")
	private QualifiedValue pegHorizontal = null;

	@JsonProperty("pegVertical")
	private QualifiedValue pegVertical = null;

	public PegMeasurements pegHoleNumber(String pegHoleNumber) {
		this.pegHoleNumber = pegHoleNumber;
		return this;
	}

	/**
	 * Get pegHoleNumber
	 * 
	 * @return pegHoleNumber
	 **/
	@ApiModelProperty(value = "")
	public String getPegHoleNumber() {
		return pegHoleNumber;
	}

	public void setPegHoleNumber(String pegHoleNumber) {
		this.pegHoleNumber = pegHoleNumber;
	}

	public PegMeasurements pegHoleTypeCode(CodifiedValue pegHoleTypeCode) {
		this.pegHoleTypeCode = pegHoleTypeCode;
		return this;
	}

	/**
	 * Get pegHoleTypeCode
	 * 
	 * @return pegHoleTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getPegHoleTypeCode() {
		return pegHoleTypeCode;
	}

	public void setPegHoleTypeCode(CodifiedValue pegHoleTypeCode) {
		this.pegHoleTypeCode = pegHoleTypeCode;
	}

	public PegMeasurements pegHorizontal(QualifiedValue pegHorizontal) {
		this.pegHorizontal = pegHorizontal;
		return this;
	}

	/**
	 * Get pegHorizontal
	 * 
	 * @return pegHorizontal
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValue getPegHorizontal() {
		return pegHorizontal;
	}

	public void setPegHorizontal(QualifiedValue pegHorizontal) {
		this.pegHorizontal = pegHorizontal;
	}

	public PegMeasurements pegVertical(QualifiedValue pegVertical) {
		this.pegVertical = pegVertical;
		return this;
	}

	/**
	 * Get pegVertical
	 * 
	 * @return pegVertical
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValue getPegVertical() {
		return pegVertical;
	}

	public void setPegVertical(QualifiedValue pegVertical) {
		this.pegVertical = pegVertical;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PegMeasurements pegMeasurements = (PegMeasurements) o;
		return Objects.equals(this.pegHoleNumber, pegMeasurements.pegHoleNumber)
				&& Objects.equals(this.pegHoleTypeCode, pegMeasurements.pegHoleTypeCode)
				&& Objects.equals(this.pegHorizontal, pegMeasurements.pegHorizontal)
				&& Objects.equals(this.pegVertical, pegMeasurements.pegVertical);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pegHoleNumber, pegHoleTypeCode, pegHorizontal, pegVertical);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PegMeasurements {\n");

		sb.append("    pegHoleNumber: ").append(toIndentedString(pegHoleNumber)).append("\n");
		sb.append("    pegHoleTypeCode: ").append(toIndentedString(pegHoleTypeCode)).append("\n");
		sb.append("    pegHorizontal: ").append(toIndentedString(pegHorizontal)).append("\n");
		sb.append("    pegVertical: ").append(toIndentedString(pegVertical)).append("\n");
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