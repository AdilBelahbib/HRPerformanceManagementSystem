package com.echallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlSeeAlso({Action.class, Formation.class}) 
public class PlanAmelioration {
	private Long id;
	private Collaborateur collaborateur;
	private BIP bip;
	
	public PlanAmelioration() {
	}
	
	public PlanAmelioration(Long id, Collaborateur collaborateur, BIP bip) {
		this.id = id;
		this.collaborateur = collaborateur;
		this.bip = bip;
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
	 * @return the collaborateur
	 */
	@XmlTransient
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
	 * @return the bip
	 */
	@XmlTransient
	public BIP getBip() {
		return bip;
	}

	/**
	 * @param bip the bip to set
	 */
	public void setBip(BIP bip) {
		this.bip = bip;
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
			result = prime * result + collaborateur.hashCode();

			
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
		PlanAmelioration other = (PlanAmelioration) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
