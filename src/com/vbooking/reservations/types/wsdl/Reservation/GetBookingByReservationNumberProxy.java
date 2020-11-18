package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.GetBookingRequest.GetBookingRequestType;
import com.vbooking.reservations.schemas.GetBookingResponse.DetailRecord;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

public class GetBookingByReservationNumberProxy implements GetBookingByReservationNumber {
	private String _endpoint = null;
	private GetBookingByReservationNumber getBookingByReservationNumber = null;

	public GetBookingByReservationNumberProxy() {
		this._initGetBookingByReservationNumberProxy();
	}

	public GetBookingByReservationNumberProxy(String endpoint) {
		this._endpoint = endpoint;
		this._initGetBookingByReservationNumberProxy();
	}

	private void _initGetBookingByReservationNumberProxy() {
		try {
			this.getBookingByReservationNumber = (new GetBookingByReservationNumberServiceLocator())
					.getGetBookingByReservationNumberPort();
			if (this.getBookingByReservationNumber != null) {
				if (this._endpoint != null) {
					((Stub) this.getBookingByReservationNumber)._setProperty("javax.xml.rpc.service.endpoint.address",
							this._endpoint);
				} else {
					this._endpoint = (String) ((Stub) this.getBookingByReservationNumber)
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
		if (this.getBookingByReservationNumber != null) {
			((Stub) this.getBookingByReservationNumber)._setProperty("javax.xml.rpc.service.endpoint.address",
					this._endpoint);
		}

	}

	public GetBookingByReservationNumber getGetBookingByReservationNumber() {
		if (this.getBookingByReservationNumber == null) {
			this._initGetBookingByReservationNumberProxy();
		}

		return this.getBookingByReservationNumber;
	}

	public DetailRecord[] getBookingByReservationNumber(GetBookingRequestType request)
			throws RemoteException, AuthenticationFault {
		if (this.getBookingByReservationNumber == null) {
			this._initGetBookingByReservationNumberProxy();
		}

		return this.getBookingByReservationNumber.getBookingByReservationNumber(request);
	}
}