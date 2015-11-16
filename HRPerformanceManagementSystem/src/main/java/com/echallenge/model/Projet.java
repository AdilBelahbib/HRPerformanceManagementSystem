package com.echallenge.model;

import java.util.HashSet;

public class Projet {
	private int id;
	private String codeProjet;
	private String nomProjet;
	/**La liste des objectifs contenus dans le projet*/
	private HashSet<Objectif> objectifs;
	
	public Projet() {
	}

	public Projet(int id, String codeProjet, String nomProjet, HashSet<Objectif> objectifs) {
		this.id = id;
		this.codeProjet = codeProjet;
		this.nomProjet = nomProjet;
		this.objectifs = objectifs;
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
	 * @return the codeProjet
	 */
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
	public String getNomProjet() {
		return nomProjet;
	}

	/**
	 * @param nomProjet the nomProjet to set
	 */
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	/**
	 * @return the objectifs
	 */
	public HashSet<Objectif> getObjectifs() {
		return objectifs;
	}

	/**
	 * @param objectifs the objectifs to set
	 */
	public void setObjectifs(HashSet<Objectif> objectifs) {
		this.objectifs = objectifs;
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
		Projet other = (Projet) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
