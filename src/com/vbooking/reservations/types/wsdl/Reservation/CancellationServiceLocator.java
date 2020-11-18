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

public class CancellationServiceLocator extends Service implements CancellationService {
	private String CancellationPort_address = "http://localhost:9080/com.vbooking.mybooking/services/CancellationPort";
	private String CancellationPortWSDDServiceName = "CancellationPort";
	private HashSet ports = null;

	public CancellationServiceLocator() {
	}

	public CancellationServiceLocator(EngineConfiguration config) {
		super(config);
	}

	public CancellationServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
		super(wsdlLoc, sName);
	}

	public String getCancellationPortAddress() {
		return this.CancellationPort_address;
	}

	public String getCancellationPortWSDDServiceName() {
		return this.CancellationPortWSDDServiceName;
	}

	public void setCancellationPortWSDDServiceName(String name) {
		this.CancellationPortWSDDServiceName = name;
	}

	public Cancellation getCancellationPort() throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(this.CancellationPort_address);
		} catch (MalformedURLException var3) {
			throw new ServiceException(var3);
		}

		return this.getCancellationPort(endpoint);
	}

	public Cancellation getCancellationPort(URL portAddress) throws ServiceException {
		try {
			CancellationBindingStub _stub = new CancellationBindingStub(portAddress, this);
			_stub.setPortName(this.getCancellationPortWSDDServiceName());
			return _stub;
		} catch (AxisFault var3) {
			return null;
		}
	}

	public void setCancellationPortEndpointAddress(String address) {
		this.CancellationPort_address = address;
	}

	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (Cancellation.class.isAssignableFrom(serviceEndpointInterface)) {
				CancellationBindingStub _stub = new CancellationBindingStub(new URL(this.CancellationPort_address),
						this);
				_stub.setPortName(this.getCancellationPortWSDDServiceName());
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
			if ("CancellationPort".equals(inputPortName)) {
				return this.getCancellationPort();
			} else {
				Remote _stub = this.getPort(serviceEndpointInterface);
				((Stub) _stub).setPortName(portName);
				return _stub;
			}
		}
	}

	public QName getServiceName() {
		return new QName("http://types.reservations.vbooking.com/wsdl/Reservation", "CancellationService");
	}

	public Iterator getPorts() {
		if (this.ports == null) {
			this.ports = new HashSet();
			this.ports.add(new QName("http://types.reservations.vbooking.com/wsdl/Reservation", "CancellationPort"));
		}

		return this.ports.iterator();
	}

	public void setEndpointAddress(String portName, String address) throws ServiceException {
		if ("CancellationPort".equals(portName)) {
			this.setCancellationPortEndpointAddress(address);
		} else {
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	public void setEndpointAddress(QName portName, String address) throws ServiceException {
		this.setEndpointAddress(portName.getLocalPart(), address);
	}
}
