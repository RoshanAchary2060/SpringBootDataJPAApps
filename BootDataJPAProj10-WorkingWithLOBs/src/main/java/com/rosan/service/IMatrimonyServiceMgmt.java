package com.rosan.service;

import java.util.Optional;

import com.rosan.entity.MarriageSeeker;

public interface IMatrimonyServiceMgmt {
	public String registerMarriageSeeker(MarriageSeeker seeker);

	public Optional<MarriageSeeker> searchSeekerById(int id);
}
