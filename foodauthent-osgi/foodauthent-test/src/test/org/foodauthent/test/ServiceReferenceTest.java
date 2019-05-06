package org.foodauthent.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.foodauthent.api.internal.filereader.RawFileReader;
import org.foodauthent.test.category.FrameworkTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * 
 * TEST OK
 *
 */
@Category(FrameworkTest.class)
public class ServiceReferenceTest extends AbstractITTest {

    @Test
    public void test01() throws Exception {
	BundleContext ctx = FrameworkUtil.getBundle(RawFileReader.class).getBundleContext();
	for (ServiceReference<?> sr : ctx.getAllServiceReferences(null, null)) {
	    // System.err.println(sr);
	}
	ServiceReference<RawFileReader> hans = ctx.getServiceReference(RawFileReader.class);
	assertThat(hans, is(not(nullValue())));
	RawFileReader reader = ctx.getService(hans);
	assertThat(reader, is(not(nullValue())));


    }
}
