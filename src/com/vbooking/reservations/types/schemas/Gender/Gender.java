package com.vbooking.reservations.types.schemas.Gender;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.EnumDeserializer;
import org.apache.axis.encoding.ser.EnumSerializer;

public class Gender implements Serializable {
	private String _value_;
	private static HashMap _table_ = new HashMap();
	public static final String _Male = "Male";
	public static final String _Female = "Female";
	public static final Gender Male = new Gender("Male");
	public static final Gender Female = new Gender("Female");
	private static TypeDesc typeDesc = new TypeDesc(Gender.class);

	protected Gender(String value) {
		this._value_ = value;
		_table_.put(this._value_, this);
	}

	public String getValue() {
		return this._value_;
	}

	public static Gender fromValue(String value) throws IllegalArgumentException {
		Gender enumeration = (Gender) _table_.get(value);
		if (enumeration == null) {
			throw new IllegalArgumentException();
		} else {
			return enumeration;
		}
	}

	public static Gender fromString(String value) throws IllegalArgumentException {
		return fromValue(value);
	}

	public boolean equals(Object obj) {
		return obj == this;
	}

	public int hashCode() {
		return this.toString().hashCode();
	}

	public String toString() {
		return this._value_;
	}

	public Object readResolve() throws ObjectStreamException {
		return fromValue(this._value_);
	}

	public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
		return new EnumSerializer(_javaType, _xmlType);
	}

	public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
		return new EnumDeserializer(_javaType, _xmlType);
	}

	public static TypeDesc getTypeDesc() {
		return typeDesc;
	}

	static {
		typeDesc.setXmlType(new QName("http://types.reservations.vbooking.com/schemas/Gender", "Gender"));
	}
}
