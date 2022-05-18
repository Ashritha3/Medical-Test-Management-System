package com.mtms.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*******************************************************************************************************************************

-Description              :    User Bean Class

*******************************************************************************************************************************/

@Entity
@Table(name = "user_info")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="user_userId_sequence")
	private Integer userId;
	@Column
	private String userName;
	@Column
	private String userPassword;
	@Column
	private BigInteger contactNumber;
	@Column
	private String userEmail;
	@Column
	private String userRole;
	@Column
	private Integer age;
	@Column
	private String gender;
	
	public User() {
		super();
	}
	
	public User(Integer userId, String userName, String userPassword, BigInteger contactNumber, String userEmail,
			String userRole, Integer age, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.contactNumber = contactNumber;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.age = age;
		this.gender = gender;
	}
    
	
	public User(String userName, String userPassword, BigInteger contactNumber, String userEmail, String userRole,
			Integer age, String gender) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.contactNumber = contactNumber;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.age = age;
		this.gender = gender;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public BigInteger getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", contactNumber=" + contactNumber + ", userEmail=" + userEmail + ", userRole=" + userRole + ", age="
				+ age + ", gender=" + gender + "]";
	}

}
