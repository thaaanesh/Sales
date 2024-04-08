package com.task.Exampledemo.Repository;

import com.task.Exampledemo.Model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Integer> {
//    @Query("SELECT p.prod_name FROM Product p JOIN p.customers c WHERE c.cus_id = :cus_id")

}
