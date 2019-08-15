package com.belatrix.exam.loggers.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;

import com.belatrix.exam.configuration.AppConfiguration;
import com.belatrix.exam.enums.LoggerLevel;
import com.belatrix.exam.factory.DBHandlerFactory;
import com.belatrix.exam.loggers.LoggerApp;

/**
 * @author Horacio Nicolas Fiorini
 * API to log in a Data Base
 */
public class DBLoggerApp implements LoggerApp {
	
	Connection connection;
	AppConfiguration configuration;
	
	public DBLoggerApp() {
		configuration = AppConfiguration.getInstance();
		connection = DBHandlerFactory.getConnection();
	}

	@Override
	public void logMessage(String message) {
		Statement stmt;
		boolean log = Boolean.getBoolean(configuration.getProperty("logger.level.message"));
		if (log) {
			try {
				stmt = connection.createStatement();
				String messageFormat = LoggerLevel.MESSAGE.name() + " " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + ": " + message;
				stmt.executeUpdate("INSERT INTO Log_Values('" + messageFormat + "', " + String.valueOf(1) + ")");
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void logWarning(String message) {
		Statement stmt;
		boolean log = Boolean.getBoolean(configuration.getProperty("logger.level.warning"));
		if (log) {
			try {
				stmt = connection.createStatement();
				String messageFormat = LoggerLevel.WARNING.name() + " " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + ": " + message;
				stmt.executeUpdate("INSERT INTO Log_Values('" + messageFormat + "', " + String.valueOf(2) + ")");
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void logError(String message) {
		Statement stmt;
		boolean log = Boolean.getBoolean(configuration.getProperty("logger.level.error"));
		if (log) {
			try {
				stmt = connection.createStatement();
				String messageFormat = LoggerLevel.ERROR.name() + " " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + ": " + message;
				stmt.executeUpdate("INSERT INTO Log_Values('" + messageFormat + "', " + String.valueOf(3) + ")");
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}