package com.vbooking.test.servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Currency;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.ibm.mq.MQException;
//import com.ibm.mq.MQGetMessageOptions;
//import com.ibm.mq.MQMessage;
//import com.ibm.mq.MQQueue;
//import com.ibm.mq.MQQueueManager;
import com.vbooking.booking.currency.CurrencyConverter;
import com.vbooking.booking.currency.CurrencyConverterServiceLocator;
import com.vbooking.booking.hotel.FindHotels;
import com.vbooking.flights.Flight;
import com.vbooking.flights.FlightsRest;
import com.vbooking.logon.LogonServiceImpl;
import com.vbooking.logon.LogonServiceImplServiceLocator;
import com.vbooking.mq.MessageSender;
import com.vbooking.util.JMSManager;

public class TestVBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionRequest = request.getParameter("actionBtn");
		String result1 = request.getParameter("test1");
		String result2 = request.getParameter("test2");
		String result3 = request.getParameter("test3");
		String result4 = request.getParameter("test4");
		String result5 = request.getParameter("test5");
		String result6 = request.getParameter("test6");
		String result7 = request.getParameter("test7");
		String result8 = request.getParameter("test8");
		String result9 = request.getParameter("test9");
		String result10 = request.getParameter("test10");
		String result11 = request.getParameter("test11");
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		String testCompleteText = "Test completed.";
		if (actionRequest == null) {
			actionRequest = "";
		}

		if (actionRequest.equals("test1")) {
			result1 = this.testMQ();
		}

		if (actionRequest.equals("test2")) {
			result2 = this.testWS(sessionID);
		}

		if (actionRequest.equals("test3")) {
			result3 = this.testDB();
		}

		if (actionRequest.equals("test4")) {
			result4 = this.testFlightSearch();
		}

		if (actionRequest.equals("test5")) {
			result5 = this.testFCS();
		}

		if (actionRequest.equals("test6")) {
			result6 = this.testHotelService();
		}

		if (actionRequest.equals("test7")) {
			result7 = this.testCurrencyService();
		}

		if (actionRequest.equals("test8")) {
			result8 = this.testFFService();
		}

		if (actionRequest.equals("test9")) {
			result9 = this.testDBSchema();
		}

		if (actionRequest.equals("test10")) {
			result10 = this.testActiveMQ();
		}

		if (actionRequest.equals("test11")) {
			result11 = this.testAvailableSeats();
		}

		if (actionRequest.equals("Test All")) {
			testCompleteText = "Tests completed.";
			result1 = this.testMQ();
			result2 = this.testWS(sessionID);
			result3 = this.testDB();
			result4 = this.testFlightSearch();
			result5 = this.testFCS();
			result6 = this.testHotelService();
			result7 = this.testCurrencyService();
			result8 = this.testFFService();
			result9 = this.testDBSchema();
			result10 = this.testActiveMQ();
			result11 = this.testAvailableSeats();
		}

		request.getRequestDispatcher("testvbooking.jsp?test1=" + result1 + "&test2=" + result2 + "&test3=" + result3
				+ "&test4=" + result4 + "&test5=" + result5 + "&test6=" + result6 + "&test7=" + result7 + "&test8="
				+ result8 + "&test9=" + result9 + "&test10=" + result10 + "&test11=" + result11 + "&testComplete="
				+ testCompleteText).forward(request, response);
	}

	private String testMQ() {
		String result = "OK";
		JMSManager theJMSmanager = JMSManager.getInstance();
		synchronized (theJMSmanager) {
			try {
				String queueName = "vbooking.request.passenger.booking";
				theJMSmanager.initQueueSession(queueName);
				String testResult = theJMSmanager.TestJMSrequest();
				if (testResult.equals("FAIL")) {
					throw new Exception();
				}
			} catch (Exception var7) {
				result = "ERROR";
			}

			return result;
		}
	}

	private String testActiveMQ() {
		String brokerURL = "tcp://localhost:61616";
		String physicalRequestQueueName = "VBOOKING.HOTEL.PAYMENT";
		String physicalReplyQueueName = "VBOOKING.HOTEL.PAYMENT.REPLY";
		Context jndiContext = null;
		ConnectionFactory connectionFactory = null;
		Connection connection = null;

		Properties paymentQueue;
		try {
			paymentQueue = new Properties();
			paymentQueue.setProperty("java.naming.factory.initial",
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			paymentQueue.setProperty("java.naming.provider.url", brokerURL);
			jndiContext = new InitialContext(paymentQueue);
		} catch (NamingException var23) {
			return "ERROR";
		}

		paymentQueue = null;
		Object var8 = null;

		try {
			connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		} catch (NamingException var22) {
			return "ERROR";
		}

		String var10;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			return "OK";
		} catch (JMSException var24) {
			var10 = "ERROR";
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException var21) {
					;
				}
			}

		}

		return var10;
	}

	private String testWS(String sessionID) {
		String result = "OK";

		try {
			ServletContext servletConfig = this.getServletContext();
			String url = servletConfig.getInitParameter("logonWSURL");
			LogonServiceImplServiceLocator loc = new LogonServiceImplServiceLocator();
			if (url != null) {
				loc.setLogonServiceImplEndpointAddress(url);
			}

			LogonServiceImpl port = loc.getLogonServiceImpl();
			port.isLoggedOn("greenhat", sessionID);
		} catch (Exception var7) {
			result = "ERROR";
		}

		return result;
	}

	private String testDB() {
		String result = "OK";
		java.sql.Connection connection = null;

		try {
			connection = com.vbooking.test.servlet.ConnectionFactory.getConnection("VBOOKING");
			String schema = System.getProperty("vbooking.schema");
			String schemaPrefix = schema != null ? schema + "." : "";
			PreparedStatement statement = connection.prepareStatement(
					"SELECT distinct FLIGHT_NUMBER FROM " + schemaPrefix + "RESERVATION ORDER BY FLIGHT_NUMBER");
			ResultSet dbResult = statement.executeQuery();
			dbResult.getFetchSize();
		} catch (Exception var15) {
			result = "ERROR";
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException var14) {
					var14.printStackTrace();
				}
			}

		}

		return result;
	}

	private String testFlightSearch() {
		String result = "OK";

		try {
			ServletContext servletConfig = this.getServletContext();
			String url = servletConfig.getInitParameter("flightWSURL");
			String from = "31/12/" + Calendar.getInstance().get(1);
			List<Flight> flights = null;
			flights = (new FlightsRest(url)).getFlightsByCriteria("STN", "EDI", from);
		} catch (Exception var6) {
			result = "ERROR";
		}

		return result;
	}

	private String testFCS() {
		String result = "OK";

		/*try {
			this.receiveMessageOnTestQueue("QM_vbooking", "vbooking.test", "localhost", 1414, "vbookingwebapp", true,
					1000);
		} catch (Exception var5) {
			;
		}

		try {
			MessageSender messageSender = new MessageSender("QM_vbooking", "vbooking.checkin", "vbooking.checkin.reply",
					"localhost", 1414, "vbookingwebapp");
			messageSender.send("VB297", "A00004", "Test for VBooking Validation");
			Thread.sleep(10000L);
			boolean testResult = this.receiveMessageOnTestQueue("QM_vbooking", "vbooking.test", "localhost", 1414,
					"vbookingwebapp", false, 5000);
			if (!testResult) {
				throw new Exception();
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			result = "ERROR";
		}*/

		return result;
	}

	/*private boolean receiveMessageOnTestQueue(String qmgrName, String queueName, String hostname, int port,
			String channelName, boolean clearMessages, int waitTime) throws MQException, IOException {
		MQQueueManager qm = null;
		MQQueue queue = null;

		try {
			if (hostname != null) {
				Hashtable<String, Object> properties = new Hashtable(3);
				properties.put("hostname", hostname);
				properties.put("port", port);
				properties.put("channel", channelName);
				qm = new MQQueueManager(qmgrName, properties);
			} else {
				qm = new MQQueueManager(qmgrName);
			}

			int receiveOptions = 8226;
			queue = qm.accessQueue(queueName, receiveOptions);
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			gmo.options = 24577;
			gmo.waitInterval = waitTime;
			String data = "No Result";

			do {
				MQMessage retrievedMessage = new MQMessage();
				queue.get(retrievedMessage, gmo);
				byte[] b = new byte[retrievedMessage.getMessageLength()];
				retrievedMessage.readFully(b);
				data = new String(b);
			} while (clearMessages);

			if (!clearMessages && data.contains("Test Validation Passed")) {
				boolean var23 = true;
				return var23;
			}
		} catch (MQException var19) {
			var19.printStackTrace();
			throw new MQException(var19.getCompCode(), var19.getReason(), var19.getClass());
		} catch (IOException var20) {
			throw new IOException(var20.getMessage());
		} finally {
			if (queue != null) {
				queue.close();
			}

			if (qm != null) {
				qm.close();
			}

		}

		return false;
	}
*/
	private String testHotelService() {
		String result = "OK";

		try {
			ServletContext servletConfig = this.getServletContext();
			String hotelURL = servletConfig.getInitParameter("hotelsWSURL");
			FindHotels fh = new FindHotels(hotelURL);
			String from = "01/01/" + Calendar.getInstance().get(1);
			String to = "07/01/" + Calendar.getInstance().get(1);
			fh.findHotels("Barcelona", from, to);
		} catch (Exception var7) {
			result = "ERROR";
		}

		return result;
	}

	private String testCurrencyService() {
		String result = "OK";

		try {
			ServletContext servletConfig = this.getServletContext();
			String currencyURL = servletConfig.getInitParameter("currencyWSURL");
			Currency c = Currency.getInstance(Locale.getDefault());
			CurrencyConverterServiceLocator csl = new CurrencyConverterServiceLocator();
			CurrencyConverter cc = csl.getCurrencyConverterPort(new URL(currencyURL));
			cc.currencyList(c.getCurrencyCode());
		} catch (Exception var7) {
			result = "ERROR";
		}

		return result;
	}

	private String testFFService() {
		String result = "OK";
		HttpURLConnection huc = null;

		try {
			ServletContext servletConfig = this.getServletContext();
			String ffURL = servletConfig.getInitParameter("frequentflyerWSURL");
			URL endpoint = new URL(ffURL + "?wsdl");
			huc = (HttpURLConnection) endpoint.openConnection();
			huc.setRequestMethod("GET");
			huc.connect();
			int responseCode = huc.getResponseCode();
			if (responseCode != 200) {
				throw new Exception();
			}
		} catch (Exception var10) {
			result = "ERROR";
		} finally {
			if (huc != null) {
				huc.disconnect();
			}

		}

		return result;
	}

	private String testDBSchema() {
		String result = "OK";
		java.sql.Connection connection = null;

		try {
			connection = com.vbooking.test.servlet.ConnectionFactory.getConnection("VBOOKING");
			Statement testStatement = connection.createStatement();
			String[] tableNames = new String[]{"RESERVATION", "FLIGHTS", "FLIGHTMILES"};

			for (int i = 0; i < tableNames.length; ++i) {
				String tableName = tableNames[i];
				ResultSet resultSet = testStatement
						.executeQuery("select * from " + tableName + " fetch first row only");
				resultSet.next();
				ResultSetMetaData rsMetaData = resultSet.getMetaData();
				boolean incorrectSchema = false;
				incorrectSchema = this.verifyColumnNamesAndTypes(rsMetaData, tableName);
				if (incorrectSchema) {
					throw new Exception();
				}
			}

			connection = com.vbooking.test.servlet.ConnectionFactory.getConnection("VBEXRATE");
			testStatement = connection.createStatement();
			String tableName = "CURRENCYRATES";
			ResultSet resultSet = testStatement.executeQuery("select * from " + tableName + " fetch first row only");
			resultSet.next();
			ResultSetMetaData rsMetaData = resultSet.getMetaData();
			boolean incorrectSchema = false;
			incorrectSchema = this.verifyColumnNamesAndTypes(rsMetaData, tableName);
			if (incorrectSchema) {
				throw new Exception();
			}
		} catch (Exception var18) {
			result = "ERROR";
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException var17) {
					var17.printStackTrace();
				}
			}

		}

		return result;
	}

	private String testAvailableSeats() {
		String result = "OK";
		HttpURLConnection huc = null;

		try {
			ServletContext servletConfig = this.getServletContext();
			String ffURL = servletConfig.getInitParameter("availableseatsWSURL");
			URL endpoint = new URL(ffURL + "?wsdl");
			huc = (HttpURLConnection) endpoint.openConnection();
			huc.setRequestMethod("GET");
			huc.connect();
			int responseCode = huc.getResponseCode();
			if (responseCode != 200) {
				throw new Exception();
			}
		} catch (Exception var10) {
			result = "ERROR";
		} finally {
			if (huc != null) {
				huc.disconnect();
			}

		}

		return result;
	}

	private boolean verifyColumnNamesAndTypes(ResultSetMetaData resultSetMetaData, String tableName) {
		int totalColumns;
		int i;
		String columnName;
		String columnType;
		if (tableName.equalsIgnoreCase("RESERVATION")) {
			try {
				totalColumns = resultSetMetaData.getColumnCount();
				if (totalColumns != 15) {
					return true;
				}

				for (i = 1; i <= totalColumns; ++i) {
					columnName = resultSetMetaData.getColumnName(i);
					columnType = resultSetMetaData.getColumnTypeName(i);
					switch (i) {
						case 1 :
							if (columnName.equalsIgnoreCase("ID") && columnType.equalsIgnoreCase("INTEGER")) {
								break;
							}

							return true;
						case 2 :
							if (columnName.equalsIgnoreCase("GENDER") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 3 :
							if (columnName.equalsIgnoreCase("MIDDLE_NAME") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 4 :
							if (columnName.equalsIgnoreCase("FIRST_NAME") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 5 :
							if (columnName.equalsIgnoreCase("WEEK_NUMBER") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 6 :
							if (columnName.equalsIgnoreCase("FLIGHT_NUMBER")
									&& columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 7 :
							if (!columnName.equalsIgnoreCase("RESERVATION_NUMBER")
									|| !columnType.equalsIgnoreCase("VARCHAR")) {
								return true;
							}
							break;
						case 8 :
							if (columnName.equalsIgnoreCase("LAST_NAME") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 9 :
							if (columnName.equalsIgnoreCase("COMMENT") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 10 :
							if (columnName.equalsIgnoreCase("CARDHOLDER_NAME")
									&& columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 11 :
							if (columnName.equalsIgnoreCase("CARD_TYPE") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 12 :
							if (columnName.equalsIgnoreCase("CARD_NUMBER") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 13 :
							if (columnName.equalsIgnoreCase("CARD_SEC_CODE")
									&& columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 14 :
							if (columnName.equalsIgnoreCase("PASSPORT_ID") && columnType.equalsIgnoreCase("VARCHAR")) {
								break;
							}

							return true;
						case 15 :
							if (!columnName.equalsIgnoreCase("BOARDED") || !columnType.equalsIgnoreCase("VARCHAR")) {
								return true;
							}
					}
				}
			} catch (SQLException var7) {
				var7.printStackTrace();
				return true;
			}
		} else if (tableName.equalsIgnoreCase("FLIGHTS")) {
			try {
				totalColumns = resultSetMetaData.getColumnCount();
				if (totalColumns != 7) {
					return true;
				}

				for (i = 1; i <= totalColumns; ++i) {
					columnName = resultSetMetaData.getColumnName(i);
					columnType = resultSetMetaData.getColumnTypeName(i);
					switch (i) {
						case 1 :
							if (!columnName.equalsIgnoreCase("FLIGHT_NO") || !columnType.equalsIgnoreCase("CHAR")) {
								return true;
							}
							break;
						case 2 :
							if (!columnName.equalsIgnoreCase("DEP_AIRPORT") || !columnType.equalsIgnoreCase("CHAR")) {
								return true;
							}
							break;
						case 3 :
							if (!columnName.equalsIgnoreCase("DEP_TIME") || !columnType.equalsIgnoreCase("TIME")) {
								return true;
							}
							break;
						case 4 :
							if (columnName.equalsIgnoreCase("ARR_AIRPORT") && columnType.equalsIgnoreCase("CHAR")) {
								break;
							}

							return true;
						case 5 :
							if (!columnName.equalsIgnoreCase("ARR_TIME") || !columnType.equalsIgnoreCase("TIME")) {
								return true;
							}
							break;
						case 6 :
							if (!columnName.equalsIgnoreCase("PRICE") || !columnType.equalsIgnoreCase("INTEGER")) {
								return true;
							}
							break;
						case 7 :
							if (!columnName.equalsIgnoreCase("DAY_OF_WEEK")
									|| !columnType.equalsIgnoreCase("INTEGER")) {
								return true;
							}
					}
				}
			} catch (SQLException var8) {
				var8.printStackTrace();
				return true;
			}
		} else if (tableName.equalsIgnoreCase("FLIGHTMILES")) {
			try {
				totalColumns = resultSetMetaData.getColumnCount();
				if (totalColumns != 4) {
					return true;
				}

				for (i = 1; i <= totalColumns; ++i) {
					columnName = resultSetMetaData.getColumnName(i);
					columnType = resultSetMetaData.getColumnTypeName(i);
					switch (i) {
						case 1 :
							if (columnName.equalsIgnoreCase("ID") && columnType.equalsIgnoreCase("INTEGER")) {
								break;
							}

							return true;
						case 2 :
							if (columnName.equalsIgnoreCase("DEP_AIRPORT") && columnType.equalsIgnoreCase("CHAR")) {
								break;
							}

							return true;
						case 3 :
							if (!columnName.equalsIgnoreCase("DEST_AIRPORT") || !columnType.equalsIgnoreCase("CHAR")) {
								return true;
							}
							break;
						case 4 :
							if (!columnName.equalsIgnoreCase("AIR_MILES_AVAILABLE")
									|| !columnType.equalsIgnoreCase("INTEGER")) {
								return true;
							}
					}
				}
			} catch (SQLException var9) {
				var9.printStackTrace();
				return true;
			}
		} else {
			if (!tableName.equalsIgnoreCase("CURRENCYRATES")) {
				return true;
			}

			try {
				totalColumns = resultSetMetaData.getColumnCount();
				if (totalColumns != 4) {
					return true;
				}

				for (i = 1; i <= totalColumns; ++i) {
					columnName = resultSetMetaData.getColumnName(i);
					columnType = resultSetMetaData.getColumnTypeName(i);
					switch (i) {
						case 1 :
							if (columnName.equalsIgnoreCase("ID") && columnType.equalsIgnoreCase("INTEGER")) {
								break;
							}

							return true;
						case 2 :
							if (columnName.equalsIgnoreCase("FROM_CURRENCY") && columnType.equalsIgnoreCase("CHAR")) {
								break;
							}

							return true;
						case 3 :
							if (columnName.equalsIgnoreCase("TO_CURRENCY") && columnType.equalsIgnoreCase("CHAR")) {
								break;
							}

							return true;
						case 4 :
							if (!columnName.equalsIgnoreCase("CONVERSION_RATE")
									|| !columnType.equalsIgnoreCase("DOUBLE")) {
								return true;
							}
					}
				}
			} catch (SQLException var10) {
				var10.printStackTrace();
				return true;
			}
		}

		return false;
	}
}