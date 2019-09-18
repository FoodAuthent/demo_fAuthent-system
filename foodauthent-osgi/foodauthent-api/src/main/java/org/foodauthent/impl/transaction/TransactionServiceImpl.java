package org.foodauthent.impl.transaction;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.foodauthent.api.TransactionService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
    
}
