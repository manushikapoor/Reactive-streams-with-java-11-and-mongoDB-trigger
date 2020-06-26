package com.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student {

	@Id
	int _id;
	String firstname;
	String lastname;
	int age;
	String email;
	String department;
	
	public int getId() {
		return _id;
	}
	public void setId(int _id) {
		this._id = _id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Student() {
		
	}
	public Student(int _id, String firstname, String lastname, int age, String email, String department) {
		super();
		this._id = _id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.department=department;
	}
	@Override
	public String toString() {
		return "Student [id=" + _id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", email="
				+ email + ", department=" + department + "]";
	}
	
	
	
}
