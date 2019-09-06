
package com.ftrace.epcis;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}farmIdentificationNumber" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}address" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}proportionPercentOfLot" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}proportionRankingOfLot" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}countriesOfBirth" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}animalIdentifications" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}numberOfAnimals" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "agricultureDetails")
public class AgricultureDetails {

    protected FarmIdentificationNumber farmIdentificationNumber;
    protected Address address;
    protected Float proportionPercentOfLot;
    protected BigInteger proportionRankingOfLot;
    protected CountriesOfBirth countriesOfBirth;
    protected AnimalIdentifications animalIdentifications;
    protected BigInteger numberOfAnimals;

    /**
     * Ruft den Wert der farmIdentificationNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FarmIdentificationNumber }
     *     
     */
    public FarmIdentificationNumber getFarmIdentificationNumber() {
        return farmIdentificationNumber;
    }

    /**
     * Legt den Wert der farmIdentificationNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FarmIdentificationNumber }
     *     
     */
    public void setFarmIdentificationNumber(FarmIdentificationNumber value) {
        this.farmIdentificationNumber = value;
    }

    /**
     * Ruft den Wert der address-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Legt den Wert der address-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Ruft den Wert der proportionPercentOfLot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getProportionPercentOfLot() {
        return proportionPercentOfLot;
    }

    /**
     * Legt den Wert der proportionPercentOfLot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setProportionPercentOfLot(Float value) {
        this.proportionPercentOfLot = value;
    }

    /**
     * Ruft den Wert der proportionRankingOfLot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProportionRankingOfLot() {
        return proportionRankingOfLot;
    }

    /**
     * Legt den Wert der proportionRankingOfLot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProportionRankingOfLot(BigInteger value) {
        this.proportionRankingOfLot = value;
    }

    /**
     * Ruft den Wert der countriesOfBirth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountriesOfBirth }
     *     
     */
    public CountriesOfBirth getCountriesOfBirth() {
        return countriesOfBirth;
    }

    /**
     * Legt den Wert der countriesOfBirth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountriesOfBirth }
     *     
     */
    public void setCountriesOfBirth(CountriesOfBirth value) {
        this.countriesOfBirth = value;
    }

    /**
     * Ruft den Wert der animalIdentifications-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AnimalIdentifications }
     *     
     */
    public AnimalIdentifications getAnimalIdentifications() {
        return animalIdentifications;
    }

    /**
     * Legt den Wert der animalIdentifications-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AnimalIdentifications }
     *     
     */
    public void setAnimalIdentifications(AnimalIdentifications value) {
        this.animalIdentifications = value;
    }

    /**
     * Ruft den Wert der numberOfAnimals-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfAnimals() {
        return numberOfAnimals;
    }

    /**
     * Legt den Wert der numberOfAnimals-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfAnimals(BigInteger value) {
        this.numberOfAnimals = value;
    }

}
