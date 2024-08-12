package com.rosan.service;

import java.util.Optional;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public String registerVaccine(CoronaVaccine vaccine);

	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);

	public long getVaccinesCount();

	public boolean checkVaccineAvailabilityByRegNo(long regNo);

	public Iterable<CoronaVaccine> fetchAllDetails();

	public Iterable<CoronaVaccine> fetchAllDetailsByIds(Iterable<Long> ids);

	public Optional<CoronaVaccine> fetchVaccineById(Long regNo);

	public String removeVaccineById(Long id);

	public String removeVaccineByObject(CoronaVaccine vaccine);

	public String removeVaccinesByIds(Iterable<Long> ids);
	
	public String removeAllVaccines();
}
