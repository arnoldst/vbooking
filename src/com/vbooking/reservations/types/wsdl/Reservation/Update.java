package com.vbooking.reservations.types.wsdl.Reservation;

import com.vbooking.reservations.schemas.AuthenticationFault.AuthenticationFault;
import com.vbooking.reservations.schemas.UpdateBookingRequest.UpdateBookingRequestType;
import com.vbooking.reservations.schemas.UpdateBookingResponse.UpdateBookingResponse;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Update extends Remote {
	UpdateBookingResponse updateBooking(UpdateBookingRequestType var1) throws RemoteException, AuthenticationFault;
}