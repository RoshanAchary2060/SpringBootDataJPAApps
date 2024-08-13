package com.rosan.service;

import java.util.Collection;
import java.util.List;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> fetchVaccinesByCompany(String company);

	public List<CoronaVaccine> fetchVaccinesByPriceLessThan(double price);

	public List<CoronaVaccine> fetchVaccinesByPriceBetween(double startPrice, double endPrice);

	public List<CoronaVaccine> fetchVaccinesByNameLike(String initChars);

	public List<CoronaVaccine> fetchVaccinesByNameStartingWith(String startLetters);

	public List<CoronaVaccine> fetchVaccinesByNameEndingWith(String endLetters);

	public List<CoronaVaccine> fetchVaccinesByNameContaining(String letters);

	public List<CoronaVaccine> fetchVaccinesByCountryIn(String... countries);

	public List<CoronaVaccine> fetchVaccinesByCountryNotIn(String... countries);

	public List<CoronaVaccine> fetchVaccinesByPriceGreaterThanOrderByPriceAsc(double price);

	public List<CoronaVaccine> fetchVaccinesByCountryIsNot(String country);
	public CoronaVaccine fetchVaccineByRegNo(Long regNo);
	
	public List<CoronaVaccine> searchVaccinesByNameAndCountry(String name, String country);

	public List<CoronaVaccine> searchVaccinesByNameLikeOrPriceBetween(String nameInitChars, double startRange, double endRange);

	public List<CoronaVaccine> searchVaccinesByCountriesAndPriceRange(Collection<String> countries, double startRange,
			double endRange);
	public List<CoronaVaccine> searchVaccinesByCountriesAndNamesOrPriceRange(Collection<String> countries,
			Collection<String> names, double priceStartRange);
}
