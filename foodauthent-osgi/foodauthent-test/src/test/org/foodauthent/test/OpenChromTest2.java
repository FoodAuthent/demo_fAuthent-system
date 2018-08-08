package org.foodauthent.test;

import java.io.File;
import java.util.UUID;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.foodauthent.impl.file.FileServiceImpl;
import org.foodauthent.impl.openchrom.OpenChromRawFileReader;
import org.foodauthent.internal.persistence.impl.SimpleInMemoryPersistenceService;
import org.foodauthent.model.FileMetadata;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class OpenChromTest2 extends AbstractITTest {

    private FileMetadata fileMeta;

    private UUID fileMetaID;

    @BeforeClass
    public void beforeClass() {

	WebTarget wt = TestUtils.newWebTarget();

	fileMeta = TestUtils.createNewMetadata("Bruker NMR Testdata", "Bruker NMR Testdata");

	fileMetaID = TestUtils.uploadMetadata(wt, fileMeta);

	Response response = TestUtils.uploadFileData(wt, fileMetaID, new File("files/bruker-nmr/1.zip"));

    }

    @AfterClass
    public void afterClass() {
	fileMetaID = null;
	fileMeta = null;
    }


    @Test
    public void test01() throws Exception {

	SimpleInMemoryPersistenceService ps = new SimpleInMemoryPersistenceService();
	FileServiceImpl fs = new FileServiceImpl();
	fs.setPersistenceService(ps);
	OpenChromRawFileReader fr = new OpenChromRawFileReader();
	fr.setFileService(fs);


    }
}
