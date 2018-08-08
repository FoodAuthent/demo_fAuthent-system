package org.foodauthent.test;

import java.io.File;
import java.util.UUID;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.foodauthent.api.internal.filereader.RawFileReader;
import org.foodauthent.impl.openchrom.OpenChromRawFileReader;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.test.category.FrameworkTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

@Category(FrameworkTest.class)
public class ServiceReferenceTest extends AbstractITTest {



    @Test
    public void test01() throws Exception {

	FileMetadata fileMeta;

	UUID fileMetaID;

	OpenChromRawFileReader rawFileReader;

	WebTarget wt = TestUtils.newWebTarget();

	fileMeta = TestUtils.createNewMetadata("Bruker NMR Testdata", "Bruker NMR Testdata");

	fileMetaID = TestUtils.uploadMetadata(wt, fileMeta);

	Response response = TestUtils.uploadFileData(wt, fileMetaID, new File("files/bruker-nmr/1.zip"));
	BundleContext ctx = FrameworkUtil.getBundle(RawFileReader.class).getBundleContext();
	for (ServiceReference<?> sr : ctx.getAllServiceReferences(null, null)) {
	    System.err.println(sr);
	}

	RawFileReader reader = ctx.getService(ctx.getServiceReference(RawFileReader.class));
	System.err.println(reader);


    }
}
