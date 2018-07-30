package com.rabbit.validationsamples.springmvc.dtos;

import com.rabbit.validationsamples.springmvc.validation.constraints.FieldsValueMatch;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


/**
 * Let’s create a NewUserForm model class intended for data required for a user registration, that has two email and password attributes, along with
 * two verifyEmail and verifyPassword attributes to re-enter the two values.
 * <p>
 * Since we have two fields to check against their corresponding matching fields, let’s add two @FieldsValueMatch annotations on the NewUserForm class, one
 * for email values, and one for password values:
 */
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
@Data
@Builder
@FieldsValueMatch.List({
		@FieldsValueMatch(
				field = "password",
				fieldMatch = "verifyPassword",
				message = "Passwords do not match!"
		),
		@FieldsValueMatch(
				field = "email",
				fieldMatch = "verifyEmail",
				message = "Email addresses do not match!"
		)
})
public class NewUserForm {

	private String email;

	private String verifyEmail;

	private String password;

	private String verifyPassword;

	// standard constructor, getters, setters
}
