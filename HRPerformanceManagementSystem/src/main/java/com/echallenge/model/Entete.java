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
	private String codeProjet;
	private String nomProjet;
	
	public Entete() {
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
	 * @return the codeProjet
	 */
	@XmlElement
	public String getCodeProjet() {
		return codeProjet;
	}

	/**
	 * @param codeProjet the codeProjet to set
	 */
	public void setCodeProjet(String codeProjet) {
		this.codeProjet = codeProjet;
	}

	/**
	 * @return the nomProjet
	 */
	@XmlElement
	public String getNomProjet() {
		return nomProjet;
	}

	/**
	 * @param nomProjet the nomProjet to set
	 */
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
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
