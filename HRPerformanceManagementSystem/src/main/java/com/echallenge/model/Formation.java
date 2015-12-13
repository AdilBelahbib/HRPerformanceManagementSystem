package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "formation")
public class Formation extends PlanAmelioration{
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
	
	
}
