package com.belatrix.exam.loggers;

/**
 * @author Horacio Nicolas Fiorini
 *
 */
public interface LoggerApp {
	public void logMessage(String message);
	public void logWarning(String message);
	public void logError(String message);
}
