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
import java.util.ArrayList;
import java.util.List;
import org.foodauthent.oneworldsync.client.model.CodifiedValue;
import org.foodauthent.oneworldsync.client.model.CodifiedValues;
import org.foodauthent.oneworldsync.client.model.RouteOfAdministration;

/**
 * HealthcareItemInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class HealthcareItemInformation {
	@JsonProperty("doesSaleOfTradeItemRequireGovernmentalReporting")
	private CodifiedValue doesSaleOfTradeItemRequireGovernmentalReporting = null;

	@JsonProperty("doesTradeItemContainHumanBloodDerivative")
	private CodifiedValue doesTradeItemContainHumanBloodDerivative = null;

	@JsonProperty("doesTradeItemContainLatex")
	private CodifiedValue doesTradeItemContainLatex = null;

	@JsonProperty("isTradeItemConsideredGeneric")
	private CodifiedValue isTradeItemConsideredGeneric = null;

	@JsonProperty("prescriptionTypeCode")
	private CodifiedValues prescriptionTypeCode = null;

	@JsonProperty("routeOfAdministration")
	private List<RouteOfAdministration> routeOfAdministration = null;

	public HealthcareItemInformation doesSaleOfTradeItemRequireGovernmentalReporting(
			CodifiedValue doesSaleOfTradeItemRequireGovernmentalReporting) {
		this.doesSaleOfTradeItemRequireGovernmentalReporting = doesSaleOfTradeItemRequireGovernmentalReporting;
		return this;
	}

	/**
	 * Get doesSaleOfTradeItemRequireGovernmentalReporting
	 * 
	 * @return doesSaleOfTradeItemRequireGovernmentalReporting
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getDoesSaleOfTradeItemRequireGovernmentalReporting() {
		return doesSaleOfTradeItemRequireGovernmentalReporting;
	}

	public void setDoesSaleOfTradeItemRequireGovernmentalReporting(
			CodifiedValue doesSaleOfTradeItemRequireGovernmentalReporting) {
		this.doesSaleOfTradeItemRequireGovernmentalReporting = doesSaleOfTradeItemRequireGovernmentalReporting;
	}

	public HealthcareItemInformation doesTradeItemContainHumanBloodDerivative(
			CodifiedValue doesTradeItemContainHumanBloodDerivative) {
		this.doesTradeItemContainHumanBloodDerivative = doesTradeItemContainHumanBloodDerivative;
		return this;
	}

	/**
	 * Get doesTradeItemContainHumanBloodDerivative
	 * 
	 * @return doesTradeItemContainHumanBloodDerivative
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getDoesTradeItemContainHumanBloodDerivative() {
		return doesTradeItemContainHumanBloodDerivative;
	}

	public void setDoesTradeItemContainHumanBloodDerivative(CodifiedValue doesTradeItemContainHumanBloodDerivative) {
		this.doesTradeItemContainHumanBloodDerivative = doesTradeItemContainHumanBloodDerivative;
	}

	public HealthcareItemInformation doesTradeItemContainLatex(CodifiedValue doesTradeItemContainLatex) {
		this.doesTradeItemContainLatex = doesTradeItemContainLatex;
		return this;
	}

	/**
	 * Get doesTradeItemContainLatex
	 * 
	 * @return doesTradeItemContainLatex
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getDoesTradeItemContainLatex() {
		return doesTradeItemContainLatex;
	}

	public void setDoesTradeItemContainLatex(CodifiedValue doesTradeItemContainLatex) {
		this.doesTradeItemContainLatex = doesTradeItemContainLatex;
	}

	public HealthcareItemInformation isTradeItemConsideredGeneric(CodifiedValue isTradeItemConsideredGeneric) {
		this.isTradeItemConsideredGeneric = isTradeItemConsideredGeneric;
		return this;
	}

	/**
	 * Get isTradeItemConsideredGeneric
	 * 
	 * @return isTradeItemConsideredGeneric
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsTradeItemConsideredGeneric() {
		return isTradeItemConsideredGeneric;
	}

	public void setIsTradeItemConsideredGeneric(CodifiedValue isTradeItemConsideredGeneric) {
		this.isTradeItemConsideredGeneric = isTradeItemConsideredGeneric;
	}

	public HealthcareItemInformation prescriptionTypeCode(CodifiedValues prescriptionTypeCode) {
		this.prescriptionTypeCode = prescriptionTypeCode;
		return this;
	}

	/**
	 * Get prescriptionTypeCode
	 * 
	 * @return prescriptionTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValues getPrescriptionTypeCode() {
		return prescriptionTypeCode;
	}

	public void setPrescriptionTypeCode(CodifiedValues prescriptionTypeCode) {
		this.prescriptionTypeCode = prescriptionTypeCode;
	}

	public HealthcareItemInformation routeOfAdministration(List<RouteOfAdministration> routeOfAdministration) {
		this.routeOfAdministration = routeOfAdministration;
		return this;
	}

	public HealthcareItemInformation addRouteOfAdministrationItem(RouteOfAdministration routeOfAdministrationItem) {
		if (this.routeOfAdministration == null) {
			this.routeOfAdministration = new ArrayList<RouteOfAdministration>();
		}
		this.routeOfAdministration.add(routeOfAdministrationItem);
		return this;
	}

	/**
	 * Get routeOfAdministration
	 * 
	 * @return routeOfAdministration
	 **/
	@ApiModelProperty(value = "")
	public List<RouteOfAdministration> getRouteOfAdministration() {
		return routeOfAdministration;
	}

	public void setRouteOfAdministration(List<RouteOfAdministration> routeOfAdministration) {
		this.routeOfAdministration = routeOfAdministration;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HealthcareItemInformation healthcareItemInformation = (HealthcareItemInformation) o;
		return Objects.equals(this.doesSaleOfTradeItemRequireGovernmentalReporting,
				healthcareItemInformation.doesSaleOfTradeItemRequireGovernmentalReporting)
				&& Objects.equals(this.doesTradeItemContainHumanBloodDerivative,
						healthcareItemInformation.doesTradeItemContainHumanBloodDerivative)
				&& Objects.equals(this.doesTradeItemContainLatex, healthcareItemInformation.doesTradeItemContainLatex)
				&& Objects.equals(this.isTradeItemConsideredGeneric,
						healthcareItemInformation.isTradeItemConsideredGeneric)
				&& Objects.equals(this.prescriptionTypeCode, healthcareItemInformation.prescriptionTypeCode)
				&& Objects.equals(this.routeOfAdministration, healthcareItemInformation.routeOfAdministration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(doesSaleOfTradeItemRequireGovernmentalReporting, doesTradeItemContainHumanBloodDerivative,
				doesTradeItemContainLatex, isTradeItemConsideredGeneric, prescriptionTypeCode, routeOfAdministration);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HealthcareItemInformation {\n");

		sb.append("    doesSaleOfTradeItemRequireGovernmentalReporting: ")
				.append(toIndentedString(doesSaleOfTradeItemRequireGovernmentalReporting)).append("\n");
		sb.append("    doesTradeItemContainHumanBloodDerivative: ")
				.append(toIndentedString(doesTradeItemContainHumanBloodDerivative)).append("\n");
		sb.append("    doesTradeItemContainLatex: ").append(toIndentedString(doesTradeItemContainLatex)).append("\n");
		sb.append("    isTradeItemConsideredGeneric: ").append(toIndentedString(isTradeItemConsideredGeneric))
				.append("\n");
		sb.append("    prescriptionTypeCode: ").append(toIndentedString(prescriptionTypeCode)).append("\n");
		sb.append("    routeOfAdministration: ").append(toIndentedString(routeOfAdministration)).append("\n");
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