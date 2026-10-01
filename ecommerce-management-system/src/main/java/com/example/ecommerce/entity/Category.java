package com.example.ecommerce.entity;

import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="categories")
public class Category { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true) private String name; private String description;
 @OneToMany(mappedBy="category", cascade=CascadeType.ALL) private List<Product> products=new ArrayList<>();
 public Category(){} public Category(String name,String description){this.name=name;this.description=description;} public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;} public void setName(String name){this.name=name;} public void setDescription(String description){this.description=description;}
}
