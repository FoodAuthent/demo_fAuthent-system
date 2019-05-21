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



import org.foodauthent.model.ImportFile;
import org.foodauthent.model.ImportFile.ImportFileBuilder;

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
    defaultImpl = ImportFile.class)
@JsonSubTypes({
    @Type(value = ImportFile.class, name="ImportFile")
})
@JsonDeserialize(builder=ImportFileBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ImportFileMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("file-id")
    public java.util.UUID getFileId();
    
    @JsonProperty("name")
    public String getName();
    
    @JsonProperty("description")
    public String getDescription();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ImportFileBuilder.class)
    @JsonSubTypes({
        @Type(value = ImportFile.ImportFileBuilder.class, name="ImportFile")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ImportFileMixInBuilder {
    
        public ImportFileMixIn build();
    
        @JsonProperty("fa-id")
        public ImportFileMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("file-id")
        public ImportFileMixInBuilder setFileId(final java.util.UUID fileId);
        
        @JsonProperty("name")
        public ImportFileMixInBuilder setName(final String name);
        
        @JsonProperty("description")
        public ImportFileMixInBuilder setDescription(final String description);
        
    }


}

