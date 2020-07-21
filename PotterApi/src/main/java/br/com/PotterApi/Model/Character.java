package br.com.PotterApi.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "characters")
public class Character implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("character id")
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME")
	private String name;
	
	@Column(name = "HOUSE")
	private String house;
	
	@Column(name = "SPECIES")
	private String species;
	
	@Column(name = "BLOOD_STATUS")
	private String bloodStatus;
	
	@Column(name = "ROLES")
	private String role;
	
	@Column(name = "SCHOOL")
	private String school;
	
	@Column(name = "DEATH_EATER")
	private Boolean deathEater;
	
	@Column(name = "DUMBLEDORES_ARMY")
	private Boolean dumbledoresArmy;
	
	@Column(name = "ORDER_PHONEIX")
	private Boolean orderOfThePhoenix;
	
	@Column(name = "MINISTRY_MAGIC")
	private Boolean ministryOfMagic;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBloodStatus() {
		return bloodStatus;
	}

	public void setBloodStatus(String bloodStatus) {
		this.bloodStatus = bloodStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Boolean getDeathEater() {
		return deathEater;
	}

	public void setDeathEater(Boolean deathEater) {
		this.deathEater = deathEater;
	}

	public Boolean getDumbledoresArmy() {
		return dumbledoresArmy;
	}

	public void setDumbledoresArmy(Boolean dumbledoresArmy) {
		this.dumbledoresArmy = dumbledoresArmy;
	}

	public Boolean getOrderOfThePhoenix() {
		return orderOfThePhoenix;
	}

	public void setOrderOfThePhoenix(Boolean orderOfThePhoenix) {
		this.orderOfThePhoenix = orderOfThePhoenix;
	}

	public Boolean getMinistryOfMagic() {
		return ministryOfMagic;
	}

	public void setMinistryOfMagic(Boolean ministryOfMagic) {
		this.ministryOfMagic = ministryOfMagic;
	}

	public Character() {
		
	}

	public Character(Integer id, String name, String house, String species, String bloodStatus,
			String role, String school, Boolean deathEater, Boolean dumbledoresArmy, Boolean orderOfThePhoenix,
			Boolean ministryOfMagic) {
		super();
		this.id = id;
		this.name = name;
		this.house = house;
		this.species = species;
		this.bloodStatus = bloodStatus;
		this.role = role;
		this.school = school;
		this.deathEater = deathEater;
		this.dumbledoresArmy = dumbledoresArmy;
		this.orderOfThePhoenix = orderOfThePhoenix;
		this.ministryOfMagic = ministryOfMagic;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", house=" + house + ", species=" + species 
				+ ", bloodStatus=" + bloodStatus + ", role=" + role + ", school=" + school + ", deathEater="
				+ deathEater + ", dumbledoresArmy=" + dumbledoresArmy + ", orderOfThePhoenix=" + orderOfThePhoenix
				+ ", ministryOfMagic=" + ministryOfMagic + "]";
	}

}
