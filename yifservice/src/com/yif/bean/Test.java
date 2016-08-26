package com.yif.bean;

public class Test {
	
	
	
	
public Test() {
		super();
	}
public Test(String phone, String email, String name) {
		super();
		this.phone = phone;
		this.email = email;
		this.name = name;
	}
private String phone;
private String email;
private String name;
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Test [phone=" + phone + ", email=" + email + ", name=" + name + "]";
}

}
