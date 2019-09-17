package org.foodauthent.epcis.impl.ftrace.tests;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.foodauthent.model.Epc;
import org.foodauthent.model.GPCAttribute;
import org.foodauthent.model.GPCAttributeValue;
import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEvent.ActionEnum;

public class MockedObjectEventBuilder {

	public static ObjectEvent buildClassificationEvent() {
		final ObjectEvent objectEvent = ObjectEvent.builder() //
				.setAction(ActionEnum.ADD) //
				.setBizStep("urn:epcglobal:cbv:bizstep:commissioning") //
				.setEventTime(OffsetDateTime.now()) //
				.setEpcList(Arrays.asList(
						"ni://api.foodauthent.net/sha-256;9ed1b204ec3f1b37d318ceaeb3f79dfd7d9743234512bc34818b4c736f82beca?type=fakx")
						.stream().map(s -> {
							return Epc.builder().setEpc(s).build();
						}).collect(Collectors.toList())) //
				.setDisposition("urn:epcglobal:cbv:disp:active") //
				.setGtin("04012345123456") //
				.setReadPoint("urn:epc:id:sgln:439990230054..0") //
				.setBricks(Arrays.asList(

						GPCBrick.builder() //
								.setCode("10000111") //
								.setText("Coffee - Beans/Ground") //

								.setAttributes(Arrays.asList(GPCAttribute.builder() //
										.setCode("20000750") //
										.setText("Botanical Variety") //
										.setValues(Arrays.asList(GPCAttributeValue.builder() //
												.setCode("30000207") //
												.setText("ARABICA").build()))
										.build(),

										GPCAttribute.builder() //
												.setCode("20000352") //
												.setText("Formation") //
												.setValues(Arrays.asList(GPCAttributeValue.builder() //
														.setCode("30015641") //
														.setText("COARSE GROUND").build()))
												.build()

								))

								.build()))
				.build();
		return objectEvent;
	}

}
