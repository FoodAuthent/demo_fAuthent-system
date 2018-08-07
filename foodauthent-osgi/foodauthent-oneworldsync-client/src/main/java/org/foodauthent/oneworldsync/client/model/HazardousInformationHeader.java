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
import org.foodauthent.oneworldsync.client.model.HazardousInformationDetail;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.QualifiedValues;
import org.foodauthent.oneworldsync.client.model.Values;

/**
 * HazardousInformationHeader
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class HazardousInformationHeader {
	@JsonProperty("aDRDangerousGoodsLimitedQuantitiesCode")
	private String aDRDangerousGoodsLimitedQuantitiesCode = null;

	@JsonProperty("aDRDangerousGoodsPackagingTypeCode")
	private String aDRDangerousGoodsPackagingTypeCode = null;

	@JsonProperty("aDRTunnelRestrictionCode")
	private Values aDRTunnelRestrictionCode = null;

	@JsonProperty("dangerousGoodsRegulationAgency")
	private String dangerousGoodsRegulationAgency = null;

	@JsonProperty("dangerousGoodsRegulationCode")
	private CodifiedValue dangerousGoodsRegulationCode = null;

	@JsonProperty("flashPointTemperature")
	private QualifiedValues flashPointTemperature = null;

	@JsonProperty("hazardousInformationDetail")
	private List<HazardousInformationDetail> hazardousInformationDetail = null;

	@JsonProperty("hazardousMaterialAdditionalInformation")
	private LanguageLabels hazardousMaterialAdditionalInformation = null;

	public HazardousInformationHeader aDRDangerousGoodsLimitedQuantitiesCode(
			String aDRDangerousGoodsLimitedQuantitiesCode) {
		this.aDRDangerousGoodsLimitedQuantitiesCode = aDRDangerousGoodsLimitedQuantitiesCode;
		return this;
	}

	/**
	 * Get aDRDangerousGoodsLimitedQuantitiesCode
	 * 
	 * @return aDRDangerousGoodsLimitedQuantitiesCode
	 **/
	@ApiModelProperty(value = "")
	public String getADRDangerousGoodsLimitedQuantitiesCode() {
		return aDRDangerousGoodsLimitedQuantitiesCode;
	}

	public void setADRDangerousGoodsLimitedQuantitiesCode(String aDRDangerousGoodsLimitedQuantitiesCode) {
		this.aDRDangerousGoodsLimitedQuantitiesCode = aDRDangerousGoodsLimitedQuantitiesCode;
	}

	public HazardousInformationHeader aDRDangerousGoodsPackagingTypeCode(String aDRDangerousGoodsPackagingTypeCode) {
		this.aDRDangerousGoodsPackagingTypeCode = aDRDangerousGoodsPackagingTypeCode;
		return this;
	}

	/**
	 * Get aDRDangerousGoodsPackagingTypeCode
	 * 
	 * @return aDRDangerousGoodsPackagingTypeCode
	 **/
	@ApiModelProperty(value = "")
	public String getADRDangerousGoodsPackagingTypeCode() {
		return aDRDangerousGoodsPackagingTypeCode;
	}

	public void setADRDangerousGoodsPackagingTypeCode(String aDRDangerousGoodsPackagingTypeCode) {
		this.aDRDangerousGoodsPackagingTypeCode = aDRDangerousGoodsPackagingTypeCode;
	}

	public HazardousInformationHeader aDRTunnelRestrictionCode(Values aDRTunnelRestrictionCode) {
		this.aDRTunnelRestrictionCode = aDRTunnelRestrictionCode;
		return this;
	}

	/**
	 * Get aDRTunnelRestrictionCode
	 * 
	 * @return aDRTunnelRestrictionCode
	 **/
	@ApiModelProperty(value = "")
	public Values getADRTunnelRestrictionCode() {
		return aDRTunnelRestrictionCode;
	}

	public void setADRTunnelRestrictionCode(Values aDRTunnelRestrictionCode) {
		this.aDRTunnelRestrictionCode = aDRTunnelRestrictionCode;
	}

	public HazardousInformationHeader dangerousGoodsRegulationAgency(String dangerousGoodsRegulationAgency) {
		this.dangerousGoodsRegulationAgency = dangerousGoodsRegulationAgency;
		return this;
	}

	/**
	 * Get dangerousGoodsRegulationAgency
	 * 
	 * @return dangerousGoodsRegulationAgency
	 **/
	@ApiModelProperty(value = "")
	public String getDangerousGoodsRegulationAgency() {
		return dangerousGoodsRegulationAgency;
	}

	public void setDangerousGoodsRegulationAgency(String dangerousGoodsRegulationAgency) {
		this.dangerousGoodsRegulationAgency = dangerousGoodsRegulationAgency;
	}

	public HazardousInformationHeader dangerousGoodsRegulationCode(CodifiedValue dangerousGoodsRegulationCode) {
		this.dangerousGoodsRegulationCode = dangerousGoodsRegulationCode;
		return this;
	}

	/**
	 * Get dangerousGoodsRegulationCode
	 * 
	 * @return dangerousGoodsRegulationCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getDangerousGoodsRegulationCode() {
		return dangerousGoodsRegulationCode;
	}

	public void setDangerousGoodsRegulationCode(CodifiedValue dangerousGoodsRegulationCode) {
		this.dangerousGoodsRegulationCode = dangerousGoodsRegulationCode;
	}

	public HazardousInformationHeader flashPointTemperature(QualifiedValues flashPointTemperature) {
		this.flashPointTemperature = flashPointTemperature;
		return this;
	}

	/**
	 * Get flashPointTemperature
	 * 
	 * @return flashPointTemperature
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValues getFlashPointTemperature() {
		return flashPointTemperature;
	}

	public void setFlashPointTemperature(QualifiedValues flashPointTemperature) {
		this.flashPointTemperature = flashPointTemperature;
	}

	public HazardousInformationHeader hazardousInformationDetail(
			List<HazardousInformationDetail> hazardousInformationDetail) {
		this.hazardousInformationDetail = hazardousInformationDetail;
		return this;
	}

	public HazardousInformationHeader addHazardousInformationDetailItem(
			HazardousInformationDetail hazardousInformationDetailItem) {
		if (this.hazardousInformationDetail == null) {
			this.hazardousInformationDetail = new ArrayList<HazardousInformationDetail>();
		}
		this.hazardousInformationDetail.add(hazardousInformationDetailItem);
		return this;
	}

	/**
	 * Get hazardousInformationDetail
	 * 
	 * @return hazardousInformationDetail
	 **/
	@ApiModelProperty(value = "")
	public List<HazardousInformationDetail> getHazardousInformationDetail() {
		return hazardousInformationDetail;
	}

	public void setHazardousInformationDetail(List<HazardousInformationDetail> hazardousInformationDetail) {
		this.hazardousInformationDetail = hazardousInformationDetail;
	}

	public HazardousInformationHeader hazardousMaterialAdditionalInformation(
			LanguageLabels hazardousMaterialAdditionalInformation) {
		this.hazardousMaterialAdditionalInformation = hazardousMaterialAdditionalInformation;
		return this;
	}

	/**
	 * Get hazardousMaterialAdditionalInformation
	 * 
	 * @return hazardousMaterialAdditionalInformation
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getHazardousMaterialAdditionalInformation() {
		return hazardousMaterialAdditionalInformation;
	}

	public void setHazardousMaterialAdditionalInformation(LanguageLabels hazardousMaterialAdditionalInformation) {
		this.hazardousMaterialAdditionalInformation = hazardousMaterialAdditionalInformation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HazardousInformationHeader hazardousInformationHeader = (HazardousInformationHeader) o;
		return Objects.equals(this.aDRDangerousGoodsLimitedQuantitiesCode,
				hazardousInformationHeader.aDRDangerousGoodsLimitedQuantitiesCode)
				&& Objects.equals(this.aDRDangerousGoodsPackagingTypeCode,
						hazardousInformationHeader.aDRDangerousGoodsPackagingTypeCode)
				&& Objects.equals(this.aDRTunnelRestrictionCode, hazardousInformationHeader.aDRTunnelRestrictionCode)
				&& Objects.equals(this.dangerousGoodsRegulationAgency,
						hazardousInformationHeader.dangerousGoodsRegulationAgency)
				&& Objects.equals(this.dangerousGoodsRegulationCode,
						hazardousInformationHeader.dangerousGoodsRegulationCode)
				&& Objects.equals(this.flashPointTemperature, hazardousInformationHeader.flashPointTemperature)
				&& Objects.equals(this.hazardousInformationDetail,
						hazardousInformationHeader.hazardousInformationDetail)
				&& Objects.equals(this.hazardousMaterialAdditionalInformation,
						hazardousInformationHeader.hazardousMaterialAdditionalInformation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aDRDangerousGoodsLimitedQuantitiesCode, aDRDangerousGoodsPackagingTypeCode,
				aDRTunnelRestrictionCode, dangerousGoodsRegulationAgency, dangerousGoodsRegulationCode,
				flashPointTemperature, hazardousInformationDetail, hazardousMaterialAdditionalInformation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HazardousInformationHeader {\n");

		sb.append("    aDRDangerousGoodsLimitedQuantitiesCode: ")
				.append(toIndentedString(aDRDangerousGoodsLimitedQuantitiesCode)).append("\n");
		sb.append("    aDRDangerousGoodsPackagingTypeCode: ")
				.append(toIndentedString(aDRDangerousGoodsPackagingTypeCode)).append("\n");
		sb.append("    aDRTunnelRestrictionCode: ").append(toIndentedString(aDRTunnelRestrictionCode)).append("\n");
		sb.append("    dangerousGoodsRegulationAgency: ").append(toIndentedString(dangerousGoodsRegulationAgency))
				.append("\n");
		sb.append("    dangerousGoodsRegulationCode: ").append(toIndentedString(dangerousGoodsRegulationCode))
				.append("\n");
		sb.append("    flashPointTemperature: ").append(toIndentedString(flashPointTemperature)).append("\n");
		sb.append("    hazardousInformationDetail: ").append(toIndentedString(hazardousInformationDetail)).append("\n");
		sb.append("    hazardousMaterialAdditionalInformation: ")
				.append(toIndentedString(hazardousMaterialAdditionalInformation)).append("\n");
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
