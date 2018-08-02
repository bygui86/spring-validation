package com.rabbit.validationsamples.integrations.reservations;

import javax.validation.executable.ExecutableValidator;


// TODO to be finished, not validating on constructor
public class ReservationIntegrationTest {

	private static ExecutableValidator executableValidator;

	// @BeforeClass
	// public static void getExecutableValidator() {
	//
	// 	final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	// 	executableValidator = factory.getValidator().forExecutables();
	// }

	// @Test
	// public void validationReservation_ok() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("Matteo")
	// 			.lastName("Baiguini")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"001", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 8, 2), 1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	Assert.assertTrue(violations.isEmpty());
	// }

	// @Test
	// public void validationReservation_idError() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("Matteo")
	// 			.lastName("Baiguini")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 8, 2), 1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	System.out.println("Violations empty: " + violations.isEmpty());
	//
	// 	Assert.assertFalse(violations.isEmpty());
	// 	Assert.assertEquals(1, violations.size());
	// }

	// @Test
	// public void validationReservation_beginError() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("Matteo")
	// 			.lastName("Baiguini")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"001", LocalDate.of(2017, 8, 1), LocalDate.of(2021, 8, 2), 1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	System.out.println("Violations empty: " + violations.isEmpty());
	//
	// 	Assert.assertFalse(violations.isEmpty());
	// 	Assert.assertEquals(1, violations.size());
	// }

	// @Test
	// public void validationReservation_endError() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("Matteo")
	// 			.lastName("Baiguini")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"001", LocalDate.of(2021, 8, 1), LocalDate.of(2017, 8, 2), 1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	System.out.println("Violations empty: " + violations.isEmpty());
	//
	// 	Assert.assertFalse(violations.isEmpty());
	// 	Assert.assertEquals(1, violations.size());
	// }

	// @Test
	// public void validationReservation_roomError() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("Matteo")
	// 			.lastName("Baiguini")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"001", LocalDate.of(2021, 8, 1), LocalDate.of(2017, 8, 2), -1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	System.out.println("Violations empty: " + violations.isEmpty());
	//
	// 	Assert.assertFalse(violations.isEmpty());
	// 	Assert.assertEquals(1, violations.size());
	// }

	// @Test
	// public void validationReservation_personError() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("John")
	// 			.lastName("Doe")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"001", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 8, 2), 1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	System.out.println("Violations empty: " + violations.isEmpty());
	//
	// 	Assert.assertFalse(violations.isEmpty());
	// 	Assert.assertEquals(1, violations.size());
	// }

	// @Test
	// public void validationReservation_multipleError() throws NoSuchMethodException {
	//
	// 	final Constructor<ReservationDto> constructor =
	// 			ReservationDto.class.getConstructor(String.class, LocalDate.class, LocalDate.class, Integer.TYPE, PersonDto.class);
	// 	final PersonDto person = PersonDto.builder()
	// 			.firstName("John")
	// 			.lastName("Doe")
	// 			.build();
	// 	final Object[] parameterValues =
	// 			{"", LocalDate.of(2017, 8, 1), LocalDate.of(2021, 8, 2), -1, person};
	// 	final Set<ConstraintViolation<ReservationDto>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);
	//
	// 	System.out.println("Violations empty: " + violations.isEmpty());
	//
	// 	Assert.assertFalse(violations.isEmpty());
	// 	Assert.assertEquals(4, violations.size());
	// }

}
