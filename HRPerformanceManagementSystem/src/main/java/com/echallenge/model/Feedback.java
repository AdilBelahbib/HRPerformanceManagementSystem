package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "feedback")
public class Feedback {
	private Long id;
	/**Le collaborateur concern�*/
	private Collaborateur collaborateur;
	private String remarqueGenerale;
	private boolean validation;
	/**L'ent�te du feedback*/
	private Entete entete;
	/**Les qualifications par th�me*/
	private Set<QualificationTheme> qualificationsTheme;
	
	public Feedback() {
		this.qualificationsTheme = new HashSet<QualificationTheme>();
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
	 * @return the collaborateur
	 */
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElementWrapper(name = "qualificationstheme")
	@XmlElement
	public Set<QualificationTheme> getQualificationsTheme() {
		return qualificationsTheme;
	}

	/**
	 * @param qualificationsTheme the qualificationsTheme to set
	 */
	public void setQualificationsTheme(Set<QualificationTheme> qualificationsTheme) {
		this.qualificationsTheme = qualificationsTheme;
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
			result = prime * result + entete.hashCode()*collaborateur.hashCode();
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
