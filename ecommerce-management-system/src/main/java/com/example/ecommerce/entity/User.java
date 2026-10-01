package com.example.ecommerce.entity;

import jakarta.persistence.*; import java.time.LocalDateTime; import java.util.*;
@Entity @Table(name="users")
public class User { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String fullName; @Column(nullable=false,unique=true) private String email; @Column(nullable=false) private String passwordHash; private LocalDateTime createdAt=LocalDateTime.now();
 @OneToMany(mappedBy="customer") private List<CustomerOrder> orders=new ArrayList<>(); public User(){} public User(String fullName,String email,String passwordHash){this.fullName=fullName;this.email=email;this.passwordHash=passwordHash;} public Long getId(){return id;} public String getEmail(){return email;} public String getPasswordHash(){return passwordHash;}
}
