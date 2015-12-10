package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bip")
public class BIP extends Bilan{
	/**Les plans d'amélioration décidés lors du BIP*/
	private Set<PlanAmelioration> plansAmelioration;

	public BIP() {
		super();
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	public BIP(Long id, Date dateBilan, FicheObjectifs ficheObjectifsTraites, Set<PlanAmelioration> plansAmelioration) {
		super(id, dateBilan, ficheObjectifsTraites);
		this.plansAmelioration = plansAmelioration;
	}
	

	public BIP(Long id, Date dateBilan,  FicheObjectifs ficheObjectifsTraites) {
		super(id, dateBilan, ficheObjectifsTraites);
		this.plansAmelioration = new HashSet<PlanAmelioration>();
	}

	/**
	 * @return the plansAmelioration
	 */
	@XmlElementWrapper(name = "plansamelioration")
	@XmlElement
	public Set<PlanAmelioration> getPlansAmelioration() {
		return plansAmelioration;
	}

	/**
	 * @param plansAmelioration the plansAmelioration to set
	 */
	public void setPlansAmelioration(Set<PlanAmelioration> plansAmelioration) {
		this.plansAmelioration = plansAmelioration;
	}
	
	
}
