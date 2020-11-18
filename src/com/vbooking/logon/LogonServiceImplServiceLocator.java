package com.vbooking.logon;

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

public class LogonServiceImplServiceLocator extends Service implements LogonServiceImplService {
	private String LogonServiceImpl_address = "http://localhost:9080/com.vbooking.mybooking/services/LogonServiceImpl";
	private String LogonServiceImplWSDDServiceName = "LogonServiceImpl";
	private HashSet ports = null;

	public LogonServiceImplServiceLocator() {
	}

	public LogonServiceImplServiceLocator(EngineConfiguration config) {
		super(config);
	}

	public LogonServiceImplServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
		super(wsdlLoc, sName);
	}

	public String getLogonServiceImplAddress() {
		return this.LogonServiceImpl_address;
	}

	public String getLogonServiceImplWSDDServiceName() {
		return this.LogonServiceImplWSDDServiceName;
	}

	public void setLogonServiceImplWSDDServiceName(String name) {
		this.LogonServiceImplWSDDServiceName = name;
	}

	public LogonServiceImpl getLogonServiceImpl() throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(this.LogonServiceImpl_address);
		} catch (MalformedURLException var3) {
			throw new ServiceException(var3);
		}

		return this.getLogonServiceImpl(endpoint);
	}

	public LogonServiceImpl getLogonServiceImpl(URL portAddress) throws ServiceException {
		try {
			LogonServiceImplSoapBindingStub _stub = new LogonServiceImplSoapBindingStub(portAddress, this);
			_stub.setPortName(this.getLogonServiceImplWSDDServiceName());
			return _stub;
		} catch (AxisFault var3) {
			return null;
		}
	}

	public void setLogonServiceImplEndpointAddress(String address) {
		this.LogonServiceImpl_address = address;
	}

	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (LogonServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
				LogonServiceImplSoapBindingStub _stub = new LogonServiceImplSoapBindingStub(
						new URL(this.LogonServiceImpl_address), this);
				_stub.setPortName(this.getLogonServiceImplWSDDServiceName());
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
			if ("LogonServiceImpl".equals(inputPortName)) {
				return this.getLogonServiceImpl();
			} else {
				Remote _stub = this.getPort(serviceEndpointInterface);
				((Stub) _stub).setPortName(portName);
				return _stub;
			}
		}
	}

	public QName getServiceName() {
		return new QName("http://logon.vbooking.com", "LogonServiceImplService");
	}

	public Iterator getPorts() {
		if (this.ports == null) {
			this.ports = new HashSet();
			this.ports.add(new QName("http://logon.vbooking.com", "LogonServiceImpl"));
		}

		return this.ports.iterator();
	}

	public void setEndpointAddress(String portName, String address) throws ServiceException {
		if ("LogonServiceImpl".equals(portName)) {
			this.setLogonServiceImplEndpointAddress(address);
		} else {
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	public void setEndpointAddress(QName portName, String address) throws ServiceException {
		this.setEndpointAddress(portName.getLocalPart(), address);
	}
}