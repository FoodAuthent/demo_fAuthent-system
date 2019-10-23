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

import org.foodauthent.model.GPCAttributeData;




/**
 * Global Product Classification Brick for storing gpc brick details
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class GPCBrickData   extends FaModel {


  protected String code;
  protected String text;
  protected java.util.List<GPCAttributeData> elements;

  public String getTypeID() {
    return "GPCBrickData";
  }


  @Override
  public java.util.UUID getFaId() {
  	return null;
  }

  protected GPCBrickData() {}

  private GPCBrickData(GPCBrickDataBuilder builder) {
    
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
        GPCBrickData ent = (GPCBrickData)o;
        return Objects.equals(code, ent.code) && Objects.equals(text, ent.text) && Objects.equals(elements, ent.elements);
    }


  /**
   * GPC brick code
   * @return code 
   */
  public String getCode() {
        return code;
    }

  /**
   * GPC brick human readable text
   * @return text 
   */
  public String getText() {
        return text;
    }

  /**
   * Get elements
   * @return elements 
   */
  public java.util.List<GPCAttributeData> getElements() {
        return elements;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static GPCBrickDataBuilder builder() {
  		return new GPCBrickDataBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static GPCBrickDataBuilder builder(GPCBrickData entity) {
		GPCBrickDataBuilder builder = builder();
        builder.code = entity.code;
        builder.text = entity.text;
        builder.elements = entity.elements;
 		return builder;
  	}


    public static class GPCBrickDataBuilder {

        protected GPCBrickDataBuilder(){
            
        }

        private String code;
        private String text;
        private java.util.List<GPCAttributeData> elements = new java.util.ArrayList<>();

        /**
         * GPC brick code
         * @return code 
         */
        public GPCBrickDataBuilder setCode(String code) {
             this.code = code;
             return this;
        }

        /**
         * GPC brick human readable text
         * @return text 
         */
        public GPCBrickDataBuilder setText(String text) {
             this.text = text;
             return this;
        }

        /**
         * Get elements
         * @return elements 
         */
        public GPCBrickDataBuilder setElements(java.util.List<GPCAttributeData> elements) {
             this.elements = elements;
             return this;
        }


        public GPCBrickData build() {
            return new GPCBrickData(this);
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
