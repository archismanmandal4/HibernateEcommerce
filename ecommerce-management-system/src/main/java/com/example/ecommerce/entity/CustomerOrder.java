package com.example.ecommerce.entity;

import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime; import java.util.*;
@Entity @Table(name="orders")
public class CustomerOrder { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private User customer; @Enumerated(EnumType.STRING) private OrderStatus status=OrderStatus.PENDING; @Column(nullable=false,precision=12,scale=2) private BigDecimal total=BigDecimal.ZERO; private LocalDateTime orderedAt=LocalDateTime.now(); @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderItem> items=new ArrayList<>(); public CustomerOrder(){} public CustomerOrder(User customer){this.customer=customer;} public Long getId(){return id;} public BigDecimal getTotal(){return total;} public List<OrderItem> getItems(){return items;} public void addItem(Product p,int qty){OrderItem i=new OrderItem(this,p,qty,p.getPrice());items.add(i);total=total.add(i.getSubtotal());}
}
