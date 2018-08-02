package com.rabbit.validationsamples.integrations.reservations;

import com.rabbit.validationsamples.configs.TestingConfig;
import com.rabbit.validationsamples.dtos.PersonDto;
import com.rabbit.validationsamples.services.ReservationService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes = {TestingConfig.class}
)
public class ReservationServiceSingleParamsIntegrationTest {

	@Resource(name = "reservationService")
	ReservationService reservationService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void validateCreateSingleDayReservation_singleParam_ok() throws InterruptedException {

		reservationService.createSingleDayReservation(
				LocalDate.now().plusDays(1),
				1,
				PersonDto.builder().firstName("Matteo").lastName("Baiguini").build()
		);
	}

	@Test
	public void validateCreateSingleDayReservation_singleParam_dateError() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createSingleDayReservation(
				LocalDate.now(),
				1,
				PersonDto.builder().firstName("Matteo").lastName("Baiguini").build()
		);
	}

	@Test
	public void validateCreateSingleDayReservation_singleParam_durationError() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createSingleDayReservation(
				LocalDate.now().plusDays(1),
				0,
				PersonDto.builder().firstName("Matteo").lastName("Baiguini").build()
		);
	}

	@Test
	public void validateCreateSingleDayReservation_singleParam_nullPersonError() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createSingleDayReservation(
				LocalDate.now().plusDays(1),
				1,
				null
		);
	}

	@Test
	public void validateCreateSingleDayReservation_singleParam_notValidPersonError() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createSingleDayReservation(
				LocalDate.now().plusDays(1),
				1,
				PersonDto.builder().firstName("John").lastName("Doe").build()
		);
	}

	@Test
	public void validateCreateSingleDayReservation_singleParam_multipleErrors() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createSingleDayReservation(
				LocalDate.now(),
				0,
				null
		);
	}

}
