package com.belatrix.exam.factory;

import java.util.logging.ConsoleHandler;

public class ConsoleHandlerFactory {
	
	public static ConsoleHandler consoleHandler;
	
	private ConsoleHandlerFactory() {
		super();
	}
	
	public static ConsoleHandler getConsoleHandler() {
		if (consoleHandler == null) {
			consoleHandler = new ConsoleHandler();
		}
		return consoleHandler;
	}

}
