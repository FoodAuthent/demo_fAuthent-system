package org.foodauthent.auth.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityScheme {

	/**
	 * The name identifying this security scheme
	 *
	 * @return String values
	 **/
	String[] value() default "";
}
