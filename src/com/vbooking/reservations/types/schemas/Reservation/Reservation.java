package com.vbooking.reservations.types.schemas.Reservation;

import com.vbooking.reservations.types.schemas.Gender.Gender;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Reservation implements Serializable {
	private String reservationNumber;
	private String passengerFirstName;
	private String passengerMiddleName;
	private String passengerLastName;
	private Gender passengerGender;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(Reservation.class, true);

	public Reservation() {
	}

	public Reservation(String reservationNumber, String passengerFirstName, String passengerMiddleName,
			String passengerLastName, Gender passengerGender) {
		this.reservationNumber = reservationNumber;
		this.passengerFirstName = passengerFirstName;
		this.passengerMiddleName = passengerMiddleName;
		this.passengerLastName = passengerLastName;
		this.passengerGender = passengerGender;
	}

	public String getReservationNumber() {
		return this.reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
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

	public Gender getPassengerGender() {
		return this.passengerGender;
	}

	public void setPassengerGender(Gender passengerGender) {
		this.passengerGender = passengerGender;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof Reservation)) {
			return false;
		} else {
			Reservation other = (Reservation) obj;
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
										&& this.passengerGender.equals(other.getPassengerGender()));
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
		typeDesc.setXmlType(new QName("http://types.reservations.vbooking.com/schemas/Reservation", "Reservation"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("reservationNumber");
		elemField.setXmlName(
				new QName("http://types.reservations.vbooking.com/schemas/Reservation", "reservationNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerFirstName");
		elemField.setXmlName(
				new QName("http://types.reservations.vbooking.com/schemas/Reservation", "passengerFirstName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerMiddleName");
		elemField.setXmlName(
				new QName("http://types.reservations.vbooking.com/schemas/Reservation", "passengerMiddleName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerLastName");
		elemField.setXmlName(
				new QName("http://types.reservations.vbooking.com/schemas/Reservation", "passengerLastName"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("passengerGender");
		elemField
				.setXmlName(new QName("http://types.reservations.vbooking.com/schemas/Reservation", "passengerGender"));
		elemField.setXmlType(new QName("http://types.reservations.vbooking.com/schemas/Gender", "Gender"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}
