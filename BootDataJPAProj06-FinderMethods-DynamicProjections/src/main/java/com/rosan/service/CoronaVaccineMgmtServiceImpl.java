package com.rosan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.repo.ICoronaVaccineRepo;
import com.rosan.type.View;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> clazz) {
		return coronaRepo.findByCompanyOrderByCompanyDesc(company, clazz);
	}


}
