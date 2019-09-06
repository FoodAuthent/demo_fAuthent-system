
package org.unece.cefact.namespaces.standardbusinessdocumentheader;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Scope complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Scope">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="InstanceIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}ScopeInformation"/>
 *           &lt;element ref="{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}CorrelationInformation"/>
 *           &lt;element ref="{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}BusinessService"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Scope", propOrder = {
    "type",
    "instanceIdentifier",
    "identifier",
    "scopeInformationOrCorrelationInformationOrBusinessService"
})
public class Scope {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "InstanceIdentifier", required = true)
    protected String instanceIdentifier;
    @XmlElement(name = "Identifier")
    protected String identifier;
    @XmlElements({
        @XmlElement(name = "ScopeInformation"),
        @XmlElement(name = "CorrelationInformation", type = CorrelationInformation.class),
        @XmlElement(name = "BusinessService", type = BusinessService.class)
    })
    protected List<Object> scopeInformationOrCorrelationInformationOrBusinessService;

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der instanceIdentifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceIdentifier() {
        return instanceIdentifier;
    }

    /**
     * Legt den Wert der instanceIdentifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceIdentifier(String value) {
        this.instanceIdentifier = value;
    }

    /**
     * Ruft den Wert der identifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Legt den Wert der identifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the scopeInformationOrCorrelationInformationOrBusinessService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scopeInformationOrCorrelationInformationOrBusinessService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScopeInformationOrCorrelationInformationOrBusinessService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link CorrelationInformation }
     * {@link BusinessService }
     * 
     * 
     */
    public List<Object> getScopeInformationOrCorrelationInformationOrBusinessService() {
        if (scopeInformationOrCorrelationInformationOrBusinessService == null) {
            scopeInformationOrCorrelationInformationOrBusinessService = new ArrayList<Object>();
        }
        return this.scopeInformationOrCorrelationInformationOrBusinessService;
    }

}
