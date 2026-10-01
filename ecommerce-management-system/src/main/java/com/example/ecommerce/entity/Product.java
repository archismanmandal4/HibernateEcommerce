package com.example.ecommerce.entity;

import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="products") @NamedQuery(name="Product.activeByName",query="select p from Product p where p.deleted=false and lower(p.name) like lower(concat('%', :term, '%')) order by p.name")
public class Product { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String name; @Column(length=1000) private String description; @Column(nullable=false,precision=12,scale=2) private BigDecimal price; @Column(nullable=false) private int stock; private boolean deleted=false; private LocalDateTime createdAt=LocalDateTime.now();
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="category_id") private Category category;
 public Product(){} public Product(String name,String description,BigDecimal price,int stock,Category category){this.name=name;this.description=description;this.price=price;this.stock=stock;this.category=category;} public Long getId(){return id;} public String getName(){return name;} public BigDecimal getPrice(){return price;} public int getStock(){return stock;} public boolean isDeleted(){return deleted;} public Category getCategory(){return category;} public void setStock(int stock){this.stock=stock;} public void setDeleted(boolean deleted){this.deleted=deleted;}
}
