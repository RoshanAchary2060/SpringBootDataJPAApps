package com.rosan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.CoronaVaccine;
import com.rosan.type.ResultView;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double startPrice);
}
