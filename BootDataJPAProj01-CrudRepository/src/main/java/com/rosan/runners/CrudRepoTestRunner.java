package com.rosan.runners;

import java.util.List;

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
//		try {
//			// create CoronaVaccine object
//			CoronaVaccine vaccine = new CoronaVaccine(null, "covishield", "IndiaTechnology", "China", 600.0, 3);
//			// call business method
//			System.out.println(service.registerVaccine(vaccine));
//		} catch (DataAccessException ex) {
//			System.out.println("Error");
//			ex.printStackTrace();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		try {
//			// Bulk Insertion/Batch Insertion
//			Iterable<CoronaVaccine> listVaccines = service
//					.registerInBatch(List.of(new CoronaVaccine(null, "shield", "IndiaTechnology", "China", 600.0, 3),
//							new CoronaVaccine(null, "covishield", "IndiaTechnology", "Russia", 600.0, 3),
//							new CoronaVaccine(null, "coronagogo", "NepTech", "Nepal", 200.0, 51)));

//			Iterable<CoronaVaccine> listVaccines = service.registerInBatch(
//					Arrays.asList(new CoronaVaccine(null, "shield", "IndiaTechnology", "China", 600.0, 3),
//							new CoronaVaccine(null, "covishield", "IndiaTechnology", "Russia", 600.0, 3),
//							new CoronaVaccine(null, "coronagogo", "NepTech", "Nepal", 200.0, 51)));
//
//			listVaccines.forEach(vaccine -> System.out.println(vaccine.getRegNo()));

//			System.out.println("Vaccines count :: " + service.getVaccinesCount());

//			System.out.println("21 regNo vaccine available ? " + service.checkVaccineAvailabilityByRegNo(21));
//			System.out.println("1 regNo vaccine available ? " + service.checkVaccineAvailabilityByRegNo(1));

//			Iterable<CoronaVaccine> itList = service.fetchAllDetails();
//			itList.forEach(vaccine -> System.out.println(vaccine));

//			List<CoronaVaccine> vaccines = (List<CoronaVaccine>) itList;
//			System.out.println("Using stream API");
//			vaccines.stream().forEach(vaccine -> System.out.println(vaccine));

//			Arrays.asList(service.fetchAllDetails()).stream().forEach(System.out::println);

//			Arrays.asList(service.fetchAllDetails()).stream().map(s1 -> s1).forEach(System.out::println);

//			System.out.println("======FindAllByIDS=======");
//			itList = service.fetchAllDetailsByIds(List.of(1l, 2l, 52l, 203l));
//			itList.forEach(System.out::println);

//			System.out.println("=======FindByID()========");
//			Optional<CoronaVaccine> opt = service.fetchVaccineById(525l);
//			if (opt.isPresent()) {
//				System.out.println(opt.get());
//			} else {
//				System.out.println("Rec not found!");
//			}
//
//			System.out.println("=======FindByID()========");
//			Optional<CoronaVaccine> opt = service.fetchVaccineById(525l);
//			if (opt.isPresent()) {
//				System.out.println(opt.get());
//			} else {
//				opt.orElseThrow(() -> new IllegalArgumentException("record not found!"));
//			}

//			CoronaVaccine vaccine = service.fetchVaccineById(22l)
//					.orElseThrow(() -> new IllegalArgumentException("not available"));
//			System.out.println(vaccine);

//			CoronaVaccine vaccine = service.fetchVaccineById(2l).orElse(new CoronaVaccine());
//			System.out.println(vaccine);

//			CoronaVaccine vaccine = service.fetchVaccineById(1l).orElseGet(() -> new CoronaVaccine());
//			System.out.println(vaccine);

//			System.out.println(service.removeVaccineById(203l));

//			CoronaVaccine vaccine = new CoronaVaccine();
//			vaccine.setRegNo(2l);
//			System.out.println(service.removeVaccineByObject(vaccine));

//			System.out.println(service.removeVaccinesByIds(List.of(453l)));

			System.out.println(service.removeAllVaccines());

			
		} catch (DataAccessException dae) {
			System.out.println("Error occured");
			dae.printStackTrace();
		}
	}
}
