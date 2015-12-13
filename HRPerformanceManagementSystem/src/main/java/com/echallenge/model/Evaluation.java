package com.echallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "evaluation")
public class Evaluation {
	private Long id;
	/** L'objectif concern� par l'�valuation */
	private Objectif objectif;
	private int poids;
	private Double resultat;

	public Evaluation() {
	}

	public Evaluation(Long id, Encadrant encadrant, Objectif objectif, int poids, double resultat) {
		this.id = id;
		this.objectif = objectif;
		this.poids = poids;
		this.resultat = resultat;
	}

	/**
	 * @return the id
	 */
	@XmlElement
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the objectif
	 */
	@XmlElement
	public Objectif getObjectif() {
		return objectif;
	}

	/**
	 * @param objectif
	 *            the objectif to set
	 */
	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	/**
	 * @return the poids
	 */
	@XmlElement
	public int getPoids() {
		return poids;
	}

	/**
	 * @param poids
	 *            the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * @return the resultat
	 */
	@XmlElement
	public Double getResultat() {
		return resultat;
	}

	/**
	 * @param resultat
	 *            the resultat to set
	 */
	public void setResultat(Double resultat) {
		this.resultat = resultat;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (id != null)
			result = prime * result + id.intValue();
		else
			result = prime * result + 	objectif.hashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Evaluation other = (Evaluation) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
