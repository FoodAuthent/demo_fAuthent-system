package org.foodauthent.data;

import static org.foodauthent.data.DeleteEntities.clearAllProducts;
import static org.foodauthent.data.DeleteEntities.clearAllWorkflows;
import static org.foodauthent.data.PopulateProducts.populateRandomProducts;
import static org.foodauthent.data.PopulateWorkflows.populateTestPedictionWorkflow;
import static org.foodauthent.data.PopulateWorkflows.populateTestTrainingWorkflow;

/**
 * Application that populates data to a foodauthent system.
 * 
 * @author Martin Horn, Unversity of Konstanz
 */
public class PopulateDataApp {
   
    public static void main(String[] args) {
	clearAllProducts();
	clearAllWorkflows();
	
	populateRandomProducts(10);
	populateTestTrainingWorkflow();
	populateTestPedictionWorkflow();
    }

}
