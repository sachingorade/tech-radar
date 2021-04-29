package net.os.tools.techradar.persistence.converters;

import net.os.tools.techradar.model.RepositoryType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTypeAttributeConverterTest {

	private final RepositoryTypeAttributeConverter converter = new RepositoryTypeAttributeConverter();

	@Test
	void testConvertEnumToDbValue() {
		assertEquals(1, converter.convertToDatabaseColumn(RepositoryType.MAVEN));
	}

	@Test
	void testConvertEnumToDbValueForNullEnumConstant() {
		assertNull(converter.convertToDatabaseColumn(null));
	}

	@Test
	void testConvertDbValueToEnum() {
		assertEquals(RepositoryType.GRADLE, converter.convertToEntityAttribute(2));
	}

	@Test
	void testConvertDbValueToEnumThrowsIllegalArgumentExceptionForNonExistentValue() {
		assertThrows(IllegalArgumentException.class, () -> converter.convertToEntityAttribute(0));
	}
}