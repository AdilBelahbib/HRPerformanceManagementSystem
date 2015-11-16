package com.echallenge.model;

import java.util.HashSet;

public class Formation extends PlanAmelioration{
	private boolean autoformation;
	/**La liste des objectifs de la formation*/
	private HashSet<Objectif> objectifs;

	public Formation() {
		super();
		this.objectifs = new HashSet<Objectif>();
	}

	public Formation(int id, boolean autoformation, HashSet<Objectif> objectifs) {
		super(id);
		this.autoformation = autoformation;
		this.objectifs = objectifs;
	}

	public Formation(int id, boolean autoformation) {
		super(id);
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
	public HashSet<Objectif> getObjectifs() {
		return objectifs;
	}

	/**
	 * @param objectifs the objectifs to set
	 */
	public void setObjectifs(HashSet<Objectif> objectifs) {
		this.objectifs = objectifs;
	}
	
	
}
