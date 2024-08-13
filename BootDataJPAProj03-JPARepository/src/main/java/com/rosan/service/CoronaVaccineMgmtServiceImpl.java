package com.rosan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rosan.entity.CoronaVaccine;
import com.rosan.repo.ICoronaVaccineRepo;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,
			String... properties) {
		// prepare Example object
		Example<CoronaVaccine> example = Example.of(vaccine);
		// Prepare Sort object
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);
		List<CoronaVaccine> listEntities = coronaRepo.findAll(example, sort);
		return listEntities;
	}

	@SuppressWarnings("deprecation")
	@Override
//	@Transactional
	public CoronaVaccine getVaccineByRegNo(Long regNo) {

		return coronaRepo.getById(regNo);
	}

	@Override
	public String removeVaccinesByRegNo(Iterable<Long> regNos) {
		Iterable<CoronaVaccine> listEntities = coronaRepo.findAllById(regNos);
		if (((List<CoronaVaccine>) listEntities).size() != 0) {
			coronaRepo.deleteAllByIdInBatch(regNos);
			return ((List<CoronaVaccine>) listEntities).size() + " records are deleted";
		}
		return "Records not found for deletion";
	}

}
