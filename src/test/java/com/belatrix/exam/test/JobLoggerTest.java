package com.belatrix.exam.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.belatrix.exam.enums.LoggerType;
import com.belatrix.exam.factory.LoggerFactory;
import com.belatrix.exam.loggers.LoggerApp;
import com.belatrix.exam.loggers.impl.ConsoleLoggerApp;
import com.belatrix.exam.loggers.impl.DBLoggerApp;
import com.belatrix.exam.loggers.impl.FileLoggerApp;

public class JobLoggerTest {
	
	@Test
	public void testConsoleLogger() {
		try {
			LoggerApp console = LoggerFactory.getLogger(LoggerType.CONSOLE);
			assertTrue(console instanceof ConsoleLoggerApp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFileLogger() {
		try {
			LoggerApp file = LoggerFactory.getLogger(LoggerType.FILE);
			assertTrue(file instanceof FileLoggerApp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDBLogger() {
		try {
			LoggerApp db = LoggerFactory.getLogger(LoggerType.DB);
			assertTrue(db instanceof DBLoggerApp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
