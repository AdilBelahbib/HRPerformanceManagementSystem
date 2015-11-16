package com.echallenge.model;

import java.util.HashSet;

public class Encadrant extends Utilisateur{
	private Profile profile;
	/**La liste des évaluations faites par l'encadrant
	 * N.B: Nous pouvons en sortir les objectifs de l'encadrant*/
	private HashSet<Evaluation> evaluations;	

	public Encadrant(int id, String email, String motDePasse, String nom, String prenom, Profile profile,
			HashSet<Evaluation> evaluations) {
		super(id, email, motDePasse, nom, prenom);
		this.profile = profile;
		this.evaluations = evaluations;
	}

	public Encadrant(int id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom);
		this.profile = profile;
		this.evaluations = new HashSet<Evaluation>();
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @return the evaluations
	 */
	public HashSet<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setEvaluations(HashSet<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	/**
	 * Récuperer la liste des objectifs de l'encadrant
	 * @return La liste des objectifs évalués
	 */
	public HashSet<Objectif> getObjectifs() {
		HashSet<Objectif> result = new HashSet<Objectif>();
	    for (Evaluation evaluation : this.evaluations) {
	        result.add(evaluation.getObjectif());
	    }
	    return result;
	}
}
