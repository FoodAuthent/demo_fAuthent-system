/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 
 * @author Martin Horn, University of Konstanz
 */
public class ServiceUtil {

    private ServiceUtil() {
        //utility class
    }
    
    public static List<Class<?>> getRestServiceClasses() {
        List<Class<?>> res = new ArrayList<Class<?>>();
        res.add(SopRestServiceImpl.class);
        res.add(FileRestServiceImpl.class);
        res.add(OrganizationRestServiceImpl.class);
        res.add(TransactionRestServiceImpl.class);
        res.add(AuthenticationRestServiceImpl.class);
        res.add(WorkflowRestServiceImpl.class);
        res.add(FingerprintRestServiceImpl.class);
        res.add(UserRestServiceImpl.class);
        res.add(ObjectEventRestServiceImpl.class);
        res.add(ProductRestServiceImpl.class);
        res.add(CustomMetadataRestServiceImpl.class);
        res.add(ModelRestServiceImpl.class);
        return res;
    }
}
