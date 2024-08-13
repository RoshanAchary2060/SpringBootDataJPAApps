package com.rosan.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.rosan.service.ICoronaVaccineMgmtService;
import com.rosan.type.ResultView1;
import com.rosan.type.ResultView2;
import com.rosan.type.ResultView3;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("============================================");
			List<ResultView1> list1 = service.searchVaccinesByCompany("USATech", ResultView1.class);
			list1.forEach(view1 -> System.out.println(view1.getName() + "," + view1.getCountry()));
			System.out.println("============================================");
			List<ResultView2> list2 = service.searchVaccinesByCompany("IndiaTech", ResultView2.class);
			list2.forEach(view2 -> System.out.println(view2.getRegNo() + "," + view2.getPrice()));
			System.out.println("============================================");
			List<ResultView3> list3 = service.searchVaccinesByCompany("IndiaTech", ResultView3.class);
			list3.forEach(
					view3 -> System.out.println(view3.getName() + "," + view3.getPrice() + "," + view3.getCountry()));
			System.out.println("============================================");

		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
