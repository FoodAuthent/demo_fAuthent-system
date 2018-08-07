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
import org.foodauthent.oneworldsync.client.model.AudioVisualMediaDateInformation;
import org.foodauthent.oneworldsync.client.model.CodifiedValue;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.Values;

/**
 * AudioVisualMediaProductDescription
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class AudioVisualMediaProductDescription {
	@JsonProperty("audioVisualMediaDateInformation")
	private List<AudioVisualMediaDateInformation> audioVisualMediaDateInformation = null;

	@JsonProperty("audioVisualMediaProductCollectionName")
	private String audioVisualMediaProductCollectionName = null;

	@JsonProperty("audioVisualMediaProductCollectionSeriesNumber")
	private Values audioVisualMediaProductCollectionSeriesNumber = null;

	@JsonProperty("audioVisualMediaProductLabelName")
	private String audioVisualMediaProductLabelName = null;

	@JsonProperty("audioVisualMediaProductLine")
	private LanguageLabels audioVisualMediaProductLine = null;

	@JsonProperty("audioVisualMediaProductTitle")
	private String audioVisualMediaProductTitle = null;

	@JsonProperty("editionDescription")
	private LanguageLabels editionDescription = null;

	@JsonProperty("genreTypeCodeReference")
	private CodifiedValue genreTypeCodeReference = null;

	@JsonProperty("longSynopsis")
	private LanguageLabels longSynopsis = null;

	@JsonProperty("musicPerformanceType")
	private String musicPerformanceType = null;

	@JsonProperty("payPerViewWindow")
	private String payPerViewWindow = null;

	@JsonProperty("shortSynopsis")
	private LanguageLabels shortSynopsis = null;

	@JsonProperty("specialFeatures")
	private LanguageLabels specialFeatures = null;

	@JsonProperty("studioName")
	private Values studioName = null;

	@JsonProperty("yearOfProduction")
	private String yearOfProduction = null;

	public AudioVisualMediaProductDescription audioVisualMediaDateInformation(
			List<AudioVisualMediaDateInformation> audioVisualMediaDateInformation) {
		this.audioVisualMediaDateInformation = audioVisualMediaDateInformation;
		return this;
	}

	public AudioVisualMediaProductDescription addAudioVisualMediaDateInformationItem(
			AudioVisualMediaDateInformation audioVisualMediaDateInformationItem) {
		if (this.audioVisualMediaDateInformation == null) {
			this.audioVisualMediaDateInformation = new ArrayList<AudioVisualMediaDateInformation>();
		}
		this.audioVisualMediaDateInformation.add(audioVisualMediaDateInformationItem);
		return this;
	}

	/**
	 * Get audioVisualMediaDateInformation
	 * 
	 * @return audioVisualMediaDateInformation
	 **/
	@ApiModelProperty(value = "")
	public List<AudioVisualMediaDateInformation> getAudioVisualMediaDateInformation() {
		return audioVisualMediaDateInformation;
	}

	public void setAudioVisualMediaDateInformation(
			List<AudioVisualMediaDateInformation> audioVisualMediaDateInformation) {
		this.audioVisualMediaDateInformation = audioVisualMediaDateInformation;
	}

	public AudioVisualMediaProductDescription audioVisualMediaProductCollectionName(
			String audioVisualMediaProductCollectionName) {
		this.audioVisualMediaProductCollectionName = audioVisualMediaProductCollectionName;
		return this;
	}

	/**
	 * Get audioVisualMediaProductCollectionName
	 * 
	 * @return audioVisualMediaProductCollectionName
	 **/
	@ApiModelProperty(value = "")
	public String getAudioVisualMediaProductCollectionName() {
		return audioVisualMediaProductCollectionName;
	}

	public void setAudioVisualMediaProductCollectionName(String audioVisualMediaProductCollectionName) {
		this.audioVisualMediaProductCollectionName = audioVisualMediaProductCollectionName;
	}

	public AudioVisualMediaProductDescription audioVisualMediaProductCollectionSeriesNumber(
			Values audioVisualMediaProductCollectionSeriesNumber) {
		this.audioVisualMediaProductCollectionSeriesNumber = audioVisualMediaProductCollectionSeriesNumber;
		return this;
	}

	/**
	 * Get audioVisualMediaProductCollectionSeriesNumber
	 * 
	 * @return audioVisualMediaProductCollectionSeriesNumber
	 **/
	@ApiModelProperty(value = "")
	public Values getAudioVisualMediaProductCollectionSeriesNumber() {
		return audioVisualMediaProductCollectionSeriesNumber;
	}

	public void setAudioVisualMediaProductCollectionSeriesNumber(Values audioVisualMediaProductCollectionSeriesNumber) {
		this.audioVisualMediaProductCollectionSeriesNumber = audioVisualMediaProductCollectionSeriesNumber;
	}

	public AudioVisualMediaProductDescription audioVisualMediaProductLabelName(
			String audioVisualMediaProductLabelName) {
		this.audioVisualMediaProductLabelName = audioVisualMediaProductLabelName;
		return this;
	}

	/**
	 * Get audioVisualMediaProductLabelName
	 * 
	 * @return audioVisualMediaProductLabelName
	 **/
	@ApiModelProperty(value = "")
	public String getAudioVisualMediaProductLabelName() {
		return audioVisualMediaProductLabelName;
	}

	public void setAudioVisualMediaProductLabelName(String audioVisualMediaProductLabelName) {
		this.audioVisualMediaProductLabelName = audioVisualMediaProductLabelName;
	}

	public AudioVisualMediaProductDescription audioVisualMediaProductLine(LanguageLabels audioVisualMediaProductLine) {
		this.audioVisualMediaProductLine = audioVisualMediaProductLine;
		return this;
	}

	/**
	 * Get audioVisualMediaProductLine
	 * 
	 * @return audioVisualMediaProductLine
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getAudioVisualMediaProductLine() {
		return audioVisualMediaProductLine;
	}

	public void setAudioVisualMediaProductLine(LanguageLabels audioVisualMediaProductLine) {
		this.audioVisualMediaProductLine = audioVisualMediaProductLine;
	}

	public AudioVisualMediaProductDescription audioVisualMediaProductTitle(String audioVisualMediaProductTitle) {
		this.audioVisualMediaProductTitle = audioVisualMediaProductTitle;
		return this;
	}

	/**
	 * Get audioVisualMediaProductTitle
	 * 
	 * @return audioVisualMediaProductTitle
	 **/
	@ApiModelProperty(value = "")
	public String getAudioVisualMediaProductTitle() {
		return audioVisualMediaProductTitle;
	}

	public void setAudioVisualMediaProductTitle(String audioVisualMediaProductTitle) {
		this.audioVisualMediaProductTitle = audioVisualMediaProductTitle;
	}

	public AudioVisualMediaProductDescription editionDescription(LanguageLabels editionDescription) {
		this.editionDescription = editionDescription;
		return this;
	}

	/**
	 * Get editionDescription
	 * 
	 * @return editionDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getEditionDescription() {
		return editionDescription;
	}

	public void setEditionDescription(LanguageLabels editionDescription) {
		this.editionDescription = editionDescription;
	}

	public AudioVisualMediaProductDescription genreTypeCodeReference(CodifiedValue genreTypeCodeReference) {
		this.genreTypeCodeReference = genreTypeCodeReference;
		return this;
	}

	/**
	 * Get genreTypeCodeReference
	 * 
	 * @return genreTypeCodeReference
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getGenreTypeCodeReference() {
		return genreTypeCodeReference;
	}

	public void setGenreTypeCodeReference(CodifiedValue genreTypeCodeReference) {
		this.genreTypeCodeReference = genreTypeCodeReference;
	}

	public AudioVisualMediaProductDescription longSynopsis(LanguageLabels longSynopsis) {
		this.longSynopsis = longSynopsis;
		return this;
	}

	/**
	 * Get longSynopsis
	 * 
	 * @return longSynopsis
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getLongSynopsis() {
		return longSynopsis;
	}

	public void setLongSynopsis(LanguageLabels longSynopsis) {
		this.longSynopsis = longSynopsis;
	}

	public AudioVisualMediaProductDescription musicPerformanceType(String musicPerformanceType) {
		this.musicPerformanceType = musicPerformanceType;
		return this;
	}

	/**
	 * Get musicPerformanceType
	 * 
	 * @return musicPerformanceType
	 **/
	@ApiModelProperty(value = "")
	public String getMusicPerformanceType() {
		return musicPerformanceType;
	}

	public void setMusicPerformanceType(String musicPerformanceType) {
		this.musicPerformanceType = musicPerformanceType;
	}

	public AudioVisualMediaProductDescription payPerViewWindow(String payPerViewWindow) {
		this.payPerViewWindow = payPerViewWindow;
		return this;
	}

	/**
	 * Get payPerViewWindow
	 * 
	 * @return payPerViewWindow
	 **/
	@ApiModelProperty(value = "")
	public String getPayPerViewWindow() {
		return payPerViewWindow;
	}

	public void setPayPerViewWindow(String payPerViewWindow) {
		this.payPerViewWindow = payPerViewWindow;
	}

	public AudioVisualMediaProductDescription shortSynopsis(LanguageLabels shortSynopsis) {
		this.shortSynopsis = shortSynopsis;
		return this;
	}

	/**
	 * Get shortSynopsis
	 * 
	 * @return shortSynopsis
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getShortSynopsis() {
		return shortSynopsis;
	}

	public void setShortSynopsis(LanguageLabels shortSynopsis) {
		this.shortSynopsis = shortSynopsis;
	}

	public AudioVisualMediaProductDescription specialFeatures(LanguageLabels specialFeatures) {
		this.specialFeatures = specialFeatures;
		return this;
	}

	/**
	 * Get specialFeatures
	 * 
	 * @return specialFeatures
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(LanguageLabels specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public AudioVisualMediaProductDescription studioName(Values studioName) {
		this.studioName = studioName;
		return this;
	}

	/**
	 * Get studioName
	 * 
	 * @return studioName
	 **/
	@ApiModelProperty(value = "")
	public Values getStudioName() {
		return studioName;
	}

	public void setStudioName(Values studioName) {
		this.studioName = studioName;
	}

	public AudioVisualMediaProductDescription yearOfProduction(String yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
		return this;
	}

	/**
	 * Get yearOfProduction
	 * 
	 * @return yearOfProduction
	 **/
	@ApiModelProperty(value = "")
	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(String yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AudioVisualMediaProductDescription audioVisualMediaProductDescription = (AudioVisualMediaProductDescription) o;
		return Objects.equals(this.audioVisualMediaDateInformation,
				audioVisualMediaProductDescription.audioVisualMediaDateInformation)
				&& Objects.equals(this.audioVisualMediaProductCollectionName,
						audioVisualMediaProductDescription.audioVisualMediaProductCollectionName)
				&& Objects.equals(this.audioVisualMediaProductCollectionSeriesNumber,
						audioVisualMediaProductDescription.audioVisualMediaProductCollectionSeriesNumber)
				&& Objects.equals(this.audioVisualMediaProductLabelName,
						audioVisualMediaProductDescription.audioVisualMediaProductLabelName)
				&& Objects.equals(this.audioVisualMediaProductLine,
						audioVisualMediaProductDescription.audioVisualMediaProductLine)
				&& Objects.equals(this.audioVisualMediaProductTitle,
						audioVisualMediaProductDescription.audioVisualMediaProductTitle)
				&& Objects.equals(this.editionDescription, audioVisualMediaProductDescription.editionDescription)
				&& Objects.equals(this.genreTypeCodeReference,
						audioVisualMediaProductDescription.genreTypeCodeReference)
				&& Objects.equals(this.longSynopsis, audioVisualMediaProductDescription.longSynopsis)
				&& Objects.equals(this.musicPerformanceType, audioVisualMediaProductDescription.musicPerformanceType)
				&& Objects.equals(this.payPerViewWindow, audioVisualMediaProductDescription.payPerViewWindow)
				&& Objects.equals(this.shortSynopsis, audioVisualMediaProductDescription.shortSynopsis)
				&& Objects.equals(this.specialFeatures, audioVisualMediaProductDescription.specialFeatures)
				&& Objects.equals(this.studioName, audioVisualMediaProductDescription.studioName)
				&& Objects.equals(this.yearOfProduction, audioVisualMediaProductDescription.yearOfProduction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(audioVisualMediaDateInformation, audioVisualMediaProductCollectionName,
				audioVisualMediaProductCollectionSeriesNumber, audioVisualMediaProductLabelName,
				audioVisualMediaProductLine, audioVisualMediaProductTitle, editionDescription, genreTypeCodeReference,
				longSynopsis, musicPerformanceType, payPerViewWindow, shortSynopsis, specialFeatures, studioName,
				yearOfProduction);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AudioVisualMediaProductDescription {\n");

		sb.append("    audioVisualMediaDateInformation: ").append(toIndentedString(audioVisualMediaDateInformation))
				.append("\n");
		sb.append("    audioVisualMediaProductCollectionName: ")
				.append(toIndentedString(audioVisualMediaProductCollectionName)).append("\n");
		sb.append("    audioVisualMediaProductCollectionSeriesNumber: ")
				.append(toIndentedString(audioVisualMediaProductCollectionSeriesNumber)).append("\n");
		sb.append("    audioVisualMediaProductLabelName: ").append(toIndentedString(audioVisualMediaProductLabelName))
				.append("\n");
		sb.append("    audioVisualMediaProductLine: ").append(toIndentedString(audioVisualMediaProductLine))
				.append("\n");
		sb.append("    audioVisualMediaProductTitle: ").append(toIndentedString(audioVisualMediaProductTitle))
				.append("\n");
		sb.append("    editionDescription: ").append(toIndentedString(editionDescription)).append("\n");
		sb.append("    genreTypeCodeReference: ").append(toIndentedString(genreTypeCodeReference)).append("\n");
		sb.append("    longSynopsis: ").append(toIndentedString(longSynopsis)).append("\n");
		sb.append("    musicPerformanceType: ").append(toIndentedString(musicPerformanceType)).append("\n");
		sb.append("    payPerViewWindow: ").append(toIndentedString(payPerViewWindow)).append("\n");
		sb.append("    shortSynopsis: ").append(toIndentedString(shortSynopsis)).append("\n");
		sb.append("    specialFeatures: ").append(toIndentedString(specialFeatures)).append("\n");
		sb.append("    studioName: ").append(toIndentedString(studioName)).append("\n");
		sb.append("    yearOfProduction: ").append(toIndentedString(yearOfProduction)).append("\n");
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
