package org.foodauthent.epcis.impl.ftrace.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.foodauthent.common.tests.base.AbstractServiceTest;
import org.foodauthent.epcis.EPCISEventService;
import org.junit.jupiter.api.Test;

public class EPCISEventServiceTest extends AbstractServiceTest {

	@Test
	public void test1() throws Exception {
		final EPCISEventService service = getService(EPCISEventService.class);
		assertNotNull(service);
		service.publish(MockedObjectEventBuilder.buildClassificationEvent());
	}
	
}
