package org.foodauthent.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.UUID;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.rest.api.service.FileRestService;
import org.foodauthent.test.category.FrameworkTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
/**
 * 
 * TEST OK
 *
 */
@Category(FrameworkTest.class)
public class FileUploadTest extends AbstractITTest {

    FileRestService s = restService(FileRestService.class);

    @Test
    public void simpleUploadTest() throws Exception {

	FileRestService s = restService(FileRestService.class);

	WebTarget wt = TestUtils.newWebTarget();

	// Create metadata
	FileMetadata fileMeta = TestUtils.createNewMetadata("Bruker NMR Testdata Test", "Bruker NMR Testdata from FileUploadTest");

	// Upload metadata
	UUID fileMetaID = TestUtils.uploadMetadata(wt, fileMeta);

	Response response = TestUtils.uploadFileData(wt, fileMetaID, new File("files/bruker-nmr/1.zip"));

	assertThat(response, is(not(nullValue())));
	assertThat(response.getStatus(), is(200));

    }

}
