package dev.jee6demo.util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesUtilTest {

	private static Properties properties=PropertiesUtil.getProperties();

	@Test
	public void test() {
		assertNotNull(properties);
		assertNotNull(properties.getProperty("my.property.1"));

	}

}
