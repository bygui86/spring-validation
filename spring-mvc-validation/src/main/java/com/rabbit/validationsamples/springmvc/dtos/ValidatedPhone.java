package com.rabbit.validationsamples.springmvc.dtos;

import com.rabbit.validationsamples.springmvc.validation.constraints.ContactNumberConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
@Data
@Builder
public class ValidatedPhone {

	@ContactNumberConstraint
	private String phone;

}
