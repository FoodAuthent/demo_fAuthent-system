/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.FaObjectSet.FaObjectSetBuilder;

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
    defaultImpl = FaObjectSet.class)
@JsonSubTypes({
    @Type(value = FaObjectSet.class, name="FaObjectSet")
})
@JsonDeserialize(builder=FaObjectSetBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FaObjectSetMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("fingerprints")
    public java.util.List<java.util.UUID> getFingerprints();
    
    @JsonProperty("products")
    public java.util.List<java.util.UUID> getProducts();
    
    @JsonProperty("sops")
    public java.util.List<java.util.UUID> getSops();
    
    @JsonProperty("workflows")
    public java.util.List<java.util.UUID> getWorkflows();
    
    @JsonProperty("files")
    public java.util.List<java.util.UUID> getFiles();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FaObjectSetBuilder.class)
    @JsonSubTypes({
        @Type(value = FaObjectSet.FaObjectSetBuilder.class, name="FaObjectSet")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FaObjectSetMixInBuilder {
    
        public FaObjectSetMixIn build();
    
        @JsonProperty("fingerprints")
        public FaObjectSetMixInBuilder setFingerprints(final java.util.List<java.util.UUID> fingerprints);
        
        @JsonProperty("products")
        public FaObjectSetMixInBuilder setProducts(final java.util.List<java.util.UUID> products);
        
        @JsonProperty("sops")
        public FaObjectSetMixInBuilder setSops(final java.util.List<java.util.UUID> sops);
        
        @JsonProperty("workflows")
        public FaObjectSetMixInBuilder setWorkflows(final java.util.List<java.util.UUID> workflows);
        
        @JsonProperty("files")
        public FaObjectSetMixInBuilder setFiles(final java.util.List<java.util.UUID> files);
        
    }


}

