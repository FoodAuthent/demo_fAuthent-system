package org.foodauthent.gpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class GpcBricks {

	private Map<String, Brick> bricks;

	public static final String[] LANGUAGES = new String[] { "en", "de" };

	public GpcBricks() throws UnsupportedEncodingException, IOException {
		bricks = new HashMap<String, Brick>();
		for (String lang : LANGUAGES) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new GZIPInputStream(
							GpcBricks.class.getResourceAsStream("FoodBeverageTobacco_Schema-" + lang + ".txt.gz")),
					"ISO-8859-15"));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				final String[] parts = line.split("\t");
				if (parts.length > 6) {
					final String brickCode = parts[6];
					final String brickDescription = parts[7];
					Brick brick = bricks.get(brickCode);
					if (brick == null) {
						brick = new Brick();
						brick.setCode(brickCode);
					}
					brick.putText(lang, brickDescription);
					if (parts.length > 8) {
						final String attributeCode = parts[8];
						final String attributeDescription = parts[9];
						final Optional<Attribute> existingAttrbute = brick.getAttributes().stream()
								.filter(a -> a.getCode().equals(attributeCode)).findFirst();
						Attribute attribute = existingAttrbute.isPresent() ? existingAttrbute.get() : new Attribute();
						attribute.setCode(attributeCode);
						attribute.putText(lang, attributeDescription);
						if (parts.length > 10) {
							final String valueCode = parts[10];
							final String valueDescription = parts[11];
							Optional<AttributeValue> existingValue = attribute.getValues().stream()
									.filter(v -> v.getCode().equals(valueCode)).findFirst();
							AttributeValue value = existingValue.isPresent() ? existingValue.get()
									: new AttributeValue();
							value.setCode(valueCode);
							value.putText(lang, valueDescription);
							if (!existingValue.isPresent()) {
								attribute.getValues().add(value);
							}
						}
						if (!existingAttrbute.isPresent()) {
							brick.getAttributes().add(attribute);
						}
					}
					bricks.put(brickCode, brick);
				}
			}
		}

	}

	public Map<String, Brick> getBricks() {
		return bricks;
	}

	public Map<String, Brick> findBricks(String lang, String s) {
		final Map<String, Brick> result = getBricks().entrySet().stream().filter(e -> {
			return containsString(e.getValue().getText(), s, lang)
					|| e.getValue().getAttributes().stream().filter(a -> containsString(a.getText(), s, lang)).findFirst()
							.isPresent()
					|| e.getValue().getAttributes().stream().filter(a -> a.getValues().stream()
							.filter(v -> containsString(v.getText(), s, lang)).findFirst().isPresent()).findFirst()
							.isPresent();
		}).collect(Collectors.toConcurrentMap(k -> k.getKey(), v -> v.getValue()));
		return result;
	}

	private boolean containsString(Map<String, String> text, String s, String lang) {
		return text.entrySet().stream()
				.filter(t -> t.getKey().equals(lang) && t.getValue().toLowerCase().indexOf(s.toLowerCase()) != -1)
				.findFirst().isPresent();
	}

}
