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
import org.foodauthent.oneworldsync.client.model.AdditionalCertificationOrganisationIdentifier;
import org.foodauthent.oneworldsync.client.model.Certification;
import org.foodauthent.oneworldsync.client.model.CodifiedValue;

/**
 * CertificationInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class CertificationInformation {
	@JsonProperty("additionalCertificationOrganisationIdentifier")
	private List<AdditionalCertificationOrganisationIdentifier> additionalCertificationOrganisationIdentifier = null;

	@JsonProperty("additionalPartyIdentificationTypeCode")
	private CodifiedValue additionalPartyIdentificationTypeCode = null;

	@JsonProperty("additionalPartyIdentificationValue")
	private String additionalPartyIdentificationValue = null;

	@JsonProperty("certification")
	private List<Certification> certification = null;

	@JsonProperty("certificationAgency")
	private String certificationAgency = null;

	@JsonProperty("certificationOrganisationIdentifier")
	private String certificationOrganisationIdentifier = null;

	@JsonProperty("certificationStandard")
	private String certificationStandard = null;

	public CertificationInformation additionalCertificationOrganisationIdentifier(
			List<AdditionalCertificationOrganisationIdentifier> additionalCertificationOrganisationIdentifier) {
		this.additionalCertificationOrganisationIdentifier = additionalCertificationOrganisationIdentifier;
		return this;
	}

	public CertificationInformation addAdditionalCertificationOrganisationIdentifierItem(
			AdditionalCertificationOrganisationIdentifier additionalCertificationOrganisationIdentifierItem) {
		if (this.additionalCertificationOrganisationIdentifier == null) {
			this.additionalCertificationOrganisationIdentifier = new ArrayList<AdditionalCertificationOrganisationIdentifier>();
		}
		this.additionalCertificationOrganisationIdentifier.add(additionalCertificationOrganisationIdentifierItem);
		return this;
	}

	/**
	 * Get additionalCertificationOrganisationIdentifier
	 * 
	 * @return additionalCertificationOrganisationIdentifier
	 **/
	@ApiModelProperty(value = "")
	public List<AdditionalCertificationOrganisationIdentifier> getAdditionalCertificationOrganisationIdentifier() {
		return additionalCertificationOrganisationIdentifier;
	}

	public void setAdditionalCertificationOrganisationIdentifier(
			List<AdditionalCertificationOrganisationIdentifier> additionalCertificationOrganisationIdentifier) {
		this.additionalCertificationOrganisationIdentifier = additionalCertificationOrganisationIdentifier;
	}

	public CertificationInformation additionalPartyIdentificationTypeCode(
			CodifiedValue additionalPartyIdentificationTypeCode) {
		this.additionalPartyIdentificationTypeCode = additionalPartyIdentificationTypeCode;
		return this;
	}

	/**
	 * Get additionalPartyIdentificationTypeCode
	 * 
	 * @return additionalPartyIdentificationTypeCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getAdditionalPartyIdentificationTypeCode() {
		return additionalPartyIdentificationTypeCode;
	}

	public void setAdditionalPartyIdentificationTypeCode(CodifiedValue additionalPartyIdentificationTypeCode) {
		this.additionalPartyIdentificationTypeCode = additionalPartyIdentificationTypeCode;
	}

	public CertificationInformation additionalPartyIdentificationValue(String additionalPartyIdentificationValue) {
		this.additionalPartyIdentificationValue = additionalPartyIdentificationValue;
		return this;
	}

	/**
	 * Get additionalPartyIdentificationValue
	 * 
	 * @return additionalPartyIdentificationValue
	 **/
	@ApiModelProperty(value = "")
	public String getAdditionalPartyIdentificationValue() {
		return additionalPartyIdentificationValue;
	}

	public void setAdditionalPartyIdentificationValue(String additionalPartyIdentificationValue) {
		this.additionalPartyIdentificationValue = additionalPartyIdentificationValue;
	}

	public CertificationInformation certification(List<Certification> certification) {
		this.certification = certification;
		return this;
	}

	public CertificationInformation addCertificationItem(Certification certificationItem) {
		if (this.certification == null) {
			this.certification = new ArrayList<Certification>();
		}
		this.certification.add(certificationItem);
		return this;
	}

	/**
	 * Get certification
	 * 
	 * @return certification
	 **/
	@ApiModelProperty(value = "")
	public List<Certification> getCertification() {
		return certification;
	}

	public void setCertification(List<Certification> certification) {
		this.certification = certification;
	}

	public CertificationInformation certificationAgency(String certificationAgency) {
		this.certificationAgency = certificationAgency;
		return this;
	}

	/**
	 * Get certificationAgency
	 * 
	 * @return certificationAgency
	 **/
	@ApiModelProperty(value = "")
	public String getCertificationAgency() {
		return certificationAgency;
	}

	public void setCertificationAgency(String certificationAgency) {
		this.certificationAgency = certificationAgency;
	}

	public CertificationInformation certificationOrganisationIdentifier(String certificationOrganisationIdentifier) {
		this.certificationOrganisationIdentifier = certificationOrganisationIdentifier;
		return this;
	}

	/**
	 * Get certificationOrganisationIdentifier
	 * 
	 * @return certificationOrganisationIdentifier
	 **/
	@ApiModelProperty(value = "")
	public String getCertificationOrganisationIdentifier() {
		return certificationOrganisationIdentifier;
	}

	public void setCertificationOrganisationIdentifier(String certificationOrganisationIdentifier) {
		this.certificationOrganisationIdentifier = certificationOrganisationIdentifier;
	}

	public CertificationInformation certificationStandard(String certificationStandard) {
		this.certificationStandard = certificationStandard;
		return this;
	}

	/**
	 * Get certificationStandard
	 * 
	 * @return certificationStandard
	 **/
	@ApiModelProperty(value = "")
	public String getCertificationStandard() {
		return certificationStandard;
	}

	public void setCertificationStandard(String certificationStandard) {
		this.certificationStandard = certificationStandard;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CertificationInformation certificationInformation = (CertificationInformation) o;
		return Objects.equals(this.additionalCertificationOrganisationIdentifier,
				certificationInformation.additionalCertificationOrganisationIdentifier)
				&& Objects.equals(this.additionalPartyIdentificationTypeCode,
						certificationInformation.additionalPartyIdentificationTypeCode)
				&& Objects.equals(this.additionalPartyIdentificationValue,
						certificationInformation.additionalPartyIdentificationValue)
				&& Objects.equals(this.certification, certificationInformation.certification)
				&& Objects.equals(this.certificationAgency, certificationInformation.certificationAgency)
				&& Objects.equals(this.certificationOrganisationIdentifier,
						certificationInformation.certificationOrganisationIdentifier)
				&& Objects.equals(this.certificationStandard, certificationInformation.certificationStandard);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalCertificationOrganisationIdentifier, additionalPartyIdentificationTypeCode,
				additionalPartyIdentificationValue, certification, certificationAgency,
				certificationOrganisationIdentifier, certificationStandard);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CertificationInformation {\n");

		sb.append("    additionalCertificationOrganisationIdentifier: ")
				.append(toIndentedString(additionalCertificationOrganisationIdentifier)).append("\n");
		sb.append("    additionalPartyIdentificationTypeCode: ")
				.append(toIndentedString(additionalPartyIdentificationTypeCode)).append("\n");
		sb.append("    additionalPartyIdentificationValue: ")
				.append(toIndentedString(additionalPartyIdentificationValue)).append("\n");
		sb.append("    certification: ").append(toIndentedString(certification)).append("\n");
		sb.append("    certificationAgency: ").append(toIndentedString(certificationAgency)).append("\n");
		sb.append("    certificationOrganisationIdentifier: ")
				.append(toIndentedString(certificationOrganisationIdentifier)).append("\n");
		sb.append("    certificationStandard: ").append(toIndentedString(certificationStandard)).append("\n");
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
