package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;

public class BIP extends Bilan{
	/**Les plans d'amélioration décidés lors du BIP*/
	private HashSet<PlanAmelioration> plansAmelioration;

	public BIP() {
		super();
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	public BIP(int id, Date dateBilan, FicheObjectifs ficheObjectifsTraites, HashSet<PlanAmelioration> plansAmelioration) {
		super(id, dateBilan, ficheObjectifsTraites);
		this.plansAmelioration = plansAmelioration;
	}
	

	public BIP(int id, Date dateBilan,  FicheObjectifs ficheObjectifsTraites) {
		super(id, dateBilan, ficheObjectifsTraites);
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	/**
	 * @return the plansAmelioration
	 */
	public HashSet<PlanAmelioration> getPlansAmelioration() {
		return plansAmelioration;
	}

	/**
	 * @param plansAmelioration the plansAmelioration to set
	 */
	public void setPlansAmelioration(HashSet<PlanAmelioration> plansAmelioration) {
		this.plansAmelioration = plansAmelioration;
	}
	
	
}
