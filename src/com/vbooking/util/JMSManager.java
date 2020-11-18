package com.vbooking.util;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSManager {
	private static JMSManager instance = null;
	private String jmsUserName = null;
	private String jmsPassword = null;
	private String requestQueueName = null;
	private String replyQueueName = null;
	private Context jndiContext = null;
	private QueueConnection queueConnection = null;
	private QueueConnectionFactory queueFactory = null;
	private Queue requestQueue = null;
	private Queue replyQueue = null;
	private QueueSession queueSession = null;

	public static synchronized JMSManager getInstance() {
		if (instance == null) {
			instance = new JMSManager();
		}

		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void init(String setJmsUserName, String setJmsPassword) throws JMSManagerException {
		this.jmsUserName = setJmsUserName;
		this.jmsPassword = setJmsPassword;

		try {
			this.jndiContext =   new InitialContext();
		} catch (NamingException var5) {
			var5.printStackTrace();
			throw new JMSManagerException("Error crreating JNDI initial context", var5);
		}

		try {
			this.queueFactory = (QueueConnectionFactory) this.jndiContext.lookup("jms/MyQCF");
		} catch (NamingException var4) {
			var4.printStackTrace();
			throw new JMSManagerException("JMS QueueConnectionFactory JNDI lookup failure", var4);
		}
	}

	public String getRequestQueueName() {
		return this.requestQueueName;
	}

	public String getReplyQueueName() {
		return this.replyQueueName;
	}

	public void initQueueSession(String queueName) throws JMSManagerException {
		this.initQueueSession(queueName, queueName + ".reply");
	}

	public void initQueueSession(String queueName, String replyQueueName) throws JMSManagerException {
		this.requestQueueName = queueName;
		this.replyQueueName = replyQueueName;

		try {
			this.requestQueue = (Queue) this.jndiContext.lookup(queueName);
		} catch (NamingException var6) {
			var6.printStackTrace();
			throw new JMSManagerException(queueName + " JNDI look-up failure", var6);
		}

		try {
			this.replyQueue = (Queue) this.jndiContext.lookup(replyQueueName);
		} catch (NamingException var5) {
			;
		}
/*
		try {
			/*
			if (this.jmsUserName != null && !this.jmsUserName.equals("")) {
				this.queueConnection = this.queueFactory.createQueueConnection(this.jmsUserName, this.jmsPassword);
			} else {
				this.queueConnection = this.queueFactory.createQueueConnection();
			}

			this.queueConnection.start();
			this.queueSession = this.queueConnection.createQueueSession(false, 1);
			
		} catch (JMSException var7) {
			var7.printStackTrace();
			Exception le = var7.getLinkedException();
			if (le != null) {
				System.err.println("Linked exception:");
				le.printStackTrace();
			}

			throw new JMSManagerException("JMS initialisation error", var7);
		}*/
	}

	public String doJMSrequest(String requestXML) throws JMSManagerException {
		String responseXML = "";

		try {

			//this.queueConnection.start();
			//try {this.queueConnection.start();} catch (Exception e) {}
			//this.queueSession = this.queueConnection.createQueueSession(false, 1);
			if (this.jmsUserName != null && !this.jmsUserName.equals("")) {
				this.queueConnection = this.queueFactory.createQueueConnection(this.jmsUserName, this.jmsPassword);
			} else {
				this.queueConnection = this.queueFactory.createQueueConnection();
			}

			this.queueConnection.start();
			this.queueSession = this.queueConnection.createQueueSession(false, 1);
	
			
			TextMessage requestMsg = this.queueSession.createTextMessage();
			requestMsg.setText(requestXML);
			System.out.println("Firing request on queue '" + this.requestQueue.getQueueName() + "'");
			System.out.println("Listening on queue '" + this.replyQueue.getQueueName() + "'");
			requestMsg.setJMSReplyTo(this.replyQueue);
			QueueSender sender = this.queueSession.createSender(this.requestQueue);
			sender.send(requestMsg);
			String correlationId = requestMsg.getJMSMessageID();
			System.out.println("correlationId '" + correlationId + "'");
			MessageConsumer consumer = this.queueSession.createConsumer(this.replyQueue);
			long l = 120000L;

			try {
				String s = System.getProperty("vbooking.jms.timeout");
				if (s != null) {
					System.out.println("Receive timeout set " + s);
					l = Long.parseLong(s);
				}
			} catch (Exception var11) {
				;
			}

			System.out.println("Receive timeout is " + Long.toString(l));
			Message responseMsg = consumer.receive(l);
			consumer.close();
			sender.close();
			//queueSession.close();
			
			if (responseMsg == null) {
				throw new JMSManagerException("JMS request timeout");
			} else {
				TextMessage responseTextMsg = (TextMessage) responseMsg;
				System.out.println("received correlationId '" + responseTextMsg.getJMSCorrelationID() + "'");
				responseXML = responseTextMsg.getText();
				return responseXML;
			}
		} catch (JMSException var12) {
			var12.printStackTrace();
			Exception le = var12.getLinkedException();
			if (le != null) {
				System.err.println("Linked exception:");
				le.printStackTrace();
			}
			try{
			    //queueSession.close();
			    
			} catch (Exception e){}
			throw new JMSManagerException("JMS request error", var12);
		}
	}

	public String TestJMSrequest() throws JMSManagerException {
		String responseText = "unsure";

		try {
			System.out.println("Listening on queue '" + this.replyQueue.getQueueName() + "'");
			MessageConsumer consumer = this.queueSession.createConsumer(this.replyQueue);
			long l = 1000L;
			Message responseMsg = consumer.receive(l);
			consumer.close();
			if (responseMsg == null) {
				responseText = "OK";
			} else {
				TextMessage responseTextMsg = (TextMessage) responseMsg;
				responseText = responseTextMsg.getText();
			}
		} catch (JMSException var7) {
			responseText = "FAIL";
		}

		return responseText;
	}

	public void close() {
		System.out.println("Closing JMS connection");

		try {
			this.queueConnection.close();
		} catch (JMSException var2) {
			var2.printStackTrace();
		}

	}
}