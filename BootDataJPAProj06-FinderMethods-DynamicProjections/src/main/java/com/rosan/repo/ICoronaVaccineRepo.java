package com.rosan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.CoronaVaccine;
import com.rosan.type.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company,Class<T> clazz);
}
