package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

public class Formation extends PlanAmelioration{
	private boolean autoformation;
	/**La liste des objectifs de la formation*/
	private Set<Objectif> objectifs;

	public Formation() {
		super();
		this.objectifs = new HashSet<Objectif>();
	}

	public Formation(Long id, Collaborateur collaborateur, BIP bip, boolean autoformation, Set<Objectif> objectifs) {
		super(id, collaborateur, bip);
		this.autoformation = autoformation;
		this.objectifs = objectifs;
	}

	public Formation(Long id, Collaborateur collaborateur, BIP bip, boolean autoformation) {
		super(id, collaborateur, bip);
		this.autoformation = autoformation;
		this.objectifs = new HashSet<Objectif>();
	}

	/**
	 * @return the autoformation
	 */
	public boolean isAutoformation() {
		return autoformation;
	}

	/**
	 * @param autoformation the autoformation to set
	 */
	public void setAutoformation(boolean autoformation) {
		this.autoformation = autoformation;
	}

	/**
	 * @return the objectifs
	 */
	public Set<Objectif> getObjectifs() {
		return objectifs;
	}

	/**
	 * @param objectifs the objectifs to set
	 */
	public void setObjectifs(Set<Objectif> objectifs) {
		this.objectifs = objectifs;
	}
	
	
}
