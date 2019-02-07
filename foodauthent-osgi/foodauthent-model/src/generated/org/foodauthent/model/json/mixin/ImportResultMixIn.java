/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FaObjectSet;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.ImportResult;
import org.foodauthent.model.ImportResult.ImportResultBuilder;

/**
 * MixIn class for entity implementations that adds jackson annotations for de-/serialization.
 *
 * @author Martin Horn, University of Konstanz
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "",
    visible = true,
    defaultImpl = ImportResult.class)
@JsonSubTypes({
    @Type(value = ImportResult.class, name="ImportResult")
})
@JsonDeserialize(builder=ImportResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ImportResultMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("problems")
    public java.util.List<String> getProblems();
    
    @JsonProperty("imported-objects")
    public FaObjectSet getImportedObjects();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ImportResultBuilder.class)
    @JsonSubTypes({
        @Type(value = ImportResult.ImportResultBuilder.class, name="ImportResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ImportResultMixInBuilder {
    
        public ImportResultMixIn build();
    
        @JsonProperty("problems")
        public ImportResultMixInBuilder setProblems(final java.util.List<String> problems);
        
        @JsonProperty("imported-objects")
        public ImportResultMixInBuilder setImportedObjects(final FaObjectSet importedObjects);
        
    }


}

