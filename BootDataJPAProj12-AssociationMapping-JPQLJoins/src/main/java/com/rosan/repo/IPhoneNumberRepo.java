package com.rosan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {

}
