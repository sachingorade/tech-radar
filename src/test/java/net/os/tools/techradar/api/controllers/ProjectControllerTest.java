package net.os.tools.techradar.api.controllers;

import net.os.tools.techradar.TestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private TestHelper testHelper;

	@Test
	void testCreateNewProjectWithoutRepository() throws Exception {
		mockMvc.perform(post("/api/projects")
			.contentType(MediaType.APPLICATION_JSON)
			.content(testHelper.getContents("mocks/projects/api/new-project-without-repository.json")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", notNullValue()));
	}
}