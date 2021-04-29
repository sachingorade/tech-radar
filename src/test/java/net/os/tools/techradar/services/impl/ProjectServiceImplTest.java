package net.os.tools.techradar.services.impl;

import net.os.tools.techradar.model.Project;
import net.os.tools.techradar.persistence.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

	@InjectMocks
	private ProjectServiceImpl projectService;
	@Mock
	private ProjectRepository projectRepository;

	@Test
	void testCreateNewProject() {
		Project projectInDb = new Project();
		given(projectRepository.save(any(Project.class))).willReturn(projectInDb);

		Project projectToSave = new Project();
		Project savedProject = projectService.create(projectToSave);

		then(projectRepository).should().save(same(projectToSave));
		assertSame(projectInDb, savedProject);
	}
}