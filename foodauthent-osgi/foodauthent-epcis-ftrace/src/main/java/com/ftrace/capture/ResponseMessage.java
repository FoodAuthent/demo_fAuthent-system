
package com.ftrace.capture;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für responseMessage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="responseMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorneousDetails" type="{http://ns.ftrace.com/fTraceCapture}errorneousDetails" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sucessDetails" type="{http://ns.ftrace.com/fTraceCapture}sucessDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lineNo" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseMessage", propOrder = {
    "errorneousDetails",
    "sucessDetails"
})
public class ResponseMessage {

    protected List<ErrorneousDetails> errorneousDetails;
    protected SucessDetails sucessDetails;
    @XmlAttribute(name = "lineNo", required = true)
    protected int lineNo;

    /**
     * Gets the value of the errorneousDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorneousDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorneousDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorneousDetails }
     * 
     * 
     */
    public List<ErrorneousDetails> getErrorneousDetails() {
        if (errorneousDetails == null) {
            errorneousDetails = new ArrayList<ErrorneousDetails>();
        }
        return this.errorneousDetails;
    }

    /**
     * Ruft den Wert der sucessDetails-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SucessDetails }
     *     
     */
    public SucessDetails getSucessDetails() {
        return sucessDetails;
    }

    /**
     * Legt den Wert der sucessDetails-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SucessDetails }
     *     
     */
    public void setSucessDetails(SucessDetails value) {
        this.sucessDetails = value;
    }

    /**
     * Ruft den Wert der lineNo-Eigenschaft ab.
     * 
     */
    public int getLineNo() {
        return lineNo;
    }

    /**
     * Legt den Wert der lineNo-Eigenschaft fest.
     * 
     */
    public void setLineNo(int value) {
        this.lineNo = value;
    }

}
