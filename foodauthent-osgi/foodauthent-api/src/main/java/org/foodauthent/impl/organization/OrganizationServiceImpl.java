package org.foodauthent.impl.organization;

import org.foodauthent.api.OrganizationService;
import org.foodauthent.api.internal.exception.EntityNotFoundException;
import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.FAExceptions.ModelAlreadyExistsResponse;
import org.foodauthent.common.exception.FAExceptions.ModelNotFoundResponse;
import org.foodauthent.common.exception.FAExceptions.FAException;
import org.foodauthent.common.exception.FAExceptions.ForbiddenAccessResponse;
import org.foodauthent.common.exception.FAExceptions.InvalidOperationResponse;
import org.foodauthent.common.exception.FAExceptions.UnauthorizedResponse;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.model.Organization;
import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationCreateRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.foodauthent.api.internal.people.OrganizationalUnitService;

@Component(service = OrganizationService.class, immediate = true)
public class OrganizationServiceImpl implements OrganizationService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private OrganizationalUnitService<org.foodauthent.people.Organization> organizationalUnitService;

    @Override
    public Organization createOrganization(OrganizationCreateRequest organizationCreateRequest)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, ModelAlreadyExistsResponse, InvalidOperationResponse,
	    FAException {
	final String dn = "ou=" + organizationCreateRequest.getOrganizationName() + ","
		+ organizationCreateRequest.getParentDn();
	final org.foodauthent.people.Organization org = Convert.toOrganization(dn, organizationCreateRequest, organizationalUnitService);
	try {
	    return Convert.toRestOrganization(organizationalUnitService.add(org));
	} catch (EntityAlreadyExistsException e) {
	    throw new ModelAlreadyExistsResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void deleteOrganization(String dn) throws UnauthorizedResponse, ForbiddenAccessResponse,
	    ModelNotFoundResponse, InvalidOperationResponse, FAException {
	try {
	    organizationalUnitService.delete(organizationalUnitService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (InvalidOperationException e) {
	    throw new InvalidOperationResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public Organization getOrganization(String dn)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse, FAException {
	try {
	    final org.foodauthent.people.Organization org = organizationalUnitService.get(dn);
	    return Convert.toRestOrganization(org);
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public Organization updateOrganization(String dn, OrganizationBase organizationBase) throws UnauthorizedResponse,
	    ForbiddenAccessResponse, ModelNotFoundResponse, InvalidOperationResponse, FAException {
	try {
	    final org.foodauthent.people.Organization org = Convert.toOrganization(dn, organizationBase, organizationalUnitService);
	    return Convert.toRestOrganization(organizationalUnitService.update(org));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

}
