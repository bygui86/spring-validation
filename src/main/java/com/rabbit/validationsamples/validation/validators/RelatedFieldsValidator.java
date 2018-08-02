package com.rabbit.validationsamples.validation.validators;

import com.rabbit.validationsamples.validation.constraints.RelatedFieldsConstraint;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * This Validator is generic (Object) in order to be flexible and potentially used to validate also complex objects.
 */
public class RelatedFieldsValidator implements ConstraintValidator<RelatedFieldsConstraint, Object> {

	private String field;

	private String fieldMatch;

	@Override
	public void initialize(final RelatedFieldsConstraint constraintAnnotation) {

		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
	}

	/**
	 * This method contains the actual validation logic.
	 * <p>
	 * This method retrieves the values of the two fields and checks if they are equal.
	 *
	 * @param objForm
	 * @param context
	 */
	@Override
	public boolean isValid(final Object objForm, final ConstraintValidatorContext context) {

		final Object fieldValue = new BeanWrapperImpl(objForm).getPropertyValue(field);
		final Object fieldMatchValue = new BeanWrapperImpl(objForm).getPropertyValue(fieldMatch);

		if (fieldValue != null) {
			return fieldValue.equals(fieldMatchValue);
		} else {
			return fieldMatchValue == null;
		}
	}

}
