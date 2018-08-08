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
import org.junit.Test;

public class OpenChromTest extends AbstractITTest {


    @Test
    public void simpleUploadTest() throws Exception {

	WebTarget wt = TestUtils.newWebTarget();

	// Create metadata
	FileMetadata fileMeta = TestUtils.createNewMetadata("Bruker NMR Testdata", "Bruker NMR Testdata");

	// Upload metadata
	UUID fileMetaID = TestUtils.uploadMetadata(wt, fileMeta);

	Response response = TestUtils.uploadFileData(wt, fileMetaID, new File("files/bruker-nmr/1.zip"));

	assertThat(response, is(not(nullValue())));
	assertThat(response.getStatus(), is(200));


    }


}
