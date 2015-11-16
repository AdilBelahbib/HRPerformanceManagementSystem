package com.echallenge.model;

import java.util.HashSet;

public class ManagerRh extends Utilisateur {
	private Profile profile;
	/**La liste des collaborateurs affectés au Manager RH*/
	private HashSet<Collaborateur> collaborateurs;

	public ManagerRh() {
		super();
		this.collaborateurs = new HashSet<Collaborateur>();
	}
	
	public ManagerRh(int id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom);
		this.profile = profile;
		this.collaborateurs = new HashSet<Collaborateur>();
	}

	public ManagerRh(int id, String email, String motDePasse, String nom, String prenom, Profile profile,
			HashSet<Collaborateur> collaborateurs) {
		super(id, email, motDePasse, nom, prenom);
		this.profile = profile;
		this.collaborateurs = collaborateurs;
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
	 * @return the collaborateurs
	 */
	public HashSet<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(HashSet<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
	
}
