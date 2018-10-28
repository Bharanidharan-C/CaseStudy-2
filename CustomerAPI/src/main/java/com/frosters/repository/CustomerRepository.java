package com.frosters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frosters.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
