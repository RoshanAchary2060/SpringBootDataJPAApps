package com.rosan.runners;

import java.util.Date;

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

//			service.searchVaccineNamesByPriceRange(200, 900).forEach(System.out::println);
//			Optional<CoronaVaccine> opt = service.searchVaccineByName("coronago");
//			if(opt.isPresent()) {
//				System.out.println(opt.get());
//			} else {
//				System.out.println("Record not found!");
//			}

//			Object obj = service.searchVaccineDataByName("coronago");
//			Arrays.stream((Object[]) obj).forEach(System.out::println);

//			System.out.println(service.searchVaccineCountryByName("coronago"));

//			System.out.println("Total vaccines are " + service.getVaccinesCount());

//			Object result = service.getVaccinesAggregateDataByPriceRange(100.0, 400.0);
//			for (Object o : (Object[]) result) {
//				System.out.print(o + " ");
//			}
//			System.out.println();

//			int count = service.updateVaccinePriceByCountry(800, "Nepal");
//			System.out.println("No of records updated :: "+count);

//			int count = service.deleteVaccinesByPriceRange(100, 500);
//			System.out.println("No of vaccines deleted :: " + count);

//			int count = service.insertVaccine(2, "prototype", "Qatar", "Remedy", 335, 3);
//			if(count == 0) {
//				System.out.println("Record not inserted");
//			} else {
//				System.out.println("Record inserted :: "+count);
//			}
//			int count = service.insertVaccine("HealthCare", "Belgium", "Cure", 455, 3);
//			if(count == 0) {
//				System.out.println("Record not inserted");
//			} else {
//				System.out.println("Record inserted :: "+count);
//			}

//			Date date = service.getSystemDate();
//			System.out.println("Date and Time :: " + date.toLocaleString());
			
			int count = service.createTempTable();
			System.out.println(count);
			if(count == 0) {
				System.out.println("Table created");
			} else {
				System.out.println("Table not created");
			}
			
		} catch (DataAccessException dae) {
			System.out.println("Error occured!");
			dae.printStackTrace();
		}
	}
}
