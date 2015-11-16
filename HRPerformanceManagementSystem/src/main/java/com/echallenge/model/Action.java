package com.echallenge.model;

public class Action extends PlanAmelioration {
	private String descriptionAction;
	
	public Action() {
		super();
	}

	public Action(int id, String descriptionAction) {
		super(id);
		this.descriptionAction = descriptionAction;
	}

	/**
	 * @return the descriptionAction
	 */
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
