package com.rosan.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.rosan.entity.Person;
import com.rosan.entity.PhoneNumber;
import com.rosan.service.IPersonMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {

			// ======= Save Operation Parent to Child =======
			// Prepare parent obj having associated child objs
			// parent obj
//			PhoneNumber ph1 = new PhoneNumber( 9999999999l, "ntc", "office");
//			PhoneNumber ph2 = new PhoneNumber( 8888888888l, "ncell", "home");
//			Set<PhoneNumber> phonesSet = new HashSet<PhoneNumber>();
//			phonesSet.add(ph1);
//			phonesSet.add(ph2); // parent obj
//			Person person1 = new Person("Raja", "hyd");
//			person1.setContactDetails(phonesSet);
			// parent to child
//			ph1.setPerson(person1);
//			ph2.setPerson(person1); // invoke service method
//			System.out.println(service.savePerson(person1));

			/* ====== Save Operation child to parent ======== */
			// child objs
//			PhoneNumber ph1 = new PhoneNumber(77777777l, "cdma", "work");
//			PhoneNumber ph2 = new PhoneNumber(66666666l, "smart", "visit");
//			Set<PhoneNumber> phonesSet = Set.of(ph1, ph2);
//			// parent obj
//			Person per = new Person("ram", "nepal");
//
//			// add parent to childs
//			ph1.setPerson(per);
//			ph2.setPerson(per);
//
//			System.out.println(service.savePhoneNumbres(phonesSet));

			// ====== load operation parent to child
//			service.fetchbyPerson().forEach(per -> {
//				System.out.println("parent::" + per);
//				Set<PhoneNumber> childs = per.getContactDetails();
//				childs.forEach(System.out::println);
//			});

//			// =====load operation child to parent=======
//			service.fetchByPhoneNumber().forEach(ph -> {
//				System.out.println("child :: " + ph);
//				Person per = ph.getPerson();
//				System.out.println("Parent :: " + per);
//			});

			// ====== Deleting Parent to child=====

//			System.out.println(service.deleteByPerson(5));

			System.out.println(service.deleteAllPhoneNumbersOfAPerson(9));
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
	}

}
