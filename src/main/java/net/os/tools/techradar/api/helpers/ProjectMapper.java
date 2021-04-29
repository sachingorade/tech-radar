package net.os.tools.techradar.api.helpers;

import net.os.tools.techradar.api.model.ApiProject;
import net.os.tools.techradar.model.Project;

public interface ProjectMapper {
	Project toProject(ApiProject apiProject);

	ApiProject toApiProject(Project project);
}
