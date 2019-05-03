package org.foodauthent.data;

import static org.foodauthent.rest.client.FASystemClient.products;
import static org.foodauthent.rest.client.FASystemClient.workflows;

import java.util.List;

import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.WorkflowPageResult;

/**
 * 
 * @author Martin Horn, University of Konstanz
 */
public class DeleteEntities {

    private DeleteEntities() {
	// utility class
    }
    
    public static void clearAllWorkflows() {
	List<Workflow> workflows = workflows().findWorkflowByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(WorkflowPageResult.class).getResults();
	workflows.stream().forEach(wf -> workflows().removeWorkflowById(wf.getFaId()));
    }
    
    public static void clearAllProducts() {
	List<Product> products = products().findProductByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(ProductPageResult.class).getResults();
	products.stream().forEach(p -> products().removeProductById(p.getFaId()));
    }
}
