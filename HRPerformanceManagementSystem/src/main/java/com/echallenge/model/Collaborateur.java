package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collaborateur")
public class Collaborateur extends Utilisateur{
	
	private Set<FicheObjectifs> ficheObjectifs;
	private Set<FicheEvaluations> fichesEvaluations;
	private Set<Formation> formations;
	private Set<Action> actions;
	
	public Collaborateur() {
		super();
		this.ficheObjectifs = new HashSet<FicheObjectifs>();
		this.fichesEvaluations = new HashSet<FicheEvaluations>();
		this.formations = new HashSet<Formation>();
		this.actions = new HashSet<Action>();
	}


	/**
	 * @return the ficheObjectifs
	 */
	@XmlElementWrapper(name = "fichesobjectifs")
	@XmlElement
	public Set<FicheObjectifs> getFicheObjectifs() {
		return ficheObjectifs;
	}

	/**
	 * @param ficheObjectifs the ficheObjectifs to set
	 */
	public void setFicheObjectifs(Set<FicheObjectifs> ficheObjectifs) {
		this.ficheObjectifs = ficheObjectifs;
	}

	/**
	 * @return the fichesEvaluations
	 */
	@XmlElementWrapper(name = "fichesevaluations")
	@XmlElement
	public Set<FicheEvaluations> getFichesEvaluations() {
		return fichesEvaluations;
	}

	/**
	 * @param fichesEvaluations the fichesEvaluations to set
	 */
	public void setFichesEvaluations(Set<FicheEvaluations> fichesEvaluations) {
		this.fichesEvaluations = fichesEvaluations;
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
