package com.gayathri.spring.model;

public class Address
{
	@Override
	public String toString() {
		return "Address [house_number=" + house_number + ", street=" + street + ", addressline1=" + addressline1
				+ ", addressline2=" + addressline2 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + "]";
	}
	public Address(String house_number, String street, String addressline1, String addressline2, String city,
			String state, String country, String pincode) {
		super();
		this.house_number = house_number;
		this.street = street;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public String getHouse_number() {
		return house_number;
	}
	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	String house_number;
	String street;
	String addressline1;
	String addressline2;
	String city;
	String state;
	String country;
	String pincode;
}