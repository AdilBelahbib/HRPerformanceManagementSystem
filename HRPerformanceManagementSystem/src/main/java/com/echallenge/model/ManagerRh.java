package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

public class ManagerRh extends Utilisateur {
	/**La liste des collaborateurs affect�s au Manager RH*/
	private Set<Collaborateur> collaborateurs;

	public ManagerRh() {
		super();
		this.collaborateurs = new HashSet<Collaborateur>();
	}
	
	public ManagerRh(Long id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.collaborateurs = new HashSet<Collaborateur>();
	}

	public ManagerRh(Long id, String email, String motDePasse, String nom, String prenom, Profile profile,
			Set<Collaborateur> collaborateurs) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.collaborateurs = collaborateurs;
	}

	/**
	 * @return the collaborateurs
	 */
	public Set<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(Set<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	
	
}
