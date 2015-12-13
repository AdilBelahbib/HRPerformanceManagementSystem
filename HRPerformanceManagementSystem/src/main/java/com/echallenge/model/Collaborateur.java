package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collaborateur")
public class Collaborateur extends Utilisateur{
	
	private Set<FicheObjectifs> ficheObjectifs;
	private Set<FicheEvaluations> fichesEvaluations;
	private Set<PlanAmelioration> plansAmelioration;
	
	public Collaborateur() {
		super();
		this.ficheObjectifs = new HashSet<FicheObjectifs>();
		this.fichesEvaluations = new HashSet<FicheEvaluations>();
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	public Collaborateur(Long id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.ficheObjectifs = new HashSet<FicheObjectifs>();
		this.fichesEvaluations = new HashSet<FicheEvaluations>();
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	public Collaborateur(Long id, String email, String motDePasse, String nom, String prenom, Profile profile,
			Set<FicheObjectifs> ficheObjectifs, Set<FicheEvaluations> fichesEvaluations, Set<PlanAmelioration> plansAmelioration) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.ficheObjectifs = ficheObjectifs;
		this.fichesEvaluations = fichesEvaluations;
		this.plansAmelioration = plansAmelioration;
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

	/**
	 * @return the plansAmelioration
	 */
	@XmlElementWrapper(name = "plansamelioration")
	@XmlElementRef
	public Set<PlanAmelioration> getPlansAmelioration() {
		return plansAmelioration;
	}

	/**
	 * @param plansAmelioration the plansAmelioration to set
	 */
	public void setPlansAmelioration(Set<PlanAmelioration> plansAmelioration) {
		this.plansAmelioration = plansAmelioration;
	}
	
	
	
}
