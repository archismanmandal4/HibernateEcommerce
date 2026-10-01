package com.example.ecommerce.util;
import jakarta.persistence.*;
public final class JpaUtil { private static final EntityManagerFactory EMF=Persistence.createEntityManagerFactory("ecommercePU"); private JpaUtil(){} public static EntityManager entityManager(){return EMF.createEntityManager();} public static void close(){EMF.close();} }
