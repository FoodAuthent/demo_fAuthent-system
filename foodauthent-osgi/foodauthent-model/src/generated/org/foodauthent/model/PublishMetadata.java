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

import org.foodauthent.model.GPCBrick;




/**
 * DiscoveryServiceTransaction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PublishMetadata   extends FaModel {


  protected String gtin;
  protected java.util.List<GPCBrick> bricks;
  protected Boolean epcis;
  protected Boolean discovery;

  public String getTypeID() {
    return "PublishMetadata";
  }


  @Override
  public java.util.UUID getFaId() {
  	return null;
  }

  protected PublishMetadata() {}

  private PublishMetadata(PublishMetadataBuilder builder) {
    
    gtin = immutable(builder.gtin);
    bricks = immutable(builder.bricks);
    epcis = immutable(builder.epcis);
    discovery = immutable(builder.discovery);


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
        PublishMetadata ent = (PublishMetadata)o;
        return Objects.equals(gtin, ent.gtin) && Objects.equals(bricks, ent.bricks) && Objects.equals(epcis, ent.epcis) && Objects.equals(discovery, ent.discovery);
    }


  /**
   * Global Trade Item Number
   * @return gtin 
   */
  public String getGtin() {
        return gtin;
    }

  /**
   * bricks
   * @return bricks 
   */
  public java.util.List<GPCBrick> getBricks() {
        return bricks;
    }

  /**
   * save to EPCIS Repository
   * @return epcis 
   */
  public Boolean isEpcis() {
        return epcis;
    }

  /**
   * send to discovery services
   * @return discovery 
   */
  public Boolean isDiscovery() {
        return discovery;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static PublishMetadataBuilder builder() {
  		return new PublishMetadataBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PublishMetadataBuilder builder(PublishMetadata entity) {
		PublishMetadataBuilder builder = builder();
        builder.gtin = entity.gtin;
        builder.bricks = entity.bricks;
        builder.epcis = entity.epcis;
        builder.discovery = entity.discovery;
 		return builder;
  	}


    public static class PublishMetadataBuilder {

        protected PublishMetadataBuilder(){
            
        }

        private String gtin;
        private java.util.List<GPCBrick> bricks = new java.util.ArrayList<>();
        private Boolean epcis;
        private Boolean discovery;

        /**
         * Global Trade Item Number
         * @return gtin 
         */
        public PublishMetadataBuilder setGtin(String gtin) {
             this.gtin = gtin;
             return this;
        }

        /**
         * bricks
         * @return bricks 
         */
        public PublishMetadataBuilder setBricks(java.util.List<GPCBrick> bricks) {
             this.bricks = bricks;
             return this;
        }

        /**
         * save to EPCIS Repository
         * @return epcis 
         */
        public PublishMetadataBuilder setEpcis(Boolean epcis) {
             this.epcis = epcis;
             return this;
        }

        /**
         * send to discovery services
         * @return discovery 
         */
        public PublishMetadataBuilder setDiscovery(Boolean discovery) {
             this.discovery = discovery;
             return this;
        }


        public PublishMetadata build() {
            return new PublishMetadata(this);
        }

    }


    /**
     * Turns an object into an immutable one (if not already).
     * TODO move it somewhere else
     *
     * @param obj the object to treat
     * @return the object itself or a immutable copy
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> T immutable(final T obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Map) {
            return (T)Collections.unmodifiableMap(new HashMap((Map)obj));
        } else if (obj instanceof List) {
            return (T)Collections.unmodifiableList(new ArrayList((List)obj));
        } else {
            return obj;
        }
    }


}
