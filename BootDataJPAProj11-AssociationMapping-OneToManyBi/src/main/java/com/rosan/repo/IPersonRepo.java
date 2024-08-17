package com.rosan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
