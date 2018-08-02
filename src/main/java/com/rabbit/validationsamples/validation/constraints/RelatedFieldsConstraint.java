package com.rabbit.validationsamples.validation.constraints;

import com.rabbit.validationsamples.validation.validators.RelatedFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * This annotation will have two parameters field and fieldMatch that represent the names of the fields to compare.
 * <p>
 * This also contains a List sub-interface for defining multiple FieldsValueMatch annotations on a class.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
// With the @Constraint annotation, we defined the class that is going to validate our field
@Constraint(validatedBy = RelatedFieldsValidator.class)
public @interface RelatedFieldsConstraint {

	String field();

	String fieldMatch();

	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {

		RelatedFieldsConstraint[] value();
	}

	/*
		These three properties are mandatory for constraint annotations:
			. message – returns the default key for creating error messages, this enables the usage of message interpolation
			. groups – allows to specify validation groups for constraints
			. payload – can be used by clients of the Bean Validation API to assign custom payload objects to a constraint
	*/

	String message() default "Fields values don't match!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
