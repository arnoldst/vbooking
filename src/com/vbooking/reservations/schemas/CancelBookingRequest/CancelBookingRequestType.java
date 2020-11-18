package com.vbooking.reservations.schemas.CancelBookingRequest;

import com.vbooking.reservations.types.schemas.Reservation.Reservation;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class CancelBookingRequestType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5237715033230465612L;
	private Reservation reservation;
	private String sessionID;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(CancelBookingRequestType.class, true);

	public CancelBookingRequestType() {
	}

	public CancelBookingRequestType(Reservation reservation, String sessionID) {
		this.reservation = reservation;
		this.sessionID = sessionID;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getSessionID() {
		return this.sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof CancelBookingRequestType)) {
			return false;
		} else {
			CancelBookingRequestType other = (CancelBookingRequestType) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = (this.reservation == null && other.getReservation() == null
						|| this.reservation != null && this.reservation.equals(other.getReservation()))
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
			if (this.getReservation() != null) {
				_hashCode += this.getReservation().hashCode();
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
				new QName("http://reservations.vbooking.com/schemas/CancelBookingRequest", "CancelBookingRequestType"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("reservation");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/CancelBookingRequest", "reservation"));
		elemField.setXmlType(new QName("http://types.reservations.vbooking.com/schemas/Reservation", "Reservation"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("sessionID");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/CancelBookingRequest", "sessionID"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}