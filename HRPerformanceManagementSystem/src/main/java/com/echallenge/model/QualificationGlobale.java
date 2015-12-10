package com.echallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "qualificationglobale")
public class QualificationGlobale {
	private int nombreThemesQualifies;
	private int totalPoidsObtenu;
	private double noteGlobale;
	
	public QualificationGlobale() {
	}

	/**
	 * @return the nombreThemesQualifies
	 */
	@XmlElement
	public int getNombreThemesQualifies() {
		return nombreThemesQualifies;
	}

	/**
	 * @param nombreThemesQualifies the nombreThemesQualifies to set
	 */
	public void setNombreThemesQualifies(int nombreThemesQualifies) {
		this.nombreThemesQualifies = nombreThemesQualifies;
	}

	/**
	 * @return the totalPoidsObtenu
	 */
	@XmlElement
	public int getTotalPoidsObtenu() {
		return totalPoidsObtenu;
	}

	/**
	 * @param totalPoidsObtenu the totalPoidsObtenu to set
	 */
	public void setTotalPoidsObtenu(int totalPoidsObtenu) {
		this.totalPoidsObtenu = totalPoidsObtenu;
	}

	/**
	 * @return the noteGlobale
	 */
	@XmlElement
	public double getNoteGlobale() {
		return noteGlobale;
	}

	/**
	 * @param noteGlobale the noteGlobale to set
	 */
	public void setNoteGlobale(double noteGlobale) {
		this.noteGlobale = noteGlobale;
	}
	
}
