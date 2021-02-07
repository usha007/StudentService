package com.example.service.impl;


import org.springframework.stereotype.Component;

import com.example.business.Student;

@Component
//@Scope(value="SCOPE_PROTOTYPE")
public class StudentService {
	
	
	public Student createStudent(String name, String id, double percentage) {
		Student myStudent = new Student(name, id, percentage);
		return myStudent;
	}
	
	public Student addAddressToStudent(Student student, String address) {
		student.setAddress(address);
		return student;
	}

	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		
		return new Student("A", "1", 0.0d);
	}
	
}
