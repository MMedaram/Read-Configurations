package com.configexample.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefinedProperties {
	
	private Logger logger = LoggerFactory.getLogger(DefinedProperties.class);

	private Properties prop = new Properties();

	public void initiate(String propertyFile) {
		
		logger.info("Loading a properties file from the file system");
		
		try {
			InputStream input = DefinedProperties.class.getResourceAsStream("/resources/" +propertyFile);
			if (input == null) {
				input = DefinedProperties.class.getClassLoader().getResourceAsStream(propertyFile);
			}
			//load a properties file from class path, inside static method
			prop.load(input);
			logger.info("properties file loaded successfully");

		} catch (IOException ex) {
			logger.info("Exception occured during properties file load");
			ex.printStackTrace();
		}

	}
	
	
	public String getProperty(String propertyKey) {
		logger.info("fetching property from loaded properties file with key :"+propertyKey);
		return prop.getProperty(propertyKey);
	}

}
