
package com.ftrace.capture;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import epcglobal.epcis.xsd._1.AggregationEventType;
import epcglobal.epcis.xsd._1.EPCISDocumentType;
import epcglobal.epcis.xsd._1.EPCISEventListExtensionType;
import epcglobal.epcis.xsd._1.ObjectEventType;
import epcglobal.epcis.xsd._1.QuantityEventType;
import epcglobal.epcis.xsd._1.TransactionEventType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftrace.ns.ftracecapture package. 
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

    private final static QName _FtraceCaptureResponse_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "ftraceCaptureResponse");
    private final static QName _QuantityEvent_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "QuantityEvent");
    private final static QName _ObjectEvent_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "ObjectEvent");
    private final static QName _TransactionEvent_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "TransactionEvent");
    private final static QName _AggregationEvent_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "AggregationEvent");
    private final static QName _Extension_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "extension");
    private final static QName _FTraceCaptureRequest_QNAME = new QName("http://ns.ftrace.com/fTraceCapture", "fTraceCaptureRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftrace.ns.ftracecapture
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FtraceCaptureResponse }
     * 
     */
    public FtraceCaptureResponse createFtraceCaptureResponse() {
        return new FtraceCaptureResponse();
    }

    /**
     * Create an instance of {@link SucessDetails }
     * 
     */
    public SucessDetails createSucessDetails() {
        return new SucessDetails();
    }

    /**
     * Create an instance of {@link Messages }
     * 
     */
    public Messages createMessages() {
        return new Messages();
    }

    /**
     * Create an instance of {@link ResponseMessage }
     * 
     */
    public ResponseMessage createResponseMessage() {
        return new ResponseMessage();
    }

    /**
     * Create an instance of {@link ErrorneousDetails }
     * 
     */
    public ErrorneousDetails createErrorneousDetails() {
        return new ErrorneousDetails();
    }

    /**
     * Create an instance of {@link ErroneousField }
     * 
     */
    public ErroneousField createErroneousField() {
        return new ErroneousField();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FtraceCaptureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "ftraceCaptureResponse")
    public JAXBElement<FtraceCaptureResponse> createFtraceCaptureResponse(FtraceCaptureResponse value) {
        return new JAXBElement<FtraceCaptureResponse>(_FtraceCaptureResponse_QNAME, FtraceCaptureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantityEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "QuantityEvent")
    public JAXBElement<QuantityEventType> createQuantityEvent(QuantityEventType value) {
        return new JAXBElement<QuantityEventType>(_QuantityEvent_QNAME, QuantityEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "ObjectEvent")
    public JAXBElement<ObjectEventType> createObjectEvent(ObjectEventType value) {
        return new JAXBElement<ObjectEventType>(_ObjectEvent_QNAME, ObjectEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "TransactionEvent")
    public JAXBElement<TransactionEventType> createTransactionEvent(TransactionEventType value) {
        return new JAXBElement<TransactionEventType>(_TransactionEvent_QNAME, TransactionEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggregationEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "AggregationEvent")
    public JAXBElement<AggregationEventType> createAggregationEvent(AggregationEventType value) {
        return new JAXBElement<AggregationEventType>(_AggregationEvent_QNAME, AggregationEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPCISEventListExtensionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "extension")
    public JAXBElement<EPCISEventListExtensionType> createExtension(EPCISEventListExtensionType value) {
        return new JAXBElement<EPCISEventListExtensionType>(_Extension_QNAME, EPCISEventListExtensionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPCISDocumentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.ftrace.com/fTraceCapture", name = "fTraceCaptureRequest")
    public JAXBElement<EPCISDocumentType> createFTraceCaptureRequest(EPCISDocumentType value) {
        return new JAXBElement<EPCISDocumentType>(_FTraceCaptureRequest_QNAME, EPCISDocumentType.class, null, value);
    }

}
