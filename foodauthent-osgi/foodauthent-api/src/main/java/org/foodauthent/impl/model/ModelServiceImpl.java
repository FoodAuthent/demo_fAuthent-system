package org.foodauthent.impl.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.foodauthent.api.DiscoveryService;
import org.foodauthent.api.FileService;
import org.foodauthent.api.ModelService;
import org.foodauthent.api.ObjectEventService;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.epcis.EPCISEventService;
import org.foodauthent.impl.file.FakxExporter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.ContentTypeEnum;
import org.foodauthent.model.FileMetadata.TypeEnum;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEvent.ActionEnum;
import org.foodauthent.model.ObjectEvent.ObjectEventBuilder;
import org.foodauthent.model.PublishMetadata;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service = ModelService.class)
public class ModelServiceImpl implements ModelService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private FileService fileService;

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private EPCISEventService epcisEventService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private ObjectEventService objectEventService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private DiscoveryService discoveryService;

    public ModelServiceImpl() {
    }

    @Override
    public UUID createModel(Model model) {
	persistenceService.save(model);
	return model.getFaId();
    }

    @Override
    public Model getModelById(UUID modelId) {
	return persistenceService.getFaModelByUUID(modelId, Model.class);
    }

    @Override
    public ModelPageResult findModelByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Model> res = persistenceService.findByKeywordsPaged(Model.class, pageNumber, pageSize,
		PersistenceService.toArray(keywords));
	return ModelPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public ObjectEvent publishModelById(UUID modelId, PublishMetadata publishMetadata) {
	final FakxExporter exporter = new FakxExporter(persistenceService);
	try {
	    Path tmp = Files.createTempFile(modelId.toString(), ".zip");
	    try {
		final FaObjectSet objectSet = FaObjectSet.builder().setModels(Arrays.asList(modelId)).build();
		exporter.export(objectSet, tmp.toFile());
		final UUID fileUUID = fileService
			.createFileMetadata(FileMetadata.builder().setName("model.fakx").setUploadName("model.fakx")
				.setType(TypeEnum.FAKX).setContentType(ContentTypeEnum.ZIP).build());
		persistenceService.save(new Blob(fileUUID, new FileInputStream(tmp.toFile())));
		ObjectEvent event = buildClassificationEvent(publishMetadata, fileUUID);
		event = persistenceService.save(event);
		final Model model = persistenceService.getFaModelByUUID(modelId, Model.class);
		final List<UUID> modelObjectsEvents = model.getObjecteventIds() == null ? new ArrayList<UUID>()
			: model.getObjecteventIds();
		modelObjectsEvents.add(event.getFaId());
		persistenceService.save(Model.builder(model).setObjecteventIds(modelObjectsEvents).build());
		if (publishMetadata.isEpcis() != null && publishMetadata.isEpcis() && epcisEventService != null) {
		    epcisEventService.publish(event);
		}
		if (publishMetadata.isDiscovery()) {
		    final DiscoveryServiceTransaction trans = objectEventService
			    .convertObjectEventToTransaction(event.getFaId());
		    final List<UUID> transIds = new ArrayList<UUID>(
			    discoveryService.createTransaction(Arrays.asList(trans)));
		    transIds.addAll(event.getTransactionIds());
		    event = persistenceService.save(ObjectEvent.builder(event).setTransactionIds(transIds).build());
		}
		return event;
	    } catch (Exception e) {
		e.printStackTrace();
	    } finally {
		Files.delete(tmp);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    private ObjectEvent buildClassificationEvent(PublishMetadata publishMetadata, UUID fileUUID)
	    throws UnsupportedEncodingException {
	final String sha256 = fileService.getFileSHA256(fileUUID);
	final String bt = "http://api.foodauthent.net/bt/" + fileUUID.toString();
	final ObjectEventBuilder builder = ObjectEvent.builder() //
		.setAction(ActionEnum.ADD) //
		.setBizStep("urn:epcglobal:cbv:bizstep:commissioning") //
		.setEventTime(OffsetDateTime.now()) //
		.setEpcList(Arrays.asList(
			String.format("ni://api.foodauthent.net/sha-256;%s?bt=%s&ffmt=application/zip", sha256, bt)))
		.setDisposition("urn:epcglobal:cbv:disp:active") //
		.setReadPoint("urn:epc:id:sgln:439990230054..0");

	if (publishMetadata.getGtin() != null) {
	    builder.setGtin(publishMetadata.getGtin());
	}
	if (publishMetadata.getBricks() != null) {
	    builder.setBricks(publishMetadata.getBricks());
	}
	if (publishMetadata.getTransactionIds() != null) {
	    builder.setTransactionIds(publishMetadata.getTransactionIds());
	}
	return builder.build();
    }

    @Override
    public void updatedModel(Model model) {
	persistenceService.replace(model);

    }

}
