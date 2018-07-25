package org.foodauthent.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Interface for all FoodAuthent-models.
 *
 * @author Martin Horn, University of Konstanz
 *
 */
public abstract class FaModel {

    /**
     * A global FoodAuthent-ID for every model in the system.
     *
     * @return a globally unique id, never <code>null</code>
     */
    public abstract UUID getFaId();
    
    public abstract String getTypeID();
    
    /**
     * Turns an object into an immutable one (if not already). TODO move it
     * somewhere else
     *
     * @param obj
     *            the object to treat
     * @return the object itself or a immutable copy
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected static <T> T immutable(final T obj) {
	if (obj == null) {
	    return null;
	} else if (obj instanceof Map) {
	    return (T) Collections.unmodifiableMap(new HashMap((Map) obj));
	} else if (obj instanceof List) {
	    return (T) Collections.unmodifiableList(new ArrayList((List) obj));
	} else {
	    return obj;
	}
    }

    protected static UUID generateFaIdIfMissing(final UUID faId) {
	if (faId == null) {
	    return UUID.randomUUID();
	} else {
	    return faId;
	}
    }
}
