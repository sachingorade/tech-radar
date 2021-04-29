package net.os.tools.techradar.api.helpers;

import net.os.tools.techradar.api.model.ApiProject;
import net.os.tools.techradar.api.model.ApiRepository;
import net.os.tools.techradar.model.Project;
import net.os.tools.techradar.model.Repository;
import net.os.tools.techradar.model.RepositoryType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ModelMapperTest {

	private final ModelMapper modelMapper = new ModelMapper();

	@Test
	void testConvertNullApiProjectToProject() {
		assertNull(modelMapper.toProject(null));
	}

	@Test
	void testConvertApiProjectToProject() {
		ApiProject apiProject = getTestApiProject(true);

		Project project = modelMapper.toProject(apiProject);

		Project expectedProject = getTestProject(true);
		assertEquals(expectedProject, project);
	}

	@Test
	void testConvertApiProjectToProjectWithoutRepository() {
		ApiProject apiProject = getTestApiProject(false);

		Project project = modelMapper.toProject(apiProject);

		Project expectedProject = getTestProject(false);
		assertEquals(expectedProject, project);
	}

	@Test
	void testConvertNullProjectToApiProject() {
		assertNull(modelMapper.toApiProject(null));
	}

	@Test
	void testConvertProjectToApiProject() {
		Project project = getTestProject(true);

		ApiProject apiProject = modelMapper.toApiProject(project);

		ApiProject expectedApiProject = getTestApiProject(true);
		assertEquals(expectedApiProject, apiProject);
	}

	@Test
	void testConvertProjectToApiProjectWithoutRepository() {
		Project project = getTestProject(false);

		ApiProject apiProject = modelMapper.toApiProject(project);

		ApiProject expectedApiProject = getTestApiProject(false);
		assertEquals(expectedApiProject, apiProject);
	}

	private ApiProject getTestApiProject(boolean withRepository) {
		return new ApiProject(2L, "ProjectName", "ProjectDescription",
				withRepository ? new ApiRepository("repo-url", RepositoryType.MAVEN) : null);
	}

	private Project getTestProject(boolean withRepository) {
		return new Project(2L, "ProjectName", "ProjectDescription",
				withRepository ? new Repository("repo-url", RepositoryType.MAVEN) : null);
	}
}