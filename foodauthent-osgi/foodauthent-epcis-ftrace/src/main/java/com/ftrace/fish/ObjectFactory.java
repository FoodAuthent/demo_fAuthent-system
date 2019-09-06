
package com.ftrace.fish;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftrace.fish.ns package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Haul_QNAME = new QName("http://ns.fish.ftrace.com", "haul");
    private final static QName _VesselOwner_QNAME = new QName("http://ns.fish.ftrace.com", "vesselOwner");
    private final static QName _UnloadingPort_QNAME = new QName("http://ns.fish.ftrace.com", "unloadingPort");
    private final static QName _VesselName_QNAME = new QName("http://ns.fish.ftrace.com", "vesselName");
    private final static QName _VesselID_QNAME = new QName("http://ns.fish.ftrace.com", "vesselID");
    private final static QName _VesselFlagState_QNAME = new QName("http://ns.fish.ftrace.com", "vesselFlagState");
    private final static QName _CatchingPeriodEnd_QNAME = new QName("http://ns.fish.ftrace.com", "catchingPeriodEnd");
    private final static QName _UnloadingDate_QNAME = new QName("http://ns.fish.ftrace.com", "unloadingDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftrace.fish.ns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VesselCatchInformation }
     * 
     */
    public VesselCatchInformation createVesselCatchInformation() {
        return new VesselCatchInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "haul")
    public JAXBElement<String> createHaul(String value) {
        return new JAXBElement<String>(_Haul_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "vesselOwner")
    public JAXBElement<String> createVesselOwner(String value) {
        return new JAXBElement<String>(_VesselOwner_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "unloadingPort")
    public JAXBElement<String> createUnloadingPort(String value) {
        return new JAXBElement<String>(_UnloadingPort_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "vesselName")
    public JAXBElement<String> createVesselName(String value) {
        return new JAXBElement<String>(_VesselName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "vesselID")
    public JAXBElement<String> createVesselID(String value) {
        return new JAXBElement<String>(_VesselID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "vesselFlagState")
    public JAXBElement<String> createVesselFlagState(String value) {
        return new JAXBElement<String>(_VesselFlagState_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "catchingPeriodEnd")
    public JAXBElement<String> createCatchingPeriodEnd(String value) {
        return new JAXBElement<String>(_CatchingPeriodEnd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fish.ftrace.com", name = "unloadingDate")
    public JAXBElement<XMLGregorianCalendar> createUnloadingDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UnloadingDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

}
