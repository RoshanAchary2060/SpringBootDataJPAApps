package com.rosan.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> searchVaccinesByCompany(String company);

	public List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max);

	public List<CoronaVaccine> searchVaccinesByCompanies(String comp1, String comp2, String comp3);

	public List<Object[]> searchVaccineDetailsByNames(String name1, String name2);

	public List<String> searchVaccineNamesByPriceRange(double min, double max);

	public Optional<CoronaVaccine> searchVaccineByName(String name);

	public Object searchVaccineDataByName(String name);

	public String searchVaccineCountryByName(String name);

	public long getVaccinesCount();

	public Object getVaccinesAggregateDataByPriceRange(double min, double max);

	public int updateVaccinePriceByCountry(double newPrice, String country);
	public int deleteVaccinesByPriceRange(double start, double end);
	public int insertVaccine(long regNo, String company, String country, String name, double price, int dosesCount);
	public int insertVaccine( String company, String country, String name, double price, int dosesCount);
	public Date getSystemDate();
	public int createTempTable();

}
