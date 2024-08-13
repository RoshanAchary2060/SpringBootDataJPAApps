package com.rosan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
}
