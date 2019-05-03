package org.foodauthent.impl.entity;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.EntityService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 *
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service=EntityService.class)
public class EntityServiceImpl implements EntityService {

    @Reference(cardinality=ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    public EntityServiceImpl() {
    }

    @Override
    public void removeEntity(UUID faId) {
	try {
	    persistenceService.removeFaModelByUUID(faId);
	} catch (NoSuchElementException e) {
	    // not a fa-model, try removing a blob
	    persistenceService.removeBlobByUUID(faId);
	}
    }

}
