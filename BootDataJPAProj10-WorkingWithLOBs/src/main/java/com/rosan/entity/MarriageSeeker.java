package com.rosan.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MarriageSeeker implements Serializable {

	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public char[] getBiodata() {
		return biodata;
	}

	public void setBiodata(char[] biodata) {
		this.biodata = biodata;
	}

	public boolean isIndian() {
		return indian;
	}

	public void setIndian(boolean indian) {
		this.indian = indian;
	}

	@Override
	public String toString() {
		return "MarriageSeeker [id=" + id + ", name=" + name + ", addrs=" + addrs + ", photo=" + Arrays.toString(photo)
				+ ", dob=" + dob + ", biodata=" + Arrays.toString(biodata) + ", indian=" + indian + "]";
	}

	public MarriageSeeker(String name, String addrs, byte[] photo, LocalDateTime dob, char[] biodata, boolean indian) {
		super();
		this.name = name;
		this.addrs = addrs;
		this.photo = photo;
		this.dob = dob;
		this.biodata = biodata;
		this.indian = indian;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String addrs;
	private byte[] photo;
	private LocalDateTime dob;
	private char[] biodata;
	private boolean indian;
}
