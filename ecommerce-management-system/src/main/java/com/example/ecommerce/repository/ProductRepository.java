package com.example.ecommerce.repository;
import com.example.ecommerce.entity.*; import jakarta.persistence.*; import jakarta.persistence.criteria.*; import java.util.*;
public class ProductRepository { private final EntityManager em; public ProductRepository(EntityManager em){this.em=em;}
 public Product save(Product p){return p.getId()==null ? persist(p) : em.merge(p);} private Product persist(Product p){em.persist(p);return p;}
 public Optional<Product> findActiveById(Long id){return em.createQuery("select p from Product p where p.id=:id and p.deleted=false",Product.class).setParameter("id",id).getResultStream().findFirst();}
 public List<Product> search(String term){return em.createNamedQuery("Product.activeByName",Product.class).setParameter("term",term).getResultList();}
 public List<Product> page(int page,int size){return em.createQuery("select p from Product p where p.deleted=false order by p.id",Product.class).setFirstResult(page*size).setMaxResults(size).getResultList();}
 public List<Product> byCategory(Long categoryId){CriteriaBuilder cb=em.getCriteriaBuilder(); CriteriaQuery<Product> q=cb.createQuery(Product.class); Root<Product> p=q.from(Product.class); q.select(p).where(cb.and(cb.equal(p.get("category").get("id"),categoryId),cb.isFalse(p.get("deleted")))); return em.createQuery(q).getResultList();}
 public void softDelete(Long id){findActiveById(id).ifPresent(p->p.setDeleted(true));}
}
