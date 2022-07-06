package com.example.springRestApi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favoriteSubject;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;

    public Student(String firstName, String lastName, String email, Gender gender, Address address, List<String> favoriteSubject, BigDecimal totalSpentInBooks, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favoriteSubject = favoriteSubject;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
