package net.os.tools.techradar.api.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.os.tools.techradar.api.ApiEndpoints;
import net.os.tools.techradar.api.helpers.ProjectMapper;
import net.os.tools.techradar.api.model.ApiProject;
import net.os.tools.techradar.services.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
public class ProjectController {

	private final ProjectService projectService;
	private final ProjectMapper projectMapper;

	@PostMapping(ApiEndpoints.PROJECTS)
	public ApiProject createProject(@RequestBody @Valid ApiProject apiProject) {
		log.debug("Creating new project using:[{}]", apiProject);
		return projectMapper.toApiProject(projectService.create(projectMapper.toProject(apiProject)));
	}

}
