package com.rosan.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.rosan.entity.CoronaVaccine;
import com.rosan.service.ICoronaVaccineMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
//			Iterable<CoronaVaccine> listEntities = service.fetchDetails(true, "price", "name");
//			listEntities.forEach(System.out::println);

//			service.fetchDetailsByPageNo(2, 5, true, "name").forEach(System.out::println);

			service.fetchDetailsByPagination(5);

		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
