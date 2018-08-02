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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes = {TestingConfig.class}
)
public class ReservationServiceReturnIntegrationTest {

	@Resource(name = "reservationService")
	ReservationService reservationService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void validateReturn_singleParams_ok() {

		reservationService.getAllPersons_ok();
	}

	@Test
	public void validateReturn_singleParams_error() {

		exception.expect(ConstraintViolationException.class);
		reservationService.getAllPersons_error();
	}

	@Test
	public void validateReturn_crossParams_ok() {

		reservationService.getReservationById_ok("001");
	}

	@Test
	public void validateReturn_crossParams_nullError() {

		exception.expect(ConstraintViolationException.class);
		reservationService.getReservationById_error_null("001");
	}

	@Test
	public void validateReturn_crossParams_wrongError() {

		exception.expect(ConstraintViolationException.class);
		reservationService.getReservationById_error_wrong("001");
	}

}
