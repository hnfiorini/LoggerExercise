package com.belatrix.exam.factory;

import com.belatrix.exam.enums.LoggerType;
import com.belatrix.exam.loggers.LoggerApp;
import com.belatrix.exam.loggers.impl.ConsoleLoggerApp;
import com.belatrix.exam.loggers.impl.DBLoggerApp;
import com.belatrix.exam.loggers.impl.FileLoggerApp;

public class LoggerFactory {
	
	public static LoggerApp getLogger(LoggerType loggerType) {
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
