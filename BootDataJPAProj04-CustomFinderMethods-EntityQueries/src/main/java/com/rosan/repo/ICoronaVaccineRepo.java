package com.rosan.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	// select reg_no,name,company,country,price,required_dose_count from
	// Corona_Vaccine where company=?
	public List<CoronaVaccine> findByCompany(String company);

	public List<CoronaVaccine> findByCompanyEquals(String company);

	public List<CoronaVaccine> findByCompanyIs(String copany);

	public List<CoronaVaccine> findByPriceLessThan(double price);

	public List<CoronaVaccine> findByPriceBetween(double startPrice, double endPrice);

	public List<CoronaVaccine> findByNameLike(String initChars);

	public List<CoronaVaccine> findByNameStartingWith(String startLetters);

	public List<CoronaVaccine> findByNameEndingWith(String endLetters);

	public List<CoronaVaccine> findByNameContaining(String letters);

	public List<CoronaVaccine> findByCountryIn(List<String> countries);

	public List<CoronaVaccine> findByCountryNotIn(List<String> countries);

	public List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(double price);

	public List<CoronaVaccine> findByCountryIsNot(String country);

	public CoronaVaccine findByRegNo(Long regNo);

	// ===========Using Multiple properties based conditions==========

	public List<CoronaVaccine> findByNameAndCountry(String name, String country);

	public List<CoronaVaccine> findByNameEqualsAndCountryEquals(String name, String country);

	public List<CoronaVaccine> findByNameLikeOrPriceBetween(String nameInitChars, double startRange, double endRange);

	public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startRange,
			double endRange);

	public List<CoronaVaccine> findByCountryInAndNameInOrPriceGreaterThanEqual(Collection<String> countries,
			Collection<String> names, double priceStartRange);
}
