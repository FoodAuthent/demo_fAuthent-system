package org.foodauthent.ldap.internal;

import java.security.SecureRandom;

import org.apache.directory.api.ldap.model.constants.LdapSecurityConstants;
import org.apache.directory.api.ldap.model.password.PasswordUtil;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.ldap.LdapOperationManager;
import org.ldaptive.AttributeModification;
import org.ldaptive.AttributeModificationType;
import org.ldaptive.Connection;
import org.ldaptive.Credential;
import org.ldaptive.LdapAttribute;
import org.ldaptive.LdapException;
import org.ldaptive.ModifyOperation;
import org.ldaptive.ModifyRequest;
import org.ldaptive.Response;
import org.ldaptive.ResultCode;
import org.ldaptive.extended.PasswordModifyOperation;
import org.ldaptive.extended.PasswordModifyRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import com.foodauthent.api.internal.people.PasswordService;

@Component(service = { PasswordService.class }, scope = ServiceScope.SINGLETON)
public class LdapPasswordServiceImpl implements PasswordService {

	private LdapOperationManager ldapService;

	@Reference(service = LdapOperationManager.class, cardinality = ReferenceCardinality.MANDATORY, unbind = "unbindPooledLdapOperationService")
	public void bindPooledLdapOperationService(final LdapOperationManager ldapService) {
		this.ldapService = ldapService;
	}

	public void unbindPooledLdapOperationService(final LdapOperationManager ldapService) {
		this.ldapService = null;
	}

	public void modifyPassword(final String dn, final String oldPassword, final String newPassword)
			throws UnauthorizedException, ServiceException {
		try {
			Connection conn = ldapService.getConnection();
			try {
				conn.open();
				PasswordModifyOperation modify = new PasswordModifyOperation(conn);
				final Response<Credential> r = modify.execute(
						new PasswordModifyRequest(dn, new Credential(oldPassword), new Credential(newPassword)));
				if (!ResultCode.SUCCESS.equals(r.getResultCode())) {
					throw new UnauthorizedException(r.getMessage());
				}
			} finally {
				conn.close();
			}
		} catch (LdapException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public String generatePassword(final String dn) throws UnauthorizedException, ServiceException {
		return generatePassword(dn, 8);
	}

	public String generatePassword(final String dn, int passwordLength) throws UnauthorizedException, ServiceException {
		if (passwordLength < 6) {
			throw new ServiceException(passwordLength + " is too short");
		}
		final String newPassword = LdapPasswordServiceImpl.createPassword(passwordLength);
		setPassword(dn, newPassword);
		return newPassword;
	}

	public void setPassword(final String dn, String newPassword) throws UnauthorizedException, ServiceException {
		try {
			Connection conn = ldapService.getConnection();
			try {
				conn.open();
				final byte[] b = PasswordUtil.createStoragePassword(newPassword.getBytes(),
						LdapSecurityConstants.HASH_METHOD_SSHA);
				ModifyOperation modify = new ModifyOperation(conn);
				Response<Void> r = modify
						.execute(new ModifyRequest(dn, new AttributeModification(AttributeModificationType.REPLACE,
								new LdapAttribute("userPassword", b))));

				if (!ResultCode.SUCCESS.equals(r.getResultCode())) {
					throw new UnauthorizedException(r.getMessage());
				}
			} finally {
				conn.close();
			}
		} catch (LdapException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	private static final String createPassword(int length) {
		final String allowedChars = "0123456789abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOP!§$%&?*+#";
		SecureRandom random = new SecureRandom();
		StringBuilder pass = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			pass.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
		}
		return pass.toString();
	}
}
