package com.example.service.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.business.Student;

@Component
public class StudentRepository
{
    // Think of this as DB
    public static Map<String, Student> studentStore = new HashMap<>();

    public Student getStudent(String id)
    {
        return studentStore.get(id);
    }

    public void addStudent(String id, Student student)
    {
        studentStore.put(id, student);
    }
}
