package org.foodauthent.test;

import static java.util.Arrays.asList;
import static org.foodauthent.rest.client.FASystemClient.fingerprints;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.UUID;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;
import org.foodauthent.model.FingerprintType;
import org.foodauthent.rest.api.service.FingerprintRestService;
import org.foodauthent.rest.client.FASystemClient;
import org.junit.Test;

/**
 * Tests endpoints that deal with fingerprints and fingerprint sets.
 */
public class FingerprintTest extends AbstractITTest {

    @Test
    public void testSaveAndRetrieveFingerprintSetMetadata() {
	Fingerprint fp = Fingerprint.builder().setSampleId(UUID.randomUUID()).setFileId(UUID.randomUUID()).setType(
		FingerprintType.builder().setName(org.foodauthent.model.FingerprintType.NameEnum.BRUKER).build())
		.build();
	FingerprintSet fps = FingerprintSet.builder().setName("myset").setFingerprintIds(Arrays.asList(fp.getFaId()))
		.build();

	fingerprints().createFingerprintSet(fps);

	FingerprintSet result = fingerprints().getFingerprintSetById(fps.getFaId())
		.readEntity(FingerprintSet.class);
	assertThat("Unexpected fingerprint set", fps, is(result));

	FingerprintSetPageResult resultPage = fingerprints().findFingerprintSetByKeyword(1, 100, asList("myset"))
		.readEntity(FingerprintSetPageResult.class);
	assertThat("Fingerprint set not contained in result", resultPage.getResults(), hasItem(fps));
    }

}
