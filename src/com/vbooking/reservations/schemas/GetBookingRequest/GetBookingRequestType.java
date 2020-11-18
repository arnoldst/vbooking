package com.vbooking.reservations.schemas.GetBookingRequest;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class GetBookingRequestType implements Serializable {
	private String reservationNumber;
	private String flightNumber;
	private String sessionID;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(GetBookingRequestType.class, true);

	public GetBookingRequestType() {
	}

	public GetBookingRequestType(String reservationNumber, String flightNumber, String sessionID) {
		this.reservationNumber = reservationNumber;
		this.flightNumber = flightNumber;
		this.sessionID = sessionID;
	}

	public String getReservationNumber() {
		return this.reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSessionID() {
		return this.sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof GetBookingRequestType)) {
			return false;
		} else {
			GetBookingRequestType other = (GetBookingRequestType) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = (this.reservationNumber == null && other.getReservationNumber() == null
						|| this.reservationNumber != null
								&& this.reservationNumber.equals(other.getReservationNumber()))
						&& (this.flightNumber == null && other.getFlightNumber() == null
								|| this.flightNumber != null && this.flightNumber.equals(other.getFlightNumber()))
						&& (this.sessionID == null && other.getSessionID() == null
								|| this.sessionID != null && this.sessionID.equals(other.getSessionID()));
				this.__equalsCalc = null;
				return _equals;
			}
		}
	}

	public synchronized int hashCode() {
		if (this.__hashCodeCalc) {
			return 0;
		} else {
			this.__hashCodeCalc = true;
			int _hashCode = 1;
			if (this.getReservationNumber() != null) {
				_hashCode += this.getReservationNumber().hashCode();
			}

			if (this.getFlightNumber() != null) {
				_hashCode += this.getFlightNumber().hashCode();
			}

			if (this.getSessionID() != null) {
				_hashCode += this.getSessionID().hashCode();
			}

			this.__hashCodeCalc = false;
			return _hashCode;
		}
	}

	public static TypeDesc getTypeDesc() {
		return typeDesc;
	}

	public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
		return new BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
		return new BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

	static {
		typeDesc.setXmlType(
				new QName("http://reservations.vbooking.com/schemas/GetBookingRequest", "GetBookingRequestType"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("reservationNumber");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/GetBookingRequest", "reservationNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("flightNumber");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/GetBookingRequest", "flightNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("sessionID");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/GetBookingRequest", "sessionID"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}
