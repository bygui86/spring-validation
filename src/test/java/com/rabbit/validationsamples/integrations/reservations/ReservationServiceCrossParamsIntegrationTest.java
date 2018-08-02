package com.rabbit.validationsamples.integrations.reservations;

import com.rabbit.validationsamples.configs.TestingConfig;
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
public class ReservationServiceCrossParamsIntegrationTest {

	@Resource(name = "reservationService")
	ReservationService reservationService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void validateCreateMultipleDaysReservation_crossParams_ok() throws InterruptedException {

		reservationService.createMultipleDaysReservation(
				LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(2)
		);
	}

	@Test
	public void validateCreateMultipleDaysReservation_crossParams_beginError() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createMultipleDaysReservation(
				LocalDate.now(),
				LocalDate.now().plusDays(2)
		);
	}

	@Test
	public void validateCreateMultipleDaysReservation_crossParams_endError() throws InterruptedException {

		exception.expect(ConstraintViolationException.class);
		reservationService.createMultipleDaysReservation(
				LocalDate.now().plusDays(1),
				LocalDate.now()
		);
	}

}
