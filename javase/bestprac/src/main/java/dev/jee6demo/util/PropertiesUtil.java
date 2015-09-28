package dev.jee6demo.util;

import java.io.FileReader;
import java.util.Properties;
/**
 * This class shows how to load a properties file, and 
 * how to use them with a static object for all the classes.
 * It is thread safe.
 *
 */
public class PropertiesUtil {

	private static Properties properties;

	private static void buildPropertiesNotSyn(){
		Properties properties = new Properties();
		try {
			//LOAD AS RESOURCE
			Properties propertiesResource = new Properties();
			propertiesResource.load(PropertiesUtil.class.getResourceAsStream("/dev/jee6demo/util/mysample.properties"));
			properties.putAll(propertiesResource);
			
			//LOAD AS FILE
			//Properties propertiesFile = new Properties();
			//propertiesFile.load(new FileReader("src/main/resources/dev/jee6demo/util/mysample.properties"));//D:/var/...
			//properties.putAll(propertiesFile);
			
			//IF OK
			PropertiesUtil.properties=properties;
		} catch (Exception e) {
			System.err.print("Error loading properties");
			throw new RuntimeException("Error loading properties",e);
		}
	}
	/** 
	 * Create Properties in a Thread Safe Way
	 */
	private synchronized static void buildProperties() {
		if (properties == null) {//necessary re-check
			buildPropertiesNotSyn();
		}
	}

	public static Properties getProperties() {
		if (properties == null ) {
			buildProperties();
		}
		return properties;
	}
	public static String getProperty(String key) {
		if (properties == null ) {
			buildProperties();
		}
		return (properties!=null) ? properties.getProperty(key):null;
	}
}
