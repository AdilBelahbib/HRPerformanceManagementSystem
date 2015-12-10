package com.echallenge.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "demandebip")
public class DemandeBIP {
	private Long id;
	private Date dateDemande;
	private Encadrant encadrant;
	private Collaborateur collaborateur;
	
	public DemandeBIP() {
	}

	public DemandeBIP(Long id, Date dateDemande, Encadrant encadrant, Collaborateur collaborateur) {
		this.id = id;
		this.dateDemande = dateDemande;
		this.encadrant = encadrant;
		this.collaborateur = collaborateur;
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
	 * @return the encadrant
	 */
	@XmlElement
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
	 * @return the collaborateur
	 */
	@XmlElement
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
	 * @return the dateDemande
	 */
	@XmlElement
	public Date getDateDemande() {
		return dateDemande;
	}

	/**
	 * @param dateDemande the dateDemande to set
	 */
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		if(this.id != null)
			result = prime * result + ((id == null) ? 0 : id.intValue());
		else
			result = prime * result + ((id == null) ? 0 : collaborateur.hashCode());
		
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
		DemandeBIP other = (DemandeBIP) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
