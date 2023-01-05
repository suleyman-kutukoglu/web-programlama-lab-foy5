package com.mustafazorbaz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mustafa
 *
 */
@Entity
@Table(name="ogrenciler")
public class Ogrenciler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ogrenciId")
	private int ogrenciId;
	
	@Column(name = "ogrenciName")
	private String ogrenciName;
	
	@Column(name = "email")
	private String email;
	
	public int getOgrenciId() {
		return ogrenciId;
	}
	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}
	public String getOgrenciName() {
		return ogrenciName;
	}
	public void setOgrenciName(String ogrenciName) {
		this.ogrenciName = ogrenciName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
