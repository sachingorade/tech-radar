package net.os.tools.techradar;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class TestHelper {

	private final ClassLoader classLoader;

	public TestHelper() {
		classLoader = TestHelper.class.getClassLoader();
	}

	public String getContents(String resourcePath) {
		try (InputStream stream = classLoader.getResourceAsStream(resourcePath)) {
			return StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IllegalArgumentException("Error while reading resource:" + resourcePath, e);
		}
	}

}
