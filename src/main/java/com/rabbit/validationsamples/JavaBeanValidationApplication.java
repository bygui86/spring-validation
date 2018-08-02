package com.rabbit.validationsamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * JSR 380 is a specification of the Java API for bean validation, part of JavaEE and JavaSE, which ensures that the properties of a bean meet specific
 * criteria, using annotations such as @NotNull, @Min, and @Max.
 * <p>
 * Standard JSR annotations:
 *
 * @NotNull – validates that the annotated property value is not null
 * @AssertTrue – validates that the annotated property value is true
 * @Size – validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array
 * properties
 * @Min – vValidates that the annotated property has a value no smaller than the value attribute
 * @Max – validates that the annotated property has a value no larger than the value attribute
 * @Email – validates that the annotated property is a valid email address
 * @NotEmpty – validates that the property is not null or empty; can be applied to String, Collection, Map or Array values
 * @NotBlank – can be applied only to text values and validated that the property is not null or whitespace
 * @Positive and @PositiveOrZero – apply to numeric values and validate that they are strictly positive, or positive including 0
 * @Negative and @NegativeOrZero – apply to numeric values and validate that they are strictly negative, or negative including 0
 * @Past and @PastOrPresent – validate that a date value is in the past or the past including the present; can be applied to date types including those added
 * in Java 8
 * @Future and @FutureOrPresent – validates that a date value is in the future, or in the future including the present
 * <p>
 * Some annotations accept additional attributes, but the message attribute is common to all of them. This is the message that will usually be rendered when
 * the value of the respective property fails validation.
 */
// TODO: Non-Generic Container Elements
@SpringBootApplication
public class JavaBeanValidationApplication {

	public static void main(final String[] args) {

		SpringApplication.run(JavaBeanValidationApplication.class, args);
	}
}
