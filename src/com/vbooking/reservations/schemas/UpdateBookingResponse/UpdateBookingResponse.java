package com.vbooking.reservations.schemas.UpdateBookingResponse;

import com.vbooking.reservations.schemas.Response.Response;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class UpdateBookingResponse extends Response implements Serializable {
	private String reservationNumber;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(UpdateBookingResponse.class, true);

	public UpdateBookingResponse() {
	}

	public UpdateBookingResponse(String status, String errorMessage, String processStack, String reservationNumber) {
		super(status, errorMessage, processStack);
		this.reservationNumber = reservationNumber;
	}

	public String getReservationNumber() {
		return this.reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof UpdateBookingResponse)) {
			return false;
		} else {
			UpdateBookingResponse other = (UpdateBookingResponse) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = super.equals(obj)
						&& (this.reservationNumber == null && other.getReservationNumber() == null
								|| this.reservationNumber != null
										&& this.reservationNumber.equals(other.getReservationNumber()));
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
			int _hashCode = super.hashCode();
			if (this.getReservationNumber() != null) {
				_hashCode += this.getReservationNumber().hashCode();
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
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingResponse", ">UpdateBookingResponse"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("reservationNumber");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/UpdateBookingResponse", "ReservationNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}