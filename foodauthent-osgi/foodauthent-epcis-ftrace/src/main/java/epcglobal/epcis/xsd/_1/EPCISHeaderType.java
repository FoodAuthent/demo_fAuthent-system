
package epcglobal.epcis.xsd._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für EPCISHeaderType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EPCISHeaderType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:epcglobal:epcis:xsd:1}abstractExtensionType">
 *       &lt;sequence>
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}EPCISHeaderExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='skip' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPCISHeaderType", propOrder = {
    "extension"
})
public class EPCISHeaderType
    extends AbstractExtensionType
{

    protected EPCISHeaderExtensionType extension;

    /**
     * Ruft den Wert der extension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EPCISHeaderExtensionType }
     *     
     */
    public EPCISHeaderExtensionType getExtension() {
        return extension;
    }

    /**
     * Legt den Wert der extension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISHeaderExtensionType }
     *     
     */
    public void setExtension(EPCISHeaderExtensionType value) {
        this.extension = value;
    }

}
