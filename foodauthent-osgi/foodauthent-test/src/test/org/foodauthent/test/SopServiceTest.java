package org.foodauthent.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ws.rs.core.Response;

import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;
import org.foodauthent.rest.api.service.SopRestService;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class SopServiceTest extends AbstractITTest {
    
    
    @Test
    public void testFindSOPsByKeywords() {
	SopRestService s = restService(SopRestService.class);
	
	// remove all sops first
	List<SOP> allSops = s.findSOPByKeyword(1, Integer.MAX_VALUE, Collections.emptyList())
		.readEntity(SOPPageResult.class).getResults();
	allSops.forEach(sop -> s.removeSOPById(sop.getFaId()));
	
	//test what happens when there are no sops
	SOPPageResult sopPage = s.findSOPByKeyword(1, 10, null).readEntity(SOPPageResult.class);
	assertEquals(1, sopPage.getPageNumber().intValue());
	assertEquals(0, sopPage.getResults().size());
	assertEquals(0, sopPage.getResultCount().intValue());

	//add sops
	List<SOP> sops = IntStream.range(0, 95).mapToObj(i -> {
	    return SOP.builder().setName("sop" + i).setDescription("desc" + (i % 10)).setFileId(UUID.randomUUID())
		    .setProductId(UUID.randomUUID()).build();
	}).collect(Collectors.toList());
	sops.stream().forEach(sop -> s.createNewSOP(sop));
	
	//retrieve them
	sopPage = s.findSOPByKeyword(1, 3, Arrays.asList("desc1", "desc2")).readEntity(SOPPageResult.class);
	assertEquals(1, sopPage.getPageNumber().intValue());
	assertEquals(3, sopPage.getResults().size());
	assertEquals(20, sopPage.getResultCount().intValue());
	
	sopPage = s.findSOPByKeyword(10, 10, Collections.emptyList()).readEntity(SOPPageResult.class);
	assertEquals(5, sopPage.getResults().size());
	assertEquals(95, sopPage.getResultCount().intValue());

    }


}
