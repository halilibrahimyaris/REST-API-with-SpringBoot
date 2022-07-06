package com.example.springRestApi.repository;

import com.example.springRestApi.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <Student,String>{
}
