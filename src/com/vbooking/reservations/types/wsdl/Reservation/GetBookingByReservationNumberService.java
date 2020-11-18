package com.vbooking.reservations.types.wsdl.Reservation;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface GetBookingByReservationNumberService extends Service {
	String getGetBookingByReservationNumberPortAddress();

	GetBookingByReservationNumber getGetBookingByReservationNumberPort() throws ServiceException;

	GetBookingByReservationNumber getGetBookingByReservationNumberPort(URL var1) throws ServiceException;
}
