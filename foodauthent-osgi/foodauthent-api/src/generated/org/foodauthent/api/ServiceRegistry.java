package org.foodauthent.api;

import org.foodauthent.impl.sop.SopServiceImpl;
import org.foodauthent.impl.file.FileServiceImpl;
import org.foodauthent.impl.workflow.WorkflowServiceImpl;
import org.foodauthent.impl.fingerprint.FingerprintServiceImpl;
import org.foodauthent.impl.product.ProductServiceImpl;
import org.foodauthent.impl.model.ModelServiceImpl;

@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ServiceRegistry {
	
	public static <S> S get(Class<S> serviceClass) {
		if(serviceClass == SopService.class) {
			return (S) new SopServiceImpl();
		} 
		if(serviceClass == FileService.class) {
			return (S) new FileServiceImpl();
		} 
		if(serviceClass == WorkflowService.class) {
			return (S) new WorkflowServiceImpl();
		} 
		if(serviceClass == FingerprintService.class) {
			return (S) new FingerprintServiceImpl();
		} 
		if(serviceClass == ProductService.class) {
			return (S) new ProductServiceImpl();
		} 
		if(serviceClass == ModelService.class) {
			return (S) new ModelServiceImpl();
		} 
		throw new IllegalArgumentException(
			"No implementation available for service " + serviceClass.getSimpleName());
	
	}
}
