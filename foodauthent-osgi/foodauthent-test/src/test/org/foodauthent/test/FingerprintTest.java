package org.foodauthent.test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.UUID;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;
import org.foodauthent.model.FingerprintSetType;
import org.foodauthent.model.FingerprintSetType.NameEnum;
import org.foodauthent.rest.api.service.FingerprintRestService;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;

/**
 * Tests endpoints that deal with fingerprints and fingerprint sets.
 */
public class FingerprintTest extends AbstractITTest {

    @Test
    public void testSaveAndRetrieveFingerprintSetMetadata() {
	Fingerprint fp = Fingerprint.builder().setMetadata("fp metadata").build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setProductId(UUID.randomUUID())
		.setType(FingerprintSetType.builder().setName(NameEnum.BRUKER).build())
		.setFingerprints(Arrays.asList(fp)).setFileId(UUID.randomUUID()).build();

	FingerprintRestService fingerprintService = restService(FingerprintRestService.class);
	fingerprintService.createFingerprintSet(fps);

	FingerprintSet result = fingerprintService.getFingerprintSetById(fps.getFaId())
		.readEntity(FingerprintSet.class);
	assertThat("Unexpected fingerprint set", fps, is(result));

	FingerprintSetPageResult resultPage = fingerprintService.findFingerprintSetByKeyword(1, 100, asList("myset"))
		.readEntity(FingerprintSetPageResult.class);
	assertThat("Fingerprint set not contained in result", resultPage.getResults(), hasItem(fps));
    }

}
