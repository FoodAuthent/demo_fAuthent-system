package org.foodauthent.impl.custommetadata;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.IOUtils;
import org.foodauthent.api.CustomMetadataService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

/**
 *
 *
 */
@Component(service = CustomMetadataService.class)
public class CustomMetadataServiceImpl implements CustomMetadataService {

    private PersistenceService persistenceService;

    private ObjectMapper mapper = new ObjectMapper();
    
    public CustomMetadataServiceImpl() {
    }

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	this.persistenceService = persistenceService;
    }

    @Override
    public String getCustomMetadata(String modelId, String schemaId, UUID faId) {
	// TODO check returned type/schema id
	JsonNode jsonNode = persistenceService.getCustomModelByUUID(modelId, schemaId, faId);
	try {
	    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
	} catch (JsonProcessingException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    @Override
    public String getCustomMetadataSchema(String modelId, String schemaId) {
	URL url = this.getClass().getResource("/json-schemas/" + modelId + "/" + schemaId + ".json");
	try {
	    return IOUtils.toString(url, StandardCharsets.UTF_8);
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<String> getCustomMetadataSchemas(String modelId) {
	URL url = this.getClass().getResource("/json-schemas/" + modelId + "/registry.json");
	try {
	    return mapper.readValue(url.openStream(), List.class);
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    @Override
    public void saveCustomMetadata(String modelId, String schemaId, UUID faId, String body) {
	try {
	    final JsonNode jsonNode = mapper.readTree(body);
	    final JsonNode schemaNode = mapper.readValue(getCustomMetadataSchema(modelId, schemaId), JsonNode.class);
	    final JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
	    final ProcessingReport report = schema.validate(jsonNode);
	    if (!report.isSuccess()) {
		throw new RuntimeException(report.toString());
	    }
	    persistenceService.saveCustomModel(modelId, schemaId, faId, jsonNode);
	} catch (Exception e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

}
