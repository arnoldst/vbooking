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

public class UpdateServiceLocator extends Service implements UpdateService {
	private String UpdatePort_address = "http://localhost:9080/com.vbooking.mybooking/services/UpdatePort";
	private String UpdatePortWSDDServiceName = "UpdatePort";
	private HashSet ports = null;

	public UpdateServiceLocator() {
	}

	public UpdateServiceLocator(EngineConfiguration config) {
		super(config);
	}

	public UpdateServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
		super(wsdlLoc, sName);
	}

	public String getUpdatePortAddress() {
		return this.UpdatePort_address;
	}

	public String getUpdatePortWSDDServiceName() {
		return this.UpdatePortWSDDServiceName;
	}

	public void setUpdatePortWSDDServiceName(String name) {
		this.UpdatePortWSDDServiceName = name;
	}

	public Update getUpdatePort() throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(this.UpdatePort_address);
		} catch (MalformedURLException var3) {
			throw new ServiceException(var3);
		}

		return this.getUpdatePort(endpoint);
	}

	public Update getUpdatePort(URL portAddress) throws ServiceException {
		try {
			UpdateBindingStub _stub = new UpdateBindingStub(portAddress, this);
			_stub.setPortName(this.getUpdatePortWSDDServiceName());
			return _stub;
		} catch (AxisFault var3) {
			return null;
		}
	}

	public void setUpdatePortEndpointAddress(String address) {
		this.UpdatePort_address = address;
	}

	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (Update.class.isAssignableFrom(serviceEndpointInterface)) {
				UpdateBindingStub _stub = new UpdateBindingStub(new URL(this.UpdatePort_address), this);
				_stub.setPortName(this.getUpdatePortWSDDServiceName());
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
			if ("UpdatePort".equals(inputPortName)) {
				return this.getUpdatePort();
			} else {
				Remote _stub = this.getPort(serviceEndpointInterface);
				((Stub) _stub).setPortName(portName);
				return _stub;
			}
		}
	}

	public QName getServiceName() {
		return new QName("http://types.reservations.vbooking.com/wsdl/Reservation", "UpdateService");
	}

	public Iterator getPorts() {
		if (this.ports == null) {
			this.ports = new HashSet();
			this.ports.add(new QName("http://types.reservations.vbooking.com/wsdl/Reservation", "UpdatePort"));
		}

		return this.ports.iterator();
	}

	public void setEndpointAddress(String portName, String address) throws ServiceException {
		if ("UpdatePort".equals(portName)) {
			this.setUpdatePortEndpointAddress(address);
		} else {
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	public void setEndpointAddress(QName portName, String address) throws ServiceException {
		this.setEndpointAddress(portName.getLocalPart(), address);
	}
}
