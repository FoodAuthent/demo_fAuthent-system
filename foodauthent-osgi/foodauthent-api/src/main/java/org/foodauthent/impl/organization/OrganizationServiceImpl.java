package org.foodauthent.impl.organization;

import org.foodauthent.api.OrganizationService;
import org.foodauthent.api.internal.exception.EntityNotFoundException;
import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.FAExceptions.EntityAlreadyExistsResponse;
import org.foodauthent.common.exception.FAExceptions.EntityNotFoundResponse;
import org.foodauthent.common.exception.FAExceptions.FAException;
import org.foodauthent.common.exception.FAExceptions.ForbiddenAccessResponse;
import org.foodauthent.common.exception.FAExceptions.InvalidOperationResponse;
import org.foodauthent.common.exception.FAExceptions.UnauthorizedResponse;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.LdapOrganizationalUnitService;
import org.foodauthent.ldap.beans.LdapOrganizationalUnit;
import org.foodauthent.model.Organization;
import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationCreateRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(service = OrganizationService.class, immediate = true)
public class OrganizationServiceImpl implements OrganizationService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private LdapOrganizationalUnitService ldapOrganizationalUnitService;

    @Override
    public Organization createOrganization(OrganizationCreateRequest organizationCreateRequest)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, EntityAlreadyExistsResponse, InvalidOperationResponse,
	    FAException {
	final String dn = "ou=" + organizationCreateRequest.getOrganizationName() + ","
		+ organizationCreateRequest.getParentDn();
	final LdapOrganizationalUnit org = Convert.toLdapOrganizationalUnit(dn, organizationCreateRequest);
	try {
	    return Convert.toRestOrganization(ldapOrganizationalUnitService.add(org));
	} catch (EntityAlreadyExistsException e) {
	    throw new EntityAlreadyExistsResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void deleteOrganization(String dn) throws UnauthorizedResponse, ForbiddenAccessResponse,
	    EntityNotFoundResponse, InvalidOperationResponse, FAException {
	try {
	    ldapOrganizationalUnitService.delete(ldapOrganizationalUnitService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (InvalidOperationException e) {
	    throw new InvalidOperationResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public Organization getOrganization(String dn)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse, FAException {
	try {
	    final LdapOrganizationalUnit org = ldapOrganizationalUnitService.get(dn);
	    return Convert.toRestOrganization(org);
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public Organization updateOrganization(String dn, OrganizationBase organizationBase) throws UnauthorizedResponse,
	    ForbiddenAccessResponse, EntityNotFoundResponse, InvalidOperationResponse, FAException {
	try {
	    final LdapOrganizationalUnit org = Convert.toLdapOrganizationalUnit(dn, organizationBase);
	    return Convert.toRestOrganization(ldapOrganizationalUnitService.update(org));
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

}
