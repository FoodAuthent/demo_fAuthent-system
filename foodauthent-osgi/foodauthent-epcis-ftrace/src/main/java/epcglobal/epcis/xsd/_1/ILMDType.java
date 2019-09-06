
package epcglobal.epcis.xsd._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ILMDType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ILMDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;any namespace='http://ns.ftrace.com/epcis' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any namespace='http://ns.fish.ftrace.com' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any namespace='http://ns.fruit.ftrace.com' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ILMDType", propOrder = {
    "anyOrAnyOrAny"
})
public class ILMDType {

    @XmlAnyElement(lax = true)
    protected List<Object> anyOrAnyOrAny;

    /**
     * Gets the value of the anyOrAnyOrAny property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anyOrAnyOrAny property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnyOrAnyOrAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAnyOrAnyOrAny() {
        if (anyOrAnyOrAny == null) {
            anyOrAnyOrAny = new ArrayList<Object>();
        }
        return this.anyOrAnyOrAny;
    }

}
