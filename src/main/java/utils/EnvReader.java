package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvReader {
	private static final Dotenv dotenv = Dotenv.configure().directory("./") // looks for .env at project root
			.ignoreIfMissing() // won't fail if file is missing (useful for CI)
			.load();

	public static String get(String key) {
		String value = dotenv.get(key);
		if (value == null) {
			throw new IllegalArgumentException("Missing env variable: " + key);
		}
		return value;
	}
}
