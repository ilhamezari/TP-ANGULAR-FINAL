package com.example.banck_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.banck_backend.entities.Customer;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    @Query("select c from Customer c where c.name like :kw")
List<Customer> searchCustomer(@Param("kw")String keyword);
}
