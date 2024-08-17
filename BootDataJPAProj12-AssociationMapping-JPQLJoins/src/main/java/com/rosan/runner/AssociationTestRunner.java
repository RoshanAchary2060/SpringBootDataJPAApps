package com.rosan.runner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.rosan.service.IPersonMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			service.fetchDataByJoinsUsingParent().forEach(row -> {
				for (Object val : row) {
					System.out.print(val + " ");
				}
				System.out.println();
			});

		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
	}

}
