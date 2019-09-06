
package com.ftrace.epcis;

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
 *       &lt;sequence>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}animalID" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}breedOfFatherCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "animalID",
    "breedOfFatherCode"
})
@XmlRootElement(name = "father")
public class Father {

    protected String animalID;
    protected String breedOfFatherCode;

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
     * Ruft den Wert der breedOfFatherCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBreedOfFatherCode() {
        return breedOfFatherCode;
    }

    /**
     * Legt den Wert der breedOfFatherCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBreedOfFatherCode(String value) {
        this.breedOfFatherCode = value;
    }

}
