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
import org.foodauthent.oneworldsync.client.model.DangerousHazardousLabel;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.QualifiedValue;
import org.foodauthent.oneworldsync.client.model.Values;

/**
 * HazardousInformationDetail
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class HazardousInformationDetail {
	@JsonProperty("classOfDangerousGoods")
	private String classOfDangerousGoods = null;

	@JsonProperty("dangerousGoodsClassificationCode")
	private String dangerousGoodsClassificationCode = null;

	@JsonProperty("dangerousGoodsHazardousCode")
	private Values dangerousGoodsHazardousCode = null;

	@JsonProperty("dangerousGoodsPackingGroup")
	private String dangerousGoodsPackingGroup = null;

	@JsonProperty("dangerousGoodsShippingName")
	private Values dangerousGoodsShippingName = null;

	@JsonProperty("dangerousGoodsSpecialProvisions")
	private Values dangerousGoodsSpecialProvisions = null;

	@JsonProperty("dangerousGoodsTechnicalName")
	private LanguageLabels dangerousGoodsTechnicalName = null;

	@JsonProperty("dangerousGoodsTransportCategoryCode")
	private CodifiedValue dangerousGoodsTransportCategoryCode = null;

	@JsonProperty("dangerousHazardousLabel")
	private List<DangerousHazardousLabel> dangerousHazardousLabel = null;

	@JsonProperty("eRGNumber")
	private String eRGNumber = null;

	@JsonProperty("extremelyHazardousSubstanceQuantity")
	private QualifiedValue extremelyHazardousSubstanceQuantity = null;

	@JsonProperty("hazardousClassSubsidiaryRiskCode")
	private String hazardousClassSubsidiaryRiskCode = null;

	@JsonProperty("netMassOfExplosives")
	private QualifiedValue netMassOfExplosives = null;

	@JsonProperty("unitedNationsDangerousGoodsNumber")
	private String unitedNationsDangerousGoodsNumber = null;

	public HazardousInformationDetail classOfDangerousGoods(String classOfDangerousGoods) {
		this.classOfDangerousGoods = classOfDangerousGoods;
		return this;
	}

	/**
	 * Get classOfDangerousGoods
	 * 
	 * @return classOfDangerousGoods
	 **/
	@ApiModelProperty(value = "")
	public String getClassOfDangerousGoods() {
		return classOfDangerousGoods;
	}

	public void setClassOfDangerousGoods(String classOfDangerousGoods) {
		this.classOfDangerousGoods = classOfDangerousGoods;
	}

	public HazardousInformationDetail dangerousGoodsClassificationCode(String dangerousGoodsClassificationCode) {
		this.dangerousGoodsClassificationCode = dangerousGoodsClassificationCode;
		return this;
	}

	/**
	 * Get dangerousGoodsClassificationCode
	 * 
	 * @return dangerousGoodsClassificationCode
	 **/
	@ApiModelProperty(value = "")
	public String getDangerousGoodsClassificationCode() {
		return dangerousGoodsClassificationCode;
	}

	public void setDangerousGoodsClassificationCode(String dangerousGoodsClassificationCode) {
		this.dangerousGoodsClassificationCode = dangerousGoodsClassificationCode;
	}

	public HazardousInformationDetail dangerousGoodsHazardousCode(Values dangerousGoodsHazardousCode) {
		this.dangerousGoodsHazardousCode = dangerousGoodsHazardousCode;
		return this;
	}

	/**
	 * Get dangerousGoodsHazardousCode
	 * 
	 * @return dangerousGoodsHazardousCode
	 **/
	@ApiModelProperty(value = "")
	public Values getDangerousGoodsHazardousCode() {
		return dangerousGoodsHazardousCode;
	}

	public void setDangerousGoodsHazardousCode(Values dangerousGoodsHazardousCode) {
		this.dangerousGoodsHazardousCode = dangerousGoodsHazardousCode;
	}

	public HazardousInformationDetail dangerousGoodsPackingGroup(String dangerousGoodsPackingGroup) {
		this.dangerousGoodsPackingGroup = dangerousGoodsPackingGroup;
		return this;
	}

	/**
	 * Get dangerousGoodsPackingGroup
	 * 
	 * @return dangerousGoodsPackingGroup
	 **/
	@ApiModelProperty(value = "")
	public String getDangerousGoodsPackingGroup() {
		return dangerousGoodsPackingGroup;
	}

	public void setDangerousGoodsPackingGroup(String dangerousGoodsPackingGroup) {
		this.dangerousGoodsPackingGroup = dangerousGoodsPackingGroup;
	}

	public HazardousInformationDetail dangerousGoodsShippingName(Values dangerousGoodsShippingName) {
		this.dangerousGoodsShippingName = dangerousGoodsShippingName;
		return this;
	}

	/**
	 * Get dangerousGoodsShippingName
	 * 
	 * @return dangerousGoodsShippingName
	 **/
	@ApiModelProperty(value = "")
	public Values getDangerousGoodsShippingName() {
		return dangerousGoodsShippingName;
	}

	public void setDangerousGoodsShippingName(Values dangerousGoodsShippingName) {
		this.dangerousGoodsShippingName = dangerousGoodsShippingName;
	}

	public HazardousInformationDetail dangerousGoodsSpecialProvisions(Values dangerousGoodsSpecialProvisions) {
		this.dangerousGoodsSpecialProvisions = dangerousGoodsSpecialProvisions;
		return this;
	}

	/**
	 * Get dangerousGoodsSpecialProvisions
	 * 
	 * @return dangerousGoodsSpecialProvisions
	 **/
	@ApiModelProperty(value = "")
	public Values getDangerousGoodsSpecialProvisions() {
		return dangerousGoodsSpecialProvisions;
	}

	public void setDangerousGoodsSpecialProvisions(Values dangerousGoodsSpecialProvisions) {
		this.dangerousGoodsSpecialProvisions = dangerousGoodsSpecialProvisions;
	}

	public HazardousInformationDetail dangerousGoodsTechnicalName(LanguageLabels dangerousGoodsTechnicalName) {
		this.dangerousGoodsTechnicalName = dangerousGoodsTechnicalName;
		return this;
	}

	/**
	 * Get dangerousGoodsTechnicalName
	 * 
	 * @return dangerousGoodsTechnicalName
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getDangerousGoodsTechnicalName() {
		return dangerousGoodsTechnicalName;
	}

	public void setDangerousGoodsTechnicalName(LanguageLabels dangerousGoodsTechnicalName) {
		this.dangerousGoodsTechnicalName = dangerousGoodsTechnicalName;
	}

	public HazardousInformationDetail dangerousGoodsTransportCategoryCode(
			CodifiedValue dangerousGoodsTransportCategoryCode) {
		this.dangerousGoodsTransportCategoryCode = dangerousGoodsTransportCategoryCode;
		return this;
	}

	/**
	 * Get dangerousGoodsTransportCategoryCode
	 * 
	 * @return dangerousGoodsTransportCategoryCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getDangerousGoodsTransportCategoryCode() {
		return dangerousGoodsTransportCategoryCode;
	}

	public void setDangerousGoodsTransportCategoryCode(CodifiedValue dangerousGoodsTransportCategoryCode) {
		this.dangerousGoodsTransportCategoryCode = dangerousGoodsTransportCategoryCode;
	}

	public HazardousInformationDetail dangerousHazardousLabel(List<DangerousHazardousLabel> dangerousHazardousLabel) {
		this.dangerousHazardousLabel = dangerousHazardousLabel;
		return this;
	}

	public HazardousInformationDetail addDangerousHazardousLabelItem(
			DangerousHazardousLabel dangerousHazardousLabelItem) {
		if (this.dangerousHazardousLabel == null) {
			this.dangerousHazardousLabel = new ArrayList<DangerousHazardousLabel>();
		}
		this.dangerousHazardousLabel.add(dangerousHazardousLabelItem);
		return this;
	}

	/**
	 * Get dangerousHazardousLabel
	 * 
	 * @return dangerousHazardousLabel
	 **/
	@ApiModelProperty(value = "")
	public List<DangerousHazardousLabel> getDangerousHazardousLabel() {
		return dangerousHazardousLabel;
	}

	public void setDangerousHazardousLabel(List<DangerousHazardousLabel> dangerousHazardousLabel) {
		this.dangerousHazardousLabel = dangerousHazardousLabel;
	}

	public HazardousInformationDetail eRGNumber(String eRGNumber) {
		this.eRGNumber = eRGNumber;
		return this;
	}

	/**
	 * Get eRGNumber
	 * 
	 * @return eRGNumber
	 **/
	@ApiModelProperty(value = "")
	public String getERGNumber() {
		return eRGNumber;
	}

	public void setERGNumber(String eRGNumber) {
		this.eRGNumber = eRGNumber;
	}

	public HazardousInformationDetail extremelyHazardousSubstanceQuantity(
			QualifiedValue extremelyHazardousSubstanceQuantity) {
		this.extremelyHazardousSubstanceQuantity = extremelyHazardousSubstanceQuantity;
		return this;
	}

	/**
	 * Get extremelyHazardousSubstanceQuantity
	 * 
	 * @return extremelyHazardousSubstanceQuantity
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValue getExtremelyHazardousSubstanceQuantity() {
		return extremelyHazardousSubstanceQuantity;
	}

	public void setExtremelyHazardousSubstanceQuantity(QualifiedValue extremelyHazardousSubstanceQuantity) {
		this.extremelyHazardousSubstanceQuantity = extremelyHazardousSubstanceQuantity;
	}

	public HazardousInformationDetail hazardousClassSubsidiaryRiskCode(String hazardousClassSubsidiaryRiskCode) {
		this.hazardousClassSubsidiaryRiskCode = hazardousClassSubsidiaryRiskCode;
		return this;
	}

	/**
	 * Get hazardousClassSubsidiaryRiskCode
	 * 
	 * @return hazardousClassSubsidiaryRiskCode
	 **/
	@ApiModelProperty(value = "")
	public String getHazardousClassSubsidiaryRiskCode() {
		return hazardousClassSubsidiaryRiskCode;
	}

	public void setHazardousClassSubsidiaryRiskCode(String hazardousClassSubsidiaryRiskCode) {
		this.hazardousClassSubsidiaryRiskCode = hazardousClassSubsidiaryRiskCode;
	}

	public HazardousInformationDetail netMassOfExplosives(QualifiedValue netMassOfExplosives) {
		this.netMassOfExplosives = netMassOfExplosives;
		return this;
	}

	/**
	 * Get netMassOfExplosives
	 * 
	 * @return netMassOfExplosives
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValue getNetMassOfExplosives() {
		return netMassOfExplosives;
	}

	public void setNetMassOfExplosives(QualifiedValue netMassOfExplosives) {
		this.netMassOfExplosives = netMassOfExplosives;
	}

	public HazardousInformationDetail unitedNationsDangerousGoodsNumber(String unitedNationsDangerousGoodsNumber) {
		this.unitedNationsDangerousGoodsNumber = unitedNationsDangerousGoodsNumber;
		return this;
	}

	/**
	 * Get unitedNationsDangerousGoodsNumber
	 * 
	 * @return unitedNationsDangerousGoodsNumber
	 **/
	@ApiModelProperty(value = "")
	public String getUnitedNationsDangerousGoodsNumber() {
		return unitedNationsDangerousGoodsNumber;
	}

	public void setUnitedNationsDangerousGoodsNumber(String unitedNationsDangerousGoodsNumber) {
		this.unitedNationsDangerousGoodsNumber = unitedNationsDangerousGoodsNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HazardousInformationDetail hazardousInformationDetail = (HazardousInformationDetail) o;
		return Objects.equals(this.classOfDangerousGoods, hazardousInformationDetail.classOfDangerousGoods)
				&& Objects.equals(this.dangerousGoodsClassificationCode,
						hazardousInformationDetail.dangerousGoodsClassificationCode)
				&& Objects.equals(this.dangerousGoodsHazardousCode,
						hazardousInformationDetail.dangerousGoodsHazardousCode)
				&& Objects.equals(this.dangerousGoodsPackingGroup,
						hazardousInformationDetail.dangerousGoodsPackingGroup)
				&& Objects.equals(this.dangerousGoodsShippingName,
						hazardousInformationDetail.dangerousGoodsShippingName)
				&& Objects.equals(this.dangerousGoodsSpecialProvisions,
						hazardousInformationDetail.dangerousGoodsSpecialProvisions)
				&& Objects.equals(this.dangerousGoodsTechnicalName,
						hazardousInformationDetail.dangerousGoodsTechnicalName)
				&& Objects.equals(this.dangerousGoodsTransportCategoryCode,
						hazardousInformationDetail.dangerousGoodsTransportCategoryCode)
				&& Objects.equals(this.dangerousHazardousLabel, hazardousInformationDetail.dangerousHazardousLabel)
				&& Objects.equals(this.eRGNumber, hazardousInformationDetail.eRGNumber)
				&& Objects.equals(this.extremelyHazardousSubstanceQuantity,
						hazardousInformationDetail.extremelyHazardousSubstanceQuantity)
				&& Objects.equals(this.hazardousClassSubsidiaryRiskCode,
						hazardousInformationDetail.hazardousClassSubsidiaryRiskCode)
				&& Objects.equals(this.netMassOfExplosives, hazardousInformationDetail.netMassOfExplosives)
				&& Objects.equals(this.unitedNationsDangerousGoodsNumber,
						hazardousInformationDetail.unitedNationsDangerousGoodsNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(classOfDangerousGoods, dangerousGoodsClassificationCode, dangerousGoodsHazardousCode,
				dangerousGoodsPackingGroup, dangerousGoodsShippingName, dangerousGoodsSpecialProvisions,
				dangerousGoodsTechnicalName, dangerousGoodsTransportCategoryCode, dangerousHazardousLabel, eRGNumber,
				extremelyHazardousSubstanceQuantity, hazardousClassSubsidiaryRiskCode, netMassOfExplosives,
				unitedNationsDangerousGoodsNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HazardousInformationDetail {\n");

		sb.append("    classOfDangerousGoods: ").append(toIndentedString(classOfDangerousGoods)).append("\n");
		sb.append("    dangerousGoodsClassificationCode: ").append(toIndentedString(dangerousGoodsClassificationCode))
				.append("\n");
		sb.append("    dangerousGoodsHazardousCode: ").append(toIndentedString(dangerousGoodsHazardousCode))
				.append("\n");
		sb.append("    dangerousGoodsPackingGroup: ").append(toIndentedString(dangerousGoodsPackingGroup)).append("\n");
		sb.append("    dangerousGoodsShippingName: ").append(toIndentedString(dangerousGoodsShippingName)).append("\n");
		sb.append("    dangerousGoodsSpecialProvisions: ").append(toIndentedString(dangerousGoodsSpecialProvisions))
				.append("\n");
		sb.append("    dangerousGoodsTechnicalName: ").append(toIndentedString(dangerousGoodsTechnicalName))
				.append("\n");
		sb.append("    dangerousGoodsTransportCategoryCode: ")
				.append(toIndentedString(dangerousGoodsTransportCategoryCode)).append("\n");
		sb.append("    dangerousHazardousLabel: ").append(toIndentedString(dangerousHazardousLabel)).append("\n");
		sb.append("    eRGNumber: ").append(toIndentedString(eRGNumber)).append("\n");
		sb.append("    extremelyHazardousSubstanceQuantity: ")
				.append(toIndentedString(extremelyHazardousSubstanceQuantity)).append("\n");
		sb.append("    hazardousClassSubsidiaryRiskCode: ").append(toIndentedString(hazardousClassSubsidiaryRiskCode))
				.append("\n");
		sb.append("    netMassOfExplosives: ").append(toIndentedString(netMassOfExplosives)).append("\n");
		sb.append("    unitedNationsDangerousGoodsNumber: ").append(toIndentedString(unitedNationsDangerousGoodsNumber))
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
