package com.rabbit.validationsamples.javabean;

import com.rabbit.validationsamples.javabean.dtos.CustomerDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;


public class CustomerDtoValidationIntegrationTest {

	private static Validator validator;

	@BeforeClass
	public static void setup() {

		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void validateCustomer_ok() {

		final Set<ConstraintViolation<CustomerDto>> violations =
				validator.validate(
						CustomerDto.builder()
								.addresses(Collections.singletonList("1st Ave, NY"))
								.dateOfBirth(LocalDate.of(1980, 5, 20))
								.build()
				);
		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void validateCustomer_noDateOfBirthOk() {

		final Set<ConstraintViolation<CustomerDto>> violations =
				validator.validate(
						CustomerDto.builder()
								.addresses(Collections.singletonList("1st Ave, NY"))
								.build()
				);
		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void validateCustomer_dateOfBirthError() {

		final Set<ConstraintViolation<CustomerDto>> violations =
				validator.validate(
						CustomerDto.builder()
								.addresses(Collections.singletonList("1st Ave, NY"))
								.dateOfBirth(LocalDate.of(2021, 5, 20))
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(violations.size(), 1);
	}

	@Test
	public void validateCustomer_addressesError() {

		final Set<ConstraintViolation<CustomerDto>> violations =
				validator.validate(
						CustomerDto.builder()
								.addresses(Collections.singletonList(" "))
								.dateOfBirth(LocalDate.of(1980, 5, 20))
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(violations.size(), 1);
	}

	@Test
	public void validateCustomer_mutipleErrors() {

		final Set<ConstraintViolation<CustomerDto>> violations =
				validator.validate(
						CustomerDto.builder()
								.addresses(Collections.singletonList(" "))
								.dateOfBirth(LocalDate.of(2021, 5, 20))
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(violations.size(), 2);
	}

}
