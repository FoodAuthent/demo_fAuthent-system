package org.foodauthent.impl.relation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.foodauthent.api.RelationService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ServiceScope;

@Component(service = RelationService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class RelationServiceImpl implements RelationService {

    private static final Map<String, String[]> ENTITY_RELATION_MAP = new HashMap<String, String[]>() {
	private static final long serialVersionUID = 1L;

	{
	    put("product", new String[] { "sample" });
	    put("workflow", new String[] { "model" });
	    put("sample", new String[] { "fingerprint" });
	}
    };

    private static final List<String> ENTITIES = new ArrayList<String>(ENTITY_RELATION_MAP.keySet());

    private List<RelationDelegate> relationDelegates = new ArrayList<RelationDelegate>();

    @Override
    public List<String> getEntities() {
	return ENTITIES;
    }

    @Override
    public Object getForeignKeyEntities(String entityName, UUID faId, String referencedEntity, Integer pageNumber,
	    Integer pageSize) {
	final Optional<RelationDelegate> delegate = relationDelegates.stream()
		.filter(d -> d.getEntityName().equals(entityName)).findFirst();
	if (delegate.isPresent()) {
	    return delegate.get().getRelations(referencedEntity, faId, pageNumber, pageSize);
	}
	return null;
    }

    @Override
    public List<String> getSupportedEntities(String entityName) {
	return Arrays.asList(ENTITY_RELATION_MAP.get(entityName));
    }

    @Reference(service = RelationDelegate.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, unbind = "unbindRelationDelegate")
    public void bindRelationDelegate(RelationDelegate delegate) {
	relationDelegates.add(delegate);
    }

    public void unbindRelationDelegate(RelationDelegate delegate) {
	relationDelegates.remove(delegate);
    }
}
