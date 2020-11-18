package com.vbooking.reservations.schemas.CancelBookingResponse;

import com.vbooking.reservations.schemas.Response.Response;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class CancelBookingResponse extends Response implements Serializable {
	private String cancelledReservationNumber;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(CancelBookingResponse.class, true);

	public CancelBookingResponse() {
	}

	public CancelBookingResponse(String status, String errorMessage, String processStack,
			String cancelledReservationNumber) {
		super(status, errorMessage, processStack);
		this.cancelledReservationNumber = cancelledReservationNumber;
	}

	public String getCancelledReservationNumber() {
		return this.cancelledReservationNumber;
	}

	public void setCancelledReservationNumber(String cancelledReservationNumber) {
		this.cancelledReservationNumber = cancelledReservationNumber;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof CancelBookingResponse)) {
			return false;
		} else {
			CancelBookingResponse other = (CancelBookingResponse) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = super.equals(obj) && (this.cancelledReservationNumber == null
						&& other.getCancelledReservationNumber() == null
						|| this.cancelledReservationNumber != null
								&& this.cancelledReservationNumber.equals(other.getCancelledReservationNumber()));
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
			if (this.getCancelledReservationNumber() != null) {
				_hashCode += this.getCancelledReservationNumber().hashCode();
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
				new QName("http://reservations.vbooking.com/schemas/CancelBookingResponse", ">CancelBookingResponse"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("cancelledReservationNumber");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/CancelBookingResponse",
				"cancelledReservationNumber"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}