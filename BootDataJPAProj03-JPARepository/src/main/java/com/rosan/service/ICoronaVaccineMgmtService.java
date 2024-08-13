package com.rosan.service;

import java.util.List;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder, String... properties);
	public CoronaVaccine getVaccineByRegNo(Long regNo);
	public String removeVaccinesByRegNo(Iterable<Long> regNos);
}
