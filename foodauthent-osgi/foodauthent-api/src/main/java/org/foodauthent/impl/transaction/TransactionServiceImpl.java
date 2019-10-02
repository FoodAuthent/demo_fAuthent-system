package org.foodauthent.impl.transaction;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.TransactionService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;
import org.foodauthent.model.Product;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.foodauthent.digest.DigestUtil;
import com.foodauthent.gs1.GS1IdentifierUtil;

/**
 *
 * @author Massimo Bevilacqua, Benelog GmbH
 *
 */
@Component(service = TransactionService.class)
public class TransactionServiceImpl implements TransactionService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Override
    public DiscoveryServiceTransactionPageResult findTransactionByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
	ResultPage<DiscoveryServiceTransaction> res = persistenceService
		.findByKeywordsPaged(DiscoveryServiceTransaction.class, pageNumber, pageSize, toArray(keywords));
	return DiscoveryServiceTransactionPageResult.builder().setPageCount(res.getTotalNumPages())
		.setPageNumber(pageNumber).setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

//    @Override
//    public UUID createTransaction(DiscoveryServiceTransaction discoveryServiceTransaction) {
//	persistenceService.save(discoveryServiceTransaction);
//	return discoveryServiceTransaction.getFaId();
//    }

    @Override
    public DiscoveryServiceTransaction getTransactionById(UUID transactionId) {
	return persistenceService.getFaModelByUUID(transactionId, DiscoveryServiceTransaction.class);
    }

    @Override
    public DiscoveryServiceTransactionPageResult findTransactionByFilter(Integer pageNumber, Integer pageSize, DiscoveryServiceSearchFilter discoveryServiceSearchFilter) {
	return persistenceService.findTransactionByFilter(discoveryServiceSearchFilter, pageNumber, pageSize);
    }

    @Override
    public List<UUID> createTransaction(List<DiscoveryServiceTransaction> requestBody) {
	List<UUID> results = new ArrayList<UUID>();
	for(DiscoveryServiceTransaction dst : requestBody) {
	    persistenceService.save(dst);
	    results.add(dst.getFaId());
	}
	return results;
    }

    @Override
    public String getSha256EpcClass(String gtin, String lot) {
	String result = "";
	String epcClass = "";
	int gcpLength = 0;
	try {
	Product p = persistenceService.findProductByGtin(gtin);
	gcpLength = p.getGcpLength();
	}catch(NoSuchElementException e) {
	 gcpLength = GS1IdentifierUtil.DEFAULT_GCP_LENGTH;
	}
	 epcClass = GS1IdentifierUtil.convertToEpcClass(gtin,lot, gcpLength);

	try {
	    result = DigestUtil.sha256(epcClass);
	} catch (NoSuchAlgorithmException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return "ni://sha-256;"+result+"?input=lgtin";
    }
    
}
