package com.echallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "action")
public class Action extends PlanAmelioration {
	private String descriptionAction;
	
	public Action() {
		super();
	}

	public Action(Long id, Collaborateur collaborateur, BIP bip, String descriptionAction) {
		super(id, collaborateur, bip);
		this.descriptionAction = descriptionAction;
	}

	/**
	 * @return the descriptionAction
	 */
	@XmlElement
	public String getDescriptionAction() {
		return descriptionAction;
	}

	/**
	 * @param descriptionAction the descriptionAction to set
	 */
	public void setDescriptionAction(String descriptionAction) {
		this.descriptionAction = descriptionAction;
	}

	
}
