
package com.ftrace.capture;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für errorneousDetails complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="errorneousDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="responseMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="erroneousField" type="{http://ns.ftrace.com/fTraceCapture}erroneousField" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorneousDetails", propOrder = {
    "responseCode",
    "responseMessage",
    "erroneousField"
})
public class ErrorneousDetails {

    protected int responseCode;
    @XmlElement(required = true)
    protected String responseMessage;
    protected ErroneousField erroneousField;

    /**
     * Ruft den Wert der responseCode-Eigenschaft ab.
     * 
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Legt den Wert der responseCode-Eigenschaft fest.
     * 
     */
    public void setResponseCode(int value) {
        this.responseCode = value;
    }

    /**
     * Ruft den Wert der responseMessage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Legt den Wert der responseMessage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMessage(String value) {
        this.responseMessage = value;
    }

    /**
     * Ruft den Wert der erroneousField-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ErroneousField }
     *     
     */
    public ErroneousField getErroneousField() {
        return erroneousField;
    }

    /**
     * Legt den Wert der erroneousField-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ErroneousField }
     *     
     */
    public void setErroneousField(ErroneousField value) {
        this.erroneousField = value;
    }

}
