package com.example.springRestApi;

import com.example.springRestApi.domain.Address;
import com.example.springRestApi.domain.Gender;
import com.example.springRestApi.domain.Student;
import com.example.springRestApi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
	CommandLineRunner runner(StudentRepository studentRepository,
							 MongoTemplate mongoTemplate){
		String email= "halil@gmail.com";
		return args -> {
			Student student1= new Student("halil","yaris",email,Gender.MALE,new Address(), List.of("computer science","maths"), BigDecimal.TEN, LocalDateTime.now());
	//		usingMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student1);
			studentRepository.findStudentByEmail(email)
					.ifPresentOrElse(s->{
						System.out.println("Student already exist");
					},()->{
						System.out.println("Inserted student"+ student1);
						studentRepository.insert(student1);
					});
		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student1) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students = mongoTemplate.find(query,Student.class);

		if(students.size()>1){
			throw new IllegalStateException("Found many student with email");
	   }
		if(students.isEmpty()){
			System.out.println("Inserted student"+ student1);
			studentRepository.insert(student1);
		}
		else {
			System.out.println("Student already exist");
		}
	}

}
