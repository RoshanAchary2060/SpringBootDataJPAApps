package com.rosan.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public Optional<CoronaVaccine> searchVaccineByName(String name) {
		return coronaRepo.searchVaccineByName(name);
	}

	@Override
	public Object searchVaccineDataByName(String name) {
		return coronaRepo.searchVaccineDataByName(name);
	}

	@Override
	public String searchVaccineCountryByName(String name) {
		return coronaRepo.searchVaccineCountryByName(name);
	}

	@Override
	public long getVaccinesCount() {
		return coronaRepo.getVaccinesCount();
	}

	@Override
	public Object getVaccinesAggregateDataByPriceRange(double min, double max) {
		return coronaRepo.getVaccinesAggregateDataByPriceRange(min, max);
	}

	@Override
	@Transactional
	public int updateVaccinePriceByCountry(double newPrice, String country) {
		return coronaRepo.updateVaccinePriceByCountry(newPrice, country);
	}

	@Override
	public int deleteVaccinesByPriceRange(double start, double end) {
		return coronaRepo.deleteVaccinesByPriceRange(start, end);
	}

	@Override
	public int insertVaccine(long regNo, String company, String country, String name, double price, int dosesCount) {
		return coronaRepo.insertVaccine(regNo, company, country, name, price, dosesCount);
	}

	@Override
	public int insertVaccine(String company, String country, String name, double price, int dosesCount) {
		return coronaRepo.insertVaccine(company, country, name, price, dosesCount);
	}

	@Override
	public Date getSystemDate() {
		return coronaRepo.getSystemDate();
	}

	@Override
	public int createTempTable() {
		return coronaRepo.createTempTable();
	}

}
