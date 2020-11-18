package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.BookFlightResponse.BookFlightResponse;
import com.vbooking.reservations.schemas.CancelBookingResponse.CancelBookingResponse;
import com.vbooking.reservations.schemas.Response.Response;
import com.vbooking.reservations.schemas.UpdateBookingRequest.UpdateBookingRequestType;
import com.vbooking.reservations.schemas.UpdateBookingResponse.UpdateBookingResponse;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.SerializerFactory;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.FaultDesc;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.DeserializerFactory;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

public class UpdateBindingStub extends Stub implements Update {
	private Vector cachedSerClasses;
	private Vector cachedSerQNames;
	private Vector cachedSerFactories;
	private Vector cachedDeserFactories;
	static OperationDesc[] _operations = new OperationDesc[1];

	private static void _initOperationDesc1() {
		OperationDesc oper = new OperationDesc();
		oper.setName("UpdateBooking");
		ParameterDesc param = new ParameterDesc(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "UpdateBookingRequest"),
				(byte) 1,
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "UpdateBookingRequestType"),
				UpdateBookingRequestType.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingResponse", ">UpdateBookingResponse"));
		oper.setReturnClass(UpdateBookingResponse.class);
		oper.setReturnQName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingResponse", "UpdateBookingResponse"));
		oper.setStyle(Style.DOCUMENT);
		oper.setUse(Use.LITERAL);
		oper.addFault(new FaultDesc(
				new QName("http://reservations.vbooking.com/schemas/AuthenticationFault", "AuthenticationFault"),
				"com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault",
				new QName("http://reservations.vbooking.com/schemas/AuthenticationFault", ">AuthenticationFault"),
				true));
		_operations[0] = oper;
	}

	public UpdateBindingStub() throws AxisFault {
		this((Service) null);
	}

	public UpdateBindingStub(URL endpointURL, Service service) throws AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public UpdateBindingStub(Service service) throws AxisFault {
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
		Class beansf = BeanSerializerFactory.class;
		Class beandf = BeanDeserializerFactory.class;
		Class enumsf = EnumSerializerFactory.class;
		Class enumdf = EnumDeserializerFactory.class;
		Class arraysf = ArraySerializerFactory.class;
		Class arraydf = ArrayDeserializerFactory.class;
		Class simplesf = SimpleSerializerFactory.class;
		Class simpledf = SimpleDeserializerFactory.class;
		Class simplelistsf = SimpleListSerializerFactory.class;
		Class simplelistdf = SimpleListDeserializerFactory.class;
		QName qName = new QName("http://reservations.vbooking.com/schemas/AuthenticationFault", ">AuthenticationFault");
		this.cachedSerQNames.add(qName);
		Class cls = AuthenticationFault.class;
		this.cachedSerClasses.add(cls);
		this.cachedSerFactories.add(beansf);
		this.cachedDeserFactories.add(beandf);
		qName = new QName("http://reservations.vbooking.com/schemas/BookFlightResponse", ">bookFlightResponse");
		this.cachedSerQNames.add(qName);
		cls = BookFlightResponse.class;
		this.cachedSerClasses.add(cls);
		this.cachedSerFactories.add(beansf);
		this.cachedDeserFactories.add(beandf);
		qName = new QName("http://reservations.vbooking.com/schemas/CancelBookingResponse", ">CancelBookingResponse");
		this.cachedSerQNames.add(qName);
		cls = CancelBookingResponse.class;
		this.cachedSerClasses.add(cls);
		this.cachedSerFactories.add(beansf);
		this.cachedDeserFactories.add(beandf);
		qName = new QName("http://reservations.vbooking.com/schemas/Response", "Response");
		this.cachedSerQNames.add(qName);
		cls = Response.class;
		this.cachedSerClasses.add(cls);
		this.cachedSerFactories.add(beansf);
		this.cachedDeserFactories.add(beandf);
		qName = new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "UpdateBookingRequestType");
		this.cachedSerQNames.add(qName);
		cls = UpdateBookingRequestType.class;
		this.cachedSerClasses.add(cls);
		this.cachedSerFactories.add(beansf);
		this.cachedDeserFactories.add(beandf);
		qName = new QName("http://reservations.vbooking.com/schemas/UpdateBookingResponse", ">UpdateBookingResponse");
		this.cachedSerQNames.add(qName);
		cls = UpdateBookingResponse.class;
		this.cachedSerClasses.add(cls);
		this.cachedSerFactories.add(beansf);
		this.cachedDeserFactories.add(beandf);
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

			synchronized (this) {
				if (this.firstCall()) {
					_call.setEncodingStyle((String) null);

					for (int i = 0; i < this.cachedSerFactories.size(); ++i) {
						Class cls = (Class) this.cachedSerClasses.get(i);
						QName qName = (QName) this.cachedSerQNames.get(i);
						Object x = this.cachedSerFactories.get(i);
						if (x instanceof Class) {
							Class sf = (Class) this.cachedSerFactories.get(i);
							Class df = (Class) this.cachedDeserFactories.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						} else if (x instanceof SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) this.cachedSerFactories
									.get(i);
							DeserializerFactory df = (DeserializerFactory) this.cachedDeserFactories.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						}
					}
				}
			}

			return _call;
		} catch (Throwable var12) {
			throw new AxisFault("Failure trying to get the Call object", var12);
		}
	}

	public UpdateBookingResponse updateBooking(UpdateBookingRequestType request)
			throws RemoteException, AuthenticationFault {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		} else {
			Call _call = this.createCall();
			_call.setOperation(_operations[0]);
			_call.setUseSOAPAction(true);
			_call.setSOAPActionURI("http://types.reservations.vbooking.com/wsdl/Reservation/UpdateBooking");
			_call.setEncodingStyle((String) null);
			_call.setProperty("sendXsiTypes", Boolean.FALSE);
			_call.setProperty("sendMultiRefs", Boolean.FALSE);
			_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
			_call.setOperationName(new QName("", "UpdateBooking"));
			this.setRequestHeaders(_call);
			this.setAttachments(_call);

			try {
				Object _resp = _call.invoke(new Object[]{request});
				if (_resp instanceof RemoteException) {
					throw (RemoteException) _resp;
				} else {
					this.extractAttachments(_call);

					try {
						return (UpdateBookingResponse) _resp;
					} catch (Exception var5) {
						return (UpdateBookingResponse) JavaUtils.convert(_resp, UpdateBookingResponse.class);
					}
				}
			} catch (AxisFault var6) {
				if (var6.detail != null) {
					if (var6.detail instanceof RemoteException) {
						throw (RemoteException) var6.detail;
					}

					if (var6.detail instanceof AuthenticationFault) {
						throw (AuthenticationFault) var6.detail;
					}
				}

				throw var6;
			}
		}
	}

	static {
		_initOperationDesc1();
	}
}