package net.os.tools.techradar.api.model;

import lombok.Value;
import net.os.tools.techradar.model.RepositoryType;

@Value
public class ApiRepository {
	String url;
	RepositoryType type;
}
