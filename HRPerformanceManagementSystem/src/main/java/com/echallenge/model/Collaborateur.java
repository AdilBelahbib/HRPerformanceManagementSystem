package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

public class Collaborateur extends Utilisateur{
	private Set<FicheObjectifs> ficheObjectifs;
	private Set<FicheEvaluations> fichesEvaluations;
	private Set<PlanAmelioration> plansAmelioration;
	private ManagerRh manager;
	
	public Collaborateur() {
		super();
		this.ficheObjectifs = new HashSet<FicheObjectifs>();
		this.fichesEvaluations = new HashSet<FicheEvaluations>();
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	public Collaborateur(Long id, String email, String motDePasse, String nom, String prenom, Profile profile,
			ManagerRh manager) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.manager = manager;
		this.ficheObjectifs = new HashSet<FicheObjectifs>();
		this.fichesEvaluations = new HashSet<FicheEvaluations>();
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	public Collaborateur(Long id, String email, String motDePasse, String nom, String prenom, Profile profile,
			Set<FicheObjectifs> ficheObjectifs, Set<FicheEvaluations> fichesEvaluations, ManagerRh manager
			,Set<PlanAmelioration> plansAmelioration) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.ficheObjectifs = ficheObjectifs;
		this.fichesEvaluations = fichesEvaluations;
		this.manager = manager;
		this.plansAmelioration = plansAmelioration;
	}

	/**
	 * @return the ficheObjectifs
	 */
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
	 * @return the manager
	 */
	public ManagerRh getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(ManagerRh manager) {
		this.manager = manager;
	}

	/**
	 * @return the plansAmelioration
	 */
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
