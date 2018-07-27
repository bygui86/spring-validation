package com.rabbit.validationsample.integrationtests;

import com.rabbit.validationsample.controllers.ValidatePhoneController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class PhoneValidationIntegrationTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(new ValidatePhoneController()).build();
	}

	@Test
	public void testGetValidatePhonePage() throws Exception {

		mockMvc
				.perform(
						get("/validatePhone")
				)
				.andExpect(
						view().name("phoneHome")
				)
		;
	}

	@Test
	public void testValidatePhone_ok() throws Exception {

		mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/addValidatePhone")
								.accept(MediaType.TEXT_HTML)
								.param("phoneInput", "123456789")
				)
				.andExpect(
						model().attributeHasFieldErrorCode(
								"validatedPhone", "phone", "ContactNumberConstraint")
				)
				.andExpect(
						view().name("phoneHome")
				)
				.andExpect(
						status().isOk()
				)
				.andDo(
						print()
				)
		;
	}

	@Test
	public void testValidatePhone_error() throws Exception {

		mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/addValidatePhone")
								.accept(MediaType.TEXT_HTML)
								.param("phoneInput", "123")
				)
				.andExpect(
						model().attributeHasFieldErrorCode(
								"validatedPhone", "phone", "ContactNumberConstraint")
				)
				.andExpect(
						view().name("phoneHome")
				)
				.andExpect(
						status().isOk()
				)
				.andDo(
						print()
				)
		;
	}

}
