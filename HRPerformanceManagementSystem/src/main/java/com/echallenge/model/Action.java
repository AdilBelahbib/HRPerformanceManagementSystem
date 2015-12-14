package com.echallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "action")
public class Action {
	private Long id;
	private String descriptionAction;
	
	public Action() {
		super();
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
	
	/**
	 * @return the id
	 */
	@XmlElement
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
			
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
