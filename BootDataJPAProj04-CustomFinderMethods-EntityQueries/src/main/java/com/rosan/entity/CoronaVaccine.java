package com.rosan.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Table(name = "CORONA_VACCINE") // optional if u want to take db table name same as entity class name
public class CoronaVaccine implements Serializable {

	private static final long serialVersionUID = -479432455497179872L;

	@Id // to make property as singular ID property and to map with singular PK column
//	@Column(name = "regNo") // optional if u want to take property name as the column name
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;

	@Column(length = 20)
	private String name;

	@Column(length = 20)
	private String company;

	@Column(length = 20)
	private String country;
	@Column()
	private Double price;
	@Column
	private Integer requiredDoseCount;
}
