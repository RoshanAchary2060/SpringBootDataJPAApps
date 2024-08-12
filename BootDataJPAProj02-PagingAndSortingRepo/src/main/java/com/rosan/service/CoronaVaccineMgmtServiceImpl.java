package com.rosan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rosan.entity.CoronaVaccine;
import com.rosan.repo.ICoronaVaccineRepo;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntities = coronaRepo.findAll(sort);
		return listEntities;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		// create Pageable object having
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
		Page<CoronaVaccine> page = coronaRepo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		// get total records count
		long count = coronaRepo.count();
		// decide the pages count
		long pagesCount = count / pageSize;
		pagesCount = count % pageSize == 0 ? pagesCount : ++pagesCount;

		for (int i = 0; i <= pagesCount; ++i) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = coronaRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			;
			System.out.println("-------------------" + page.getNumber() + 1 + " of " + page.getTotalPages()
					+ "---------------------");
		}
	}

}
