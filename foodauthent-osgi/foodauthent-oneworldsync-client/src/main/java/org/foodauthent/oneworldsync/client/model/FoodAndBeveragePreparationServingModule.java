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
import org.foodauthent.oneworldsync.client.model.CodifiedValues;
import org.foodauthent.oneworldsync.client.model.PreparationServing;
import org.foodauthent.oneworldsync.client.model.ServingQuantityInformation;

/**
 * FoodAndBeveragePreparationServingModule
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class FoodAndBeveragePreparationServingModule {
	@JsonProperty("manufacturerPreparationTypeCode")
	private CodifiedValues manufacturerPreparationTypeCode = null;

	@JsonProperty("preparationServing")
	private List<PreparationServing> preparationServing = null;

	@JsonProperty("servingQuantityInformation")
	private List<ServingQuantityInformation> servingQuantityInformation = null;

	public FoodAndBeveragePreparationServingModule manufacturerPreparationTypeCode(
			CodifiedValues manufacturerPreparationTypeCode) {
		this.manufacturerPreparationTypeCode = manufacturerPreparationTypeCode;
		return this;
	}

	/**
	 * Get manufacturerPreparationTypeCode
	 * 
	 * @return manufacturerPreparationTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValues getManufacturerPreparationTypeCode() {
		return manufacturerPreparationTypeCode;
	}

	public void setManufacturerPreparationTypeCode(CodifiedValues manufacturerPreparationTypeCode) {
		this.manufacturerPreparationTypeCode = manufacturerPreparationTypeCode;
	}

	public FoodAndBeveragePreparationServingModule preparationServing(List<PreparationServing> preparationServing) {
		this.preparationServing = preparationServing;
		return this;
	}

	public FoodAndBeveragePreparationServingModule addPreparationServingItem(
			PreparationServing preparationServingItem) {
		if (this.preparationServing == null) {
			this.preparationServing = new ArrayList<PreparationServing>();
		}
		this.preparationServing.add(preparationServingItem);
		return this;
	}

	/**
	 * Get preparationServing
	 * 
	 * @return preparationServing
	 **/
	@ApiModelProperty(value = "")
	public List<PreparationServing> getPreparationServing() {
		return preparationServing;
	}

	public void setPreparationServing(List<PreparationServing> preparationServing) {
		this.preparationServing = preparationServing;
	}

	public FoodAndBeveragePreparationServingModule servingQuantityInformation(
			List<ServingQuantityInformation> servingQuantityInformation) {
		this.servingQuantityInformation = servingQuantityInformation;
		return this;
	}

	public FoodAndBeveragePreparationServingModule addServingQuantityInformationItem(
			ServingQuantityInformation servingQuantityInformationItem) {
		if (this.servingQuantityInformation == null) {
			this.servingQuantityInformation = new ArrayList<ServingQuantityInformation>();
		}
		this.servingQuantityInformation.add(servingQuantityInformationItem);
		return this;
	}

	/**
	 * Get servingQuantityInformation
	 * 
	 * @return servingQuantityInformation
	 **/
	@ApiModelProperty(value = "")
	public List<ServingQuantityInformation> getServingQuantityInformation() {
		return servingQuantityInformation;
	}

	public void setServingQuantityInformation(List<ServingQuantityInformation> servingQuantityInformation) {
		this.servingQuantityInformation = servingQuantityInformation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FoodAndBeveragePreparationServingModule foodAndBeveragePreparationServingModule = (FoodAndBeveragePreparationServingModule) o;
		return Objects.equals(this.manufacturerPreparationTypeCode,
				foodAndBeveragePreparationServingModule.manufacturerPreparationTypeCode)
				&& Objects.equals(this.preparationServing, foodAndBeveragePreparationServingModule.preparationServing)
				&& Objects.equals(this.servingQuantityInformation,
						foodAndBeveragePreparationServingModule.servingQuantityInformation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufacturerPreparationTypeCode, preparationServing, servingQuantityInformation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FoodAndBeveragePreparationServingModule {\n");

		sb.append("    manufacturerPreparationTypeCode: ").append(toIndentedString(manufacturerPreparationTypeCode))
				.append("\n");
		sb.append("    preparationServing: ").append(toIndentedString(preparationServing)).append("\n");
		sb.append("    servingQuantityInformation: ").append(toIndentedString(servingQuantityInformation)).append("\n");
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
