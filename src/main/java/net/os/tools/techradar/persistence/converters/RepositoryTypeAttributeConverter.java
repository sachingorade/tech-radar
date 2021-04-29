package net.os.tools.techradar.persistence.converters;

import net.os.tools.techradar.model.RepositoryType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

@Converter(autoApply = true)
public class RepositoryTypeAttributeConverter implements AttributeConverter<RepositoryType, Integer> {

	private final Map<Integer, RepositoryType> dbValueToEnumMap = new HashMap<>();

	public RepositoryTypeAttributeConverter() {
		for(RepositoryType type : RepositoryType.values()) {
			dbValueToEnumMap.put(type.getValue(), type);
		}
	}

	@Override
	public Integer convertToDatabaseColumn(RepositoryType attribute) {
		return attribute != null ? attribute.getValue() : null;
	}

	@Override
	public RepositoryType convertToEntityAttribute(Integer dbData) {
		RepositoryType type = dbValueToEnumMap.get(dbData);
		if (type == null) {
			throw new IllegalArgumentException("Db value:" + dbData + " cannot be converted to RepositoryType.");
		}
		return type;
	}
}
