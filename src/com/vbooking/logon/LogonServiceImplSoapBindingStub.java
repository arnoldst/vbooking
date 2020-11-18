package com.vbooking.logon;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.holders.BooleanHolder;
import javax.xml.rpc.holders.StringHolder;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

public class LogonServiceImplSoapBindingStub extends Stub implements LogonServiceImpl {
	private Vector cachedSerClasses;
	private Vector cachedSerQNames;
	private Vector cachedSerFactories;
	private Vector cachedDeserFactories;
	static OperationDesc[] _operations = new OperationDesc[3];

	private static void _initOperationDesc1() {
		OperationDesc oper = new OperationDesc();
		oper.setName("logon");
		ParameterDesc param = new ParameterDesc(new QName("http://logon.vbooking.com", "username"), (byte) 1,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		param.setNillable(true);
		oper.addParameter(param);
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "password"), (byte) 1,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		param.setNillable(true);
		oper.addParameter(param);
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "logonReturn"), (byte) 2,
				new QName("http://www.w3.org/2001/XMLSchema", "boolean"), Boolean.TYPE, false, false);
		oper.addParameter(param);
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "sessionID"), (byte) 2,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(XMLType.AXIS_VOID);
		oper.setStyle(Style.WRAPPED);
		oper.setUse(Use.LITERAL);
		_operations[0] = oper;
		oper = new OperationDesc();
		oper.setName("logoff");
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "username"), (byte) 1,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		oper.addParameter(param);
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "sessionID"), (byte) 1,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(XMLType.AXIS_VOID);
		oper.setStyle(Style.WRAPPED);
		oper.setUse(Use.LITERAL);
		_operations[1] = oper;
		oper = new OperationDesc();
		oper.setName("isLoggedOn");
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "username"), (byte) 1,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		oper.addParameter(param);
		param = new ParameterDesc(new QName("http://logon.vbooking.com", "sessionID"), (byte) 1,
				new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
		oper.setReturnClass(Boolean.TYPE);
		oper.setReturnQName(new QName("http://logon.vbooking.com", "isLoggedOnReturn"));
		oper.setStyle(Style.WRAPPED);
		oper.setUse(Use.LITERAL);
		_operations[2] = oper;
	}

	public LogonServiceImplSoapBindingStub() throws AxisFault {
		this((Service) null);
	}

	public LogonServiceImplSoapBindingStub(URL endpointURL, Service service) throws AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public LogonServiceImplSoapBindingStub(Service service) throws AxisFault {
		this.cachedSerClasses = new Vector();
		this.cachedSerQNames = new Vector();
		this.cachedSerFactories = new Vector();
		this.cachedDeserFactories = new Vector();
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}

		((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
	}

	protected Call createCall() throws RemoteException {
		try {
			Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}

			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}

			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}

			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}

			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}

			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}

			Enumeration keys = super.cachedProperties.keys();

			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}

			return _call;
		} catch (Throwable var4) {
			throw new AxisFault("Failure trying to get the Call object", var4);
		}
	}

	public void logon(String username, String password, BooleanHolder logonReturn, StringHolder sessionID)
			throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		} else {
			Call _call = this.createCall();
			_call.setOperation(_operations[0]);
			_call.setUseSOAPAction(true);
			_call.setSOAPActionURI("logon");
			_call.setEncodingStyle((String) null);
			_call.setProperty("sendXsiTypes", Boolean.FALSE);
			_call.setProperty("sendMultiRefs", Boolean.FALSE);
			_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
			_call.setOperationName(new QName("http://logon.vbooking.com", "logon"));
			this.setRequestHeaders(_call);
			this.setAttachments(_call);

			try {
				Object _resp = _call.invoke(new Object[]{username, password});
				if (_resp instanceof RemoteException) {
					throw (RemoteException) _resp;
				} else {
					this.extractAttachments(_call);
					Map _output = _call.getOutputParams();

					try {
						logonReturn.value = (Boolean) _output
								.get(new QName("http://logon.vbooking.com", "logonReturn"));
					} catch (Exception var10) {
						logonReturn.value = (Boolean) JavaUtils.convert(
								_output.get(new QName("http://logon.vbooking.com", "logonReturn")), Boolean.TYPE);
					}

					try {
						sessionID.value = (String) _output.get(new QName("http://logon.vbooking.com", "sessionID"));
					} catch (Exception var9) {
						sessionID.value = (String) JavaUtils.convert(
								_output.get(new QName("http://logon.vbooking.com", "sessionID")), String.class);
					}

				}
			} catch (AxisFault var11) {
				throw var11;
			}
		}
	}

	public void logoff(String username, String sessionID) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		} else {
			Call _call = this.createCall();
			_call.setOperation(_operations[1]);
			_call.setUseSOAPAction(true);
			_call.setSOAPActionURI("logoff");
			_call.setEncodingStyle((String) null);
			_call.setProperty("sendXsiTypes", Boolean.FALSE);
			_call.setProperty("sendMultiRefs", Boolean.FALSE);
			_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
			_call.setOperationName(new QName("http://logon.vbooking.com", "logoff"));
			this.setRequestHeaders(_call);
			this.setAttachments(_call);

			try {
				Object _resp = _call.invoke(new Object[]{username, sessionID});
				if (_resp instanceof RemoteException) {
					throw (RemoteException) _resp;
				} else {
					this.extractAttachments(_call);
				}
			} catch (AxisFault var5) {
				throw var5;
			}
		}
	}

	public boolean isLoggedOn(String username, String sessionID) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		} else {
			Call _call = this.createCall();
			_call.setOperation(_operations[2]);
			_call.setUseSOAPAction(true);
			_call.setSOAPActionURI("isLoggedOn");
			_call.setEncodingStyle((String) null);
			_call.setProperty("sendXsiTypes", Boolean.FALSE);
			_call.setProperty("sendMultiRefs", Boolean.FALSE);
			_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
			_call.setOperationName(new QName("http://logon.vbooking.com", "isLoggedOn"));
			this.setRequestHeaders(_call);
			this.setAttachments(_call);

			try {
				Object _resp = _call.invoke(new Object[]{username, sessionID});
				if (_resp instanceof RemoteException) {
					throw (RemoteException) _resp;
				} else {
					this.extractAttachments(_call);

					try {
						return (Boolean) _resp;
					} catch (Exception var6) {
						return (Boolean) JavaUtils.convert(_resp, Boolean.TYPE);
					}
				}
			} catch (AxisFault var7) {
				throw var7;
			}
		}
	}

	static {
		_initOperationDesc1();
	}
}