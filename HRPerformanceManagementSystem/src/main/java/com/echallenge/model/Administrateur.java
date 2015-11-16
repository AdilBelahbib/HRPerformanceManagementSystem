package com.echallenge.model;

public class Administrateur extends Utilisateur {
	private Profile profile;
	

	public Administrateur(int id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom);
		this.profile = profile;
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
	
	
}
