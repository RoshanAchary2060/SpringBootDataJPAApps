package com.rosan.service;

import java.util.List;

import com.rosan.entity.CoronaVaccine;

public interface IVaccineMgmtService {
	public List<CoronaVaccine> searchAllVaccinesByPriceRange(float min, float max);

	public String authenticate(String user, String password);

	public Object[] getEmpDetailsByEno(int eno);
}
