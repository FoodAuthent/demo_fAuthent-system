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
import org.foodauthent.oneworldsync.client.model.AdditionalPartyIdentification;
import org.foodauthent.oneworldsync.client.model.CodifiedValue;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.TargetMarketCommunicationChannel;

/**
 * TradeItemContactInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class TradeItemContactInformation {
	@JsonProperty("additionalPartyIdentification")
	private List<AdditionalPartyIdentification> additionalPartyIdentification = null;

	@JsonProperty("availableTime")
	private LanguageLabels availableTime = null;

	@JsonProperty("contactAddress")
	private String contactAddress = null;

	@JsonProperty("contactDescription")
	private LanguageLabels contactDescription = null;

	@JsonProperty("contactName")
	private String contactName = null;

	@JsonProperty("contactTypeCode")
	private CodifiedValue contactTypeCode = null;

	@JsonProperty("informationProviderId")
	private String informationProviderId = null;

	@JsonProperty("informationProviderType")
	private CodifiedValue informationProviderType = null;

	@JsonProperty("targetMarketCommunicationChannel")
	private List<TargetMarketCommunicationChannel> targetMarketCommunicationChannel = null;

	public TradeItemContactInformation additionalPartyIdentification(
			List<AdditionalPartyIdentification> additionalPartyIdentification) {
		this.additionalPartyIdentification = additionalPartyIdentification;
		return this;
	}

	public TradeItemContactInformation addAdditionalPartyIdentificationItem(
			AdditionalPartyIdentification additionalPartyIdentificationItem) {
		if (this.additionalPartyIdentification == null) {
			this.additionalPartyIdentification = new ArrayList<AdditionalPartyIdentification>();
		}
		this.additionalPartyIdentification.add(additionalPartyIdentificationItem);
		return this;
	}

	/**
	 * Get additionalPartyIdentification
	 * 
	 * @return additionalPartyIdentification
	 **/
	@ApiModelProperty(value = "")
	public List<AdditionalPartyIdentification> getAdditionalPartyIdentification() {
		return additionalPartyIdentification;
	}

	public void setAdditionalPartyIdentification(List<AdditionalPartyIdentification> additionalPartyIdentification) {
		this.additionalPartyIdentification = additionalPartyIdentification;
	}

	public TradeItemContactInformation availableTime(LanguageLabels availableTime) {
		this.availableTime = availableTime;
		return this;
	}

	/**
	 * Get availableTime
	 * 
	 * @return availableTime
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(LanguageLabels availableTime) {
		this.availableTime = availableTime;
	}

	public TradeItemContactInformation contactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
		return this;
	}

	/**
	 * Get contactAddress
	 * 
	 * @return contactAddress
	 **/
	@ApiModelProperty(value = "")
	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public TradeItemContactInformation contactDescription(LanguageLabels contactDescription) {
		this.contactDescription = contactDescription;
		return this;
	}

	/**
	 * Get contactDescription
	 * 
	 * @return contactDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(LanguageLabels contactDescription) {
		this.contactDescription = contactDescription;
	}

	public TradeItemContactInformation contactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	/**
	 * Get contactName
	 * 
	 * @return contactName
	 **/
	@ApiModelProperty(value = "")
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public TradeItemContactInformation contactTypeCode(CodifiedValue contactTypeCode) {
		this.contactTypeCode = contactTypeCode;
		return this;
	}

	/**
	 * Get contactTypeCode
	 * 
	 * @return contactTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getContactTypeCode() {
		return contactTypeCode;
	}

	public void setContactTypeCode(CodifiedValue contactTypeCode) {
		this.contactTypeCode = contactTypeCode;
	}

	public TradeItemContactInformation informationProviderId(String informationProviderId) {
		this.informationProviderId = informationProviderId;
		return this;
	}

	/**
	 * Get informationProviderId
	 * 
	 * @return informationProviderId
	 **/
	@ApiModelProperty(value = "")
	public String getInformationProviderId() {
		return informationProviderId;
	}

	public void setInformationProviderId(String informationProviderId) {
		this.informationProviderId = informationProviderId;
	}

	public TradeItemContactInformation informationProviderType(CodifiedValue informationProviderType) {
		this.informationProviderType = informationProviderType;
		return this;
	}

	/**
	 * Get informationProviderType
	 * 
	 * @return informationProviderType
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getInformationProviderType() {
		return informationProviderType;
	}

	public void setInformationProviderType(CodifiedValue informationProviderType) {
		this.informationProviderType = informationProviderType;
	}

	public TradeItemContactInformation targetMarketCommunicationChannel(
			List<TargetMarketCommunicationChannel> targetMarketCommunicationChannel) {
		this.targetMarketCommunicationChannel = targetMarketCommunicationChannel;
		return this;
	}

	public TradeItemContactInformation addTargetMarketCommunicationChannelItem(
			TargetMarketCommunicationChannel targetMarketCommunicationChannelItem) {
		if (this.targetMarketCommunicationChannel == null) {
			this.targetMarketCommunicationChannel = new ArrayList<TargetMarketCommunicationChannel>();
		}
		this.targetMarketCommunicationChannel.add(targetMarketCommunicationChannelItem);
		return this;
	}

	/**
	 * Get targetMarketCommunicationChannel
	 * 
	 * @return targetMarketCommunicationChannel
	 **/
	@ApiModelProperty(value = "")
	public List<TargetMarketCommunicationChannel> getTargetMarketCommunicationChannel() {
		return targetMarketCommunicationChannel;
	}

	public void setTargetMarketCommunicationChannel(
			List<TargetMarketCommunicationChannel> targetMarketCommunicationChannel) {
		this.targetMarketCommunicationChannel = targetMarketCommunicationChannel;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TradeItemContactInformation tradeItemContactInformation = (TradeItemContactInformation) o;
		return Objects.equals(this.additionalPartyIdentification,
				tradeItemContactInformation.additionalPartyIdentification)
				&& Objects.equals(this.availableTime, tradeItemContactInformation.availableTime)
				&& Objects.equals(this.contactAddress, tradeItemContactInformation.contactAddress)
				&& Objects.equals(this.contactDescription, tradeItemContactInformation.contactDescription)
				&& Objects.equals(this.contactName, tradeItemContactInformation.contactName)
				&& Objects.equals(this.contactTypeCode, tradeItemContactInformation.contactTypeCode)
				&& Objects.equals(this.informationProviderId, tradeItemContactInformation.informationProviderId)
				&& Objects.equals(this.informationProviderType, tradeItemContactInformation.informationProviderType)
				&& Objects.equals(this.targetMarketCommunicationChannel,
						tradeItemContactInformation.targetMarketCommunicationChannel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalPartyIdentification, availableTime, contactAddress, contactDescription,
				contactName, contactTypeCode, informationProviderId, informationProviderType,
				targetMarketCommunicationChannel);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TradeItemContactInformation {\n");

		sb.append("    additionalPartyIdentification: ").append(toIndentedString(additionalPartyIdentification))
				.append("\n");
		sb.append("    availableTime: ").append(toIndentedString(availableTime)).append("\n");
		sb.append("    contactAddress: ").append(toIndentedString(contactAddress)).append("\n");
		sb.append("    contactDescription: ").append(toIndentedString(contactDescription)).append("\n");
		sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
		sb.append("    contactTypeCode: ").append(toIndentedString(contactTypeCode)).append("\n");
		sb.append("    informationProviderId: ").append(toIndentedString(informationProviderId)).append("\n");
		sb.append("    informationProviderType: ").append(toIndentedString(informationProviderType)).append("\n");
		sb.append("    targetMarketCommunicationChannel: ").append(toIndentedString(targetMarketCommunicationChannel))
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
