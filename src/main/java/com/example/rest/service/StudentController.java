package com.example.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.Student;
import com.example.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController
{

    @Autowired
    StudentServiceImpl myStudentServiceImpl;

    @Autowired
    ApplicationContext appContext;

    @GetMapping("/printBeans")
    public void printBeansInSystem()
    {
        // log statement
        System.out.println("Entered method student : TRACE");
        printBeans();
    }

    @GetMapping("/create")
    public Student createStudent(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "id", defaultValue = "123") String id,
            @RequestParam(value = "percentage", defaultValue = "23.45") double percentage)
    {
        // log statement
        System.out.println("Entered method student : TRACE");
        //printBeans();

        return myStudentServiceImpl.createStudent(name, id, percentage);
    }

    @GetMapping("/addAddress")
    public Student setAddressToStudent(@RequestParam(value = "address", defaultValue = "Tanuku") String address,
            @RequestParam(value = "id", defaultValue = "123") String id)
    {
        System.out.println("Entered method setAddressToStudent : TRACE");

        Student student = myStudentServiceImpl.findStudentById(id);
        myStudentServiceImpl.addAddressToStudent(student, address);
        return student;
    }

    @GetMapping("/id/{id}")
    public Student getStudent(@PathVariable String id)
    {
        System.out.println("Entered method getStudent : TRACE");
        Student student = myStudentServiceImpl.findStudentById(id);
        return student;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student student2(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "id", defaultValue = "123") String id,
            @RequestParam(value = "percentage", defaultValue = "23.45") double percentage)
    {
        return new Student(name, id, percentage);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Student deleteStudent(@RequestParam(value = "id") String id)
    {
        Student student= myStudentServiceImpl.deleteStudentById(id);
        return  student;
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<Student> listAllStudents()
    {
        return myStudentServiceImpl.listAllStudents();
    }

    private void printBeans()
    {
        // Printing beans
        try
        {
            run();
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e);
        }
        // End of printing beans
    }

    public void run() throws Exception
    {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans)
        {
            System.out.println(bean);
        }

    }
}
