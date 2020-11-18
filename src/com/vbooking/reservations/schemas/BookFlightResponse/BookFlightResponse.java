package com.vbooking.reservations.schemas.BookFlightResponse;

import com.vbooking.reservations.schemas.Response.Response;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class BookFlightResponse extends Response implements Serializable {
	private String newReservationNumber;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(BookFlightResponse.class, true);

	public BookFlightResponse() {
	}

	public BookFlightResponse(String status, String errorMessage, String processStack, String newReservationNumber) {
		super(status, errorMessage, processStack);
		this.newReservationNumber = newReservationNumber;
	}

	public String getNewReservationNumber() {
		return this.newReservationNumber;
	}

	public void setNewReservationNumber(String newReservationNumber) {
		this.newReservationNumber = newReservationNumber;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof BookFlightResponse)) {
			return false;
		} else {
			BookFlightResponse other = (BookFlightResponse) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = super.equals(obj)
						&& (this.newReservationNumber == null && other.getNewReservationNumber() == null
								|| this.newReservationNumber != null
										&& this.newReservationNumber.equals(other.getNewReservationNumber()));
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
			if (this.getNewReservationNumber() != null) {
				_hashCode += this.getNewReservationNumber().hashCode();
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
				new QName("http://reservations.vbooking.com/schemas/BookFlightResponse", ">bookFlightResponse"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("newReservationNumber");
		elemField.setXmlName(
				new QName("http://reservations.vbooking.com/schemas/BookFlightResponse", "newReservationNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}
