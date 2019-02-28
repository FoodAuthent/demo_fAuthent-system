/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import java.time.LocalDate;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.foodauthent.model.FileMetadata.TypeEnum;


import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.FileMetadataBuilder;

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
    defaultImpl = FileMetadata.class)
@JsonSubTypes({
    @Type(value = FileMetadata.class, name="FileMetadata")
})
@JsonDeserialize(builder=FileMetadataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FileMetadataMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("type")
    public TypeEnum getType();
    
    @JsonProperty("name")
    public String getName();
    
    @JsonProperty("contentType")
    public String getContentType();
    
    @JsonProperty("uploadName")
    public String getUploadName();
    
    @JsonProperty("description")
    public String getDescription();
    
    @JsonProperty("author")
    public String getAuthor();
    
    @JsonProperty("date")
    public LocalDate getDate();
    
    @JsonProperty("uploadDate")
    public LocalDate getUploadDate();
    
    @JsonProperty("version")
    public Integer getVersion();
    
    @JsonProperty("additional-properties")
    public java.util.Map<String, String> getAdditionalProperties();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FileMetadataBuilder.class)
    @JsonSubTypes({
        @Type(value = FileMetadata.FileMetadataBuilder.class, name="FileMetadata")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FileMetadataMixInBuilder {
    
        public FileMetadataMixIn build();
    
        @JsonProperty("fa-id")
        public FileMetadataMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("type")
        public FileMetadataMixInBuilder setType(final TypeEnum type);
        
        @JsonProperty("name")
        public FileMetadataMixInBuilder setName(final String name);
        
        @JsonProperty("contentType")
        public FileMetadataMixInBuilder setContentType(final String contentType);
        
        @JsonProperty("uploadName")
        public FileMetadataMixInBuilder setUploadName(final String uploadName);
        
        @JsonProperty("description")
        public FileMetadataMixInBuilder setDescription(final String description);
        
        @JsonProperty("author")
        public FileMetadataMixInBuilder setAuthor(final String author);
        
        @JsonProperty("date")
        public FileMetadataMixInBuilder setDate(final LocalDate date);
        
        @JsonProperty("uploadDate")
        public FileMetadataMixInBuilder setUploadDate(final LocalDate uploadDate);
        
        @JsonProperty("version")
        public FileMetadataMixInBuilder setVersion(final Integer version);
        
        @JsonProperty("additional-properties")
        public FileMetadataMixInBuilder setAdditionalProperties(final java.util.Map<String, String> additionalProperties);
        
    }


}

