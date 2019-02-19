package org.foodauthent.impl.transaction;

import java.util.List;

import org.foodauthent.api.TransactionService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.TransactionPageResult;
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
    public TransactionPageResult findTransactionByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<DiscoveryServiceTransaction> res = persistenceService.findByKeywordsPaged(keywords, DiscoveryServiceTransaction.class, pageNumber, pageSize);
	return TransactionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }



  

}
