package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ficheobjectifs")
public class FicheObjectifs {
	private Long id;
	private Date dateFicheObjectifs;
	/**Le droit d'accès pour le collaborateur concern�*/
	private boolean autorisationAcces;
	/**La liste des objectifs composant la fiche*/
	private Set<Objectif> objectifs;
	
	public FicheObjectifs() {
		this.objectifs = new HashSet<Objectif>();
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
	 * @return the dateFicheObjectifs
	 */
	@XmlElement
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
	 * @return the objectifs
	 */
	@XmlElementWrapper(name = "objectifs")
	@XmlElement
	public Set<Objectif> getObjectifs() {
		return objectifs;
	}

	/**
	 * @param objectifs the objectifs to set
	 */
	public void setObjectifs(Set<Objectif> objectifs) {
		this.objectifs = objectifs;
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
			result = prime * result + objectifs.hashCode();
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
