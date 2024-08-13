package com.rosan.service;

import java.util.List;

import com.rosan.type.ResultView;

public interface ICoronaVaccineMgmtService {
	public List<ResultView> searchVaccinesByStartPrice(double startPrice);
}
