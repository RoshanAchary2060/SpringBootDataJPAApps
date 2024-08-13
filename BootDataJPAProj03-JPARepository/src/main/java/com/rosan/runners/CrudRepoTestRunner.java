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
//			CoronaVaccine vaccine = new CoronaVaccine(null, "covishield", "IndiaTechnology", "Russia", 600.0, 3);
//			service.searchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);

//			CoronaVaccine vaccine = service.getVaccineByRegNo(705l);
//			if (vaccine != null) {
//				System.out.println("Vaccine details :: " + vaccine);
//			} else {
//				System.out.println("Record not found");
//			}

			System.out.println(service.removeVaccinesByRegNo(List.of(653l, 705l)));

		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
