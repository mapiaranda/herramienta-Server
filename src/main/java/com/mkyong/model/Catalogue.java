package com.mkyong.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOGUE_TBL", catalog = "test_apps")
public class Catalogue implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_catalogue;


	@Column(name = "name", unique = true)
	private String name;

	@Column
	private String description;

	public Catalogue(int id_catalogue, String name, String description) {
		this.id_catalogue = id_catalogue;
		this.name = name;
		this.description = description;
	}

	public Catalogue() {
	}

	public int getId_catalogue() {
		return id_catalogue;
	}

	public void setId_catalogue(int id_catalogue) {
		this.id_catalogue = id_catalogue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {

		return this.id_catalogue + this.name + this.description;

	}

}
