package com.rosan.service;

import com.rosan.entity.Person;
import com.rosan.entity.PhoneNumber;

public interface IPersonMgmtService {
	public String savePerson(Person per);

	public String savePhoneNumbres(Iterable<PhoneNumber> phones);

	public Iterable<Person> fetchbyPerson();

	public Iterable<PhoneNumber> fetchByPhoneNumber();

	public String deleteByPerson(int personId);

	public String deleteAllPhoneNumbersOfAPerson(int personId);
}
