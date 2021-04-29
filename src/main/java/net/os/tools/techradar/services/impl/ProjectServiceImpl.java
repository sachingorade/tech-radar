package net.os.tools.techradar.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.os.tools.techradar.model.Project;
import net.os.tools.techradar.persistence.ProjectRepository;
import net.os.tools.techradar.services.ProjectService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;

	@Override
	public Project create(Project project) {
		log.debug("Creating new project using:[{}]", project);
		return projectRepository.save(project);
	}

}
