package com.belatrix.exam.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.belatrix.exam.configuration.AppConfiguration;

public class DBHandlerFactory {
	
	private static Connection connection;
	private static AppConfiguration configuration;
	
	public DBHandlerFactory() {
		super();
	}
	
	public static Connection getConnection()  {
		configuration = AppConfiguration.getInstance();
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:" + configuration.getProperty("logger.db.dbms") + "://" + configuration.getProperty("logger.db.serverName")
				+ ":" + configuration.getProperty("logger.db.portNumber") + "/");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
