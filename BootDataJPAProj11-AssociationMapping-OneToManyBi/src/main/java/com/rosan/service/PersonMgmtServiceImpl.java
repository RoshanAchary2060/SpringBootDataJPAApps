package com.rosan.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.entity.Person;
import com.rosan.entity.PhoneNumber;
import com.rosan.repo.IPersonRepo;
import com.rosan.repo.IPhoneNumberRepo;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	private IPersonRepo pRepo;
	@Autowired
	private IPhoneNumberRepo phoneRepo;

	@Override
	public String savePerson(Person per) {
		int idVal = pRepo.save(per).getPid();
		return "Person and his phone numbers are saved with id value :: " + idVal;
	}

	@Override
	public String savePhoneNumbres(Iterable<PhoneNumber> phones) {
		List<PhoneNumber> list = phoneRepo.saveAll(phones);
		return list.size() + " phone numbers are inserted";
	}

	@Override
	public Iterable<Person> fetchbyPerson() {
		return pRepo.findAll();
	}

	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneRepo.findAll();
	}

	@Override
	public String deleteByPerson(int personId) {
		// Load parent obj
		Optional<Person> person = pRepo.findById(personId);
		if (person.isPresent()) {
			pRepo.delete(person.get());
			return "Person and his phone numbers are deleted";
		}
		return "Person not found!";
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		// Load parent obj
		Optional<Person> opt = pRepo.findById(personId);
		if (opt.isPresent()) {
			// get all childs of a parent
			Set<PhoneNumber> childs = opt.get().getContactDetails();
			// delete all childs
			childs.forEach(ph -> {
				ph.setPerson(null);
			});
			phoneRepo.deleteAll(childs);
			return childs.size() + " phone numbers of " + personId + " Person are deleted";
		}
		return personId + " Person not found!";
	}

}
