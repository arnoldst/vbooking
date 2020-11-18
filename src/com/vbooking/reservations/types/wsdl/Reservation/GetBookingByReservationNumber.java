package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.GetBookingRequest.GetBookingRequestType;
import com.vbooking.reservations.schemas.GetBookingResponse.DetailRecord;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetBookingByReservationNumber extends Remote {
	DetailRecord[] getBookingByReservationNumber(GetBookingRequestType var1)
			throws RemoteException, AuthenticationFault;
}