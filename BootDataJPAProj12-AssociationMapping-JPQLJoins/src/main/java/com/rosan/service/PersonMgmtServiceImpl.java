package com.rosan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.repo.IPersonRepo;
import com.rosan.repo.IPhoneNumberRepo;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	private IPersonRepo pRepo;
	@Autowired
	private IPhoneNumberRepo phoneRepo;

	@Override
	public List<Object[]> fetchDataByJoinsUsingParent() {
		return pRepo.fetchDataUsingJoinsByParent();
	}

}
