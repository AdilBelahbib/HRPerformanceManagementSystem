package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FicheEvaluations {
	private Long id;
	private Date dateEvaluation;
	/**Le collaborateur concern�*/
	private Collaborateur collaborateur;
	/**Le droit d'acc�s pour le collaborateur concern�*/
	private boolean autorisationAcces;
	/**La liste des �valuations composant la fiche*/
	private Set<Evaluation> evaluations;
	
	public FicheEvaluations() {
		this.evaluations = new HashSet<Evaluation>();
	}

	public FicheEvaluations(Long id, Date dateEvaluation, boolean autorisationAcces, Collaborateur collaborateur) {
		this.id = id;
		this.dateEvaluation = dateEvaluation;
		this.autorisationAcces = autorisationAcces;
		this.collaborateur = collaborateur;
		this.evaluations = new HashSet<Evaluation>();
	}

	public FicheEvaluations(Long id, Date dateEvaluation, Collaborateur collaborateur, boolean autorisationAcces,
			Set<Evaluation> evaluations) {
		this.id = id;
		this.dateEvaluation = dateEvaluation;
		this.collaborateur = collaborateur;
		this.autorisationAcces = autorisationAcces;
		this.evaluations = evaluations;
	}

	
	
	/**
	 * @return the id
	 */
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
	 * @return the dateEvaluation
	 */
	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	/**
	 * @param dateEvaluation the dateEvaluation to set
	 */
	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
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
	 * @return the autorisationAcces
	 */
	public boolean isAutorisationAcces() {
		return autorisationAcces;
	}

	/**
	 * @param autorisationAcces the autorisationAcces to set
	 */
	public void setAutorisationAcces(boolean autorisationAcces) {
		this.autorisationAcces = autorisationAcces;
	}

	/**
	 * @return the evaluations
	 */
	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
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
			result = prime * result + collaborateur.hashCode()*dateEvaluation.hashCode();
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
		FicheEvaluations other = (FicheEvaluations) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}