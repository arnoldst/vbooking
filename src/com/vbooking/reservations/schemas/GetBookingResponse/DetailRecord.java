package com.vbooking.reservations.schemas.GetBookingResponse;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class DetailRecord implements Serializable {
	private String flightNumber;
	private String weekNumber;
	private BigInteger price;
	private String passengerFirstName;
	private String passengerMiddleName;
	private String passengerLastName;
	private String passengerGender;
	private String reservation;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(DetailRecord.class, true);

	public DetailRecord() {
	}

	public DetailRecord(String flightNumber, String weekNumber, BigInteger price, String passengerFirstName,
			String passengerMiddleName, String passengerLastName, String passengerGender, String reservation) {
		this.flightNumber = flightNumber;
		this.weekNumber = weekNumber;
		this.price = price;
		this.passengerFirstName = passengerFirstName;
		this.passengerMiddleName = passengerMiddleName;
		this.passengerLastName = passengerLastName;
		this.passengerGender = passengerGender;
		this.reservation = reservation;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getWeekNumber() {
		return this.weekNumber;
	}

	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}

	public BigInteger getPrice() {
		return this.price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
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

	public String getReservation() {
		return this.reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof DetailRecord)) {
			return false;
		} else {
			DetailRecord other = (DetailRecord) obj;
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
						&& (this.price == null && other.getPrice() == null
								|| this.price != null && this.price.equals(other.getPrice()))
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
						&& (this.reservation == null && other.getReservation() == null
								|| this.reservation != null && this.reservation.equals(other.getReservation()));
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

			if (this.getPrice() != null) {
				_hashCode += this.getPrice().hashCode();
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

			if (this.getReservation() != null) {
				_hashCode += this.getReservation().hashCode();
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
		typeDesc.setXmlType(new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "DetailRecord"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("flightNumber");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "flightNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("weekNumber");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "weekNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("price");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "price"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "integer"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerFirstName");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "passengerFirstName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerMiddleName");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "passengerMiddleName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerLastName");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "passengerLastName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerGender");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "passengerGender"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("reservation");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/GetBookingResponse", "reservation"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}