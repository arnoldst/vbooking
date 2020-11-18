package com.vbooking.reservations.schemas.Response;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String errorMessage;
	private String processStack;
	private Object __equalsCalc = null;
	private boolean __hashCodeCalc = false;
	private static TypeDesc typeDesc = new TypeDesc(Response.class, true);

	public Response() {
	}

	public Response(String status, String errorMessage, String processStack) {
		this.status = status;
		this.errorMessage = errorMessage;
		this.processStack = processStack;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getProcessStack() {
		return this.processStack;
	}

	public void setProcessStack(String processStack) {
		this.processStack = processStack;
	}

	public synchronized boolean equals(Object obj) {
		if (!(obj instanceof Response)) {
			return false;
		} else {
			Response other = (Response) obj;
			if (obj == null) {
				return false;
			} else if (this == obj) {
				return true;
			} else if (this.__equalsCalc != null) {
				return this.__equalsCalc == obj;
			} else {
				this.__equalsCalc = obj;
				boolean _equals = (this.status == null && other.getStatus() == null
						|| this.status != null && this.status.equals(other.getStatus()))
						&& (this.errorMessage == null && other.getErrorMessage() == null
								|| this.errorMessage != null && this.errorMessage.equals(other.getErrorMessage()))
						&& (this.processStack == null && other.getProcessStack() == null
								|| this.processStack != null && this.processStack.equals(other.getProcessStack()));
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
			if (this.getStatus() != null) {
				_hashCode += this.getStatus().hashCode();
			}

			if (this.getErrorMessage() != null) {
				_hashCode += this.getErrorMessage().hashCode();
			}

			if (this.getProcessStack() != null) {
				_hashCode += this.getProcessStack().hashCode();
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
		typeDesc.setXmlType(new QName("http://reservations.vbooking.com/schemas/Response", "Response"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("status");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/Response", "status"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("errorMessage");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/Response", "errorMessage"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("processStack");
		elemField.setXmlName(new QName("http://reservations.vbooking.com/schemas/Response", "processStack"));
		elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}
