package com.echallenge.model;

public class Evaluation {
	private Long id;
	/** L'encadrant ayant fait l'�valuation */
	private Encadrant encadrant;
	/** L'objectif concern� par l'�valuation */
	private Objectif objectif;
	private int poids;
	private double resultat;

	public Evaluation() {
	}

	public Evaluation(Long id, Encadrant encadrant, Objectif objectif, int poids, double resultat) {
		this.id = id;
		this.encadrant = encadrant;
		this.objectif = objectif;
		this.poids = poids;
		this.resultat = resultat;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the encadrant
	 */
	public Encadrant getEncadrant() {
		return encadrant;
	}

	/**
	 * @param encadrant
	 *            the encadrant to set
	 */
	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}

	/**
	 * @return the objectif
	 */
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
	public double getResultat() {
		return resultat;
	}

	/**
	 * @param resultat
	 *            the resultat to set
	 */
	public void setResultat(double resultat) {
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
			result = prime * result + encadrant.hashCode() * objectif.hashCode();
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
