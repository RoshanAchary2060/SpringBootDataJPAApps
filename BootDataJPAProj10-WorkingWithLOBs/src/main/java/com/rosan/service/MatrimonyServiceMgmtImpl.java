package com.rosan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.entity.MarriageSeeker;
import com.rosan.repo.IMarriageSeekerRepo;

@Service("matrimonyServiceO")
public class MatrimonyServiceMgmtImpl implements IMatrimonyServiceMgmt {
	@Autowired
	private IMarriageSeekerRepo msRepo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "MarriageSeeker info is saved with id :: " + msRepo.save(seeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(int id) {
		return msRepo.findById(id);
	}

}
