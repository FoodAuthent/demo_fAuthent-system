package org.foodauthent.fakx;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.foodauthent.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FAKXTest {

	private Archive archive;
	private Path testFile;

	@Before
	public void setup() throws IOException {
		List<SOP> sop = Collections.singletonList(createSop());
		List<Product> product = Collections.singletonList(createProduct());
		List<FileMetadata> metadata = Collections.singletonList(createFileMetadata());
		List<Tag> tag = Collections.singletonList(createTag());
		List<Model> model = Collections.singletonList(createModel(tag));
		List<Prediction> prediction = Collections.singletonList(createPrediction());
		List<Workflow> workflow = Collections.singletonList(createWorkflow(tag));
		List<Fingerprint> fingerprint = Collections.singletonList(createFingerprint());
		List<FingerprintSet> fingerprintSet = Collections.singletonList(createFingerprintSet(fingerprint));

		archive = new Archive.Builder().sop(sop).product(product).metadata(metadata).tag(tag).model(model)
				.prediction(prediction).workflow(workflow).fingerprint(fingerprint).fingerprintset(fingerprintSet)
				.build();

		testFile = Files.createTempFile("archive", ".fakx");
	}

	@After
	public void tearDown() throws IOException {
		Files.delete(testFile);
	}

	@Test
	public void test() throws Exception {

		FAKX.write(archive, testFile);

        try (InputStream stream = Files.newInputStream(testFile)) {
        	archive = FAKX.read(stream);
		}
		
		// Small checks
		assertEquals(1, archive.getSOP().size());
		assertEquals(1, archive.getProduct().size());
		assertEquals(1, archive.getMetadata().size());
		assertEquals(1, archive.getTag().size());
		assertEquals(1, archive.getModel().size());
		assertEquals(1, archive.getPrediction().size());
		assertEquals(1, archive.getWorkflow().size());
		assertEquals(1, archive.getFingerprint().size());
		assertEquals(1, archive.getFingerprintSet().size());
	}

	private static SOP createSop() {
		return SOP.builder().setFaId(UUID.randomUUID()).setFileId(UUID.randomUUID()).setName("name")
				.setDescription("description").setProductId(UUID.randomUUID()).build();
	}

	private static Product createProduct() {
		return Product.builder().setFaId(UUID.randomUUID()).setGtin("gtin").setBrand("brand")
				.setTargetMarket("targetMarket").setLabelDescription("labelDescription").setCompanyName("companyName")
				.setProductClassification("productClassification").setCountryOfOrigin("countryOfOrigin")
				.setRegionOfOriginClaims("regionOfOriginClaims").setComment("comment").build();
	}

	private static FileMetadata createFileMetadata() {
		return FileMetadata.builder().setFaId(UUID.randomUUID()).setType(FileMetadata.TypeEnum.FINGERPRINT_BRUKER)
				.setName("name").setContentType("contentType").setUploadName("uploadName").setDescription("description")
				.setAuthor("author").setDate(LocalDate.now()).setUploadDate(LocalDate.now()).setVersion(0).build();
	}

	private static Tag createTag() {
		return Tag.builder().setFaId(UUID.randomUUID()).setName("name").setDescription("description")
				.setType(Tag.TypeEnum.MODEL).build();
	}

	private static Model createModel(List<Tag> tag) {
		ModelType modelType = ModelType.builder().setName(ModelType.NameEnum.KNIME_PYTHON).build();
		return Model.builder().setFaId(UUID.randomUUID()).setName("name").setDescription("description")
				.setAuthor("author").setDate(LocalDate.now()).setVersion(0).setType(modelType).setTags(tag)
				.setFileId(UUID.randomUUID()).setFingerprintsetIds(Arrays.asList(UUID.randomUUID()))
				.setWorkflowId(UUID.randomUUID()).build();
	}

	private static Prediction createPrediction() {
		return Prediction.builder().setFaId(UUID.randomUUID()).setWorkflowId(UUID.randomUUID())
				.setFingerprintsetId(UUID.randomUUID()).setModelId(UUID.randomUUID()).build();
	}

	private static Workflow createWorkflow(List<Tag> tag) {
		Workflow.RepresentationEnum repr = Workflow.RepresentationEnum.PYTHON;
		Workflow.TypeEnum type = Workflow.TypeEnum.PREDICTION_WORKFLOW;
		WorkflowParameter param = WorkflowParameter.builder().setName("name").setRequired(true)
				.setType(WorkflowParameter.TypeEnum.NUMBER).setValue("0").build();

		// WorkflowIOTypes
		FingerprintType fingerprintsetType = FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER)
				.build();
		ModelType modelType = ModelType.builder().setName(ModelType.NameEnum.KNIME_PYTHON).build();
		WorkflowIOTypes ioTypes = WorkflowIOTypes.builder().setFingerprintType(fingerprintsetType)
				.setModelType(modelType).build();

		return Workflow.builder().setFaId(UUID.randomUUID()).setName("name").setDescription("description")
				.setRepresentation(repr).setType(type).setParameters(Arrays.asList(param)).setTags(tag)
				.setFileId(UUID.randomUUID()).setOutputTypes(ioTypes).setInputTypes(ioTypes).build();
	}

	private static Fingerprint createFingerprint() {
		FingerprintType type = FingerprintType.builder().setName(FingerprintType.NameEnum.BRUKER).build();
		return Fingerprint.builder().setFaId(UUID.randomUUID()).setSampleId(UUID.randomUUID())
				.setType(type)
				.setFileId(UUID.randomUUID()).build();
	}

	private static FingerprintSet createFingerprintSet(List<Fingerprint> fingerprint) {
		return FingerprintSet.builder().setFaId(UUID.randomUUID())
				.setFingerprintIds(fingerprint.stream().map(f -> f.getFaId()).collect(Collectors.toList()))
				.setName("name").build();
	}
}
