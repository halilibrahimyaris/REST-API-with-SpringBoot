package com.example.springRestApi;

import com.example.springRestApi.domain.Address;
import com.example.springRestApi.domain.Gender;
import com.example.springRestApi.domain.Student;
import com.example.springRestApi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(StudentRepository studentRepository){
		return args -> {
			Student student1= new Student("halil","yaris","halil@gmail.com",Gender.MALE,new Address(), List.of("computer science","maths"), BigDecimal.TEN, LocalDateTime.now());
			studentRepository.insert(student1);
		};
	}

}
