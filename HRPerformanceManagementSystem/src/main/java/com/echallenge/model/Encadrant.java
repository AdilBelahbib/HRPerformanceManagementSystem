package com.echallenge.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "encadrant")
public class Encadrant extends Utilisateur{
	
	public Encadrant() {
		super();
	}

	public Encadrant(Long id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom, profile);
	}

}
