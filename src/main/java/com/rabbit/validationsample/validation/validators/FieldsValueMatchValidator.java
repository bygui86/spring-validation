package com.rabbit.validationsample.validation.validators;

import com.rabbit.validationsample.validation.constraints.FieldsValueMatch;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

	private String field;

	private String fieldMatch;

	@Override
	public void initialize(final FieldsValueMatch constraintAnnotation) {

		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
	}

	/**
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
