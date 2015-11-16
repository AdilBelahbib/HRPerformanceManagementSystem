package com.echallenge.model;

public class Evaluation {
	private int id;
	/**L'encadrant ayant fait l'évaluation*/
	private Encadrant encadrant;
	/**L'objectif concerné par l'évaluation*/
	private Objectif objectif;
	private int poids;
	private double resultat;
	
	public Evaluation() {
	}

	public Evaluation(int id, Encadrant encadrant, Objectif objectif, int poids, double resultat) {
		this.id = id;
		this.encadrant = encadrant;
		this.objectif = objectif;
		this.poids = poids;
		this.resultat = resultat;
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
	 * @return the encadrant
	 */
	public Encadrant getEncadrant() {
		return encadrant;
	}

	/**
	 * @param encadrant the encadrant to set
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
	 * @param objectif the objectif to set
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
	 * @param poids the poids to set
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
	 * @param resultat the resultat to set
	 */
	public void setResultat(double resultat) {
		this.resultat = resultat;
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
		Evaluation other = (Evaluation) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
