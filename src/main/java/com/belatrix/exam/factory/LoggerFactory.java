package com.belatrix.exam.factory;

import com.belatrix.exam.enums.LoggerType;
import com.belatrix.exam.loggers.LoggerApp;
import com.belatrix.exam.loggers.impl.ConsoleLoggerApp;
import com.belatrix.exam.loggers.impl.DBLoggerApp;
import com.belatrix.exam.loggers.impl.FileLoggerApp;

/**
 * @author Horacio Nicolas Fiorini
 *
 */
public class LoggerFactory {

	/**
	 * @param loggerType, it could be CONSOLE, FILE, DB
	 * @return an implementation of interface LoggerApp. It can be ConsoleLoggerApp, DBLoggerApp or FileLoggerApp
	 * @throws Exception
	 */
	public static LoggerApp getLogger(LoggerType loggerType) throws Exception {
		
		if (loggerType.equals(LoggerType.CONSOLE)) {
			return new ConsoleLoggerApp();
		}
		if (loggerType.equals(LoggerType.FILE)) {
			return new FileLoggerApp();
		} else {
			return new DBLoggerApp();
		}
	}
}