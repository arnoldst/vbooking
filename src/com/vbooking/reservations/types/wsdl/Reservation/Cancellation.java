package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.CancelBookingRequest.CancelBookingRequestType;
import com.vbooking.reservations.schemas.CancelBookingResponse.CancelBookingResponse;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cancellation extends Remote {
	CancelBookingResponse cancelBooking(CancelBookingRequestType var1) throws RemoteException, AuthenticationFault;
}
