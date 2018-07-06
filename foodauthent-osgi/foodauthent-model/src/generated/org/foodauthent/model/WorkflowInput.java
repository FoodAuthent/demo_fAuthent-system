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
 * WorkflowInput
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowInput extends FaModel {

    /**
     * the input type
     */
    public enum TypeEnum {
	STRING("string"),

	INTEGER("integer"),

	MODEL("model"),

	BRUKER_FILE("bruker_file"),

	PROCESSED_BRUKER_FILE("processed_bruker_file");

	private String value;

	TypeEnum(String value) {
	    this.value = value;
	}

	@Override
	public String toString() {
	    return String.valueOf(value);
	}

    }

    private java.util.UUID faId;
    private String id;
    private Boolean required;
    private TypeEnum type;

    public String getTypeID() {
	return "WorkflowInput";
    }

    private WorkflowInput(WorkflowInputBuilder builder) {

	faId = immutable(builder.faId);
	id = immutable(builder.id);
	required = immutable(builder.required);
	type = immutable(builder.type);

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
	WorkflowInput ent = (WorkflowInput) o;
	return Objects.equals(faId, ent.faId) && Objects.equals(id, ent.id) && Objects.equals(required, ent.required)
		&& Objects.equals(type, ent.type);
    }

    public java.util.UUID getFaId() {
	return faId;
    }

    public String getId() {
	return id;
    }

    public Boolean Required() {
	return required;
    }

    public TypeEnum getType() {
	return type;
    }

    /**
     * @return a newly created builder
     */
    public static WorkflowInputBuilder builder() {
	return new WorkflowInputBuilder();
    }

    /**
     * Copy-builder, i.e. creates a new builder with all properties of the passed
     * entity pre-set.
     * 
     * @param entity
     *            entity to copy the properties from
     * @return a new builder with the properties set
     */
    public static WorkflowInputBuilder builder(WorkflowInput entity) {
	WorkflowInputBuilder builder = builder();
	builder.faId = entity.faId;
	builder.id = entity.id;
	builder.required = entity.required;
	builder.type = entity.type;
	return builder;
    }

    public static class WorkflowInputBuilder {

	private WorkflowInputBuilder() {

	}

	private java.util.UUID faId = null;
	private String id = null;
	private Boolean required = null;
	private TypeEnum type = null;

	public WorkflowInputBuilder setFaId(java.util.UUID faId) {
	    this.faId = faId;
	    return this;
	}

	public WorkflowInputBuilder setId(String id) {
	    this.id = id;
	    return this;
	}

	public WorkflowInputBuilder setRequired(Boolean required) {
	    this.required = required;
	    return this;
	}

	public WorkflowInputBuilder setType(TypeEnum type) {
	    this.type = type;
	    return this;
	}

	public WorkflowInput build() {
	    return new WorkflowInput(this);
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
