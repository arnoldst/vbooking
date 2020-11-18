package com.vbooking.logon;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.rpc.holders.BooleanHolder;
import javax.xml.rpc.holders.StringHolder;



public interface LogonServiceImpl extends Remote {
	void logon(String var1, String var2, BooleanHolder var3, StringHolder var4) throws RemoteException;

	void logoff(String var1, String var2) throws RemoteException;

	boolean isLoggedOn(String var1, String var2) throws RemoteException;
}