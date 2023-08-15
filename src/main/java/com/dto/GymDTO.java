package com.dto;

public class GymDTO {
	
	private int memberid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int age;
	private double weight;
	
	
	public GymDTO() {
		super();
		
	}
	public GymDTO(int memberid, String firstname, String lastname, String email, String password, int age,
			double weight) {
		super();
		this.memberid = memberid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.age = age;
		this.weight = weight;
	}
	
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "GymDTO [memberid=" + memberid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", age=" + age + ", weight=" + weight + "]";
	}
}


