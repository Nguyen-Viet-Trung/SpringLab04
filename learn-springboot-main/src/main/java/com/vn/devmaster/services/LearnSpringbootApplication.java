package com.vn.devmaster.services;

import com.vn.devmaster.services.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(LearnSpringbootApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		System.out.println(studentRepository.findById(1).get().getClazz());
	}

}
