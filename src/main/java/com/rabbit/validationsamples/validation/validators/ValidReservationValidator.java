package com.rabbit.validationsamples.validation.validators;

import com.rabbit.validationsamples.dtos.ReservationDto;
import com.rabbit.validationsamples.validation.constraints.ValidReservationConstraint;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;


public class ValidReservationValidator implements ConstraintValidator<ValidReservationConstraint, ReservationDto> {

	@Override
	public void initialize(final ValidReservationConstraint constraintAnnotation) {

		// no-op
	}

	@Override
	public boolean isValid(final ReservationDto reservation, final ConstraintValidatorContext context) {

		if (reservation == null) {
			return false;
		}

		System.out.println("Reservation " + reservation.toString());

		if (StringUtils.isEmpty(reservation.getId())
				|| reservation.getBegin() == null
				|| reservation.getEnd() == null
				|| reservation.getPerson() == null) {
			return false;
		}

		return (reservation.getBegin().isAfter(LocalDate.now())
				&& reservation.getBegin().isBefore(reservation.getEnd())
				&& reservation.getRoom() > 0);
	}

}
