/*
 * TODO	
 */
package org.foodauthent.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A fingerprint object referencing metadata and raw data.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Fingerprint extends FaModel {

    private java.util.UUID faId;
    private String metadata;

    public String getTypeID() {
	return "Fingerprint";
    }

    private Fingerprint(FingerprintBuilder builder) {

	faId = immutable(builder.faId);
	metadata = immutable(builder.metadata);

	faId = generateFaIdIfMissing(faId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null) {
	    return false;
	}
	if (getClass() != o.getClass()) {
	    return false;
	}
	Fingerprint ent = (Fingerprint) o;
	return Objects.equals(faId, ent.faId) && Objects.equals(metadata, ent.metadata);
    }

    public java.util.UUID getFaId() {
	return faId;
    }

    public String getMetadata() {
	return metadata;
    }

    /**
     * @return a newly created builder
     */
    public static FingerprintBuilder builder() {
	return new FingerprintBuilder();
    }

    /**
     * Copy-builder, i.e. creates a new builder with all properties of the passed
     * entity pre-set.
     * 
     * @param entity
     *            entity to copy the properties from
     * @return a new builder with the properties set
     */
    public static FingerprintBuilder builder(Fingerprint entity) {
	FingerprintBuilder builder = builder();
	builder.faId = entity.faId;
	builder.metadata = entity.metadata;
	return builder;
    }

    public static class FingerprintBuilder {

	private FingerprintBuilder() {

	}

	private java.util.UUID faId = null;
	private String metadata = null;

	public FingerprintBuilder setFaId(java.util.UUID faId) {
	    this.faId = faId;
	    return this;
	}

	public FingerprintBuilder setMetadata(String metadata) {
	    this.metadata = metadata;
	    return this;
	}

	public Fingerprint build() {
	    return new Fingerprint(this);
	}

    }

    /**
     * Turns an object into an immutable one (if not already). TODO move it
     * somewhere else
     *
     * @param obj
     *            the object to treat
     * @return the object itself or a immutable copy
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T immutable(final T obj) {
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

}
