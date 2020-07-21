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
@Table(name = "houses")
public class House implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("house id")
	@Id
	@Column(name = "ID_HOUSE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHouse;
	
	@Column(name = "NOME")
	private String name;
	
	@Column(name = "MASCOT")
	private String mascot;
	
	@Column(name = "HEAD_HOUSE")
	private String headOfHouse;
	
	@Column(name = "HOUSE_GHOST")
	private String houseGhost;
	
	@Column(name = "FOUNDER")
	private String founder;
	
	@Column(name = "SCHOOL")
	private String school;
	
	@Column(name = "MEMBERS")
	private String members;

	public Integer getIdHouse() {
		return idHouse;
	}

	public void setIdHouse(Integer idHouse) {
		this.idHouse = idHouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMascot() {
		return mascot;
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	public String getHeadOfHouse() {
		return headOfHouse;
	}

	public void setHeadOfHouse(String headOfHouse) {
		this.headOfHouse = headOfHouse;
	}

	public String getHouseGhost() {
		return houseGhost;
	}

	public void setHouseGhost(String houseGhost) {
		this.houseGhost = houseGhost;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public House() {
		super();
	}

	public House(Integer idHouse, String name, String mascot, String headOfHouse, String houseGhost, String founder,
			String school, String members) {
		super();
		this.idHouse = idHouse;
		this.name = name;
		this.mascot = mascot;
		this.headOfHouse = headOfHouse;
		this.houseGhost = houseGhost;
		this.founder = founder;
		this.school = school;
		this.members = members;
	}
	

	@Override
	public String toString() {
		return "House [idHouse=" + idHouse + ", name=" + name + ", mascot=" + mascot + ", headOfHouse=" + headOfHouse
				+ ", houseGhost=" + houseGhost + ", founder=" + founder + ", school=" + school + ", members="
				+ members +"]";
	}
	
	
}
