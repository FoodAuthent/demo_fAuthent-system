package org.foodauthent.auth.security;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecuritySchemeUtil {

	public static final Set<String> getSecuritySchemeNames(final Class<?> cls, final Method resourceMethod) {
		final Set<String> schemes = new HashSet<String>();
		final SecurityScheme securityScheme = resourceMethod.getAnnotation(SecurityScheme.class);
		schemes.addAll(getSecuritySchemeNames(securityScheme));
		if (securityScheme == null) {
			for (Class<?> in : cls.getInterfaces()) {
				try {
					final Method m = in.getMethod(resourceMethod.getName(), resourceMethod.getParameterTypes());
					if (m != null) {
						schemes.addAll(getSecuritySchemeNames(m.getAnnotation(SecurityScheme.class)));
					}
				} catch (Exception e) {
					// ignore
				}
			}
		}
		return schemes;
	}

	public static List<String> getSecuritySchemeNames(final SecurityScheme securityScheme) {
		if (securityScheme != null) {
			return Arrays.asList(securityScheme.value());
		}
		return Collections.emptyList();
	}

}
