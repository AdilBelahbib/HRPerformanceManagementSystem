package com.echallenge.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entete")
public class Entete {
	private Long id;
	private Date dateDebutIntervention;
	private Date dateFinIntervention;
	private String role;
	private int nombreJoursValorises;
	/**Le projet concern� par l'ent�te*/
	private Projet projet;
	
	public Entete() {
	}

	public Entete(Long id, Date dateDebutIntervention, Date dateFinIntervention, String role, int nombreJoursValorises,
			Projet projet) {
		this.id = id;
		this.dateDebutIntervention = dateDebutIntervention;
		this.dateFinIntervention = dateFinIntervention;
		this.role = role;
		this.nombreJoursValorises = nombreJoursValorises;
		this.projet = projet;
	}

	/**
	 * @return the id
	 */
	@XmlElement
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateDebutIntervention
	 */
	@XmlElement
	public Date getDateDebutIntervention() {
		return dateDebutIntervention;
	}

	/**
	 * @param dateDebutIntervention the dateDebutIntervention to set
	 */
	public void setDateDebutIntervention(Date dateDebutIntervention) {
		this.dateDebutIntervention = dateDebutIntervention;
	}

	/**
	 * @return the dateFinIntervention
	 */
	@XmlElement
	public Date getDateFinIntervention() {
		return dateFinIntervention;
	}

	/**
	 * @param dateFinIntervention the dateFinIntervention to set
	 */
	public void setDateFinIntervention(Date dateFinIntervention) {
		this.dateFinIntervention = dateFinIntervention;
	}

	/**
	 * @return the role
	 */
	@XmlElement
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the nombreJoursValorises
	 */
	@XmlElement
	public int getNombreJoursValorises() {
		return nombreJoursValorises;
	}

	/**
	 * @param nombreJoursValorises the nombreJoursValorises to set
	 */
	public void setNombreJoursValorises(int nombreJoursValorises) {
		this.nombreJoursValorises = nombreJoursValorises;
	}

	/**
	 * @return the projet
	 */
	@XmlElement
	public Projet getProjet() {
		return projet;
	}

	/**
	 * @param projet the projet to set
	 */
	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
		else
			result = prime * result + dateDebutIntervention.hashCode()*role.hashCode()*nombreJoursValorises;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entete other = (Entete) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
