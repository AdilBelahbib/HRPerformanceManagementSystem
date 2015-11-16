package com.echallenge.model;

import java.util.HashSet;

public class Feedback {
	private int id;
	/**Le collaborateur concerné*/
	private Collaborateur collaborateur;
	private String remarqueGenerale;
	private boolean validation;
	/**L'entête du feedback*/
	private Entete entete;
	/**Les qualifications par thème*/
	private HashSet<QualificationTheme> qualificationsTheme;
	
	public Feedback() {
		this.qualificationsTheme = new HashSet<QualificationTheme>();
	}

	public Feedback(int id, Collaborateur collaborateur, String remarqueGenerale, boolean validation, Entete entete,
			HashSet<QualificationTheme> qualificationsTheme) {
		this.id = id;
		this.collaborateur = collaborateur;
		this.remarqueGenerale = remarqueGenerale;
		this.validation = validation;
		this.entete = entete;
		this.qualificationsTheme = qualificationsTheme;
	}

	public Feedback(int id, Collaborateur collaborateur, String remarqueGenerale, boolean validation, Entete entete) {
		this.id = id;
		this.collaborateur = collaborateur;
		this.remarqueGenerale = remarqueGenerale;
		this.validation = validation;
		this.entete = entete;
		this.qualificationsTheme = new HashSet<QualificationTheme>();
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
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the remarqueGenerale
	 */
	public String getRemarqueGenerale() {
		return remarqueGenerale;
	}

	/**
	 * @param remarqueGenerale the remarqueGenerale to set
	 */
	public void setRemarqueGenerale(String remarqueGenerale) {
		this.remarqueGenerale = remarqueGenerale;
	}

	/**
	 * @return the validation
	 */
	public boolean isValidation() {
		return validation;
	}

	/**
	 * @param validation the validation to set
	 */
	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	/**
	 * @return the entete
	 */
	public Entete getEntete() {
		return entete;
	}

	/**
	 * @param entete the entete to set
	 */
	public void setEntete(Entete entete) {
		this.entete = entete;
	}

	/**
	 * @return the qualificationsTheme
	 */
	public HashSet<QualificationTheme> getQualificationsTheme() {
		return qualificationsTheme;
	}

	/**
	 * @param qualificationsTheme the qualificationsTheme to set
	 */
	public void setQualificationsTheme(HashSet<QualificationTheme> qualificationsTheme) {
		this.qualificationsTheme = qualificationsTheme;
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
		Feedback other = (Feedback) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
