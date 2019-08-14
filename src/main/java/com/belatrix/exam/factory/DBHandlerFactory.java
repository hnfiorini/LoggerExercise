package com.belatrix.exam.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
				Properties connectionProps = new Properties();
				connectionProps.put("user", configuration.getProperty("logger.db.userName"));
				connectionProps.put("password", configuration.getProperty("logger.db.password"));
				connection = DriverManager.getConnection("jdbc:" + configuration.getProperty("logger.db.dbms") + "://" + configuration.getProperty("logger.db.serverName")
				+ ":" + configuration.getProperty("logger.db.portNumber") + "/", connectionProps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
