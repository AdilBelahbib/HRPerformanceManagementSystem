package com.echallenge.model;

public class QualificationTheme {
	private int id;
	/**Les thèmes sont énumérés dans l'enum. 'Theme'*/
	private Theme theme;
	/**Les qualifications sont énumérées dans l'enum. 'Qualification'*/
	private Qualification qualification;
	/**La remarque est optionnelle*/
	private String remarque;
	
	public QualificationTheme() {
		this.remarque = "";
	}

	public QualificationTheme(int id, Theme theme, Qualification qualification, String remarque) {
		this.id = id;
		this.theme = theme;
		this.qualification = qualification;
		this.remarque = remarque;
	}

	public QualificationTheme(int id, Theme theme, Qualification qualification) {
		this.id = id;
		this.theme = theme;
		this.qualification = qualification;
		this.remarque = "";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the theme
	 */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	/**
	 * @return the qualification
	 */
	public Qualification getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return the remarque
	 */
	public String getRemarque() {
		return remarque;
	}

	/**
	 * @param remarque the remarque to set
	 */
	public void setRemarque(String remarque) {
		this.remarque = remarque;
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
		QualificationTheme other = (QualificationTheme) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
