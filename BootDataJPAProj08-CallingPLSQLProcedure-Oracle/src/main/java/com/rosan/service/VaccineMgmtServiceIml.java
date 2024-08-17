package com.rosan.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.entity.CoronaVaccine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("vaccineService")
public class VaccineMgmtServiceIml implements IVaccineMgmtService {
	@Autowired
	private EntityManager manager;
	/*
	 * create or replace PROCEDURE p_get_vaccines_by_pricerange ( startprice IN
	 * FLOAT, endprice IN FLOAT, details OUT SYS_REFCURSOR ) AS BEGIN OPEN details
	 * FOR SELECT reg_no, name, company, country, price, required_dose_count FROM
	 * corona_vaccine WHERE price >= startprice AND price <= endprice;
	 * 
	 * END p_get_vaccines_by_pricerange;
	 */

	@Override
	public List<CoronaVaccine> searchAllVaccinesByPriceRange(float min, float max) {
		// create StoredProcedure obj representing our Pl-sql procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_get_vaccines_by_pricerange",
				CoronaVaccine.class);

		// register Parameters of pl-sql procedures
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);

		// set values to parameters
		query.setParameter(1, min);
		query.setParameter(2, max);
//		System.out.println("VaccineMgmtServiceIml.searchAllVaccinesByPriceRange()");

		// call pl-sql procedure
		List<CoronaVaccine> list = query.getResultList();
		return list;
	}

	/*
	 * 1 create or replace procedure p_authentication 2 (username in varchar2,pwd in
	 * varchar2,result out varchar2) as 3 cnt number(5); 4 begin 5 select count(*)
	 * into cnt from userslist where uname=username and password=pwd; 6 if cnt <>0
	 * then 7 result:='VALID CREDENTIALS'; 8 else 9 result:='INVALID CREDENTIALS';
	 * 10 end if; 11* end p_authentication; SQL> /
	 * 
	 * Procedure created.
	 * 
	 */

	@Override
	public String authenticate(String user, String password) {
		// create StoredProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_authentication");

		// register parameters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);

		// set parameter values
		query.setParameter(1, user);
		query.setParameter(2, password);

		// call the procedure
		query.execute();
		// gather result from outparameter
		String result = (String) query.getOutputParameterValue(3);
		return result;
	}

	/*
	 * create or replace function fx_get_Emp_details ( eno in number,name out
	 * varchar2,desg out varchar2,salary out number) return number as dno number(3);
	 * begin select ename, job, sal, deptno into name, desg,salary,dno from emp
	 * where empno=eno; return dno; * end fx_get_emp_details;
	 * 
	 */
	@Override
	public Object[] getEmpDetailsByEno(int eno) {
		// unwrap Session object from EntityManager
		Session sess = manager.unwrap(Session.class);

		// work with doReturningWork<T> callback interface to write plain jdbc code to
		// call pl-sql function
		Object[] obj = sess.doReturningWork(conn -> {
			// create Callable statement obj
			CallableStatement cs = conn.prepareCall("{?=call fx_get_emp_details(?,?,?,?)}");
			// register return, out parameters
			// return value is the first out parameter to be registered
			cs.registerOutParameter(1, Types.INTEGER); // return param(?1)
			cs.registerOutParameter(3, Types.VARCHAR); // return param(?1)
			cs.registerOutParameter(4, Types.VARCHAR); // return param(?1)
			cs.registerOutParameter(5, Types.INTEGER); // return param(?1)
			// set value in param
			cs.setInt(2, eno);
			// call pl-sql function
			cs.execute();
			// gather result from return, out params
			Object objs[] = new Object[4];
			objs[0] = cs.getInt(1);
			objs[1] = cs.getString(3);
			objs[2] = cs.getString(4);
			objs[3] = cs.getInt(5);

			return objs;
		});
		return obj;
	}

}
