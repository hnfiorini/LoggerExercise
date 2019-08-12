package com.belatrix.exam.factory;

import java.io.IOException;
import java.util.logging.FileHandler;

import com.belatrix.exam.configuration.AppConfiguration;
import com.belatrix.exam.exceptions.FileHandlerException;

public class FileHandlerFactory {
	
	private static AppConfiguration config;
	
	public static FileHandler fileHandler;
	
	private FileHandlerFactory() {
		super();
	}
	
	public static FileHandler getFileHandler() {
		if (fileHandler == null) {
			try {
				fileHandler = new FileHandler(config.getProperty("logger.logFileFolder") + "/logFile.txt");
			} catch (SecurityException | IOException e) {
				throw new FileHandlerException("It was an error creating new File Handler", e);
			}
		}
		return fileHandler;
	}

}
