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
import org.foodauthent.oneworldsync.client.model.ChemicalInformation;
import org.foodauthent.oneworldsync.client.model.CodifiedValue;
import org.foodauthent.oneworldsync.client.model.FireFightingInstructions;
import org.foodauthent.oneworldsync.client.model.GHSDetail;
import org.foodauthent.oneworldsync.client.model.HazardousWasteInformation;
import org.foodauthent.oneworldsync.client.model.LanguageLabels;
import org.foodauthent.oneworldsync.client.model.PhysicalChemicalPropertyInformation;
import org.foodauthent.oneworldsync.client.model.ProtectiveEquipment;
import org.foodauthent.oneworldsync.client.model.QualifiedValue;
import org.foodauthent.oneworldsync.client.model.REACHInformation;
import org.foodauthent.oneworldsync.client.model.ReferencedFileInformation;
import org.foodauthent.oneworldsync.client.model.StorageCompatibilityInformation;

/**
 * SafetyDataSheetInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class SafetyDataSheetInformation {
	@JsonProperty("accidentalReleaseMeasuresDescription")
	private LanguageLabels accidentalReleaseMeasuresDescription = null;

	@JsonProperty("additionalSDSInformation")
	private LanguageLabels additionalSDSInformation = null;

	@JsonProperty("chemicalInformation")
	private List<ChemicalInformation> chemicalInformation = null;

	@JsonProperty("conditionsToAvoid")
	private LanguageLabels conditionsToAvoid = null;

	@JsonProperty("ecologicalInformationDescription")
	private LanguageLabels ecologicalInformationDescription = null;

	@JsonProperty("fireFightingInstructions")
	private FireFightingInstructions fireFightingInstructions = null;

	@JsonProperty("firstAidProceduresDescription")
	private LanguageLabels firstAidProceduresDescription = null;

	@JsonProperty("gHSDetail")
	private GHSDetail gHSDetail = null;

	@JsonProperty("hazardousMaterialsHandlingProcedures")
	private LanguageLabels hazardousMaterialsHandlingProcedures = null;

	@JsonProperty("hazardousWasteInformation")
	private List<HazardousWasteInformation> hazardousWasteInformation = null;

	@JsonProperty("isProductClassifiedAsNonHazardous")
	private CodifiedValue isProductClassifiedAsNonHazardous = null;

	@JsonProperty("isRegulatedForTransportation")
	private CodifiedValue isRegulatedForTransportation = null;

	@JsonProperty("noteToPhysician")
	private LanguageLabels noteToPhysician = null;

	@JsonProperty("physicalChemicalPropertyInformation")
	private PhysicalChemicalPropertyInformation physicalChemicalPropertyInformation = null;

	@JsonProperty("protectiveEquipment")
	private List<ProtectiveEquipment> protectiveEquipment = null;

	@JsonProperty("rEACHInformation")
	private REACHInformation rEACHInformation = null;

	@JsonProperty("referencedFileInformation")
	private List<ReferencedFileInformation> referencedFileInformation = null;

	@JsonProperty("sDSSheetNumber")
	private String sDSSheetNumber = null;

	@JsonProperty("sDSStandardCode")
	private CodifiedValue sDSStandardCode = null;

	@JsonProperty("sDSStandardVersion")
	private String sDSStandardVersion = null;

	@JsonProperty("storageCompatibilityInformation")
	private StorageCompatibilityInformation storageCompatibilityInformation = null;

	@JsonProperty("storageRequirementsDescription")
	private LanguageLabels storageRequirementsDescription = null;

	@JsonProperty("toxicologicalInformationDescription")
	private LanguageLabels toxicologicalInformationDescription = null;

	@JsonProperty("volatileOrganicCompound")
	private QualifiedValue volatileOrganicCompound = null;

	@JsonProperty("volatileOrganicCompoundBasis")
	private QualifiedValue volatileOrganicCompoundBasis = null;

	@JsonProperty("volatileOrganicCompoundPercent")
	private String volatileOrganicCompoundPercent = null;

	@JsonProperty("volatileOrganicCompoundPercentMeasurementPrecision")
	private CodifiedValue volatileOrganicCompoundPercentMeasurementPrecision = null;

	public SafetyDataSheetInformation accidentalReleaseMeasuresDescription(
			LanguageLabels accidentalReleaseMeasuresDescription) {
		this.accidentalReleaseMeasuresDescription = accidentalReleaseMeasuresDescription;
		return this;
	}

	/**
	 * Get accidentalReleaseMeasuresDescription
	 * 
	 * @return accidentalReleaseMeasuresDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getAccidentalReleaseMeasuresDescription() {
		return accidentalReleaseMeasuresDescription;
	}

	public void setAccidentalReleaseMeasuresDescription(LanguageLabels accidentalReleaseMeasuresDescription) {
		this.accidentalReleaseMeasuresDescription = accidentalReleaseMeasuresDescription;
	}

	public SafetyDataSheetInformation additionalSDSInformation(LanguageLabels additionalSDSInformation) {
		this.additionalSDSInformation = additionalSDSInformation;
		return this;
	}

	/**
	 * Get additionalSDSInformation
	 * 
	 * @return additionalSDSInformation
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getAdditionalSDSInformation() {
		return additionalSDSInformation;
	}

	public void setAdditionalSDSInformation(LanguageLabels additionalSDSInformation) {
		this.additionalSDSInformation = additionalSDSInformation;
	}

	public SafetyDataSheetInformation chemicalInformation(List<ChemicalInformation> chemicalInformation) {
		this.chemicalInformation = chemicalInformation;
		return this;
	}

	public SafetyDataSheetInformation addChemicalInformationItem(ChemicalInformation chemicalInformationItem) {
		if (this.chemicalInformation == null) {
			this.chemicalInformation = new ArrayList<ChemicalInformation>();
		}
		this.chemicalInformation.add(chemicalInformationItem);
		return this;
	}

	/**
	 * Get chemicalInformation
	 * 
	 * @return chemicalInformation
	 **/
	@ApiModelProperty(value = "")
	public List<ChemicalInformation> getChemicalInformation() {
		return chemicalInformation;
	}

	public void setChemicalInformation(List<ChemicalInformation> chemicalInformation) {
		this.chemicalInformation = chemicalInformation;
	}

	public SafetyDataSheetInformation conditionsToAvoid(LanguageLabels conditionsToAvoid) {
		this.conditionsToAvoid = conditionsToAvoid;
		return this;
	}

	/**
	 * Get conditionsToAvoid
	 * 
	 * @return conditionsToAvoid
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getConditionsToAvoid() {
		return conditionsToAvoid;
	}

	public void setConditionsToAvoid(LanguageLabels conditionsToAvoid) {
		this.conditionsToAvoid = conditionsToAvoid;
	}

	public SafetyDataSheetInformation ecologicalInformationDescription(
			LanguageLabels ecologicalInformationDescription) {
		this.ecologicalInformationDescription = ecologicalInformationDescription;
		return this;
	}

	/**
	 * Get ecologicalInformationDescription
	 * 
	 * @return ecologicalInformationDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getEcologicalInformationDescription() {
		return ecologicalInformationDescription;
	}

	public void setEcologicalInformationDescription(LanguageLabels ecologicalInformationDescription) {
		this.ecologicalInformationDescription = ecologicalInformationDescription;
	}

	public SafetyDataSheetInformation fireFightingInstructions(FireFightingInstructions fireFightingInstructions) {
		this.fireFightingInstructions = fireFightingInstructions;
		return this;
	}

	/**
	 * Get fireFightingInstructions
	 * 
	 * @return fireFightingInstructions
	 **/
	@ApiModelProperty(value = "")
	public FireFightingInstructions getFireFightingInstructions() {
		return fireFightingInstructions;
	}

	public void setFireFightingInstructions(FireFightingInstructions fireFightingInstructions) {
		this.fireFightingInstructions = fireFightingInstructions;
	}

	public SafetyDataSheetInformation firstAidProceduresDescription(LanguageLabels firstAidProceduresDescription) {
		this.firstAidProceduresDescription = firstAidProceduresDescription;
		return this;
	}

	/**
	 * Get firstAidProceduresDescription
	 * 
	 * @return firstAidProceduresDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getFirstAidProceduresDescription() {
		return firstAidProceduresDescription;
	}

	public void setFirstAidProceduresDescription(LanguageLabels firstAidProceduresDescription) {
		this.firstAidProceduresDescription = firstAidProceduresDescription;
	}

	public SafetyDataSheetInformation gHSDetail(GHSDetail gHSDetail) {
		this.gHSDetail = gHSDetail;
		return this;
	}

	/**
	 * Get gHSDetail
	 * 
	 * @return gHSDetail
	 **/
	@ApiModelProperty(value = "")
	public GHSDetail getGHSDetail() {
		return gHSDetail;
	}

	public void setGHSDetail(GHSDetail gHSDetail) {
		this.gHSDetail = gHSDetail;
	}

	public SafetyDataSheetInformation hazardousMaterialsHandlingProcedures(
			LanguageLabels hazardousMaterialsHandlingProcedures) {
		this.hazardousMaterialsHandlingProcedures = hazardousMaterialsHandlingProcedures;
		return this;
	}

	/**
	 * Get hazardousMaterialsHandlingProcedures
	 * 
	 * @return hazardousMaterialsHandlingProcedures
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getHazardousMaterialsHandlingProcedures() {
		return hazardousMaterialsHandlingProcedures;
	}

	public void setHazardousMaterialsHandlingProcedures(LanguageLabels hazardousMaterialsHandlingProcedures) {
		this.hazardousMaterialsHandlingProcedures = hazardousMaterialsHandlingProcedures;
	}

	public SafetyDataSheetInformation hazardousWasteInformation(
			List<HazardousWasteInformation> hazardousWasteInformation) {
		this.hazardousWasteInformation = hazardousWasteInformation;
		return this;
	}

	public SafetyDataSheetInformation addHazardousWasteInformationItem(
			HazardousWasteInformation hazardousWasteInformationItem) {
		if (this.hazardousWasteInformation == null) {
			this.hazardousWasteInformation = new ArrayList<HazardousWasteInformation>();
		}
		this.hazardousWasteInformation.add(hazardousWasteInformationItem);
		return this;
	}

	/**
	 * Get hazardousWasteInformation
	 * 
	 * @return hazardousWasteInformation
	 **/
	@ApiModelProperty(value = "")
	public List<HazardousWasteInformation> getHazardousWasteInformation() {
		return hazardousWasteInformation;
	}

	public void setHazardousWasteInformation(List<HazardousWasteInformation> hazardousWasteInformation) {
		this.hazardousWasteInformation = hazardousWasteInformation;
	}

	public SafetyDataSheetInformation isProductClassifiedAsNonHazardous(
			CodifiedValue isProductClassifiedAsNonHazardous) {
		this.isProductClassifiedAsNonHazardous = isProductClassifiedAsNonHazardous;
		return this;
	}

	/**
	 * Get isProductClassifiedAsNonHazardous
	 * 
	 * @return isProductClassifiedAsNonHazardous
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsProductClassifiedAsNonHazardous() {
		return isProductClassifiedAsNonHazardous;
	}

	public void setIsProductClassifiedAsNonHazardous(CodifiedValue isProductClassifiedAsNonHazardous) {
		this.isProductClassifiedAsNonHazardous = isProductClassifiedAsNonHazardous;
	}

	public SafetyDataSheetInformation isRegulatedForTransportation(CodifiedValue isRegulatedForTransportation) {
		this.isRegulatedForTransportation = isRegulatedForTransportation;
		return this;
	}

	/**
	 * Get isRegulatedForTransportation
	 * 
	 * @return isRegulatedForTransportation
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getIsRegulatedForTransportation() {
		return isRegulatedForTransportation;
	}

	public void setIsRegulatedForTransportation(CodifiedValue isRegulatedForTransportation) {
		this.isRegulatedForTransportation = isRegulatedForTransportation;
	}

	public SafetyDataSheetInformation noteToPhysician(LanguageLabels noteToPhysician) {
		this.noteToPhysician = noteToPhysician;
		return this;
	}

	/**
	 * Get noteToPhysician
	 * 
	 * @return noteToPhysician
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getNoteToPhysician() {
		return noteToPhysician;
	}

	public void setNoteToPhysician(LanguageLabels noteToPhysician) {
		this.noteToPhysician = noteToPhysician;
	}

	public SafetyDataSheetInformation physicalChemicalPropertyInformation(
			PhysicalChemicalPropertyInformation physicalChemicalPropertyInformation) {
		this.physicalChemicalPropertyInformation = physicalChemicalPropertyInformation;
		return this;
	}

	/**
	 * Get physicalChemicalPropertyInformation
	 * 
	 * @return physicalChemicalPropertyInformation
	 **/
	@ApiModelProperty(value = "")
	public PhysicalChemicalPropertyInformation getPhysicalChemicalPropertyInformation() {
		return physicalChemicalPropertyInformation;
	}

	public void setPhysicalChemicalPropertyInformation(
			PhysicalChemicalPropertyInformation physicalChemicalPropertyInformation) {
		this.physicalChemicalPropertyInformation = physicalChemicalPropertyInformation;
	}

	public SafetyDataSheetInformation protectiveEquipment(List<ProtectiveEquipment> protectiveEquipment) {
		this.protectiveEquipment = protectiveEquipment;
		return this;
	}

	public SafetyDataSheetInformation addProtectiveEquipmentItem(ProtectiveEquipment protectiveEquipmentItem) {
		if (this.protectiveEquipment == null) {
			this.protectiveEquipment = new ArrayList<ProtectiveEquipment>();
		}
		this.protectiveEquipment.add(protectiveEquipmentItem);
		return this;
	}

	/**
	 * Get protectiveEquipment
	 * 
	 * @return protectiveEquipment
	 **/
	@ApiModelProperty(value = "")
	public List<ProtectiveEquipment> getProtectiveEquipment() {
		return protectiveEquipment;
	}

	public void setProtectiveEquipment(List<ProtectiveEquipment> protectiveEquipment) {
		this.protectiveEquipment = protectiveEquipment;
	}

	public SafetyDataSheetInformation rEACHInformation(REACHInformation rEACHInformation) {
		this.rEACHInformation = rEACHInformation;
		return this;
	}

	/**
	 * Get rEACHInformation
	 * 
	 * @return rEACHInformation
	 **/
	@ApiModelProperty(value = "")
	public REACHInformation getREACHInformation() {
		return rEACHInformation;
	}

	public void setREACHInformation(REACHInformation rEACHInformation) {
		this.rEACHInformation = rEACHInformation;
	}

	public SafetyDataSheetInformation referencedFileInformation(
			List<ReferencedFileInformation> referencedFileInformation) {
		this.referencedFileInformation = referencedFileInformation;
		return this;
	}

	public SafetyDataSheetInformation addReferencedFileInformationItem(
			ReferencedFileInformation referencedFileInformationItem) {
		if (this.referencedFileInformation == null) {
			this.referencedFileInformation = new ArrayList<ReferencedFileInformation>();
		}
		this.referencedFileInformation.add(referencedFileInformationItem);
		return this;
	}

	/**
	 * Get referencedFileInformation
	 * 
	 * @return referencedFileInformation
	 **/
	@ApiModelProperty(value = "")
	public List<ReferencedFileInformation> getReferencedFileInformation() {
		return referencedFileInformation;
	}

	public void setReferencedFileInformation(List<ReferencedFileInformation> referencedFileInformation) {
		this.referencedFileInformation = referencedFileInformation;
	}

	public SafetyDataSheetInformation sDSSheetNumber(String sDSSheetNumber) {
		this.sDSSheetNumber = sDSSheetNumber;
		return this;
	}

	/**
	 * Get sDSSheetNumber
	 * 
	 * @return sDSSheetNumber
	 **/
	@ApiModelProperty(value = "")
	public String getSDSSheetNumber() {
		return sDSSheetNumber;
	}

	public void setSDSSheetNumber(String sDSSheetNumber) {
		this.sDSSheetNumber = sDSSheetNumber;
	}

	public SafetyDataSheetInformation sDSStandardCode(CodifiedValue sDSStandardCode) {
		this.sDSStandardCode = sDSStandardCode;
		return this;
	}

	/**
	 * Get sDSStandardCode
	 * 
	 * @return sDSStandardCode
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getSDSStandardCode() {
		return sDSStandardCode;
	}

	public void setSDSStandardCode(CodifiedValue sDSStandardCode) {
		this.sDSStandardCode = sDSStandardCode;
	}

	public SafetyDataSheetInformation sDSStandardVersion(String sDSStandardVersion) {
		this.sDSStandardVersion = sDSStandardVersion;
		return this;
	}

	/**
	 * Get sDSStandardVersion
	 * 
	 * @return sDSStandardVersion
	 **/
	@ApiModelProperty(value = "")
	public String getSDSStandardVersion() {
		return sDSStandardVersion;
	}

	public void setSDSStandardVersion(String sDSStandardVersion) {
		this.sDSStandardVersion = sDSStandardVersion;
	}

	public SafetyDataSheetInformation storageCompatibilityInformation(
			StorageCompatibilityInformation storageCompatibilityInformation) {
		this.storageCompatibilityInformation = storageCompatibilityInformation;
		return this;
	}

	/**
	 * Get storageCompatibilityInformation
	 * 
	 * @return storageCompatibilityInformation
	 **/
	@ApiModelProperty(value = "")
	public StorageCompatibilityInformation getStorageCompatibilityInformation() {
		return storageCompatibilityInformation;
	}

	public void setStorageCompatibilityInformation(StorageCompatibilityInformation storageCompatibilityInformation) {
		this.storageCompatibilityInformation = storageCompatibilityInformation;
	}

	public SafetyDataSheetInformation storageRequirementsDescription(LanguageLabels storageRequirementsDescription) {
		this.storageRequirementsDescription = storageRequirementsDescription;
		return this;
	}

	/**
	 * Get storageRequirementsDescription
	 * 
	 * @return storageRequirementsDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getStorageRequirementsDescription() {
		return storageRequirementsDescription;
	}

	public void setStorageRequirementsDescription(LanguageLabels storageRequirementsDescription) {
		this.storageRequirementsDescription = storageRequirementsDescription;
	}

	public SafetyDataSheetInformation toxicologicalInformationDescription(
			LanguageLabels toxicologicalInformationDescription) {
		this.toxicologicalInformationDescription = toxicologicalInformationDescription;
		return this;
	}

	/**
	 * Get toxicologicalInformationDescription
	 * 
	 * @return toxicologicalInformationDescription
	 **/
	@ApiModelProperty(value = "")
	public LanguageLabels getToxicologicalInformationDescription() {
		return toxicologicalInformationDescription;
	}

	public void setToxicologicalInformationDescription(LanguageLabels toxicologicalInformationDescription) {
		this.toxicologicalInformationDescription = toxicologicalInformationDescription;
	}

	public SafetyDataSheetInformation volatileOrganicCompound(QualifiedValue volatileOrganicCompound) {
		this.volatileOrganicCompound = volatileOrganicCompound;
		return this;
	}

	/**
	 * Get volatileOrganicCompound
	 * 
	 * @return volatileOrganicCompound
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValue getVolatileOrganicCompound() {
		return volatileOrganicCompound;
	}

	public void setVolatileOrganicCompound(QualifiedValue volatileOrganicCompound) {
		this.volatileOrganicCompound = volatileOrganicCompound;
	}

	public SafetyDataSheetInformation volatileOrganicCompoundBasis(QualifiedValue volatileOrganicCompoundBasis) {
		this.volatileOrganicCompoundBasis = volatileOrganicCompoundBasis;
		return this;
	}

	/**
	 * Get volatileOrganicCompoundBasis
	 * 
	 * @return volatileOrganicCompoundBasis
	 **/
	@ApiModelProperty(value = "")
	public QualifiedValue getVolatileOrganicCompoundBasis() {
		return volatileOrganicCompoundBasis;
	}

	public void setVolatileOrganicCompoundBasis(QualifiedValue volatileOrganicCompoundBasis) {
		this.volatileOrganicCompoundBasis = volatileOrganicCompoundBasis;
	}

	public SafetyDataSheetInformation volatileOrganicCompoundPercent(String volatileOrganicCompoundPercent) {
		this.volatileOrganicCompoundPercent = volatileOrganicCompoundPercent;
		return this;
	}

	/**
	 * Get volatileOrganicCompoundPercent
	 * 
	 * @return volatileOrganicCompoundPercent
	 **/
	@ApiModelProperty(value = "")
	public String getVolatileOrganicCompoundPercent() {
		return volatileOrganicCompoundPercent;
	}

	public void setVolatileOrganicCompoundPercent(String volatileOrganicCompoundPercent) {
		this.volatileOrganicCompoundPercent = volatileOrganicCompoundPercent;
	}

	public SafetyDataSheetInformation volatileOrganicCompoundPercentMeasurementPrecision(
			CodifiedValue volatileOrganicCompoundPercentMeasurementPrecision) {
		this.volatileOrganicCompoundPercentMeasurementPrecision = volatileOrganicCompoundPercentMeasurementPrecision;
		return this;
	}

	/**
	 * Get volatileOrganicCompoundPercentMeasurementPrecision
	 * 
	 * @return volatileOrganicCompoundPercentMeasurementPrecision
	 **/
	@ApiModelProperty(value = "")
	public CodifiedValue getVolatileOrganicCompoundPercentMeasurementPrecision() {
		return volatileOrganicCompoundPercentMeasurementPrecision;
	}

	public void setVolatileOrganicCompoundPercentMeasurementPrecision(
			CodifiedValue volatileOrganicCompoundPercentMeasurementPrecision) {
		this.volatileOrganicCompoundPercentMeasurementPrecision = volatileOrganicCompoundPercentMeasurementPrecision;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SafetyDataSheetInformation safetyDataSheetInformation = (SafetyDataSheetInformation) o;
		return Objects.equals(this.accidentalReleaseMeasuresDescription,
				safetyDataSheetInformation.accidentalReleaseMeasuresDescription)
				&& Objects.equals(this.additionalSDSInformation, safetyDataSheetInformation.additionalSDSInformation)
				&& Objects.equals(this.chemicalInformation, safetyDataSheetInformation.chemicalInformation)
				&& Objects.equals(this.conditionsToAvoid, safetyDataSheetInformation.conditionsToAvoid)
				&& Objects.equals(this.ecologicalInformationDescription,
						safetyDataSheetInformation.ecologicalInformationDescription)
				&& Objects.equals(this.fireFightingInstructions, safetyDataSheetInformation.fireFightingInstructions)
				&& Objects.equals(this.firstAidProceduresDescription,
						safetyDataSheetInformation.firstAidProceduresDescription)
				&& Objects.equals(this.gHSDetail, safetyDataSheetInformation.gHSDetail)
				&& Objects.equals(this.hazardousMaterialsHandlingProcedures,
						safetyDataSheetInformation.hazardousMaterialsHandlingProcedures)
				&& Objects.equals(this.hazardousWasteInformation, safetyDataSheetInformation.hazardousWasteInformation)
				&& Objects.equals(this.isProductClassifiedAsNonHazardous,
						safetyDataSheetInformation.isProductClassifiedAsNonHazardous)
				&& Objects.equals(this.isRegulatedForTransportation,
						safetyDataSheetInformation.isRegulatedForTransportation)
				&& Objects.equals(this.noteToPhysician, safetyDataSheetInformation.noteToPhysician)
				&& Objects.equals(this.physicalChemicalPropertyInformation,
						safetyDataSheetInformation.physicalChemicalPropertyInformation)
				&& Objects.equals(this.protectiveEquipment, safetyDataSheetInformation.protectiveEquipment)
				&& Objects.equals(this.rEACHInformation, safetyDataSheetInformation.rEACHInformation)
				&& Objects.equals(this.referencedFileInformation, safetyDataSheetInformation.referencedFileInformation)
				&& Objects.equals(this.sDSSheetNumber, safetyDataSheetInformation.sDSSheetNumber)
				&& Objects.equals(this.sDSStandardCode, safetyDataSheetInformation.sDSStandardCode)
				&& Objects.equals(this.sDSStandardVersion, safetyDataSheetInformation.sDSStandardVersion)
				&& Objects.equals(this.storageCompatibilityInformation,
						safetyDataSheetInformation.storageCompatibilityInformation)
				&& Objects.equals(this.storageRequirementsDescription,
						safetyDataSheetInformation.storageRequirementsDescription)
				&& Objects.equals(this.toxicologicalInformationDescription,
						safetyDataSheetInformation.toxicologicalInformationDescription)
				&& Objects.equals(this.volatileOrganicCompound, safetyDataSheetInformation.volatileOrganicCompound)
				&& Objects.equals(this.volatileOrganicCompoundBasis,
						safetyDataSheetInformation.volatileOrganicCompoundBasis)
				&& Objects.equals(this.volatileOrganicCompoundPercent,
						safetyDataSheetInformation.volatileOrganicCompoundPercent)
				&& Objects.equals(this.volatileOrganicCompoundPercentMeasurementPrecision,
						safetyDataSheetInformation.volatileOrganicCompoundPercentMeasurementPrecision);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accidentalReleaseMeasuresDescription, additionalSDSInformation, chemicalInformation,
				conditionsToAvoid, ecologicalInformationDescription, fireFightingInstructions,
				firstAidProceduresDescription, gHSDetail, hazardousMaterialsHandlingProcedures,
				hazardousWasteInformation, isProductClassifiedAsNonHazardous, isRegulatedForTransportation,
				noteToPhysician, physicalChemicalPropertyInformation, protectiveEquipment, rEACHInformation,
				referencedFileInformation, sDSSheetNumber, sDSStandardCode, sDSStandardVersion,
				storageCompatibilityInformation, storageRequirementsDescription, toxicologicalInformationDescription,
				volatileOrganicCompound, volatileOrganicCompoundBasis, volatileOrganicCompoundPercent,
				volatileOrganicCompoundPercentMeasurementPrecision);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SafetyDataSheetInformation {\n");

		sb.append("    accidentalReleaseMeasuresDescription: ")
				.append(toIndentedString(accidentalReleaseMeasuresDescription)).append("\n");
		sb.append("    additionalSDSInformation: ").append(toIndentedString(additionalSDSInformation)).append("\n");
		sb.append("    chemicalInformation: ").append(toIndentedString(chemicalInformation)).append("\n");
		sb.append("    conditionsToAvoid: ").append(toIndentedString(conditionsToAvoid)).append("\n");
		sb.append("    ecologicalInformationDescription: ").append(toIndentedString(ecologicalInformationDescription))
				.append("\n");
		sb.append("    fireFightingInstructions: ").append(toIndentedString(fireFightingInstructions)).append("\n");
		sb.append("    firstAidProceduresDescription: ").append(toIndentedString(firstAidProceduresDescription))
				.append("\n");
		sb.append("    gHSDetail: ").append(toIndentedString(gHSDetail)).append("\n");
		sb.append("    hazardousMaterialsHandlingProcedures: ")
				.append(toIndentedString(hazardousMaterialsHandlingProcedures)).append("\n");
		sb.append("    hazardousWasteInformation: ").append(toIndentedString(hazardousWasteInformation)).append("\n");
		sb.append("    isProductClassifiedAsNonHazardous: ").append(toIndentedString(isProductClassifiedAsNonHazardous))
				.append("\n");
		sb.append("    isRegulatedForTransportation: ").append(toIndentedString(isRegulatedForTransportation))
				.append("\n");
		sb.append("    noteToPhysician: ").append(toIndentedString(noteToPhysician)).append("\n");
		sb.append("    physicalChemicalPropertyInformation: ")
				.append(toIndentedString(physicalChemicalPropertyInformation)).append("\n");
		sb.append("    protectiveEquipment: ").append(toIndentedString(protectiveEquipment)).append("\n");
		sb.append("    rEACHInformation: ").append(toIndentedString(rEACHInformation)).append("\n");
		sb.append("    referencedFileInformation: ").append(toIndentedString(referencedFileInformation)).append("\n");
		sb.append("    sDSSheetNumber: ").append(toIndentedString(sDSSheetNumber)).append("\n");
		sb.append("    sDSStandardCode: ").append(toIndentedString(sDSStandardCode)).append("\n");
		sb.append("    sDSStandardVersion: ").append(toIndentedString(sDSStandardVersion)).append("\n");
		sb.append("    storageCompatibilityInformation: ").append(toIndentedString(storageCompatibilityInformation))
				.append("\n");
		sb.append("    storageRequirementsDescription: ").append(toIndentedString(storageRequirementsDescription))
				.append("\n");
		sb.append("    toxicologicalInformationDescription: ")
				.append(toIndentedString(toxicologicalInformationDescription)).append("\n");
		sb.append("    volatileOrganicCompound: ").append(toIndentedString(volatileOrganicCompound)).append("\n");
		sb.append("    volatileOrganicCompoundBasis: ").append(toIndentedString(volatileOrganicCompoundBasis))
				.append("\n");
		sb.append("    volatileOrganicCompoundPercent: ").append(toIndentedString(volatileOrganicCompoundPercent))
				.append("\n");
		sb.append("    volatileOrganicCompoundPercentMeasurementPrecision: ")
				.append(toIndentedString(volatileOrganicCompoundPercentMeasurementPrecision)).append("\n");
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