package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ficheevaluations")
public class FicheEvaluations {
	private Long id;
	private Date dateEvaluation;
	/**Le droit d'acc�s pour le collaborateur concern�*/
	private boolean autorisationAcces;
	/**La liste des �valuations composant la fiche*/
	private Set<Evaluation> evaluations;
	private double noteFinale;
	
	public FicheEvaluations() {
		this.evaluations = new HashSet<Evaluation>();
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
	 * @return the dateEvaluation
	 */
	@XmlElement
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
	 * @return the autorisationAcces
	 */
	@XmlElement
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
	@XmlElementWrapper(name = "evaluations")
	@XmlElement
	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	/**
	 * @return the noteFinale
	 */
	public double getNoteFinale() {
		return noteFinale;
	}

	/**
	 * @param noteFinale the noteFinale to set
	 */
	public void setNoteFinale(double noteFinale) {
		this.noteFinale = noteFinale;
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
			result = prime * result + 	dateEvaluation.hashCode();
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
