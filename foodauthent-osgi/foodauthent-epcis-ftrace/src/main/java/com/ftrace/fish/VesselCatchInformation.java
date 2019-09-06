
package com.ftrace.fish;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://ns.fish.ftrace.com}vesselID" minOccurs="0"/>
 *         &lt;element ref="{http://ns.fish.ftrace.com}vesselName" minOccurs="0"/>
 *         &lt;element ref="{http://ns.fish.ftrace.com}vesselOwner" minOccurs="0"/>
 *         &lt;element ref="{http://ns.fish.ftrace.com}vesselFlagState" minOccurs="0"/>
 *         &lt;element ref="{http://ns.fish.ftrace.com}haul" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}catchMethod" minOccurs="0"/>
 *         &lt;element ref="{http://ns.ftrace.com/epcis}catchArea" minOccurs="0"/>
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
@XmlRootElement(name = "vesselCatchInformation")
public class VesselCatchInformation {

    protected String vesselID;
    protected String vesselName;
    protected String vesselOwner;
    protected String vesselFlagState;
    protected String haul;
    @XmlElement(namespace = "http://ns.ftrace.com/epcis")
    protected String catchMethod;
    @XmlElement(namespace = "http://ns.ftrace.com/epcis")
    protected String catchArea;

    /**
     * Ruft den Wert der vesselID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVesselID() {
        return vesselID;
    }

    /**
     * Legt den Wert der vesselID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVesselID(String value) {
        this.vesselID = value;
    }

    /**
     * Ruft den Wert der vesselName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVesselName() {
        return vesselName;
    }

    /**
     * Legt den Wert der vesselName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVesselName(String value) {
        this.vesselName = value;
    }

    /**
     * Ruft den Wert der vesselOwner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVesselOwner() {
        return vesselOwner;
    }

    /**
     * Legt den Wert der vesselOwner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVesselOwner(String value) {
        this.vesselOwner = value;
    }

    /**
     * Ruft den Wert der vesselFlagState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVesselFlagState() {
        return vesselFlagState;
    }

    /**
     * Legt den Wert der vesselFlagState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVesselFlagState(String value) {
        this.vesselFlagState = value;
    }

    /**
     * Ruft den Wert der haul-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHaul() {
        return haul;
    }

    /**
     * Legt den Wert der haul-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHaul(String value) {
        this.haul = value;
    }

    /**
     * Ruft den Wert der catchMethod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatchMethod() {
        return catchMethod;
    }

    /**
     * Legt den Wert der catchMethod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatchMethod(String value) {
        this.catchMethod = value;
    }

    /**
     * Ruft den Wert der catchArea-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatchArea() {
        return catchArea;
    }

    /**
     * Legt den Wert der catchArea-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatchArea(String value) {
        this.catchArea = value;
    }

}
