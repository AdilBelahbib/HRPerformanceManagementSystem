package com.echallenge.model;

public class Administrateur extends Utilisateur {
	
	public Administrateur() {
		super();
	}

	public Administrateur(Long id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom, profile);
	}

	
}
