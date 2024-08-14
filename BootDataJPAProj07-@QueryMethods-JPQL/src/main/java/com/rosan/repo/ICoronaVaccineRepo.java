package com.rosan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
//	@Query("FROM com.rosan.entity.CoronaVaccine WHERE company=?1")
//	@Query("From CoronaVaccine where company=?1")
	@Query("From CoronaVaccine where company=:comp")
	public List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);

//	@Query("From CoronaVaccine where price>=?1 and price<=?2")
	@Query("From CoronaVaccine where price>=:min and price<=:max")
	public List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max);

	// ============Entity query selecting column values============
	@Query("FROM CoronaVaccine where company in(:comp1,:comp2,:comp3) order by company")
	public List<CoronaVaccine> searchVaccinesByCompanies(String comp1, String comp2, String comp3);
	// here we cannot take List<String>, String... companies(var args)/String[]
	// companies(String) as the param type

	// Scalar query selecting specific multiple col values

	@Query("select name, company, price from CoronaVaccine where name in(:name1,:name2)")
	public List<Object[]> searchVaccineDetailsByNames(String name1, String name2);

	@Query("select name from CoronaVaccine where price between :min and :max")
	public List<String> searchVaccineNamesByPriceRange(double min, double max);

}
