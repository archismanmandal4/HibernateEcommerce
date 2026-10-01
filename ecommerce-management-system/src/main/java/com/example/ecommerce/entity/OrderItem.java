package com.example.ecommerce.entity;

import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="order_items")
public class OrderItem { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="order_id") private CustomerOrder order; @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="product_id") private Product product; private int quantity; @Column(nullable=false,precision=12,scale=2) private BigDecimal unitPrice; public OrderItem(){} public OrderItem(CustomerOrder order,Product product,int quantity,BigDecimal unitPrice){this.order=order;this.product=product;this.quantity=quantity;this.unitPrice=unitPrice;} public BigDecimal getSubtotal(){return unitPrice.multiply(BigDecimal.valueOf(quantity));}
}
