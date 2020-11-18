package com.vbooking.logon;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;
import javax.xml.rpc.holders.BooleanHolder;
import javax.xml.rpc.holders.StringHolder;

public class LogonServiceImplProxy implements LogonServiceImpl {
	private String _endpoint = null;
	private LogonServiceImpl logonServiceImpl = null;

	public LogonServiceImplProxy() {
		this._initLogonServiceImplProxy();
	}

	public LogonServiceImplProxy(String endpoint) {
		this._endpoint = endpoint;
		this._initLogonServiceImplProxy();
	}

	private void _initLogonServiceImplProxy() {
		try {
			this.logonServiceImpl = (new LogonServiceImplServiceLocator()).getLogonServiceImpl();
			if (this.logonServiceImpl != null) {
				if (this._endpoint != null) {
					((Stub) this.logonServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address",
							this._endpoint);
				} else {
					this._endpoint = (String) ((Stub) this.logonServiceImpl)
							._getProperty("javax.xml.rpc.service.endpoint.address");
				}
			}
		} catch (ServiceException var2) {
			;
		}

	}

	public String getEndpoint() {
		return this._endpoint;
	}

	public void setEndpoint(String endpoint) {
		this._endpoint = endpoint;
		if (this.logonServiceImpl != null) {
			((Stub) this.logonServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
		}

	}

	public LogonServiceImpl getLogonServiceImpl() {
		if (this.logonServiceImpl == null) {
			this._initLogonServiceImplProxy();
		}

		return this.logonServiceImpl;
	}

	public void logon(String username, String password, BooleanHolder logonReturn, StringHolder sessionID)
			throws RemoteException {
		if (this.logonServiceImpl == null) {
			this._initLogonServiceImplProxy();
		}

		this.logonServiceImpl.logon(username, password, logonReturn, sessionID);
	}

	public void logoff(String username, String sessionID) throws RemoteException {
		if (this.logonServiceImpl == null) {
			this._initLogonServiceImplProxy();
		}

		this.logonServiceImpl.logoff(username, sessionID);
	}

	public boolean isLoggedOn(String username, String sessionID) throws RemoteException {
		if (this.logonServiceImpl == null) {
			this._initLogonServiceImplProxy();
		}

		return this.logonServiceImpl.isLoggedOn(username, sessionID);
	}
}