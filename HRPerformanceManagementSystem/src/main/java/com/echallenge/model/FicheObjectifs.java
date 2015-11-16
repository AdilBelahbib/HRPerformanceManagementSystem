package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;

public class FicheObjectifs {
	private int id;
	/**Le collaborateur concern�*/
	private Collaborateur collaborateur;
	private Date dateFicheObjectifs;
	/**Le droit d'acc�s pour le collaborateur concern�*/
	private boolean autorisationAcces;
	/**La liste des objectifs composant la fiche*/
	private HashSet<Objectif> objectifs;
	
	public FicheObjectifs() {
		this.objectifs = new HashSet<Objectif>();
	}

	public FicheObjectifs(int id, Collaborateur collaborateur, Date dateFicheObjectifs, boolean autorisationAcces,
			HashSet<Objectif> objectifs) {
		this.id = id;
		this.collaborateur = collaborateur;
		this.dateFicheObjectifs = dateFicheObjectifs;
		this.autorisationAcces = autorisationAcces;
		this.objectifs = objectifs;
	}

	public FicheObjectifs(int id, Collaborateur collaborateur, Date dateFicheObjectifs, boolean autorisationAcces) {
		this.id = id;
		this.collaborateur = collaborateur;
		this.dateFicheObjectifs = dateFicheObjectifs;
		this.autorisationAcces = autorisationAcces;
		this.objectifs = new HashSet<Objectif>();
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
	 * @return the dateFicheObjectifs
	 */
	public Date getDateFicheObjectifs() {
		return dateFicheObjectifs;
	}

	/**
	 * @param dateFicheObjectifs the dateFicheObjectifs to set
	 */
	public void setDateFicheObjectifs(Date dateFicheObjectifs) {
		this.dateFicheObjectifs = dateFicheObjectifs;
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
		FicheObjectifs other = (FicheObjectifs) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
