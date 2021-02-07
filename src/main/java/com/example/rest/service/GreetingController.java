package com.example.rest.service;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.impl.StudentServiceImpl;

@RestController
public class GreetingController {

	  @Autowired
	  StudentServiceImpl myStudentServiceImpl;
	  
	  @Autowired
	  ApplicationContext appContext;
	 
	private static final String template = "Hello, %s! ";
	private static AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greeting2")
	public String greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Helloo thyere " + name;
	}
	
	public void run() throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }

    }
}
