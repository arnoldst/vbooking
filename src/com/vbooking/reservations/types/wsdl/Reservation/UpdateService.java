package com.vbooking.reservations.types.wsdl.Reservation;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface UpdateService extends Service {
	String getUpdatePortAddress();

	Update getUpdatePort() throws ServiceException;

	Update getUpdatePort(URL var1) throws ServiceException;
}
