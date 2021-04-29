package net.os.tools.techradar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Repository {

	@Column(name = "repository_url")
	private String url;

	@Column(name = "repository_type")
	private RepositoryType type;

}
