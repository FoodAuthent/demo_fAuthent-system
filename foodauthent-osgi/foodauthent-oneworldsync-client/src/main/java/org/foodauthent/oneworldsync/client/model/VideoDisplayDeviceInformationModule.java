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
import org.foodauthent.oneworldsync.client.model.DisplayScreenInformation;
import org.foodauthent.oneworldsync.client.model.TelevisionInformationServiceInformation;
import org.foodauthent.oneworldsync.client.model.VideoDisplayDeviceInstallationInformation;

/**
 * VideoDisplayDeviceInformationModule
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class VideoDisplayDeviceInformationModule {
	@JsonProperty("availableBrightnessValues")
	private String availableBrightnessValues = null;

	@JsonProperty("combFilterTechnologyTypeCode")
	private CodifiedValue combFilterTechnologyTypeCode = null;

	@JsonProperty("displayScreenInformation")
	private DisplayScreenInformation displayScreenInformation = null;

	@JsonProperty("dynamicContrastRatio")
	private String dynamicContrastRatio = null;

	@JsonProperty("multiPictureDisplayCapabilityTypeCode")
	private CodifiedValue multiPictureDisplayCapabilityTypeCode = null;

	@JsonProperty("screenRefreshRate")
	private String screenRefreshRate = null;

	@JsonProperty("staticContrastRatio")
	private String staticContrastRatio = null;

	@JsonProperty("televisionInformationServiceInformation")
	private TelevisionInformationServiceInformation televisionInformationServiceInformation = null;

	@JsonProperty("videoDisplayDeviceInstallationInformation")
	private VideoDisplayDeviceInstallationInformation videoDisplayDeviceInstallationInformation = null;

	public VideoDisplayDeviceInformationModule availableBrightnessValues(String availableBrightnessValues) {
		this.availableBrightnessValues = availableBrightnessValues;
		return this;
	}

	/**
	 * Get availableBrightnessValues
	 * 
	 * @return availableBrightnessValues
	 **/
	@ApiModelProperty(value = "")
	public String getAvailableBrightnessValues() {
		return availableBrightnessValues;
	}

	public void setAvailableBrightnessValues(String availableBrightnessValues) {
		this.availableBrightnessValues = availableBrightnessValues;
	}

	public VideoDisplayDeviceInformationModule combFilterTechnologyTypeCode(
			CodifiedValue combFilterTechnologyTypeCode) {
		this.combFilterTechnologyTypeCode = combFilterTechnologyTypeCode;
		return this;
	}

	/**
	 * Get combFilterTechnologyTypeCode
	 * 
	 * @return combFilterTechnologyTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getCombFilterTechnologyTypeCode() {
		return combFilterTechnologyTypeCode;
	}

	public void setCombFilterTechnologyTypeCode(CodifiedValue combFilterTechnologyTypeCode) {
		this.combFilterTechnologyTypeCode = combFilterTechnologyTypeCode;
	}

	public VideoDisplayDeviceInformationModule displayScreenInformation(
			DisplayScreenInformation displayScreenInformation) {
		this.displayScreenInformation = displayScreenInformation;
		return this;
	}

	/**
	 * Get displayScreenInformation
	 * 
	 * @return displayScreenInformation
	 **/
	@ApiModelProperty(value = "")
	public DisplayScreenInformation getDisplayScreenInformation() {
		return displayScreenInformation;
	}

	public void setDisplayScreenInformation(DisplayScreenInformation displayScreenInformation) {
		this.displayScreenInformation = displayScreenInformation;
	}

	public VideoDisplayDeviceInformationModule dynamicContrastRatio(String dynamicContrastRatio) {
		this.dynamicContrastRatio = dynamicContrastRatio;
		return this;
	}

	/**
	 * Get dynamicContrastRatio
	 * 
	 * @return dynamicContrastRatio
	 **/
	@ApiModelProperty(value = "")
	public String getDynamicContrastRatio() {
		return dynamicContrastRatio;
	}

	public void setDynamicContrastRatio(String dynamicContrastRatio) {
		this.dynamicContrastRatio = dynamicContrastRatio;
	}

	public VideoDisplayDeviceInformationModule multiPictureDisplayCapabilityTypeCode(
			CodifiedValue multiPictureDisplayCapabilityTypeCode) {
		this.multiPictureDisplayCapabilityTypeCode = multiPictureDisplayCapabilityTypeCode;
		return this;
	}

	/**
	 * Get multiPictureDisplayCapabilityTypeCode
	 * 
	 * @return multiPictureDisplayCapabilityTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getMultiPictureDisplayCapabilityTypeCode() {
		return multiPictureDisplayCapabilityTypeCode;
	}

	public void setMultiPictureDisplayCapabilityTypeCode(CodifiedValue multiPictureDisplayCapabilityTypeCode) {
		this.multiPictureDisplayCapabilityTypeCode = multiPictureDisplayCapabilityTypeCode;
	}

	public VideoDisplayDeviceInformationModule screenRefreshRate(String screenRefreshRate) {
		this.screenRefreshRate = screenRefreshRate;
		return this;
	}

	/**
	 * Get screenRefreshRate
	 * 
	 * @return screenRefreshRate
	 **/
	@ApiModelProperty(value = "")
	public String getScreenRefreshRate() {
		return screenRefreshRate;
	}

	public void setScreenRefreshRate(String screenRefreshRate) {
		this.screenRefreshRate = screenRefreshRate;
	}

	public VideoDisplayDeviceInformationModule staticContrastRatio(String staticContrastRatio) {
		this.staticContrastRatio = staticContrastRatio;
		return this;
	}

	/**
	 * Get staticContrastRatio
	 * 
	 * @return staticContrastRatio
	 **/
	@ApiModelProperty(value = "")
	public String getStaticContrastRatio() {
		return staticContrastRatio;
	}

	public void setStaticContrastRatio(String staticContrastRatio) {
		this.staticContrastRatio = staticContrastRatio;
	}

	public VideoDisplayDeviceInformationModule televisionInformationServiceInformation(
			TelevisionInformationServiceInformation televisionInformationServiceInformation) {
		this.televisionInformationServiceInformation = televisionInformationServiceInformation;
		return this;
	}

	/**
	 * Get televisionInformationServiceInformation
	 * 
	 * @return televisionInformationServiceInformation
	 **/
	@ApiModelProperty(value = "")
	public TelevisionInformationServiceInformation getTelevisionInformationServiceInformation() {
		return televisionInformationServiceInformation;
	}

	public void setTelevisionInformationServiceInformation(
			TelevisionInformationServiceInformation televisionInformationServiceInformation) {
		this.televisionInformationServiceInformation = televisionInformationServiceInformation;
	}

	public VideoDisplayDeviceInformationModule videoDisplayDeviceInstallationInformation(
			VideoDisplayDeviceInstallationInformation videoDisplayDeviceInstallationInformation) {
		this.videoDisplayDeviceInstallationInformation = videoDisplayDeviceInstallationInformation;
		return this;
	}

	/**
	 * Get videoDisplayDeviceInstallationInformation
	 * 
	 * @return videoDisplayDeviceInstallationInformation
	 **/
	@ApiModelProperty(value = "")
	public VideoDisplayDeviceInstallationInformation getVideoDisplayDeviceInstallationInformation() {
		return videoDisplayDeviceInstallationInformation;
	}

	public void setVideoDisplayDeviceInstallationInformation(
			VideoDisplayDeviceInstallationInformation videoDisplayDeviceInstallationInformation) {
		this.videoDisplayDeviceInstallationInformation = videoDisplayDeviceInstallationInformation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VideoDisplayDeviceInformationModule videoDisplayDeviceInformationModule = (VideoDisplayDeviceInformationModule) o;
		return Objects.equals(this.availableBrightnessValues,
				videoDisplayDeviceInformationModule.availableBrightnessValues)
				&& Objects.equals(this.combFilterTechnologyTypeCode,
						videoDisplayDeviceInformationModule.combFilterTechnologyTypeCode)
				&& Objects.equals(this.displayScreenInformation,
						videoDisplayDeviceInformationModule.displayScreenInformation)
				&& Objects.equals(this.dynamicContrastRatio, videoDisplayDeviceInformationModule.dynamicContrastRatio)
				&& Objects.equals(this.multiPictureDisplayCapabilityTypeCode,
						videoDisplayDeviceInformationModule.multiPictureDisplayCapabilityTypeCode)
				&& Objects.equals(this.screenRefreshRate, videoDisplayDeviceInformationModule.screenRefreshRate)
				&& Objects.equals(this.staticContrastRatio, videoDisplayDeviceInformationModule.staticContrastRatio)
				&& Objects.equals(this.televisionInformationServiceInformation,
						videoDisplayDeviceInformationModule.televisionInformationServiceInformation)
				&& Objects.equals(this.videoDisplayDeviceInstallationInformation,
						videoDisplayDeviceInformationModule.videoDisplayDeviceInstallationInformation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableBrightnessValues, combFilterTechnologyTypeCode, displayScreenInformation,
				dynamicContrastRatio, multiPictureDisplayCapabilityTypeCode, screenRefreshRate, staticContrastRatio,
				televisionInformationServiceInformation, videoDisplayDeviceInstallationInformation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VideoDisplayDeviceInformationModule {\n");

		sb.append("    availableBrightnessValues: ").append(toIndentedString(availableBrightnessValues)).append("\n");
		sb.append("    combFilterTechnologyTypeCode: ").append(toIndentedString(combFilterTechnologyTypeCode))
				.append("\n");
		sb.append("    displayScreenInformation: ").append(toIndentedString(displayScreenInformation)).append("\n");
		sb.append("    dynamicContrastRatio: ").append(toIndentedString(dynamicContrastRatio)).append("\n");
		sb.append("    multiPictureDisplayCapabilityTypeCode: ")
				.append(toIndentedString(multiPictureDisplayCapabilityTypeCode)).append("\n");
		sb.append("    screenRefreshRate: ").append(toIndentedString(screenRefreshRate)).append("\n");
		sb.append("    staticContrastRatio: ").append(toIndentedString(staticContrastRatio)).append("\n");
		sb.append("    televisionInformationServiceInformation: ")
				.append(toIndentedString(televisionInformationServiceInformation)).append("\n");
		sb.append("    videoDisplayDeviceInstallationInformation: ")
				.append(toIndentedString(videoDisplayDeviceInstallationInformation)).append("\n");
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
