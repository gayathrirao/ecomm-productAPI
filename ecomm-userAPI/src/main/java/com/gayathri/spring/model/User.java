package com.gayathri.spring.model;

import java.util.Date;



import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {

	 @Id
	  private ObjectId id;
	 
	 @Field("ADDRESS")
	 private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Field("USER_NAME")
	@Indexed(unique=true)
	private String userName;
	
	@Field("FIRST_NAME")
	private String firstName;
	
	@Field("LAST_NAME")
	private String lastName;
	
	@Field("SEX")
	private String sex;
	
	@Field("MEMBER_TYPE")
	private String memberType;
	
	@Field("REGISTRATION_DATE")
	private Date registrationDate;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRgistrationDate(Date rgistrationDate) {
		this.registrationDate = rgistrationDate;
	}

	public User(ObjectId id, String userName, String firstName, String lastName, String sex, String memberType,
			Date rgistrationDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.memberType = memberType;
		this.registrationDate = rgistrationDate;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", sex=" + sex + ", memberType=" + memberType + ", registrationDate=" + registrationDate + "] +address [" +address + "]";
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((memberType == null) ? 0 : memberType.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (memberType == null) {
			if (other.memberType != null)
				return false;
		} else if (!memberType.equals(other.memberType))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
*/	
	

	
	
}
