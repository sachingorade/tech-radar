package net.os.tools.techradar.api.helpers;

import lombok.extern.slf4j.Slf4j;
import net.os.tools.techradar.api.model.ApiProject;
import net.os.tools.techradar.api.model.ApiRepository;
import net.os.tools.techradar.model.Project;
import net.os.tools.techradar.model.Repository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ModelMapper implements ProjectMapper {

	@Override
	public Project toProject( ApiProject apiProject) {
		log.debug("Converting ApiProject:[{}] to Project", apiProject);
		if (apiProject == null) {
			return null;
		}
		return new Project(apiProject.getId(), apiProject.getName(), apiProject.getDescription(), toRepository(apiProject.getRepository()));
	}

	private Repository toRepository(ApiRepository apiRepository) {
		log.debug("Converting ApiRepository:[{}] to Repository", apiRepository);
		if (apiRepository == null) {
			return null;
		}
		return new Repository(apiRepository.getUrl(), apiRepository.getType());
	}

	@Override
	public ApiProject toApiProject(Project project) {
		log.debug("Converting Project:[{}] to ApiProject", project);
		if (project == null) {
			return null;
		}
		return new ApiProject(project.getId(), project.getName(), project.getDescription(), toApiRepository(project.getRepository()));
	}

	private ApiRepository toApiRepository(Repository repository) {
		log.debug("Converting Repository:[{}] to ApiRepository", repository);
		if (repository == null) {
			return null;
		}
		return new ApiRepository(repository.getUrl(), repository.getType());
	}

}
