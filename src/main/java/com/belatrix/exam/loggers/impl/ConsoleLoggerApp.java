package com.belatrix.exam.loggers.impl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.exam.configuration.AppConfiguration;
import com.belatrix.exam.factory.ConsoleHandlerFactory;
import com.belatrix.exam.loggers.LoggerApp;

/**
 * @author Horacio Nicolas Fiorini
 * API to log on console
 */
public class ConsoleLoggerApp implements LoggerApp {
	
	public static final Logger logger = Logger.getLogger("ConsoleLoggerApp");
	public ConsoleHandler consoleHandler;
	private AppConfiguration configuration;
	
	public ConsoleLoggerApp() {
		consoleHandler = ConsoleHandlerFactory.getConsoleHandler();
		configuration = AppConfiguration.getInstance();
		logger.addHandler(consoleHandler);
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