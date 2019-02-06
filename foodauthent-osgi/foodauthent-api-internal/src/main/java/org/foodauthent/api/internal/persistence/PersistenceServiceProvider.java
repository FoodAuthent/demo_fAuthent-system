package org.foodauthent.api.internal.persistence;

/**
 * Should be implemented by concrete persistence backends
 * @author sven
 *
 */
public interface PersistenceServiceProvider extends PersistenceService {

	/**
	 * service priority
	 * in case more that one provider is present,
	 * the one with the highest priority is being used
	 * @return priority
	 */
	public int getPriority();
	
}
