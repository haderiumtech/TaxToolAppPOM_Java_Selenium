// src/main/java/utils/JsonReader.java
package utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	private JsonNode rootNode;

	public JsonReader(String filePath) {
		try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath)) {
			if (is == null) {
				throw new RuntimeException("Failed to read JSON test data file: " + filePath);
			}
			rootNode = objectMapper.readTree(is);
		} catch (IOException e) {
			throw new RuntimeException("Error reading JSON file: " + filePath, e);
		}
	}

	// Get value using dot notation key like: "ForgotPasswordPage.toastSuccess"
	public String getValue(String keyPath) {
		String[] keys = keyPath.split("\\.");
		JsonNode currentNode = rootNode;

		for (String key : keys) {
			currentNode = currentNode.get(key);
			if (currentNode == null) {
				throw new RuntimeException("Key not found in JSON: " + keyPath);
			}
		}

		return currentNode.asText();
	}
}
