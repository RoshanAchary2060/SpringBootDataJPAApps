package com.rosan.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.rosan.service.ICoronaVaccineMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
//			service.fetchVaccinesByCompany("NepTech").forEach(System.out::println);

//			service.fetchVaccinesByPriceLessThan(400).forEach(System.out::println);

//			service.fetchVaccinesByPriceBetween(100, 700).forEach(System.out::println);

//			service.fetchVaccinesByNameLike("__________").forEach(System.out::println);

//			service.fetchVaccinesByNameStartingWith("c").forEach(System.out::println);

//			service.fetchVaccinesByNameEndingWith("go").forEach(System.out::println);
//			service.fetchVaccinesByNameContaining("i").forEach(System.out::println);

//			service.fetchVaccinesByCountryIn("Nepal", "USA","China").forEach(System.out::println);
//			service.fetchVaccinesByCountryNotIn("Nepal", "USA", "China").forEach(System.out::println);

//			service.fetchVaccinesByPriceGreaterThanOrderByPriceAsc(300).forEach(System.out::println);

//			service.fetchVaccinesByCountryIsNot("Nepal").forEach(System.out::println);

//			System.out.println(service.fetchVaccineByRegNo(605l));

//			service.searchVaccinesByNameAndCountry("coronagogo", "Nepal").forEach(System.out::println);

//			service.searchVaccinesByNameLikeOrPriceBetween("c%", 200, 700).forEach(System.out::println);

//		service.searchVaccinesByCountriesAndPriceRange(List.of("India","Nepal"), 200, 700).forEach(System.out::println);

			service.searchVaccinesByCountriesAndNamesOrPriceRange(List.of("Nepal", "China"),
					List.of("coronagogo", "shield"), 200).forEach(System.out::println);
		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
