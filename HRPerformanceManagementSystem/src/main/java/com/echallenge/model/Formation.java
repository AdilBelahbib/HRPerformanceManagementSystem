package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "formation")
public class Formation{
	private Long id;
	private boolean autoformation;
	/**La liste des objectifs de la formation*/
	private Set<Objectif> objectifs;

	public Formation() {
		super();
		this.objectifs = new HashSet<Objectif>();
	}

	/**
	 * @return the autoformation
	 */
	@XmlElement
	public boolean isAutoformation() {
		return autoformation;
	}

	/**
	 * @param autoformation the autoformation to set
	 */
	public void setAutoformation(boolean autoformation) {
		this.autoformation = autoformation;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
			
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
		Formation other = (Formation) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
