package com.echallenge.model;

import java.util.Date;

public abstract class Bilan {
	private Long id;
	private Date dateBilan;
	/**
	 * La fiche des objectifs traités (modifiés dans le cas de BIP et valid�s
	 * dans le cas de BAP)
	 */
	private FicheObjectifs ficheObjectifsTraites;
	private Collaborateur collaborateur;

	public Bilan() {
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
	 * @return the dateBilan
	 */
	public Date getDateBilan() {
		return dateBilan;
	}

	/**
	 * @param dateBilan
	 *            the dateBilan to set
	 */
	public void setDateBilan(Date dateBilan) {
		this.dateBilan = dateBilan;
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
	 * @return the ficheObjectifsTraites
	 */
	public FicheObjectifs getFicheObjectifsTraites() {
		return ficheObjectifsTraites;
	}

	/**
	 * @param ficheObjectifsTraites
	 *            the ficheObjectifsTraites to set
	 */
	public void setFicheObjectifsTraites(FicheObjectifs ficheObjectifsTraites) {
		this.ficheObjectifsTraites = ficheObjectifsTraites;
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
			result = prime * result + dateBilan.hashCode() * ficheObjectifsTraites.hashCode();
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
		Bilan other = (Bilan) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
