package com.belatrix.exam.loggers.impl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.exam.factory.ConsoleHandlerFactory;
import com.belatrix.exam.loggers.LoggerApp;

public class ConsoleLoggerApp implements LoggerApp {
	
	public static final Logger logger = Logger.getLogger("ConsoleLoggerApp");
	public ConsoleHandler consoleHandler;
	
	public ConsoleLoggerApp() {
		consoleHandler = ConsoleHandlerFactory.getConsoleHandler();
		logger.addHandler(consoleHandler);
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
