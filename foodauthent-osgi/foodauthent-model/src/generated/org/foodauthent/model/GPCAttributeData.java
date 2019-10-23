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

import org.foodauthent.model.GPCAttributeValueData;




/**
 * Global Product Classification Attribute for storing gpc brick details
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class GPCAttributeData   extends FaModel {


  protected String code;
  protected String text;
  protected java.util.List<GPCAttributeValueData> elements;

  public String getTypeID() {
    return "GPCAttributeData";
  }


  @Override
  public java.util.UUID getFaId() {
  	return null;
  }

  protected GPCAttributeData() {}

  private GPCAttributeData(GPCAttributeDataBuilder builder) {
    
    code = immutable(builder.code);
    text = immutable(builder.text);
    elements = immutable(builder.elements);


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
        GPCAttributeData ent = (GPCAttributeData)o;
        return Objects.equals(code, ent.code) && Objects.equals(text, ent.text) && Objects.equals(elements, ent.elements);
    }


  /**
   * GPC attribute code
   * @return code 
   */
  public String getCode() {
        return code;
    }

  /**
   * GPC attribute human readable text
   * @return text 
   */
  public String getText() {
        return text;
    }

  /**
   * Get elements
   * @return elements 
   */
  public java.util.List<GPCAttributeValueData> getElements() {
        return elements;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static GPCAttributeDataBuilder builder() {
  		return new GPCAttributeDataBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static GPCAttributeDataBuilder builder(GPCAttributeData entity) {
		GPCAttributeDataBuilder builder = builder();
        builder.code = entity.code;
        builder.text = entity.text;
        builder.elements = entity.elements;
 		return builder;
  	}


    public static class GPCAttributeDataBuilder {

        protected GPCAttributeDataBuilder(){
            
        }

        private String code;
        private String text;
        private java.util.List<GPCAttributeValueData> elements = new java.util.ArrayList<>();

        /**
         * GPC attribute code
         * @return code 
         */
        public GPCAttributeDataBuilder setCode(String code) {
             this.code = code;
             return this;
        }

        /**
         * GPC attribute human readable text
         * @return text 
         */
        public GPCAttributeDataBuilder setText(String text) {
             this.text = text;
             return this;
        }

        /**
         * Get elements
         * @return elements 
         */
        public GPCAttributeDataBuilder setElements(java.util.List<GPCAttributeValueData> elements) {
             this.elements = elements;
             return this;
        }


        public GPCAttributeData build() {
            return new GPCAttributeData(this);
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
