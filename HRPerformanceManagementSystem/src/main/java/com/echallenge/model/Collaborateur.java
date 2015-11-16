package com.echallenge.model;

public class Collaborateur extends Utilisateur{
	private Profile profile;
	private FicheObjectifs ficheObjectifs;
	private FicheEvaluations ficheEvaluations;
	

	public Collaborateur(int id, String email, String motDePasse, String nom, String prenom, Profile profile,
			FicheObjectifs ficheObjectifs, FicheEvaluations ficheEvaluations) {
		super(id, email, motDePasse, nom, prenom);
		this.profile = profile;
		this.ficheObjectifs = ficheObjectifs;
		this.ficheEvaluations = ficheEvaluations;
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
	 * @return the ficheObjectifs
	 */
	public FicheObjectifs getFicheObjectifs() {
		return ficheObjectifs;
	}

	/**
	 * @param ficheObjectifs the ficheObjectifs to set
	 */
	public void setFicheObjectifs(FicheObjectifs ficheObjectifs) {
		this.ficheObjectifs = ficheObjectifs;
	}

	/**
	 * @return the ficheEvaluations
	 */
	public FicheEvaluations getFicheEvaluations() {
		return ficheEvaluations;
	}

	/**
	 * @param ficheEvaluations the ficheEvaluations to set
	 */
	public void setFicheEvaluations(FicheEvaluations ficheEvaluations) {
		this.ficheEvaluations = ficheEvaluations;
	}
	
	
}
