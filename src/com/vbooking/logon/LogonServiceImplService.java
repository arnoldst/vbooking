package com.vbooking.logon;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface LogonServiceImplService extends Service {
	String getLogonServiceImplAddress();

	LogonServiceImpl getLogonServiceImpl() throws ServiceException;

	LogonServiceImpl getLogonServiceImpl(URL var1) throws ServiceException;
}