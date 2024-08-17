package com.rosan.service;

import java.util.List;

import com.rosan.entity.Customer;

public interface ICustomerMgmtService {
	public String registerCustomer(Customer cust);
	public List<Customer> getCustomers();

}
