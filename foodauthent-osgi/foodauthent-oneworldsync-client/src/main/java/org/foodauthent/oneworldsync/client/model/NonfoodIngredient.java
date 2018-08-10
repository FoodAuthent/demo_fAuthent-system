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
import org.foodauthent.oneworldsync.client.model.IngredientStrength;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.NonfoodIngredientCodeReference;

/**
 * NonfoodIngredient
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class NonfoodIngredient {
	@JsonProperty("ingredientStrength")
	private List<IngredientStrength> ingredientStrength = null;

	@JsonProperty("isIngredientActive")
	private CodifiedValue isIngredientActive = null;

	@JsonProperty("isIngredientGeneric")
	private CodifiedValue isIngredientGeneric = null;

	@JsonProperty("isNonfoodIngredientEmphasized")
	private CodifiedValue isNonfoodIngredientEmphasized = null;

	@JsonProperty("nonfoodIngredientCodeReference")
	private NonfoodIngredientCodeReference nonfoodIngredientCodeReference = null;

	@JsonProperty("nonfoodIngredientDefinition")
	private LanguageLabels nonfoodIngredientDefinition = null;

	@JsonProperty("nonfoodIngredientName")
	private String nonfoodIngredientName = null;

	@JsonProperty("nonfoodIngredientPurpose")
	private LanguageLabels nonfoodIngredientPurpose = null;

	@JsonProperty("sequenceNumber")
	private String sequenceNumber = null;

	public NonfoodIngredient ingredientStrength(List<IngredientStrength> ingredientStrength) {
		this.ingredientStrength = ingredientStrength;
		return this;
	}

	public NonfoodIngredient addIngredientStrengthItem(IngredientStrength ingredientStrengthItem) {
		if (this.ingredientStrength == null) {
			this.ingredientStrength = new ArrayList<IngredientStrength>();
		}
		this.ingredientStrength.add(ingredientStrengthItem);
		return this;
	}

	/**
	 * Get ingredientStrength
	 * 
	 * @return ingredientStrength
	 **/
	@ApiModelProperty(value = "")
	public List<IngredientStrength> getIngredientStrength() {
		return ingredientStrength;
	}

	public void setIngredientStrength(List<IngredientStrength> ingredientStrength) {
		this.ingredientStrength = ingredientStrength;
	}

	public NonfoodIngredient isIngredientActive(CodifiedValue isIngredientActive) {
		this.isIngredientActive = isIngredientActive;
		return this;
	}

	/**
	 * Get isIngredientActive
	 * 
	 * @return isIngredientActive
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsIngredientActive() {
		return isIngredientActive;
	}

	public void setIsIngredientActive(CodifiedValue isIngredientActive) {
		this.isIngredientActive = isIngredientActive;
	}

	public NonfoodIngredient isIngredientGeneric(CodifiedValue isIngredientGeneric) {
		this.isIngredientGeneric = isIngredientGeneric;
		return this;
	}

	/**
	 * Get isIngredientGeneric
	 * 
	 * @return isIngredientGeneric
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsIngredientGeneric() {
		return isIngredientGeneric;
	}

	public void setIsIngredientGeneric(CodifiedValue isIngredientGeneric) {
		this.isIngredientGeneric = isIngredientGeneric;
	}

	public NonfoodIngredient isNonfoodIngredientEmphasized(CodifiedValue isNonfoodIngredientEmphasized) {
		this.isNonfoodIngredientEmphasized = isNonfoodIngredientEmphasized;
		return this;
	}

	/**
	 * Get isNonfoodIngredientEmphasized
	 * 
	 * @return isNonfoodIngredientEmphasized
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsNonfoodIngredientEmphasized() {
		return isNonfoodIngredientEmphasized;
	}

	public void setIsNonfoodIngredientEmphasized(CodifiedValue isNonfoodIngredientEmphasized) {
		this.isNonfoodIngredientEmphasized = isNonfoodIngredientEmphasized;
	}

	public NonfoodIngredient nonfoodIngredientCodeReference(
			NonfoodIngredientCodeReference nonfoodIngredientCodeReference) {
		this.nonfoodIngredientCodeReference = nonfoodIngredientCodeReference;
		return this;
	}

	/**
	 * Get nonfoodIngredientCodeReference
	 * 
	 * @return nonfoodIngredientCodeReference
	 **/
	@ApiModelProperty(value = "")
	public NonfoodIngredientCodeReference getNonfoodIngredientCodeReference() {
		return nonfoodIngredientCodeReference;
	}

	public void setNonfoodIngredientCodeReference(NonfoodIngredientCodeReference nonfoodIngredientCodeReference) {
		this.nonfoodIngredientCodeReference = nonfoodIngredientCodeReference;
	}

	public NonfoodIngredient nonfoodIngredientDefinition(LanguageLabels nonfoodIngredientDefinition) {
		this.nonfoodIngredientDefinition = nonfoodIngredientDefinition;
		return this;
	}

	/**
	 * Get nonfoodIngredientDefinition
	 * 
	 * @return nonfoodIngredientDefinition
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getNonfoodIngredientDefinition() {
		return nonfoodIngredientDefinition;
	}

	public void setNonfoodIngredientDefinition(LanguageLabels nonfoodIngredientDefinition) {
		this.nonfoodIngredientDefinition = nonfoodIngredientDefinition;
	}

	public NonfoodIngredient nonfoodIngredientName(String nonfoodIngredientName) {
		this.nonfoodIngredientName = nonfoodIngredientName;
		return this;
	}

	/**
	 * Get nonfoodIngredientName
	 * 
	 * @return nonfoodIngredientName
	 **/
	@ApiModelProperty(value = "")
	public String getNonfoodIngredientName() {
		return nonfoodIngredientName;
	}

	public void setNonfoodIngredientName(String nonfoodIngredientName) {
		this.nonfoodIngredientName = nonfoodIngredientName;
	}

	public NonfoodIngredient nonfoodIngredientPurpose(LanguageLabels nonfoodIngredientPurpose) {
		this.nonfoodIngredientPurpose = nonfoodIngredientPurpose;
		return this;
	}

	/**
	 * Get nonfoodIngredientPurpose
	 * 
	 * @return nonfoodIngredientPurpose
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getNonfoodIngredientPurpose() {
		return nonfoodIngredientPurpose;
	}

	public void setNonfoodIngredientPurpose(LanguageLabels nonfoodIngredientPurpose) {
		this.nonfoodIngredientPurpose = nonfoodIngredientPurpose;
	}

	public NonfoodIngredient sequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
		return this;
	}

	/**
	 * Get sequenceNumber
	 * 
	 * @return sequenceNumber
	 **/
	@ApiModelProperty(value = "")
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NonfoodIngredient nonfoodIngredient = (NonfoodIngredient) o;
		return Objects.equals(this.ingredientStrength, nonfoodIngredient.ingredientStrength)
				&& Objects.equals(this.isIngredientActive, nonfoodIngredient.isIngredientActive)
				&& Objects.equals(this.isIngredientGeneric, nonfoodIngredient.isIngredientGeneric)
				&& Objects.equals(this.isNonfoodIngredientEmphasized, nonfoodIngredient.isNonfoodIngredientEmphasized)
				&& Objects.equals(this.nonfoodIngredientCodeReference, nonfoodIngredient.nonfoodIngredientCodeReference)
				&& Objects.equals(this.nonfoodIngredientDefinition, nonfoodIngredient.nonfoodIngredientDefinition)
				&& Objects.equals(this.nonfoodIngredientName, nonfoodIngredient.nonfoodIngredientName)
				&& Objects.equals(this.nonfoodIngredientPurpose, nonfoodIngredient.nonfoodIngredientPurpose)
				&& Objects.equals(this.sequenceNumber, nonfoodIngredient.sequenceNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredientStrength, isIngredientActive, isIngredientGeneric, isNonfoodIngredientEmphasized,
				nonfoodIngredientCodeReference, nonfoodIngredientDefinition, nonfoodIngredientName,
				nonfoodIngredientPurpose, sequenceNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NonfoodIngredient {\n");

		sb.append("    ingredientStrength: ").append(toIndentedString(ingredientStrength)).append("\n");
		sb.append("    isIngredientActive: ").append(toIndentedString(isIngredientActive)).append("\n");
		sb.append("    isIngredientGeneric: ").append(toIndentedString(isIngredientGeneric)).append("\n");
		sb.append("    isNonfoodIngredientEmphasized: ").append(toIndentedString(isNonfoodIngredientEmphasized))
				.append("\n");
		sb.append("    nonfoodIngredientCodeReference: ").append(toIndentedString(nonfoodIngredientCodeReference))
				.append("\n");
		sb.append("    nonfoodIngredientDefinition: ").append(toIndentedString(nonfoodIngredientDefinition))
				.append("\n");
		sb.append("    nonfoodIngredientName: ").append(toIndentedString(nonfoodIngredientName)).append("\n");
		sb.append("    nonfoodIngredientPurpose: ").append(toIndentedString(nonfoodIngredientPurpose)).append("\n");
		sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
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