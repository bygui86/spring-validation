package com.rabbit.validationsamples.integrations;

import com.rabbit.validationsamples.dtos.CustomerDto;
import com.rabbit.validationsamples.dtos.CustomerMapDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.Set;


public class CustomerMapDtoDtoValidationIntegrationTest {

	private static Validator validator;

	@BeforeClass
	public static void setup() {

		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void validateCustomerMap_ok() {

		final Set<ConstraintViolation<CustomerMapDto>> violations
				= validator.validate(
				CustomerMapDto.builder()
						.customers(Collections.singletonMap("john@doe.org", new CustomerDto()))
						.build()
		);

		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void validateCustomerMap_error() {

		final Set<ConstraintViolation<CustomerMapDto>> violations
				= validator.validate(
				CustomerMapDto.builder()
						.customers(Collections.singletonMap("john", new CustomerDto()))
						.build()
		);

		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
		Assert.assertEquals(
				"Must be a valid email",
				violations.iterator().next().getMessage());
	}

}
