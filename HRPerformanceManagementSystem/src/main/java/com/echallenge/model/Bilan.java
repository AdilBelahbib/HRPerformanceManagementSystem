package com.echallenge.model;

import java.util.Date;

public abstract class Bilan {
	private int id;
	private Date dateBilan;
	/**La fiche des objectifs traités
	*(modifiés dans le cas de BIP et validés dans le cas de BAP)*/
	private FicheObjectifs ficheObjectifsTraites;
	
	public Bilan() {
	}

	public Bilan(int id, Date dateBilan, FicheObjectifs ficheObjectifs) {
		this.id = id;
		this.dateBilan = dateBilan;
		this.ficheObjectifsTraites = ficheObjectifs;
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
	 * @return the dateBilan
	 */
	public Date getDateBilan() {
		return dateBilan;
	}

	/**
	 * @param dateBilan the dateBilan to set
	 */
	public void setDateBilan(Date dateBilan) {
		this.dateBilan = dateBilan;
	}

	

	/**
	 * @return the ficheObjectifs
	 */
	public FicheObjectifs getFicheObjectifs() {
		return ficheObjectifsTraites;
	}

	/**
	 * @param ficheObjectifs the ficheObjectifs to set
	 */
	public void setFicheObjectifs(FicheObjectifs ficheObjectifs) {
		this.ficheObjectifsTraites = ficheObjectifs;
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
		Bilan other = (Bilan) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	/**
	 * Récuperer le collaborateur concerné
	 * @return Le collaborateur concerné par le Bilan
	 */
	public Collaborateur getCollaborateur()
	{
		if(this.ficheObjectifsTraites != null)
			return this.ficheObjectifsTraites.getCollaborateur();
		
		return null;
	}
}
