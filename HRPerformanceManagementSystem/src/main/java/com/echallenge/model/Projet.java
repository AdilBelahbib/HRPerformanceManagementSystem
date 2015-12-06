package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projet")
public class Projet {
	private Long id;
	private String codeProjet;
	private String nomProjet;
	/**La liste des objectifs contenus dans le projet*/
	private Set<Objectif> objectifs;
	
	public Projet() {
		this.objectifs = new HashSet<Objectif>();
	}

	public Projet(Long id, String codeProjet, String nomProjet, Set<Objectif> objectifs) {
		this.id = id;
		this.codeProjet = codeProjet;
		this.nomProjet = nomProjet;
		this.objectifs = objectifs;
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
	 * @return the codeProjet
	 */
	@XmlElement
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
	@XmlElement
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
			result = prime * result + codeProjet.hashCode();
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
