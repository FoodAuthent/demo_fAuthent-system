
package com.ftrace.epcis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://ns.ftrace.com/epcis}animalID" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}crossBreedIndicator" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}breedCode" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}dateOfBirth" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}placeOfBirth" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}father" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}mother" minOccurs="0"/>
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
@XmlRootElement(name = "animal")
public class Animal {

    protected String animalID;
    protected Boolean crossBreedIndicator;
    protected String breedCode;
    protected XMLGregorianCalendar dateOfBirth;
    protected PlaceOfBirth placeOfBirth;
    protected Father father;
    protected Mother mother;

    /**
     * Ruft den Wert der animalID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnimalID() {
        return animalID;
    }

    /**
     * Legt den Wert der animalID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnimalID(String value) {
        this.animalID = value;
    }

    /**
     * Ruft den Wert der crossBreedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossBreedIndicator() {
        return crossBreedIndicator;
    }

    /**
     * Legt den Wert der crossBreedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossBreedIndicator(Boolean value) {
        this.crossBreedIndicator = value;
    }

    /**
     * Ruft den Wert der breedCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * Legt den Wert der breedCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBreedCode(String value) {
        this.breedCode = value;
    }

    /**
     * Ruft den Wert der dateOfBirth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Legt den Wert der dateOfBirth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Ruft den Wert der placeOfBirth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PlaceOfBirth }
     *     
     */
    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Legt den Wert der placeOfBirth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceOfBirth }
     *     
     */
    public void setPlaceOfBirth(PlaceOfBirth value) {
        this.placeOfBirth = value;
    }

    /**
     * Ruft den Wert der father-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Father }
     *     
     */
    public Father getFather() {
        return father;
    }

    /**
     * Legt den Wert der father-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Father }
     *     
     */
    public void setFather(Father value) {
        this.father = value;
    }

    /**
     * Ruft den Wert der mother-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Mother }
     *     
     */
    public Mother getMother() {
        return mother;
    }

    /**
     * Legt den Wert der mother-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Mother }
     *     
     */
    public void setMother(Mother value) {
        this.mother = value;
    }

}
