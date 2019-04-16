/*
 * TODO	
 */
package org.foodauthent.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.foodauthent.model.*;
import org.foodauthent.model.json.mixin.*;

/**
 * TODO
 
 * @author Martin Horn, University of Konstanz
 */
public class ModelUtil {

    private ModelUtil() {
        //utility class
    }

    /**
     * TODO
     */
    public static final void addModelMixIns(final ObjectMapper mapper) {
    
        mapper.addMixIn(BizTransaction.class, BizTransactionMixIn.class);
        mapper.addMixIn(BizTransaction.BizTransactionBuilder.class, BizTransactionMixIn.BizTransactionMixInBuilder.class);
        mapper.addMixIn(ChangePasswordRequest.class, ChangePasswordRequestMixIn.class);
        mapper.addMixIn(ChangePasswordRequest.ChangePasswordRequestBuilder.class, ChangePasswordRequestMixIn.ChangePasswordRequestMixInBuilder.class);
        mapper.addMixIn(DiscoveryServiceTransaction.class, DiscoveryServiceTransactionMixIn.class);
        mapper.addMixIn(DiscoveryServiceTransaction.DiscoveryServiceTransactionBuilder.class, DiscoveryServiceTransactionMixIn.DiscoveryServiceTransactionMixInBuilder.class);
        mapper.addMixIn(DiscoveryServiceTransactionPageResult.class, DiscoveryServiceTransactionPageResultMixIn.class);
        mapper.addMixIn(DiscoveryServiceTransactionPageResult.DiscoveryServiceTransactionPageResultBuilder.class, DiscoveryServiceTransactionPageResultMixIn.DiscoveryServiceTransactionPageResultMixInBuilder.class);
        mapper.addMixIn(Epc.class, EpcMixIn.class);
        mapper.addMixIn(Epc.EpcBuilder.class, EpcMixIn.EpcMixInBuilder.class);
        mapper.addMixIn(FaObjectSet.class, FaObjectSetMixIn.class);
        mapper.addMixIn(FaObjectSet.FaObjectSetBuilder.class, FaObjectSetMixIn.FaObjectSetMixInBuilder.class);
        mapper.addMixIn(FileMetadata.class, FileMetadataMixIn.class);
        mapper.addMixIn(FileMetadata.FileMetadataBuilder.class, FileMetadataMixIn.FileMetadataMixInBuilder.class);
        mapper.addMixIn(Fingerprint.class, FingerprintMixIn.class);
        mapper.addMixIn(Fingerprint.FingerprintBuilder.class, FingerprintMixIn.FingerprintMixInBuilder.class);
        mapper.addMixIn(FingerprintSet.class, FingerprintSetMixIn.class);
        mapper.addMixIn(FingerprintSet.FingerprintSetBuilder.class, FingerprintSetMixIn.FingerprintSetMixInBuilder.class);
        mapper.addMixIn(FingerprintSetPageResult.class, FingerprintSetPageResultMixIn.class);
        mapper.addMixIn(FingerprintSetPageResult.FingerprintSetPageResultBuilder.class, FingerprintSetPageResultMixIn.FingerprintSetPageResultMixInBuilder.class);
        mapper.addMixIn(FingerprintType.class, FingerprintTypeMixIn.class);
        mapper.addMixIn(FingerprintType.FingerprintTypeBuilder.class, FingerprintTypeMixIn.FingerprintTypeMixInBuilder.class);
        mapper.addMixIn(GPCAttribute.class, GPCAttributeMixIn.class);
        mapper.addMixIn(GPCAttribute.GPCAttributeBuilder.class, GPCAttributeMixIn.GPCAttributeMixInBuilder.class);
        mapper.addMixIn(GPCAttributeValue.class, GPCAttributeValueMixIn.class);
        mapper.addMixIn(GPCAttributeValue.GPCAttributeValueBuilder.class, GPCAttributeValueMixIn.GPCAttributeValueMixInBuilder.class);
        mapper.addMixIn(GPCBrick.class, GPCBrickMixIn.class);
        mapper.addMixIn(GPCBrick.GPCBrickBuilder.class, GPCBrickMixIn.GPCBrickMixInBuilder.class);
        mapper.addMixIn(ImportResult.class, ImportResultMixIn.class);
        mapper.addMixIn(ImportResult.ImportResultBuilder.class, ImportResultMixIn.ImportResultMixInBuilder.class);
        mapper.addMixIn(Model.class, ModelMixIn.class);
        mapper.addMixIn(Model.ModelBuilder.class, ModelMixIn.ModelMixInBuilder.class);
        mapper.addMixIn(ModelPageResult.class, ModelPageResultMixIn.class);
        mapper.addMixIn(ModelPageResult.ModelPageResultBuilder.class, ModelPageResultMixIn.ModelPageResultMixInBuilder.class);
        mapper.addMixIn(ModelType.class, ModelTypeMixIn.class);
        mapper.addMixIn(ModelType.ModelTypeBuilder.class, ModelTypeMixIn.ModelTypeMixInBuilder.class);
        mapper.addMixIn(ObjectEvent.class, ObjectEventMixIn.class);
        mapper.addMixIn(ObjectEvent.ObjectEventBuilder.class, ObjectEventMixIn.ObjectEventMixInBuilder.class);
        mapper.addMixIn(ObjectEventPageResult.class, ObjectEventPageResultMixIn.class);
        mapper.addMixIn(ObjectEventPageResult.ObjectEventPageResultBuilder.class, ObjectEventPageResultMixIn.ObjectEventPageResultMixInBuilder.class);
        mapper.addMixIn(OrganizationBase.class, OrganizationBaseMixIn.class);
        mapper.addMixIn(OrganizationBase.OrganizationBaseBuilder.class, OrganizationBaseMixIn.OrganizationBaseMixInBuilder.class);
        mapper.addMixIn(OrganizationCreateRequest.class, OrganizationCreateRequestMixIn.class);
        mapper.addMixIn(OrganizationCreateRequest.OrganizationCreateRequestBuilder.class, OrganizationCreateRequestMixIn.OrganizationCreateRequestMixInBuilder.class);
        mapper.addMixIn(Organization.class, OrganizationMixIn.class);
        mapper.addMixIn(Organization.OrganizationBuilder.class, OrganizationMixIn.OrganizationMixInBuilder.class);
        mapper.addMixIn(OrganizationalPostalAddress.class, OrganizationalPostalAddressMixIn.class);
        mapper.addMixIn(OrganizationalPostalAddress.OrganizationalPostalAddressBuilder.class, OrganizationalPostalAddressMixIn.OrganizationalPostalAddressMixInBuilder.class);
        mapper.addMixIn(PostalAddress.class, PostalAddressMixIn.class);
        mapper.addMixIn(PostalAddress.PostalAddressBuilder.class, PostalAddressMixIn.PostalAddressMixInBuilder.class);
        mapper.addMixIn(PredictionInstance.class, PredictionInstanceMixIn.class);
        mapper.addMixIn(PredictionInstance.PredictionInstanceBuilder.class, PredictionInstanceMixIn.PredictionInstanceMixInBuilder.class);
        mapper.addMixIn(PredictionJob.class, PredictionJobMixIn.class);
        mapper.addMixIn(PredictionJob.PredictionJobBuilder.class, PredictionJobMixIn.PredictionJobMixInBuilder.class);
        mapper.addMixIn(PredictionJobPageResult.class, PredictionJobPageResultMixIn.class);
        mapper.addMixIn(PredictionJobPageResult.PredictionJobPageResultBuilder.class, PredictionJobPageResultMixIn.PredictionJobPageResultMixInBuilder.class);
        mapper.addMixIn(Prediction.class, PredictionMixIn.class);
        mapper.addMixIn(Prediction.PredictionBuilder.class, PredictionMixIn.PredictionMixInBuilder.class);
        mapper.addMixIn(PredictionPageResult.class, PredictionPageResultMixIn.class);
        mapper.addMixIn(PredictionPageResult.PredictionPageResultBuilder.class, PredictionPageResultMixIn.PredictionPageResultMixInBuilder.class);
        mapper.addMixIn(PredictionWorkflowInput.class, PredictionWorkflowInputMixIn.class);
        mapper.addMixIn(PredictionWorkflowInput.PredictionWorkflowInputBuilder.class, PredictionWorkflowInputMixIn.PredictionWorkflowInputMixInBuilder.class);
        mapper.addMixIn(PredictionWorkflowOutput.class, PredictionWorkflowOutputMixIn.class);
        mapper.addMixIn(PredictionWorkflowOutput.PredictionWorkflowOutputBuilder.class, PredictionWorkflowOutputMixIn.PredictionWorkflowOutputMixInBuilder.class);
        mapper.addMixIn(ProductIngredientStatement.class, ProductIngredientStatementMixIn.class);
        mapper.addMixIn(ProductIngredientStatement.ProductIngredientStatementBuilder.class, ProductIngredientStatementMixIn.ProductIngredientStatementMixInBuilder.class);
        mapper.addMixIn(Product.class, ProductMixIn.class);
        mapper.addMixIn(Product.ProductBuilder.class, ProductMixIn.ProductMixInBuilder.class);
        mapper.addMixIn(ProductPageResult.class, ProductPageResultMixIn.class);
        mapper.addMixIn(ProductPageResult.ProductPageResultBuilder.class, ProductPageResultMixIn.ProductPageResultMixInBuilder.class);
        mapper.addMixIn(QuantityElement.class, QuantityElementMixIn.class);
        mapper.addMixIn(QuantityElement.QuantityElementBuilder.class, QuantityElementMixIn.QuantityElementMixInBuilder.class);
        mapper.addMixIn(SOP.class, SOPMixIn.class);
        mapper.addMixIn(SOP.SOPBuilder.class, SOPMixIn.SOPMixInBuilder.class);
        mapper.addMixIn(SOPPageResult.class, SOPPageResultMixIn.class);
        mapper.addMixIn(SOPPageResult.SOPPageResultBuilder.class, SOPPageResultMixIn.SOPPageResultMixInBuilder.class);
        mapper.addMixIn(Sample.class, SampleMixIn.class);
        mapper.addMixIn(Sample.SampleBuilder.class, SampleMixIn.SampleMixInBuilder.class);
        mapper.addMixIn(SamplePageResult.class, SamplePageResultMixIn.class);
        mapper.addMixIn(SamplePageResult.SamplePageResultBuilder.class, SamplePageResultMixIn.SamplePageResultMixInBuilder.class);
        mapper.addMixIn(SystemInfo.class, SystemInfoMixIn.class);
        mapper.addMixIn(SystemInfo.SystemInfoBuilder.class, SystemInfoMixIn.SystemInfoMixInBuilder.class);
        mapper.addMixIn(Tag.class, TagMixIn.class);
        mapper.addMixIn(Tag.TagBuilder.class, TagMixIn.TagMixInBuilder.class);
        mapper.addMixIn(TagPageResult.class, TagPageResultMixIn.class);
        mapper.addMixIn(TagPageResult.TagPageResultBuilder.class, TagPageResultMixIn.TagPageResultMixInBuilder.class);
        mapper.addMixIn(TrainingJob.class, TrainingJobMixIn.class);
        mapper.addMixIn(TrainingJob.TrainingJobBuilder.class, TrainingJobMixIn.TrainingJobMixInBuilder.class);
        mapper.addMixIn(TrainingJobPageResult.class, TrainingJobPageResultMixIn.class);
        mapper.addMixIn(TrainingJobPageResult.TrainingJobPageResultBuilder.class, TrainingJobPageResultMixIn.TrainingJobPageResultMixInBuilder.class);
        mapper.addMixIn(TrainingWorkflowInputFingerprint.class, TrainingWorkflowInputFingerprintMixIn.class);
        mapper.addMixIn(TrainingWorkflowInputFingerprint.TrainingWorkflowInputFingerprintBuilder.class, TrainingWorkflowInputFingerprintMixIn.TrainingWorkflowInputFingerprintMixInBuilder.class);
        mapper.addMixIn(TrainingWorkflowInput.class, TrainingWorkflowInputMixIn.class);
        mapper.addMixIn(TrainingWorkflowInput.TrainingWorkflowInputBuilder.class, TrainingWorkflowInputMixIn.TrainingWorkflowInputMixInBuilder.class);
        mapper.addMixIn(TrainingWorkflowOutput.class, TrainingWorkflowOutputMixIn.class);
        mapper.addMixIn(TrainingWorkflowOutput.TrainingWorkflowOutputBuilder.class, TrainingWorkflowOutputMixIn.TrainingWorkflowOutputMixInBuilder.class);
        mapper.addMixIn(UserAuthenticationRequest.class, UserAuthenticationRequestMixIn.class);
        mapper.addMixIn(UserAuthenticationRequest.UserAuthenticationRequestBuilder.class, UserAuthenticationRequestMixIn.UserAuthenticationRequestMixInBuilder.class);
        mapper.addMixIn(UserBase.class, UserBaseMixIn.class);
        mapper.addMixIn(UserBase.UserBaseBuilder.class, UserBaseMixIn.UserBaseMixInBuilder.class);
        mapper.addMixIn(UserCreateRequest.class, UserCreateRequestMixIn.class);
        mapper.addMixIn(UserCreateRequest.UserCreateRequestBuilder.class, UserCreateRequestMixIn.UserCreateRequestMixInBuilder.class);
        mapper.addMixIn(UserGroupBase.class, UserGroupBaseMixIn.class);
        mapper.addMixIn(UserGroupBase.UserGroupBaseBuilder.class, UserGroupBaseMixIn.UserGroupBaseMixInBuilder.class);
        mapper.addMixIn(UserGroupCreateRequest.class, UserGroupCreateRequestMixIn.class);
        mapper.addMixIn(UserGroupCreateRequest.UserGroupCreateRequestBuilder.class, UserGroupCreateRequestMixIn.UserGroupCreateRequestMixInBuilder.class);
        mapper.addMixIn(UserGroup.class, UserGroupMixIn.class);
        mapper.addMixIn(UserGroup.UserGroupBuilder.class, UserGroupMixIn.UserGroupMixInBuilder.class);
        mapper.addMixIn(User.class, UserMixIn.class);
        mapper.addMixIn(User.UserBuilder.class, UserMixIn.UserMixInBuilder.class);
        mapper.addMixIn(WorkflowIOTypes.class, WorkflowIOTypesMixIn.class);
        mapper.addMixIn(WorkflowIOTypes.WorkflowIOTypesBuilder.class, WorkflowIOTypesMixIn.WorkflowIOTypesMixInBuilder.class);
        mapper.addMixIn(Workflow.class, WorkflowMixIn.class);
        mapper.addMixIn(Workflow.WorkflowBuilder.class, WorkflowMixIn.WorkflowMixInBuilder.class);
        mapper.addMixIn(WorkflowPageResult.class, WorkflowPageResultMixIn.class);
        mapper.addMixIn(WorkflowPageResult.WorkflowPageResultBuilder.class, WorkflowPageResultMixIn.WorkflowPageResultMixInBuilder.class);
        mapper.addMixIn(WorkflowParameter.class, WorkflowParameterMixIn.class);
        mapper.addMixIn(WorkflowParameter.WorkflowParameterBuilder.class, WorkflowParameterMixIn.WorkflowParameterMixInBuilder.class);
    	
    }
}
