package com.rosan.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rosan.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
//	@Query("FROM com.rosan.entity.CoronaVaccine WHERE company=?1")
//	@Query("From CoronaVaccine where company=?1")
	@Query("From CoronaVaccine where company=:comp")
	public List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);

//	@Query("From CoronaVaccine where price>=?1 and price<=?2")
	@Query("From CoronaVaccine where price>=:min and price<=:max")
	public List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max);

	// ===============Select Queries Performing Bulk Operations==================

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

	// ============Select Query performing Single Row Operation================

	@Query("From CoronaVaccine where name=:name")
	public Optional<CoronaVaccine> searchVaccineByName(String name);

	@Query("select name,company,country from CoronaVaccine where name=:name")
	public Object searchVaccineDataByName(String name);

	@Query("select country from CoronaVaccine where name=:name")
	public String searchVaccineCountryByName(String name);

	// ===============Aggregate Functions================
	@Query("select count(*) from CoronaVaccine")
	public long getVaccinesCount();

	@Query("select count(*),max(price),min(price),sum(price),avg(price) from CoronaVaccine where price>=:min and price<=:max")
	public Object getVaccinesAggregateDataByPriceRange(double min, double max);

	// ===================NON-Select Operations (DML Operations)==================
	@Modifying
	@Query("update CoronaVaccine set price=:newPrice where country=:country")
	public int updateVaccinePriceByCountry(double newPrice, String country);

	@Modifying
	@Transactional
	@Query("delete from CoronaVaccine where price between :start and :end")
	public int deleteVaccinesByPriceRange(double start, double end);

	// =========Native SQL Queries================
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "insert into corona_vaccine values(?,?,?,?,?,?)")

	public int insertVaccine(long regNo, String company, String country, String name, double price, int dosesCount);

	@Query(nativeQuery = true, value = "insert into corona_vaccine values(CORONA_VACCINE_SEQ.NEXTVAL,?,?,?,?,?)")
	@Transactional
	@Modifying
	public int insertVaccine(String company, String country, String name, double price, int dosesCount);

	@Query(value = "select sysdate from dual", nativeQuery = true)
	public Date getSystemDate();

	// =========== DDL Command ===========
	@Query(value = "Create table temp(col1 number(5),col2 varchar2(20))", nativeQuery = true)
	@Transactional
	@Modifying
	public int createTempTable();
}
