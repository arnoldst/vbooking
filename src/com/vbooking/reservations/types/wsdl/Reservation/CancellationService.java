package com.vbooking.reservations.types.wsdl.Reservation;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface CancellationService extends Service {
	String getCancellationPortAddress();

	Cancellation getCancellationPort() throws ServiceException;

	Cancellation getCancellationPort(URL var1) throws ServiceException;
}
