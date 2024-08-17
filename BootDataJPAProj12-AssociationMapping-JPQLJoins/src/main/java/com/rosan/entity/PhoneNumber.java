package com.rosan.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "OTM_Phonenumber")
//@Data
public class PhoneNumber implements Serializable {

	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type;
	}

	public PhoneNumber(Long phoneNo, String provider, String type) {
		super();
		this.phoneNo = phoneNo;
		this.provider = provider;
		this.type = type;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "regno_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
	private Integer regno;

	private Long phoneNo;
	@Column(length = 20)
	private String provider;
	@Column(length = 20)

	private String type;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person person; // for MTO association


}
