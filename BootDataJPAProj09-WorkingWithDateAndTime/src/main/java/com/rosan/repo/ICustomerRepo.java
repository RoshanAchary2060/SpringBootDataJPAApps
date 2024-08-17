package com.rosan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
