package org.foodauthent.codegen;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.DefaultCodegen;
import io.swagger.codegen.SupportingFile;
import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.DateProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
import io.swagger.models.properties.UUIDProperty;
import io.swagger.util.Json;

/**
 * Code generator for vue.js-forms json-files (see, e.g.,
 * https://icebob.gitbooks.io/vueformgenerator/content/schema.html).
 * 
 * @author Martin Horn, University of Konstanz
 */
public class VueJSClientCodegen extends DefaultCodegen implements CodegenConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(VueJSClientCodegen.class);
	private static final String VUE_JS_FORMS_EXTENSION = "x-ui-vue.js";

	private static final Object[][] ARRAY_STATIC_FIELDS = new Object[][] { { "type", "array" },
			{ "validator", "array" }, { "showRemoveButton", true }, { "itemFieldClasses", "form-control" },
			{ "itemContainerClasses", "input-group pb-2" }, { "newElementButtonLabelClasses", "btn btn-outline-dark" },
			{ "removeElementButtonClasses", "btn btn-danger input-group-append" },
			{ "moveElementUpButtonClasses", "btn btn-outline-dark input-group-append" },
			{ "moveElementDownButtonClasses", "btn btn-outline-dark input-group-append" },
			{ "newElementButtonLabel", "Add" } };

	private static final Object[][] STRING_STATIC_FIELDS = new Object[][] { { "type", "input" },
			{ "inputType", "text" } };

	private static final Object[][] ENUM_STATIC_FIELDS = new Object[][] { { "type", "select" },
			{ "validator", "string" } };

	private static final Object[][] BOOLEAN_STATIC_FIELDS = new Object[][] { { "type", "checkbox" } };

	private static final Object[][] INTEGER_STATIC_FIELDS = new Object[][] { { "type", "input" },
			{ "inputType", "number" }, { "validator", "integer" } };

	public VueJSClientCodegen() {
		super();
	}

	@Override
	public CodegenType getTag() {
		return CodegenType.OTHER;
	}

	@Override
	public String getName() {
		return additionalProperties().get("codegenName").toString();
	}

	@Override
	public String getHelp() {
		return "Writes definitions as Vue Forms schemas.";
	}

	@Override
	public void processSwagger(Swagger swagger) {
		for (Entry<String, Model> def : swagger.getDefinitions().entrySet()) {
			if (def.getValue().getVendorExtensions().containsKey(VUE_JS_FORMS_EXTENSION)) {
				try {
					// write vue form
					ObjectNode vueForm = Json.mapper().createObjectNode();
					ArrayNode fields = Json.mapper().createArrayNode();
					addFieldsInfo(def.getValue(), fields, swagger.getDefinitions());
					vueForm.set("fields", fields);

					String vueFormString = Json.pretty(vueForm);
					String outputFile = outputFolder + File.separator + "schema" + File.separator
							+ def.getKey().toLowerCase() + ".json";
					FileUtils.writeStringToFile(new File(outputFile), vueFormString);
					LOGGER.debug("wrote file to " + outputFile);

					// // write example
					// HashMap<String, Object> example = (HashMap<String, Object>)
					// def.getValue().getExample();
					// Map<String, Object> filteredExample = example.entrySet().stream()
					// .filter(e -> inclProps.contains(e.getKey()))
					// .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
					// String exampleString = Json.pretty(filteredExample);
					// outputFile = outputFolder + File.separator + def.getKey() + "Example.json";
					// FileUtils.writeStringToFile(new File(outputFile), exampleString);
					// LOGGER.debug("wrote file to " + outputFile);

				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
	}

	private void addFieldsInfo(Model model, ArrayNode fields, Map<String, Model> models) {
		List<Map<String, String>> uiInfo = (List<Map<String, String>>) model.getVendorExtensions()
				.get(VUE_JS_FORMS_EXTENSION);
		if (uiInfo == null) {
			throw new IllegalStateException("No " + VUE_JS_FORMS_EXTENSION
					+ " vendor extension defined for model with description" + model.getDescription());
		}
		for (Map<String, String> m : uiInfo) {
			String name = m.get("name");
			if (model.getProperties().get(name) == null) {
				throw new IllegalStateException("No property '" + name + "'");
			}
			ObjectNode field = Json.mapper().createObjectNode();
			addFieldInfo(m, model.getProperties().get(name), field, models);
			fields.add(field);
		}
	}

	private void addFieldInfo(Map<String, String> uiInfo, Property prop, ObjectNode field, Map<String, Model> models) {
		String name = uiInfo.get("name");
		// properties that have all fields in common
		field.put("label", StringUtils.capitalize(name));
		field.put("model", name);
		field.put("required", prop.getRequired());

		if (uiInfo.containsKey("id-provider")) {
			field.put("idprovider", uiInfo.get("id-provider"));
		}

		if (prop.getType().equals("string") && prop.getFormat() != null && prop.getFormat().equals("uuid")) {
			UUIDProperty uuidProp = (UUIDProperty) prop;
			// uuid
			addStaticProperties(field, STRING_STATIC_FIELDS);
		} else if (prop.getType().equals("string")) {
			StringProperty stringProp = (StringProperty) prop;
			if (stringProp.getEnum() == null) {
				// simple string
				addStaticProperties(field, STRING_STATIC_FIELDS);
			} else {
				// enum
				addStaticProperties(field, ENUM_STATIC_FIELDS);
				field.put("inputName", name);
				ArrayNode values = Json.mapper().createArrayNode();
				for (String e : stringProp.getEnum()) {
					ObjectNode value = Json.mapper().createObjectNode();
					value.put("id", e);
					value.put("name", StringUtils.capitalize(e));
					values.add(value);
				}
				field.set("values", values);
			}
		} else if (prop.getType().equals("array")) {
			// array
			ArrayProperty arrayProp = (ArrayProperty) prop;
			// add static props
			addStaticProperties(field, ARRAY_STATIC_FIELDS);
			field.put("inputName", name);
			ObjectNode items = Json.mapper().createObjectNode();
			field.set("items", items);
			items.put("type", "object");
			ObjectNode schema = Json.mapper().createObjectNode();
			items.set("schema", schema);
			ArrayNode fields = Json.mapper().createArrayNode();
			schema.set("fields", fields);
			addFieldsInfo(models.get(((RefProperty) arrayProp.getItems()).getSimpleRef()), fields, models);
		} else if (prop.getType().equals("boolean")) {
			addStaticProperties(field, BOOLEAN_STATIC_FIELDS);
		} else if(prop.getType().equals("integer")) {
			addStaticProperties(field, INTEGER_STATIC_FIELDS);
		} else {
			throw new IllegalArgumentException("Type " + prop.getType() + " not supported!");
		}
	}

	private static void addStaticProperties(ObjectNode field, Object[][] staticProps) {
		for (Object[] pair : staticProps) {
			String key = (String) pair[0];
			Object value = pair[1];
			if (value instanceof String) {
				field.put(key, (String) value);
			} else if (value instanceof Boolean) {
				field.put(key, (boolean) value);
			}
		}
	}

	@Override
	public String escapeQuotationMark(String input) {
		// just return the original string
		return input;
	}

	@Override
	public String escapeUnsafeCharacters(String input) {
		// just return the original string
		return input;
	}
}
