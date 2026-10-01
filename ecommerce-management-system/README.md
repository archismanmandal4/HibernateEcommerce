# E-Commerce Management System

A Java learning project showcasing Hibernate ORM 6, JPA, MySQL, transactions, HQL, Criteria API, BCrypt password hashing, soft deletion, pagination, and JUnit 5.

## Open in VS Code

1. Install Java 17, Maven, MySQL, and VS Code's **Extension Pack for Java**.
2. Create a database: `CREATE DATABASE ecommerce_db;`
3. Update the username/password in `src/main/resources/META-INF/persistence.xml`.
4. Open this folder in VS Code, then run `mvn test` or `mvn exec:java` in its terminal.

`hibernate.hbm2ddl.auto` is set to `update` for learning purposes. Change it to `validate` for production-style deployments.

## Domain model

`Category 1..* Product`, `User 1..* CustomerOrder`, and `CustomerOrder 1..* OrderItem`; each order item references one product. Product stock is reduced atomically when an order is placed.

## Features

- CRUD-ready repositories and service layer
- `@NamedQuery`, HQL search, Criteria API category filtering
- soft-deleted products excluded by default
- pageable product catalog
- transactional order placement and stock validation
- BCrypt password hashing (never store plain-text passwords)
