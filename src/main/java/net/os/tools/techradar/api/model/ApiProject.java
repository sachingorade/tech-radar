package net.os.tools.techradar.api.model;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ApiProject {
	Long id;
	@NotNull
	String name;
	String description;
	ApiRepository repository;
}
