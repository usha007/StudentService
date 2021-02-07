package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.business.Student;
import com.example.service.repository.StudentRepository;

@Component
//@Scope(value="SCOPE_PROTOTYPE")
public class StudentServiceImpl
{
	@Autowired
    StudentRepository studentRepository;

    /**
     * API to add student to student repo
     * @param name
     * @param id
     * @param percentage
     * @return
     */
    public Student createStudent(String name, String id, double percentage)
    {
        Student myStudent = new Student(name, id, percentage);
        studentRepository.addStudent(id, myStudent);
        return myStudent;
    }

    public Student addAddressToStudent(Student student, String address)
    {
        student.setAddress(address);
        return student;
    }

    /**
     * API to find student in student repo
     * @param id
     * @return
     */
    public Student findStudentById(String id)
    {
        Student student = studentRepository.getStudent(id);
        System.out.println("Student found in repo is "+ student);
        return student;
    }

    /**
     * API to delete student in student repo
     * @param id
     * @return
     */
    public Student deleteStudentById(String id)
    {
        Student student = studentRepository.deleteStudentByID(id);
        System.out.println("Student deleete in repo is "+ student);
        return student;
    }

    /**
     * API to list all students in student repo
     * @return
     */
    public List<Student> listAllStudents()
    {
        List<Student> studentList = studentRepository.listAllStudents();
        System.out.println("Student list in repo is "+ studentList);
        return studentList;
    }

}
