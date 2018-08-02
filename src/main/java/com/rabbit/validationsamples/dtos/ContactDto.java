package com.rabbit.validationsamples.dtos;

import com.rabbit.validationsamples.validation.constraints.ContactPhoneConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ContactDto {

	@ContactPhoneConstraint
	String phone;

}
