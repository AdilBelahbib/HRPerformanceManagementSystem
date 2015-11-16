package com.echallenge.model;

import java.util.Date;

public class Entete {
	private int id;
	private Date dateDebutIntervention;
	private Date dateFinIntervention;
	private String role;
	private int nombreJoursValorises;
	/**Le projet concerné par l'entête*/
	private Projet projet;
	
	public Entete() {
	}

	public Entete(int id, Date dateDebutIntervention, Date dateFinIntervention, String role, int nombreJoursValorises,
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
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateDebutIntervention
	 */
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
		result = prime * result + id;
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
