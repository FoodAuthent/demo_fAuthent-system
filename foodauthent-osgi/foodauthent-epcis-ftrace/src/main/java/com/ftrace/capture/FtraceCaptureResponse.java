
package com.ftrace.capture;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FtraceCaptureResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FtraceCaptureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validEvents" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invalidEvents" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="messages" type="{http://ns.ftrace.com/fTraceCapture}messages"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FtraceCaptureResponse", propOrder = {
    "transactionId",
    "validEvents",
    "invalidEvents",
    "messages"
})
public class FtraceCaptureResponse {

    @XmlElement(required = true)
    protected String transactionId;
    protected int validEvents;
    protected int invalidEvents;
    @XmlElement(required = true)
    protected Messages messages;

    /**
     * Ruft den Wert der transactionId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Legt den Wert der transactionId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Ruft den Wert der validEvents-Eigenschaft ab.
     * 
     */
    public int getValidEvents() {
        return validEvents;
    }

    /**
     * Legt den Wert der validEvents-Eigenschaft fest.
     * 
     */
    public void setValidEvents(int value) {
        this.validEvents = value;
    }

    /**
     * Ruft den Wert der invalidEvents-Eigenschaft ab.
     * 
     */
    public int getInvalidEvents() {
        return invalidEvents;
    }

    /**
     * Legt den Wert der invalidEvents-Eigenschaft fest.
     * 
     */
    public void setInvalidEvents(int value) {
        this.invalidEvents = value;
    }

    /**
     * Ruft den Wert der messages-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Messages }
     *     
     */
    public Messages getMessages() {
        return messages;
    }

    /**
     * Legt den Wert der messages-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Messages }
     *     
     */
    public void setMessages(Messages value) {
        this.messages = value;
    }

}
