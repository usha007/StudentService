package com.example.business;

public class Student {
private String name;
private String id;
private double percentage;
private String address;

public Student(String name, String id, double percentage) {
	super();
	this.name = name;
	this.id = id;
	this.percentage = percentage;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

	
}
