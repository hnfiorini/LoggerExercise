package com.belatrix.exam.loggers.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.belatrix.exam.configuration.AppConfiguration;
import com.belatrix.exam.factory.DBHandlerFactory;
import com.belatrix.exam.loggers.LoggerApp;

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
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO Log_Values('" + message + "', " + String.valueOf(1) + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void logWarning(String message) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO Log_Values('" + message + "', " + String.valueOf(2) + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void logError(String message) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO Log_Values('" + message + "', " + String.valueOf(3) + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
