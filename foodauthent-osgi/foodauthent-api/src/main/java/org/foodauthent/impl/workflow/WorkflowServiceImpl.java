package org.foodauthent.impl.workflow;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

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
import java.util.stream.Collectors;

import org.foodauthent.api.DiscoveryService;
import org.foodauthent.api.FileService;
import org.foodauthent.api.ObjectEventService;
import org.foodauthent.api.WorkflowService;
import org.foodauthent.api.internal.job.JobService;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.epcis.EPCISEventService;
import org.foodauthent.impl.file.FakxExporter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.ContentTypeEnum;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEvent.ActionEnum;
import org.foodauthent.model.ObjectEvent.ObjectEventBuilder;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.PublishMetadata;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.TypeEnum;
import org.foodauthent.model.WorkflowPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service = WorkflowService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class WorkflowServiceImpl implements WorkflowService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private JobService jobService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private FileService fileService;

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private EPCISEventService epcisEventService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private ObjectEventService objectEventService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private DiscoveryService discoveryService;
    
    public WorkflowServiceImpl() {
    }

    @Override
    public PredictionJob createPredictionJob(final UUID workflowId, final UUID fingerprintSetId, UUID modelId,
	    Boolean async) throws InitJobException {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId, Workflow.class);
	final FingerprintSet fingerprint = persistenceService.getFaModelByUUID(fingerprintSetId, FingerprintSet.class);
	final Model model = persistenceService.getFaModelByUUID(modelId, Model.class);
	final PredictionJob job = jobService.createNewPredictionJob(workflow, fingerprint, model, async);
	return job;
    }

    @Override
    public TrainingJob createTrainingJob(final UUID workflowId, final List<UUID> fingerprintSetIds, Boolean async)
	    throws InitJobException {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId, Workflow.class);
	List<FingerprintSet> fingerprintSets = fingerprintSetIds.stream()
		.map(uuid -> persistenceService.getFaModelByUUID(uuid, FingerprintSet.class))
		.collect(Collectors.toList());
	final TrainingJob job = jobService.createNewTrainingJob(workflow, fingerprintSets, async);
	return job;
    }

    @Override
    public PredictionJob getPredictionJob(final UUID jobId) {
	return persistenceService.getFaModelByUUID(jobId, PredictionJob.class);
    }

    @Override
    public Prediction getPredictionResult(final UUID predictionId) {
	return persistenceService.getFaModelByUUID(predictionId, Prediction.class);
    }

    @Override
    public TrainingJob getTrainingJob(final UUID jobId) {
	return persistenceService.getFaModelByUUID(jobId, TrainingJob.class);
    }

    @Override
    public Workflow getWorkflowById(final UUID workflowId) {
	return persistenceService.getFaModelByUUID(workflowId, Workflow.class);
    }

    @Override
    public UUID createWorkflow(final Workflow workflow) {
	persistenceService.save(workflow);
	return workflow.getFaId();
    }

    @Override
    public WorkflowPageResult findWorkflowByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Workflow> res = persistenceService.findByKeywordsPaged(Workflow.class, pageNumber, pageSize,
		toArray(keywords));
	return WorkflowPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public PredictionPageResult findPredictionByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Prediction> res = persistenceService.findByKeywordsPaged(Prediction.class, pageNumber, pageSize,
		toArray(keywords));
	return PredictionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public PredictionJobPageResult findPredictionJobs(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<PredictionJob> res = persistenceService.findByKeywordsPaged(PredictionJob.class, pageNumber,
		pageSize, toArray(keywords));
	return PredictionJobPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public WorkflowPageResult findPredictionWorkflows(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Workflow> res = persistenceService.findByKeywordsPaged(Workflow.class, pageNumber, pageSize,
		toArray(keywords), toArray(TypeEnum.PREDICTION_WORKFLOW_E680F8C1.toString()));
	return WorkflowPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public TrainingJobPageResult findTrainingJobs(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<TrainingJob> res = persistenceService.findByKeywordsPaged(TrainingJob.class, pageNumber, pageSize,
		toArray(keywords));
	return TrainingJobPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public WorkflowPageResult findTrainingWorkflows(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Workflow> res = persistenceService.findByKeywordsPaged(Workflow.class, pageNumber, pageSize,
		toArray(keywords), toArray(TypeEnum.TRAINING_WORKFLOW_64B046CB.toString()));
	return WorkflowPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public PredictionPageResult findPredictionsByFingerprintSetId(UUID fingerprintsetId, Integer pageNumber,
	    Integer pageSize, List<String> keywords) {
	ResultPage<Prediction> res = persistenceService.findByKeywordsPaged(Prediction.class, pageNumber, pageSize,
		toArray(keywords), toArray(fingerprintsetId.toString()));
	return PredictionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
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
	return builder.build();
    }

    @Override
    public ObjectEvent publishPredictionResult(UUID predictionId, Boolean sellable, PublishMetadata publishMetadata) {
	final FakxExporter exporter = new FakxExporter(persistenceService);
	try {
	    Path tmp = Files.createTempFile(predictionId.toString(), ".zip");
	    try {
		final FaObjectSet objectSet = FaObjectSet.builder().setPredictions(Arrays.asList(predictionId)).build();
		exporter.export(objectSet, tmp.toFile());
		final UUID fileUUID = fileService.createFileMetadata(FileMetadata.builder().setName("model.fakx")
			.setUploadName("model.fakx").setType(org.foodauthent.model.FileMetadata.TypeEnum.FAKX)
			.setContentType(ContentTypeEnum.ZIP).build());
		persistenceService.save(new Blob(fileUUID, new FileInputStream(tmp.toFile())));
		ObjectEvent event = buildClassificationEvent(publishMetadata, fileUUID);
		event = persistenceService.save(event);
		final Prediction prediction = persistenceService.getFaModelByUUID(predictionId, Prediction.class);
		final List<UUID> predictionObjectsEvents = prediction.getObjecteventIds() == null ? new ArrayList<UUID>()
			: prediction.getObjecteventIds();
		predictionObjectsEvents.add(event.getFaId());
		persistenceService.save(Prediction.builder(prediction).setObjecteventIds(predictionObjectsEvents).build());
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
<<<<<<< HEAD

=======
>>>>>>> ff5442a7cd8441c7cc88c0b6c4bd0b410cb5b020
}
