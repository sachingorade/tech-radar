package net.os.tools.techradar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RepositoryType {
	MAVEN(1),
	GRADLE(2)
	;

	private final int value;
}
