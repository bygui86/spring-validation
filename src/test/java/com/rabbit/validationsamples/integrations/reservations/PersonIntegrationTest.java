package com.rabbit.validationsamples.integrations.reservations;

import com.rabbit.validationsamples.dtos.PersonDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.util.Set;


public class PersonIntegrationTest {

	private static ExecutableValidator executableValidator;

	@BeforeClass
	public static void getExecutableValidator() {

		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		executableValidator = factory.getValidator().forExecutables();
	}

	@Test
	public void validationPerson_ok() throws NoSuchMethodException {

		final Constructor<PersonDto> constructor = PersonDto.class.getConstructor(String.class, String.class);
		final Object[] parameterValues = {"Matteo", "Baiguini"};
		final Set<ConstraintViolation<PersonDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);

		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void validationPerson_firstNameError() throws NoSuchMethodException {

		final Constructor<PersonDto> constructor = PersonDto.class.getConstructor(String.class, String.class);
		final Object[] parameterValues = {"John", "Baiguini"};
		final Set<ConstraintViolation<PersonDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);

		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
	}

	@Test
	public void validationPerson_lastNameError() throws NoSuchMethodException {

		final Constructor<PersonDto> constructor = PersonDto.class.getConstructor(String.class, String.class);
		final Object[] parameterValues = {"Matteo", "Doe"};
		final Set<ConstraintViolation<PersonDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);

		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
	}

	@Test
	public void validationPerson_multipleErrors() throws NoSuchMethodException {

		final Constructor<PersonDto> constructor = PersonDto.class.getConstructor(String.class, String.class);
		final Object[] parameterValues = {"John", "Doe"};
		final Set<ConstraintViolation<PersonDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);

		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(2, violations.size());
	}

}
