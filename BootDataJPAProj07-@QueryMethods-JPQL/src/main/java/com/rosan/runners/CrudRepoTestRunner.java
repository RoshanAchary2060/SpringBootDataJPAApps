package com.rosan.runners;

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
//			service.searchVaccinesByCompany("NepTech").forEach(System.out::println);

//			service.searchVaccinesByPriceRange(200, 800).forEach(System.out::println);

//			service.searchVaccinesByCompanies("NepTech", "", "").forEach(System.out::println);

//			service.searchVaccineDetailsByNames("coronago", "sun").forEach(values -> {
//				System.out.println(values[0] + "," + values[1] + "," + values[2]);
//			});

			service.searchVaccineNamesByPriceRange(200, 900).forEach(System.out::println);
		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
