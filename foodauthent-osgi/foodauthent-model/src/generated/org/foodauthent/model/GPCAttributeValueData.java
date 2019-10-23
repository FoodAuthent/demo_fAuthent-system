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
 * Global Product Classification Attribute for storing gpc brick details
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class GPCAttributeValueData   extends FaModel {


  protected String code;
  protected String text;

  public String getTypeID() {
    return "GPCAttributeValueData";
  }


  @Override
  public java.util.UUID getFaId() {
  	return null;
  }

  protected GPCAttributeValueData() {}

  private GPCAttributeValueData(GPCAttributeValueDataBuilder builder) {
    
    code = immutable(builder.code);
    text = immutable(builder.text);


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
        GPCAttributeValueData ent = (GPCAttributeValueData)o;
        return Objects.equals(code, ent.code) && Objects.equals(text, ent.text);
    }


  /**
   * GPC attribute value code
   * @return code 
   */
  public String getCode() {
        return code;
    }

  /**
   * GPC attribute value human readable text
   * @return text 
   */
  public String getText() {
        return text;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static GPCAttributeValueDataBuilder builder() {
  		return new GPCAttributeValueDataBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static GPCAttributeValueDataBuilder builder(GPCAttributeValueData entity) {
		GPCAttributeValueDataBuilder builder = builder();
        builder.code = entity.code;
        builder.text = entity.text;
 		return builder;
  	}


    public static class GPCAttributeValueDataBuilder {

        protected GPCAttributeValueDataBuilder(){
            
        }

        private String code;
        private String text;

        /**
         * GPC attribute value code
         * @return code 
         */
        public GPCAttributeValueDataBuilder setCode(String code) {
             this.code = code;
             return this;
        }

        /**
         * GPC attribute value human readable text
         * @return text 
         */
        public GPCAttributeValueDataBuilder setText(String text) {
             this.text = text;
             return this;
        }


        public GPCAttributeValueData build() {
            return new GPCAttributeValueData(this);
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
