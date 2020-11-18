package com.vbooking.reservations.schemas.UpdateBookingRequest;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class UpdateBookingRequestType implements Serializable {
	private String flightNumber;
	private BigInteger weekNumber;
	private String passengerFirstName;
	private String passengerMiddleName;
	private String passengerLastName;
	private String passengerGender;
	private String reservationNumber;
	private String sessionID;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(UpdateBookingRequestType.class, true);

	public UpdateBookingRequestType() {
	}

	public UpdateBookingRequestType(String flightNumber, BigInteger weekNumber, String passengerFirstName,
			String passengerMiddleName, String passengerLastName, String passengerGender, String reservationNumber,
			String sessionID) {
		this.flightNumber = flightNumber;
		this.weekNumber = weekNumber;
		this.passengerFirstName = passengerFirstName;
		this.passengerMiddleName = passengerMiddleName;
		this.passengerLastName = passengerLastName;
		this.passengerGender = passengerGender;
		this.reservationNumber = reservationNumber;
		this.sessionID = sessionID;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public BigInteger getWeekNumber() {
		return this.weekNumber;
	}

	public void setWeekNumber(BigInteger weekNumber) {
		this.weekNumber = weekNumber;
	}

	public String getPassengerFirstName() {
		return this.passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerMiddleName() {
		return this.passengerMiddleName;
	}

	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}

	public String getPassengerLastName() {
		return this.passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerGender() {
		return this.passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getReservationNumber() {
		return this.reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getSessionID() {
		return this.sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof UpdateBookingRequestType)) {
			return false;
		} else {
			UpdateBookingRequestType other = (UpdateBookingRequestType) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = (this.flightNumber == null && other.getFlightNumber() == null
						|| this.flightNumber != null && this.flightNumber.equals(other.getFlightNumber()))
						&& (this.weekNumber == null && other.getWeekNumber() == null
								|| this.weekNumber != null && this.weekNumber.equals(other.getWeekNumber()))
						&& (this.passengerFirstName == null && other.getPassengerFirstName() == null
								|| this.passengerFirstName != null
										&& this.passengerFirstName.equals(other.getPassengerFirstName()))
						&& (this.passengerMiddleName == null && other.getPassengerMiddleName() == null
								|| this.passengerMiddleName != null
										&& this.passengerMiddleName.equals(other.getPassengerMiddleName()))
						&& (this.passengerLastName == null && other.getPassengerLastName() == null
								|| this.passengerLastName != null
										&& this.passengerLastName.equals(other.getPassengerLastName()))
						&& (this.passengerGender == null && other.getPassengerGender() == null
								|| this.passengerGender != null
										&& this.passengerGender.equals(other.getPassengerGender()))
						&& (this.reservationNumber == null && other.getReservationNumber() == null
								|| this.reservationNumber != null
										&& this.reservationNumber.equals(other.getReservationNumber()))
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
			if (this.getFlightNumber() != null) {
				_hashCode += this.getFlightNumber().hashCode();
			}

			if (this.getWeekNumber() != null) {
				_hashCode += this.getWeekNumber().hashCode();
			}

			if (this.getPassengerFirstName() != null) {
				_hashCode += this.getPassengerFirstName().hashCode();
			}

			if (this.getPassengerMiddleName() != null) {
				_hashCode += this.getPassengerMiddleName().hashCode();
			}

			if (this.getPassengerLastName() != null) {
				_hashCode += this.getPassengerLastName().hashCode();
			}

			if (this.getPassengerGender() != null) {
				_hashCode += this.getPassengerGender().hashCode();
			}

			if (this.getReservationNumber() != null) {
				_hashCode += this.getReservationNumber().hashCode();
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
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "UpdateBookingRequestType"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("flightNumber");
		elemField
				.setXmlName(new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "flightNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("weekNumber");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "weekNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "integer"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerFirstName");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "passengerFirstName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerMiddleName");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "passengerMiddleName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerLastName");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "passengerLastName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerGender");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "passengerGender"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("reservationNumber");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "reservationNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("sessionID");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/UpdateBookingRequest", "sessionID"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}