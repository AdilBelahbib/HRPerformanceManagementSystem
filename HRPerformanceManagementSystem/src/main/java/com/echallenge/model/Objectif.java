package com.echallenge.model;

public class Objectif {
	private int id;
	private String descriptionObjectif;
	private String mesureObjectif;
	private double avancementObjectif;
	
	public Objectif() {
		
	}

	public Objectif(int id, String descriptionObjectif, String mesureObjectif, double avancementObjectif) {
		this.id = id;
		this.descriptionObjectif = descriptionObjectif;
		this.mesureObjectif = mesureObjectif;
		this.avancementObjectif = avancementObjectif;
	}

	/**
	 * @return the idObjectif
	 */
	public int getIdObjectif() {
		return id;
	}

	/**
	 * @param idObjectif the idObjectif to set
	 */
	public void setIdObjectif(int idObjectif) {
		this.id = idObjectif;
	}

	/**
	 * @return the descriptionObjectif
	 */
	public String getDescriptionObjectif() {
		return descriptionObjectif;
	}

	/**
	 * @param descriptionObjectif the descriptionObjectif to set
	 */
	public void setDescriptionObjectif(String descriptionObjectif) {
		this.descriptionObjectif = descriptionObjectif;
	}

	/**
	 * @return the mesureObjectif
	 */
	public String getMesureObjectif() {
		return mesureObjectif;
	}

	/**
	 * @param mesureObjectif the mesureObjectif to set
	 */
	public void setMesureObjectif(String mesureObjectif) {
		this.mesureObjectif = mesureObjectif;
	}

	/**
	 * @return the avancementObjectif
	 */
	public double getAvancementObjectif() {
		return avancementObjectif;
	}

	/**
	 * @param avancementObjectif the avancementObjectif to set
	 */
	public void setAvancementObjectif(double avancementObjectif) {
		this.avancementObjectif = avancementObjectif;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Objectif other = (Objectif) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
