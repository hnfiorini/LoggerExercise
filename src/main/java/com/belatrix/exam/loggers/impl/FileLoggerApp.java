package com.belatrix.exam.loggers.impl;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.exam.configuration.AppConfiguration;
import com.belatrix.exam.exceptions.FileHandlerException;
import com.belatrix.exam.factory.FileHandlerFactory;
import com.belatrix.exam.loggers.LoggerApp;

/**
 * @author Horacio Nicolas Fiorini
 * API to log in a file
 */
public class FileLoggerApp implements LoggerApp {
	
	public static final Logger logger = Logger.getLogger("FileLoggerApp");
	public FileHandler fileHandler;
	private AppConfiguration configuration;
	
	public FileLoggerApp() throws FileHandlerException {
		fileHandler = FileHandlerFactory.getFileHandler();
		configuration = AppConfiguration.getInstance();
		logger.addHandler(fileHandler);
	}

	@Override
	public void logMessage(String message) {
		boolean log = Boolean.getBoolean(configuration.getProperty("logger.level.message"));
		if (log) {
			logger.log(Level.INFO, message);
		}
	}

	@Override
	public void logWarning(String message) {
		boolean log = Boolean.getBoolean(configuration.getProperty("logger.level.warning"));
		if (log) {
			logger.log(Level.WARNING, message);
		}
	}

	@Override
	public void logError(String message) {
		boolean log = Boolean.getBoolean(configuration.getProperty("logger.level.error"));
		if (log) {
			logger.log(Level.SEVERE, message);
		}
	}
}