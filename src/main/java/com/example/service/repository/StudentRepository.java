package com.example.service.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.business.Student;

@Component
public class StudentRepository
{

    @PostConstruct
    public void getDefaultData()
    {
        for (int i = 1;i <=10; i++)
        {
            Student student = new Student("Name"+i, String.valueOf(i), 100d);
            this.addStudent(String.valueOf(i), student);
        }
    }

    // Think of this as DB
    // Map <id, Student>
    private static Map<String, Student> studentStore = new HashMap<>();

    public Student getStudent(String id)
    {
        return studentStore.get(id);
    }

    public void addStudent(String id, Student student)
    {
        studentStore.put(id, student);
    }
    public Student deleteStudentByID(String id)
    {
        Student student = studentStore.remove(id);
        return student;
    }

    public List<Student> listAllStudents()
    {
        return new ArrayList<>(studentStore.values());
    }
}
