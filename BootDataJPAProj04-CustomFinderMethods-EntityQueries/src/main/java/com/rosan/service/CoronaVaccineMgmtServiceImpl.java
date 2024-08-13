package com.rosan.service;

import java.util.Arrays;
import java.util.Collection;
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
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		System.out.println(Arrays.toString(coronaRepo.getClass().getClass().getDeclaredMethods()));
		// use repo
//		return coronaRepo.findByCompany(company);
//		return coronaRepo.findByCompanyEquals(company);
		return coronaRepo.findByCompanyIs(company);

	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceLessThan(double price) {

		return coronaRepo.findByPriceLessThan(price);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceBetween(double startPrice, double endPrice) {
		return coronaRepo.findByPriceBetween(startPrice, endPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameLike(String initChars) {
		return coronaRepo.findByNameLike(initChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameStartingWith(String startLetters) {
		return coronaRepo.findByNameStartingWith(startLetters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameEndingWith(String endLetters) {
		return coronaRepo.findByNameEndingWith(endLetters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameContaining(String letters) {
		return coronaRepo.findByNameContaining(letters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountryIn(String... countries) {

		return coronaRepo.findByCountryIn(List.of(countries));
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountryNotIn(String... countries) {
		return coronaRepo.findByCountryNotIn(List.of(countries));
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceGreaterThanOrderByPriceAsc(double price) {
		return coronaRepo.findByPriceGreaterThanOrderByPriceAsc(price);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountryIsNot(String country) {
		return coronaRepo.findByCountryIsNot(country);
	}

	@Override
	public CoronaVaccine fetchVaccineByRegNo(Long regNo) {
		return coronaRepo.findByRegNo(regNo);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByNameAndCountry(String name, String country) {
		return coronaRepo.findByNameEqualsAndCountryEquals(name, country);

	}

	@Override
	public List<CoronaVaccine> searchVaccinesByNameLikeOrPriceBetween(String nameInitChars, double startRange,
			double endRange) {
		return coronaRepo.findByNameLikeOrPriceBetween(nameInitChars, startRange, endRange);

	}

	@Override
	public List<CoronaVaccine> searchVaccinesByCountriesAndPriceRange(Collection<String> countries, double startRange,
			double endRange) {
		return coronaRepo.findByCountryInAndPriceBetween(countries, startRange, endRange);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByCountriesAndNamesOrPriceRange(Collection<String> countries,
			Collection<String> names, double priceStartRange) {
		return coronaRepo.findByCountryInAndNameInOrPriceGreaterThanEqual(countries, names, priceStartRange);
	}

}
