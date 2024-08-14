package com.rosan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.entity.CoronaVaccine;
import com.rosan.repo.ICoronaVaccineRepo;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public List<CoronaVaccine> searchVaccinesByCompany(String company) {
		return coronaRepo.searchVaccinesByCompany(company);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max) {
		return coronaRepo.searchVaccinesByPriceRange(min, max);

	}

	@Override
	public List<CoronaVaccine> searchVaccinesByCompanies(String comp1, String comp2, String comp3) {
		return coronaRepo.searchVaccinesByCompanies(comp1, comp2, comp3);
	}

	@Override
	public List<Object[]> searchVaccineDetailsByNames(String name1, String name2) {
		return coronaRepo.searchVaccineDetailsByNames(name1, name2);
	}

	@Override
	public List<String> searchVaccineNamesByPriceRange(double min, double max) {
		return coronaRepo.searchVaccineNamesByPriceRange(min, max);
	}

}
