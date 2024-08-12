package com.rosan.repo;

import org.springframework.data.repository.CrudRepository;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}
