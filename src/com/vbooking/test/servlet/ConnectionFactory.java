package com.vbooking.test.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionFactory {
	private static AtomicBoolean loadedDrivers = new AtomicBoolean();

	public static Connection getConnection(String databaseName) throws Exception {
		String driversProp;
		if (!loadedDrivers.getAndSet(true)) {
			driversProp = System.getProperty("jdbc.drivers");
			if (driversProp == null) {
				throw new Exception("No JDBC drivers specified. Please set jdbc.drivers in configuration.");
			}

			String[] drivers = driversProp.split(":");
			String[] arr$ = drivers;
			int len$ = drivers.length;

			for (int i$ = 0; i$ < len$; ++i$) {
				String d = arr$[i$];
				Class.forName(d);
			}
		}

		driversProp = "jdbc:db2://localhost:50000/" + databaseName;
		return DriverManager.getConnection(driversProp, System.getProperty("jdbc.username"),
				System.getProperty("jdbc.password"));
	}
}
