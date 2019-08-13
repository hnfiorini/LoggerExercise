package com.belatrix.exam.factory;

import java.util.logging.ConsoleHandler;

/**
 * @author Horacio Nicolas Fiorini
 * This class works like a factory of ConsoleHandler class. It implements singleton pattern to ensure only one class instance
 *
 */
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
