package com.rosan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.entity.Customer;
import com.rosan.repo.ICustomerRepo;

@Service("customerService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerRepo custRepo;

	@Override
	public String registerCustomer(Customer cust) {
		int idVal = custRepo.save(cust).getCustId();
		return "Customer is saved with id :: " + idVal;
	}

	@Override
	public List<Customer> getCustomers() {
		return custRepo.findAll();
	}

}
