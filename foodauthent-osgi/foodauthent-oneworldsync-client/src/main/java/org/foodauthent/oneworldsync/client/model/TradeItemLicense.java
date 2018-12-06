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
import org.foodauthent.oneworldsync.client.model.TradeItemLicenseDetail;
import org.foodauthent.oneworldsync.client.model.TradeItemLicenseEffectiveDateInformation;
import org.foodauthent.oneworldsync.client.model.TradeItemLicenseOwnerIdentification;
import org.foodauthent.oneworldsync.client.model.TradeItemLicenseRegion;

/**
 * TradeItemLicense
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class TradeItemLicense {
	@JsonProperty("tradeItemLicenseDetail")
	private List<TradeItemLicenseDetail> tradeItemLicenseDetail = null;

	@JsonProperty("tradeItemLicenseEffectiveDateInformation")
	private List<TradeItemLicenseEffectiveDateInformation> tradeItemLicenseEffectiveDateInformation = null;

	@JsonProperty("tradeItemLicenseOwnerIdentification")
	private TradeItemLicenseOwnerIdentification tradeItemLicenseOwnerIdentification = null;

	@JsonProperty("tradeItemLicenseOwnerName")
	private String tradeItemLicenseOwnerName = null;

	@JsonProperty("tradeItemLicenseRegion")
	private List<TradeItemLicenseRegion> tradeItemLicenseRegion = null;

	public TradeItemLicense tradeItemLicenseDetail(List<TradeItemLicenseDetail> tradeItemLicenseDetail) {
		this.tradeItemLicenseDetail = tradeItemLicenseDetail;
		return this;
	}

	public TradeItemLicense addTradeItemLicenseDetailItem(TradeItemLicenseDetail tradeItemLicenseDetailItem) {
		if (this.tradeItemLicenseDetail == null) {
			this.tradeItemLicenseDetail = new ArrayList<TradeItemLicenseDetail>();
		}
		this.tradeItemLicenseDetail.add(tradeItemLicenseDetailItem);
		return this;
	}

	/**
	 * Get tradeItemLicenseDetail
	 * 
	 * @return tradeItemLicenseDetail
	 **/
	@ApiModelProperty(value = "")
	public List<TradeItemLicenseDetail> getTradeItemLicenseDetail() {
		return tradeItemLicenseDetail;
	}

	public void setTradeItemLicenseDetail(List<TradeItemLicenseDetail> tradeItemLicenseDetail) {
		this.tradeItemLicenseDetail = tradeItemLicenseDetail;
	}

	public TradeItemLicense tradeItemLicenseEffectiveDateInformation(
			List<TradeItemLicenseEffectiveDateInformation> tradeItemLicenseEffectiveDateInformation) {
		this.tradeItemLicenseEffectiveDateInformation = tradeItemLicenseEffectiveDateInformation;
		return this;
	}

	public TradeItemLicense addTradeItemLicenseEffectiveDateInformationItem(
			TradeItemLicenseEffectiveDateInformation tradeItemLicenseEffectiveDateInformationItem) {
		if (this.tradeItemLicenseEffectiveDateInformation == null) {
			this.tradeItemLicenseEffectiveDateInformation = new ArrayList<TradeItemLicenseEffectiveDateInformation>();
		}
		this.tradeItemLicenseEffectiveDateInformation.add(tradeItemLicenseEffectiveDateInformationItem);
		return this;
	}

	/**
	 * Get tradeItemLicenseEffectiveDateInformation
	 * 
	 * @return tradeItemLicenseEffectiveDateInformation
	 **/
	@ApiModelProperty(value = "")
	public List<TradeItemLicenseEffectiveDateInformation> getTradeItemLicenseEffectiveDateInformation() {
		return tradeItemLicenseEffectiveDateInformation;
	}

	public void setTradeItemLicenseEffectiveDateInformation(
			List<TradeItemLicenseEffectiveDateInformation> tradeItemLicenseEffectiveDateInformation) {
		this.tradeItemLicenseEffectiveDateInformation = tradeItemLicenseEffectiveDateInformation;
	}

	public TradeItemLicense tradeItemLicenseOwnerIdentification(
			TradeItemLicenseOwnerIdentification tradeItemLicenseOwnerIdentification) {
		this.tradeItemLicenseOwnerIdentification = tradeItemLicenseOwnerIdentification;
		return this;
	}

	/**
	 * Get tradeItemLicenseOwnerIdentification
	 * 
	 * @return tradeItemLicenseOwnerIdentification
	 **/
	@ApiModelProperty(value = "")
	public TradeItemLicenseOwnerIdentification getTradeItemLicenseOwnerIdentification() {
		return tradeItemLicenseOwnerIdentification;
	}

	public void setTradeItemLicenseOwnerIdentification(
			TradeItemLicenseOwnerIdentification tradeItemLicenseOwnerIdentification) {
		this.tradeItemLicenseOwnerIdentification = tradeItemLicenseOwnerIdentification;
	}

	public TradeItemLicense tradeItemLicenseOwnerName(String tradeItemLicenseOwnerName) {
		this.tradeItemLicenseOwnerName = tradeItemLicenseOwnerName;
		return this;
	}

	/**
	 * Get tradeItemLicenseOwnerName
	 * 
	 * @return tradeItemLicenseOwnerName
	 **/
	@ApiModelProperty(value = "")
	public String getTradeItemLicenseOwnerName() {
		return tradeItemLicenseOwnerName;
	}

	public void setTradeItemLicenseOwnerName(String tradeItemLicenseOwnerName) {
		this.tradeItemLicenseOwnerName = tradeItemLicenseOwnerName;
	}

	public TradeItemLicense tradeItemLicenseRegion(List<TradeItemLicenseRegion> tradeItemLicenseRegion) {
		this.tradeItemLicenseRegion = tradeItemLicenseRegion;
		return this;
	}

	public TradeItemLicense addTradeItemLicenseRegionItem(TradeItemLicenseRegion tradeItemLicenseRegionItem) {
		if (this.tradeItemLicenseRegion == null) {
			this.tradeItemLicenseRegion = new ArrayList<TradeItemLicenseRegion>();
		}
		this.tradeItemLicenseRegion.add(tradeItemLicenseRegionItem);
		return this;
	}

	/**
	 * Get tradeItemLicenseRegion
	 * 
	 * @return tradeItemLicenseRegion
	 **/
	@ApiModelProperty(value = "")
	public List<TradeItemLicenseRegion> getTradeItemLicenseRegion() {
		return tradeItemLicenseRegion;
	}

	public void setTradeItemLicenseRegion(List<TradeItemLicenseRegion> tradeItemLicenseRegion) {
		this.tradeItemLicenseRegion = tradeItemLicenseRegion;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TradeItemLicense tradeItemLicense = (TradeItemLicense) o;
		return Objects.equals(this.tradeItemLicenseDetail, tradeItemLicense.tradeItemLicenseDetail)
				&& Objects.equals(this.tradeItemLicenseEffectiveDateInformation,
						tradeItemLicense.tradeItemLicenseEffectiveDateInformation)
				&& Objects.equals(this.tradeItemLicenseOwnerIdentification,
						tradeItemLicense.tradeItemLicenseOwnerIdentification)
				&& Objects.equals(this.tradeItemLicenseOwnerName, tradeItemLicense.tradeItemLicenseOwnerName)
				&& Objects.equals(this.tradeItemLicenseRegion, tradeItemLicense.tradeItemLicenseRegion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tradeItemLicenseDetail, tradeItemLicenseEffectiveDateInformation,
				tradeItemLicenseOwnerIdentification, tradeItemLicenseOwnerName, tradeItemLicenseRegion);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TradeItemLicense {\n");

		sb.append("    tradeItemLicenseDetail: ").append(toIndentedString(tradeItemLicenseDetail)).append("\n");
		sb.append("    tradeItemLicenseEffectiveDateInformation: ")
				.append(toIndentedString(tradeItemLicenseEffectiveDateInformation)).append("\n");
		sb.append("    tradeItemLicenseOwnerIdentification: ")
				.append(toIndentedString(tradeItemLicenseOwnerIdentification)).append("\n");
		sb.append("    tradeItemLicenseOwnerName: ").append(toIndentedString(tradeItemLicenseOwnerName)).append("\n");
		sb.append("    tradeItemLicenseRegion: ").append(toIndentedString(tradeItemLicenseRegion)).append("\n");
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