package org.foodauthent.impl.objectevent;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.ObjectEventService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransaction.ActionEnum;
import org.foodauthent.model.Epc;
import org.foodauthent.model.GPCAttribute;
import org.foodauthent.model.GPCAttributeValue;
import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEventPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.foodauthent.digest.DigestUtil;

/**
 *
 * @author Massimo Bevilacqua, Benelog GmbH
 *
 */
@Component(service = ObjectEventService.class)
public class ObjectEventServiceImpl implements ObjectEventService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Override
    public ObjectEventPageResult findObjectEventByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<ObjectEvent> res = persistenceService.findByKeywordsPaged(ObjectEvent.class, pageNumber, pageSize,
		toArray(keywords));
	return ObjectEventPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public UUID createObjectEvent(ObjectEvent objectEvent) {
	persistenceService.save(objectEvent);
	return objectEvent.getFaId();
    }

    @Override
    public ObjectEvent getObjectEventById(UUID objecteventId) {
	return persistenceService.getFaModelByUUID(objecteventId, ObjectEvent.class);
    }

    @Override
    public DiscoveryServiceTransaction convertObjectEventToTransaction(UUID objecteventId) {
	ObjectEvent objectEvent = getObjectEventById(objecteventId);
	DiscoveryServiceTransaction discoveryServiceTransaction = null;
	try {
	    discoveryServiceTransaction = buildDiscoveryServiceTransaction(objectEvent);
	} catch (NoSuchAlgorithmException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return discoveryServiceTransaction;
    }

    private static String getGlnMaskingCode(String sgln) {
	return "1.FCK03l#";
    }
    
    private static String getInterfaceMaskingCode(String interfaceId) {
	return "Koe1nerD*m";
    }
    

    private static List<String> convertBrickList(List<GPCBrick> bricks) {
	List<String> result = new ArrayList();
	for (GPCBrick brick : bricks) {
	    for (GPCAttribute att : brick.getAttributes()) {
		for (GPCAttributeValue val : att.getValues()) {
		    result.add(brick.getCode() + "/" + att.getCode() + "/" + val.getCode());
		}
	    }
	}
	return result;
    }
   

    static ActionEnum ObjectToTransactionEnum(org.foodauthent.model.ObjectEvent.ActionEnum value) {
	return ActionEnum.values()[value.ordinal()];
    }

    public static DiscoveryServiceTransaction buildDiscoveryServiceTransaction(ObjectEvent objectEvent)
	    throws NoSuchAlgorithmException {
	final DiscoveryServiceTransaction discoveryServiceTransaction = DiscoveryServiceTransaction.builder() //
		.setAction(ObjectToTransactionEnum(objectEvent.getAction())) //
		.setBizTransactionList(objectEvent.getBizTransactionList())//
		.setEventType("ObjectEvent")//
		.setInterfaceId("ni:///sha-256;"+DigestUtil.sha256("api.foodauthent.net (http://api.foodauthent.net/)" + getInterfaceMaskingCode(""))+"?input=iid.imc&multiHash=yes")
		.setQuantityList(objectEvent.getQuantityList()
                        .stream().map(s -> {
                            try {
				return "ni:///sha-256;"+DigestUtil.sha256(s.getEpcClass())+"?input=lgtin";
			    } catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			    }
			    return null;
                        }).collect(Collectors.toList()))
		.setBizStep(objectEvent.getBizStep()) //
		.setEventTime(objectEvent.getEventTime()) //
                .setEpcList(objectEvent.getEpcList()
                        .stream().map(s -> {
                            try {
				return Epc.builder().setEpc("ni:///sha-256;"+DigestUtil.sha256(s.getEpc())+"?input=lgtin").build();
			    } catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			    }
			    return s;
                        }).collect(Collectors.toList()))
		.setGtin(objectEvent.getGtin()) //
		.setReadPoint("ni:///sha-256;"+DigestUtil.sha256(objectEvent.getReadPoint() + getGlnMaskingCode(""))+"?input=sgln.gmc&multiHash=yes")
		.setBricks(convertBrickList(objectEvent.getBricks())).build();
	return discoveryServiceTransaction;
    }

}
