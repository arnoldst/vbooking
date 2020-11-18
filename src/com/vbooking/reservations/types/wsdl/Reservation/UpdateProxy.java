package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.UpdateBookingRequest.UpdateBookingRequestType;
import com.vbooking.reservations.schemas.UpdateBookingResponse.UpdateBookingResponse;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

public class UpdateProxy implements Update {
	private String _endpoint = null;
	private Update update = null;

	public UpdateProxy() {
		this._initUpdateProxy();
	}

	public UpdateProxy(String endpoint) {
		this._endpoint = endpoint;
		this._initUpdateProxy();
	}

	private void _initUpdateProxy() {
		try {
			this.update = (new UpdateServiceLocator()).getUpdatePort();
			if (this.update != null) {
				if (this._endpoint != null) {
					((Stub) this.update)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
				} else {
					this._endpoint = (String) ((Stub) this.update)
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
		if (this.update != null) {
			((Stub) this.update)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
		}

	}

	public Update getUpdate() {
		if (this.update == null) {
			this._initUpdateProxy();
		}

		return this.update;
	}

	public UpdateBookingResponse updateBooking(UpdateBookingRequestType request)
			throws RemoteException, AuthenticationFault {
		if (this.update == null) {
			this._initUpdateProxy();
		}

		return this.update.updateBooking(request);
	}
}