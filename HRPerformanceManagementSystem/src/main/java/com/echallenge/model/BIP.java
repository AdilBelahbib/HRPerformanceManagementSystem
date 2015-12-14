package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bip")
public class BIP extends Bilan{
	/**Les plans d'amélioration décidés lors du BIP*/
	private Set<Formation> formations;
	private Set<Action> actions;

	public BIP() {
		super();
		this.formations = new HashSet<Formation>();
		this.actions = new HashSet<Action>();
	}	

	@XmlElementWrapper(name = "formations")
	@XmlElement
	public Set<Formation> getFormations() {
		return formations;
	}


	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	@XmlElementWrapper(name = "actions")
	@XmlElement
	public Set<Action> getActions() {
		return actions;
	}


	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	
	
	
	
}
