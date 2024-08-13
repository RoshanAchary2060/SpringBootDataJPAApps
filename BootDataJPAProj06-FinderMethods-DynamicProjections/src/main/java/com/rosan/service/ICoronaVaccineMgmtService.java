package com.rosan.service;

import java.util.List;

import com.rosan.type.View;

public interface ICoronaVaccineMgmtService {
	public <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> clazz); 
}
