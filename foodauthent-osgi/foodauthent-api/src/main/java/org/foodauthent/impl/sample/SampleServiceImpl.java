package org.foodauthent.impl.sample;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.SampleService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Sample;
import org.foodauthent.model.SamplePageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 *
 * @author Massimo Bevilacqua, Benelog GmbH
 *
 */
@Component(service = SampleService.class)
public class SampleServiceImpl implements SampleService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Override
    public SamplePageResult findSampleByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Sample> res = persistenceService.findByKeywordsPaged(Sample.class, pageNumber, pageSize,
		toArray(keywords));
	return SamplePageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }


    @Override
    public UUID createSample(Sample sample) {
	persistenceService.save(sample);
	return sample.getFaId();
    }

    @Override
    public Sample getSampleById(UUID sampleId) {
	return persistenceService.getFaModelByUUID(sampleId, Sample.class);
    }

  

}
