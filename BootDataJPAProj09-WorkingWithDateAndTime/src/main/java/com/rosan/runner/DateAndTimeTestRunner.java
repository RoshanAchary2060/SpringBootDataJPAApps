package com.rosan.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rosan.entity.Customer;
import com.rosan.service.ICustomerMgmtService;

@Component
public class DateAndTimeTestRunner implements CommandLineRunner {
	@Autowired
	private ICustomerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
//		Customer cust = new Customer("raja", "hyd", LocalDateTime.of(2003, 7, 9, 12, 15, 30), LocalTime.now(),
//				LocalDate.now());
//		System.out.println(service.registerCustomer(cust));

		service.getCustomers().forEach(System.out::println);
	}

}
