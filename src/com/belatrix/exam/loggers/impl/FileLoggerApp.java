package com.belatrix.exam.loggers.impl;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.exam.factory.FileHandlerFactory;
import com.belatrix.exam.loggers.LoggerApp;

public class FileLoggerApp implements LoggerApp {
	
	public static final Logger logger = Logger.getLogger("FileLoggerApp");
	public FileHandler fileHandler;
	
	public FileLoggerApp() {
		fileHandler = FileHandlerFactory.getFileHandler();
		logger.addHandler(fileHandler);
	}

	@Override
	public void logMessage(String message) {
		logger.log(Level.INFO, message);
	}

	@Override
	public void logWarning(String message) {
		logger.log(Level.WARNING, message);
	}

	@Override
	public void logError(String message) {
		logger.log(Level.SEVERE, message);
	}

}
