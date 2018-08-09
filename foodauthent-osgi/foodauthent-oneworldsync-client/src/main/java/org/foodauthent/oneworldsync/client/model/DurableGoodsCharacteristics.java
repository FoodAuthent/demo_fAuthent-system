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
import org.foodauthent.oneworldsync.client.model.ItemMountingInformation;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.Values;

/**
 * DurableGoodsCharacteristics
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class DurableGoodsCharacteristics {
	@JsonProperty("isAssemblyRequired")
	private String isAssemblyRequired = null;

	@JsonProperty("isTradeItemReconditioned")
	private CodifiedValue isTradeItemReconditioned = null;

	@JsonProperty("itemMountingInformation")
	private List<ItemMountingInformation> itemMountingInformation = null;

	@JsonProperty("numberOfWheels")
	private String numberOfWheels = null;

	@JsonProperty("tradeItemFinishDescription")
	private LanguageLabels tradeItemFinishDescription = null;

	@JsonProperty("tradeItemOperatingEnvironment")
	private Values tradeItemOperatingEnvironment = null;

	public DurableGoodsCharacteristics isAssemblyRequired(String isAssemblyRequired) {
		this.isAssemblyRequired = isAssemblyRequired;
		return this;
	}

	/**
	 * Get isAssemblyRequired
	 * 
	 * @return isAssemblyRequired
	 **/
	@ApiModelProperty(value = "")
	public String getIsAssemblyRequired() {
		return isAssemblyRequired;
	}

	public void setIsAssemblyRequired(String isAssemblyRequired) {
		this.isAssemblyRequired = isAssemblyRequired;
	}

	public DurableGoodsCharacteristics isTradeItemReconditioned(CodifiedValue isTradeItemReconditioned) {
		this.isTradeItemReconditioned = isTradeItemReconditioned;
		return this;
	}

	/**
	 * Get isTradeItemReconditioned
	 * 
	 * @return isTradeItemReconditioned
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsTradeItemReconditioned() {
		return isTradeItemReconditioned;
	}

	public void setIsTradeItemReconditioned(CodifiedValue isTradeItemReconditioned) {
		this.isTradeItemReconditioned = isTradeItemReconditioned;
	}

	public DurableGoodsCharacteristics itemMountingInformation(List<ItemMountingInformation> itemMountingInformation) {
		this.itemMountingInformation = itemMountingInformation;
		return this;
	}

	public DurableGoodsCharacteristics addItemMountingInformationItem(
			ItemMountingInformation itemMountingInformationItem) {
		if (this.itemMountingInformation == null) {
			this.itemMountingInformation = new ArrayList<ItemMountingInformation>();
		}
		this.itemMountingInformation.add(itemMountingInformationItem);
		return this;
	}

	/**
	 * Get itemMountingInformation
	 * 
	 * @return itemMountingInformation
	 **/
	@ApiModelProperty(value = "")
	public List<ItemMountingInformation> getItemMountingInformation() {
		return itemMountingInformation;
	}

	public void setItemMountingInformation(List<ItemMountingInformation> itemMountingInformation) {
		this.itemMountingInformation = itemMountingInformation;
	}

	public DurableGoodsCharacteristics numberOfWheels(String numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
		return this;
	}

	/**
	 * Get numberOfWheels
	 * 
	 * @return numberOfWheels
	 **/
	@ApiModelProperty(value = "")
	public String getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(String numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public DurableGoodsCharacteristics tradeItemFinishDescription(LanguageLabels tradeItemFinishDescription) {
		this.tradeItemFinishDescription = tradeItemFinishDescription;
		return this;
	}

	/**
	 * Get tradeItemFinishDescription
	 * 
	 * @return tradeItemFinishDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getTradeItemFinishDescription() {
		return tradeItemFinishDescription;
	}

	public void setTradeItemFinishDescription(LanguageLabels tradeItemFinishDescription) {
		this.tradeItemFinishDescription = tradeItemFinishDescription;
	}

	public DurableGoodsCharacteristics tradeItemOperatingEnvironment(Values tradeItemOperatingEnvironment) {
		this.tradeItemOperatingEnvironment = tradeItemOperatingEnvironment;
		return this;
	}

	/**
	 * Get tradeItemOperatingEnvironment
	 * 
	 * @return tradeItemOperatingEnvironment
	 **/
	@ApiModelProperty(value = "")
	public Values getTradeItemOperatingEnvironment() {
		return tradeItemOperatingEnvironment;
	}

	public void setTradeItemOperatingEnvironment(Values tradeItemOperatingEnvironment) {
		this.tradeItemOperatingEnvironment = tradeItemOperatingEnvironment;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DurableGoodsCharacteristics durableGoodsCharacteristics = (DurableGoodsCharacteristics) o;
		return Objects.equals(this.isAssemblyRequired, durableGoodsCharacteristics.isAssemblyRequired)
				&& Objects.equals(this.isTradeItemReconditioned, durableGoodsCharacteristics.isTradeItemReconditioned)
				&& Objects.equals(this.itemMountingInformation, durableGoodsCharacteristics.itemMountingInformation)
				&& Objects.equals(this.numberOfWheels, durableGoodsCharacteristics.numberOfWheels)
				&& Objects.equals(this.tradeItemFinishDescription,
						durableGoodsCharacteristics.tradeItemFinishDescription)
				&& Objects.equals(this.tradeItemOperatingEnvironment,
						durableGoodsCharacteristics.tradeItemOperatingEnvironment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isAssemblyRequired, isTradeItemReconditioned, itemMountingInformation, numberOfWheels,
				tradeItemFinishDescription, tradeItemOperatingEnvironment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DurableGoodsCharacteristics {\n");

		sb.append("    isAssemblyRequired: ").append(toIndentedString(isAssemblyRequired)).append("\n");
		sb.append("    isTradeItemReconditioned: ").append(toIndentedString(isTradeItemReconditioned)).append("\n");
		sb.append("    itemMountingInformation: ").append(toIndentedString(itemMountingInformation)).append("\n");
		sb.append("    numberOfWheels: ").append(toIndentedString(numberOfWheels)).append("\n");
		sb.append("    tradeItemFinishDescription: ").append(toIndentedString(tradeItemFinishDescription)).append("\n");
		sb.append("    tradeItemOperatingEnvironment: ").append(toIndentedString(tradeItemOperatingEnvironment))
				.append("\n");
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