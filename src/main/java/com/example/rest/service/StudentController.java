package com.example.rest.service;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.business.Student;
import com.example.service.impl.StudentService;

@RestController
public class StudentController {

	  @Autowired 
	  StudentService myStudentService2;
	  
	  @Autowired
	  ApplicationContext appContext;
	 
	
	@GetMapping("/student")
	public Student student(@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestParam(value = "id", defaultValue = "123") String id,
			@RequestParam(value = "percentage", defaultValue = "23.45") double percentage) {
		System.out.println("Entered method student : TRACE");
		
		// Printing beans
		try
		{
			run();
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e);
		}
		// End of printing beans
		
		return myStudentService2.createStudent(name, id, percentage);
	}
	
	@GetMapping("/student")
	public Student setAddressToStudent(@RequestParam(value = "address", defaultValue = "Tanuku") String address,
			@RequestParam(value = "id", defaultValue = "123") String id) {
		System.out.println("Entered method setAddressToStudent : TRACE");
		
		Student student = myStudentService2.findStudentById(id);
		myStudentService2.addAddressToStudent(student, address);
		
		return student;
		
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student student2(@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestParam(value = "id", defaultValue = "123") String id,
			@RequestParam(value = "percentage", defaultValue = "23.45") double percentage) {
		return new Student(name, id, percentage);
	}

	
	public void run() throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }

    }
}
