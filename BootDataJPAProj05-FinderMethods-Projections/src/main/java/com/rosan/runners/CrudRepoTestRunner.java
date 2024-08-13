package com.rosan.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.rosan.service.ICoronaVaccineMgmtService;
import com.rosan.type.ResultView;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {

			List<ResultView> listVaccines = service.searchVaccinesByStartPrice(500.0);
			listVaccines.forEach(vaccine -> {
				System.out.println(vaccine.getClass());
				System.out.println(vaccine.getName() + ", " + vaccine.getCountry());
			});
//			listVaccines.forEach(System.out::println); it won't work

		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
