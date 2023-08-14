package com.student.sms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.sms.entity.Student;
import com.student.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student student1=new Student("Ramesh","Fadatare","ramesh@gmail.com");
//		Student student2=new Student("Sanjay","jadhav","sanjay@gmail.com");
//		Student student3=new Student("Tony","Stark","tony@gmail.com");
//		studentRepository.save(student1);
//		studentRepository.save(student2);
//		studentRepository.save(student3);
		
	}

}
