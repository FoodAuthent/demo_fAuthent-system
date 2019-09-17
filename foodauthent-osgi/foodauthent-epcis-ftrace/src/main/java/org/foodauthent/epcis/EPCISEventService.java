package org.foodauthent.epcis;

import org.foodauthent.model.ObjectEvent;

public interface EPCISEventService {

	void publish(ObjectEvent event);
	
}
