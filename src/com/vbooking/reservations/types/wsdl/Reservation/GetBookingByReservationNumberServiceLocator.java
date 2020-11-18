package com.vbooking.reservations.types.wsdl.Reservation;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

public class GetBookingByReservationNumberServiceLocator extends Service
		implements
			GetBookingByReservationNumberService {
	private String GetBookingByReservationNumberPort_address = "http://localhost:9080/com.vbooking.mybooking/services/GetBookingByReservationNumberPort";
	private String GetBookingByReservationNumberPortWSDDServiceName = "GetBookingByReservationNumberPort";
	private HashSet ports = null;

	public GetBookingByReservationNumberServiceLocator() {
	}

	public GetBookingByReservationNumberServiceLocator(EngineConfiguration config) {
		super(config);
	}

	public GetBookingByReservationNumberServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
		super(wsdlLoc, sName);
	}

	public String getGetBookingByReservationNumberPortAddress() {
		return this.GetBookingByReservationNumberPort_address;
	}

	public String getGetBookingByReservationNumberPortWSDDServiceName() {
		return this.GetBookingByReservationNumberPortWSDDServiceName;
	}

	public void setGetBookingByReservationNumberPortWSDDServiceName(String name) {
		this.GetBookingByReservationNumberPortWSDDServiceName = name;
	}

	public GetBookingByReservationNumber getGetBookingByReservationNumberPort() throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(this.GetBookingByReservationNumberPort_address);
		} catch (MalformedURLException var3) {
			throw new ServiceException(var3);
		}

		return this.getGetBookingByReservationNumberPort(endpoint);
	}

	public GetBookingByReservationNumber getGetBookingByReservationNumberPort(URL portAddress) throws ServiceException {
		try {
			GetBookingByReservationNumberBindingStub _stub = new GetBookingByReservationNumberBindingStub(portAddress,
					this);
			_stub.setPortName(this.getGetBookingByReservationNumberPortWSDDServiceName());
			return _stub;
		} catch (AxisFault var3) {
			return null;
		}
	}

	public void setGetBookingByReservationNumberPortEndpointAddress(String address) {
		this.GetBookingByReservationNumberPort_address = address;
	}

	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (GetBookingByReservationNumber.class.isAssignableFrom(serviceEndpointInterface)) {
				GetBookingByReservationNumberBindingStub _stub = new GetBookingByReservationNumberBindingStub(
						new URL(this.GetBookingByReservationNumberPort_address), this);
				_stub.setPortName(this.getGetBookingByReservationNumberPortWSDDServiceName());
				return _stub;
			}
		} catch (Throwable var3) {
			throw new ServiceException(var3);
		}

		throw new ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
		if (portName == null) {
			return this.getPort(serviceEndpointInterface);
		} else {
			String inputPortName = portName.getLocalPart();
			if ("GetBookingByReservationNumberPort".equals(inputPortName)) {
				return this.getGetBookingByReservationNumberPort();
			} else {
				Remote _stub = this.getPort(serviceEndpointInterface);
				((Stub) _stub).setPortName(portName);
				return _stub;
			}
		}
	}

	public QName getServiceName() {
		return new QName("http://types.reservations.vbooking.com/wsdl/Reservation",
				"GetBookingByReservationNumberService");
	}

	public Iterator getPorts() {
		if (this.ports == null) {
			this.ports = new HashSet();
			this.ports.add(new QName("http://types.reservations.vbooking.com/wsdl/Reservation",
					"GetBookingByReservationNumberPort"));
		}

		return this.ports.iterator();
	}

	public void setEndpointAddress(String portName, String address) throws ServiceException {
		if ("GetBookingByReservationNumberPort".equals(portName)) {
			this.setGetBookingByReservationNumberPortEndpointAddress(address);
		} else {
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	public void setEndpointAddress(QName portName, String address) throws ServiceException {
		this.setEndpointAddress(portName.getLocalPart(), address);
	}
}