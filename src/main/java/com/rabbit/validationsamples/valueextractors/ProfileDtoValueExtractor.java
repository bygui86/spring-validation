package com.rabbit.validationsamples.valueextractors;

import com.rabbit.validationsamples.dtos.ProfileDto;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.UnwrapByDefault;
import javax.validation.valueextraction.ValueExtractor;


/**
 * This class also need to specify the type of the value extracted using the @ExtractedValue annotation.
 * <p>
 * Also, we’ve added the @UnwrapByDefault annotation that specifies the validation should be applied to the
 * unwrapped value and not the container.
 * <p>
 * Finally, we need to register the class by adding a file called javax.validation.valueextraction.ValueExtractor
 * to the META-INF/services directory, which contains the full name of our ProfileValueExtractor class:
 * com.rabbit.validationsamples.javabean.valueextractors.ProfileDtoValueExtractor
 */
@UnwrapByDefault
public class ProfileDtoValueExtractor implements ValueExtractor<@ExtractedValue(type = String.class) ProfileDto> {

	@Override
	public void extractValues(final ProfileDto originalValue, final ValueReceiver receiver) {

		receiver.value(null, originalValue.getCompanyName());
	}

}
