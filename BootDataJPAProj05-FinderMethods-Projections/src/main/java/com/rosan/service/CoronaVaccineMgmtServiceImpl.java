package com.rosan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.repo.ICoronaVaccineRepo;
import com.rosan.type.ResultView;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public List<ResultView> searchVaccinesByStartPrice(double startPrice) {
		return coronaRepo.findByPriceGreaterThanEqualOrderByPrice(startPrice);
	}

}
