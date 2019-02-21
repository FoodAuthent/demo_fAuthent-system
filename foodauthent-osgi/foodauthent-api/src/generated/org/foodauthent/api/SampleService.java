/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Sample;
import org.foodauthent.model.SamplePageResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SampleService {

    /**
     * Creates/adds a new Sample.
     *
     * @param sample TODO
     *
     * @return the result
     */
    java.util.UUID createSample(Sample sample);
        
    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    SamplePageResult findSampleByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Get the Sample an id.
     *
     * @param sampleId 
     *
     * @return the result
     */
    Sample getSampleById(java.util.UUID sampleId);
        
}
