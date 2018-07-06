/*
 * TODO	
 */
package org.foodauthent.rest.service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 
 * @author Martin Horn, University of Konstanz
 */
public class ServiceUtil {

    private ServiceUtil() {
	// utility class
    }

    public static List<Class<?>> getRestServiceClasses() {
	List<Class<?>> res = new ArrayList<Class<?>>();
	res.add(SopRestService.class);
	res.add(WorkflowRestService.class);
	res.add(FingerprintRestService.class);
	res.add(ProductRestService.class);
	return res;
    }
}
