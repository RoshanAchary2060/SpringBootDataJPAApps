package com.rosan.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rosan.service.IVaccineMgmtService;

@Component
public class StoredProcedureRunner implements CommandLineRunner {
	@Autowired
	private IVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("StoredProcedureRunner.run()");
//		service.searchAllVaccinesByPriceRange(200, 900).forEach(System.out::println);
//		System.out.println("Result :: " + service.authenticate("ram", "sita"));
		Object[] result = service.getEmpDetailsByEno(7499);
		System.out.println("Eno:"+result[0] + ",\nEname:" + result[1] + ",\nJob:" + result[2] + ",\nSal:" + result[3]);
	}

}
