package com.ts.properties;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;


import static java.util.Collections.list;

public class PropertiesLoader implements PropertiesProvider {

	public static final PropertiesProvider INST = new PropertiesLoader();
	private final Map<String, String> propertiesMap;

	private PropertiesLoader(){
		this.propertiesMap = new HashMap<>();
		initialize();
	}

	private void initialize() {
		loadFromClashPath().forEach(fileName -> {
			isValidPropertiesFileName(fileName);
			propertiesMap.putAll(loadProperties(fileName));
		});
	}

	private Stream<String> loadFromClashPath() {
		try {
			URI uri = PropertiesLoader.class.getResource("/").toURI();
			return  Files.walk(Paths.get(uri), 1)
					.filter(path -> path.getFileName().toString().endsWith(".properties"))
					.map(path -> path.getFileName().toString());
		} catch (URISyntaxException|IOException e) {
			throw new IllegalStateException("Can't load properties, caused by: " + e);
		}
	}

	private void isValidPropertiesFileName(String propertiesFileName) {
		if(propertiesFileName == null || propertiesFileName.isEmpty() || propertiesFileName.startsWith(".") || !propertiesFileName.contains(".properties")){
			throw new IllegalArgumentException("Properties file name is invalid : " + propertiesFileName);
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> loadProperties(String propertyFile){
		Map<String, String> readPropertiesMap = new HashMap<>();
		try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile)){
			Properties properties = new Properties();
			properties.load(inputStream);
			list((Enumeration<String>) properties.propertyNames()).forEach(key -> readPropertiesMap.put(key, properties.getProperty(key)));
		}catch (IOException ex){
			throw new IllegalStateException("Resource not found, cause: " + ex);
		}
		return readPropertiesMap;
	}

	@Override
	public String getValue(String propertyName) {
		return propertiesMap.get(propertyName);
	}
}
