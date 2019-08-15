package com.belatrix.exam.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * @author Horacio Nicolas Fiorini
 * Represents an instance of loggin.properties file
 */
public class AppConfiguration {

	LogManager localLogManager = null;
	
	private static AppConfiguration instance;
	
	private AppConfiguration() {
		InputStream stream;
		try {
			stream = Thread.currentThread().getContextClassLoader().getResource("logging.properties").openStream();
			LogManager.getLogManager().readConfiguration(stream);
			localLogManager = LogManager.getLogManager();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static AppConfiguration getInstance() {
		if (instance == null) {
			instance = new AppConfiguration();
		}
		return instance;
	}
	
	/**
	 * @param property a property of loggin.properties file
	 * @return the value of the input property in loggin.properties file
	 */
	public String getProperty(String property) {
		return localLogManager.getProperty(property);
	}

}
