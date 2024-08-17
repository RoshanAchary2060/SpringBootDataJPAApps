package com.rosan.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "OTM_Person")
public class Person implements Serializable {
	public Person(String pname, String paddrs) {
		super();
		this.pname = pname;
		this.paddrs = paddrs;
	}

	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_sequence")
	@SequenceGenerator(name = "default_sequence", allocationSize = 1)
	private Integer pid;
	@Column(length = 20)
	private String pname;
	@Column(length = 20)
	private String paddrs;

	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, mappedBy = "person")
//	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID") no need to mention
	private Set<PhoneNumber> contactDetails; // for OTM association


	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs;
	}

}
