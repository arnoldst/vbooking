package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.CancelBookingRequest.CancelBookingRequestType;
import com.vbooking.reservations.schemas.CancelBookingResponse.CancelBookingResponse;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

public class CancellationProxy implements Cancellation {
	private String _endpoint = null;
	private Cancellation cancellation = null;

	public CancellationProxy() {
		this._initCancellationProxy();
	}

	public CancellationProxy(String endpoint) {
		this._endpoint = endpoint;
		this._initCancellationProxy();
	}

	private void _initCancellationProxy() {
		try {
			this.cancellation = (new CancellationServiceLocator()).getCancellationPort();
			if (this.cancellation != null) {
				if (this._endpoint != null) {
					((Stub) this.cancellation)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
				} else {
					this._endpoint = (String) ((Stub) this.cancellation)
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
		if (this.cancellation != null) {
			((Stub) this.cancellation)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
		}

	}

	public Cancellation getCancellation() {
		if (this.cancellation == null) {
			this._initCancellationProxy();
		}

		return this.cancellation;
	}

	public CancelBookingResponse cancelBooking(CancelBookingRequestType request)
			throws RemoteException, AuthenticationFault {
		if (this.cancellation == null) {
			this._initCancellationProxy();
		}

		return this.cancellation.cancelBooking(request);
	}
}