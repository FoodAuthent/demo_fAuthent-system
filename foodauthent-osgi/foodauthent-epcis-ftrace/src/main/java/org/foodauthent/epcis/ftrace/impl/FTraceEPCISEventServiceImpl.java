package org.foodauthent.epcis.ftrace.impl;

import java.math.BigDecimal;
import java.net.URL;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang3.StringUtils;
import org.foodauthent.epcis.EPCISEventService;
import org.foodauthent.epcis.ftrace.config.FTraceConfig;
import org.foodauthent.epcis.ftrace.config.FTraceConfig.Endpoint;
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.ObjectEvent;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import com.ftrace.capture.FTraceCapture;
import com.ftrace.capture.FTraceCapture_Service;

import de.foodauthent.epcis.AttType;
import de.foodauthent.epcis.AttValue;
import de.foodauthent.epcis.Brick;
import de.foodauthent.epcis.ObjectFactory;
import epcglobal.epcis.xsd._1.ActionType;
import epcglobal.epcis.xsd._1.BusinessTransactionListType;
import epcglobal.epcis.xsd._1.BusinessTransactionType;
import epcglobal.epcis.xsd._1.EPCISBodyType;
import epcglobal.epcis.xsd._1.EPCISDocumentType;
import epcglobal.epcis.xsd._1.EPCListType;
import epcglobal.epcis.xsd._1.EventListType;
import epcglobal.epcis.xsd._1.ObjectEventExtensionType;
import epcglobal.epcis.xsd._1.ObjectEventType;
import epcglobal.epcis.xsd._1.QuantityElementType;
import epcglobal.epcis.xsd._1.QuantityListType;
import epcglobal.epcis.xsd._1.ReadPointType;

@Component(service = EPCISEventService.class, scope = ServiceScope.SINGLETON, immediate = true)
public class FTraceEPCISEventServiceImpl implements EPCISEventService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private FTraceConfig config;

	private List<FTraceCapture> captureList = new ArrayList<FTraceCapture>();

	private DatatypeFactory datatypeFactory;

	private ObjectFactory foodAuthentObjectFactory = new ObjectFactory();

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
	}

	public FTraceEPCISEventServiceImpl() {
	}

	public void activate() throws Exception {
		datatypeFactory = DatatypeFactory.newInstance();
		for (Endpoint ep : config.getEndpoints()) {
			FTraceCapture_Service captureService = new FTraceCapture_Service(new URL(ep.getUrl()));
			final FTraceCapture capture = captureService.getFTraceCaptureSOAP();
			final BindingProvider bp = (BindingProvider) capture;
			Map<String, List<String>> requestHeaders = new HashMap<>();
			requestHeaders.put("Authorization", Arrays.asList("Bearer " + ep.getToken()));
			bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
			captureList.add(capture);
		}
	}

	public void deactivate() {
		captureList.clear();
	}

	@Override
	public void publish(ObjectEvent event) {
		final ObjectEventType o = objectEventTpye(event);
		final EPCISDocumentType fTraceCaptureRequest = epcisDocumentType(o);
		for (FTraceCapture capture : captureList) {
			capture.ftraceCapture(fTraceCaptureRequest);
		}
	}

	private EPCISDocumentType epcisDocumentType(ObjectEventType o) {
		final EPCISDocumentType doc = new EPCISDocumentType();
		doc.setSchemaVersion(BigDecimal.valueOf(1.2d));
		doc.setCreationDate(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
		final EPCISBodyType body = new EPCISBodyType();
		final EventListType eventList = new EventListType();
		eventList.getQuantityEventOrTransactionEventOrExtension().add(o);
		body.setEventList(eventList);
		doc.setEPCISBody(body);
		return doc;
	}

	private ObjectEventType objectEventTpye(ObjectEvent event) {
		final ObjectEventType o = new ObjectEventType();
		o.setAction(action(event));
		o.setBizStep(event.getBizStep());
		o.setBizTransactionList(bizTransactionList(event));
		o.setDisposition(event.getDisposition());
		o.setEpcList(epcList(event));
		o.setEventTime(eventTime(event));
		o.setEventTimeZoneOffset(eventTimeZoneOffset(event));
		o.setExtension(objectEventExtension(event));
		o.setReadPoint(readPoint(event));
		o.setRecordTime(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
		addFoodAuthentObjects(o, event);
		return o;
	}

	private void addFoodAuthentObjects(ObjectEventType o, ObjectEvent event) {
		if (!StringUtils.isEmpty(event.getGtin())) {
			o.getAny().add(foodAuthentObjectFactory.createGtin(event.getGtin()));
		}

		if (event.getBricks() != null && !event.getBricks().isEmpty()) {
			o.getAny().addAll(event.getBricks().stream().map(b -> {
				final Brick brick = foodAuthentObjectFactory.createBrick();
				brick.setCode(b.getCode());
				brick.setText(b.getText());
				if (b.getAttributes() != null) {
					brick.getAttType().addAll(b.getAttributes().stream().map(a -> {
						final AttType attribute = foodAuthentObjectFactory.createAttType();
						attribute.setCode(a.getCode());
						attribute.setText(a.getText());
						if (a.getValues() != null) {
							attribute.getAttValue().addAll(a.getValues().stream().map(v -> {
								final AttValue value = foodAuthentObjectFactory.createAttValue();
								value.setCode(v.getCode());
								value.setValue(v.getText());
								return value;
							}).collect(Collectors.toList()));
						}
						return attribute;
					}).collect(Collectors.toList()));
				}
				return brick;
			}).collect(Collectors.toList()));
		}
	}

	private ObjectEventExtensionType objectEventExtension(ObjectEvent event) {
		if (event.getQuantityList() == null || event.getQuantityList().isEmpty()) {
			return null;
		}
		final ObjectEventExtensionType ext = new ObjectEventExtensionType();
		final QuantityListType ql = new QuantityListType();
		ql.getQuantityElement().addAll(event.getQuantityList().stream().map(e -> {
			final QuantityElementType q = new QuantityElementType();
			q.setEpcClass(e.getEpcClass());
			q.setQuantity(e.getQuantity());
			q.setUom(e.getUom());
			return q;
		}).collect(Collectors.toList()));
		ext.setQuantityList(ql);
		return ext;
	}

	private ReadPointType readPoint(ObjectEvent event) {
		if (event.getReadPoint() == null) {
			return null;
		}
		final ReadPointType readPoint = new ReadPointType();
		readPoint.setId(event.getReadPoint());
		return readPoint;
	}

	private String eventTimeZoneOffset(ObjectEvent event) {
		if (event.getEventTime() != null) {
			return OffsetDateTime.now().getOffset().getDisplayName(TextStyle.SHORT, Locale.getDefault());
		}
		return null;
	}

	private XMLGregorianCalendar eventTime(ObjectEvent event) {
		if (event.getEventTime() == null) {
			return datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar());
		}
		final GregorianCalendar cal = GregorianCalendar.from(event.getEventTime().atStartOfDay(ZoneId.systemDefault()));
		return datatypeFactory.newXMLGregorianCalendar(cal);
	}

	private EPCListType epcList(ObjectEvent event) {
		if (event.getEpcList() == null || event.getEpcList().isEmpty()) {
			return null;
		}
		final EPCListType epcList = new EPCListType();
		epcList.getEpc().addAll(event.getEpcList().stream().map(epc -> epc.getEpc()).collect(Collectors.toList()));
		return epcList;
	}

	private ActionType action(ObjectEvent event) {
		return ActionType.valueOf(event.getAction().name().toUpperCase());
	}

	private BusinessTransactionListType bizTransactionList(ObjectEvent event) {
		if (event.getBizTransactionList() == null || event.getBizTransactionList().isEmpty()) {
			return null;
		}
		final BusinessTransactionListType bt = new BusinessTransactionListType();
		for (BizTransaction t : event.getBizTransactionList()) {
			final BusinessTransactionType v = new BusinessTransactionType();
			v.setType(t.getType());
			v.setValue(t.getValue());
			bt.getBizTransaction().add(v);
		}
		return bt;
	}

}
