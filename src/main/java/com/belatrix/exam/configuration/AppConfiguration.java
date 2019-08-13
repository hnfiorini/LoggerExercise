package com.belatrix.exam.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * @author Horacio Nicolas Fiorini
 *
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
	
	public String getProperty(String property) {
		return localLogManager.getProperty(property);
	}

}
