
package com.ftrace.fruit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftrace.fruit.ns package. 
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

    private final static QName _SizeCode_QNAME = new QName("http://ns.fruit.ftrace.com", "sizeCode");
    private final static QName _GradeCode_QNAME = new QName("http://ns.fruit.ftrace.com", "gradeCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftrace.fruit.ns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnalysisReference }
     * 
     */
    public AnalysisReference createAnalysisReference() {
        return new AnalysisReference();
    }

    /**
     * Create an instance of {@link CertificationCode }
     * 
     */
    public CertificationCode createCertificationCode() {
        return new CertificationCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fruit.ftrace.com", name = "sizeCode")
    public JAXBElement<String> createSizeCode(String value) {
        return new JAXBElement<String>(_SizeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.fruit.ftrace.com", name = "gradeCode")
    public JAXBElement<String> createGradeCode(String value) {
        return new JAXBElement<String>(_GradeCode_QNAME, String.class, null, value);
    }

}
