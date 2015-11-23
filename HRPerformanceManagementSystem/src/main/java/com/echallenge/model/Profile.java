package com.echallenge.model;

public class Profile {
	private Long id;
	private String codeProfile;
	private String descriptionProfile;
	
	
	public Profile() {
	}
	
	public Profile(Long id, String codeProfile, String descriptionProfile) {
		this.id = id;
		this.codeProfile = codeProfile;
		this.descriptionProfile = descriptionProfile;
	}
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the codeProfile
	 */
	public String getCodeProfile() {
		return codeProfile;
	}


	/**
	 * @param codeProfile the codeProfile to set
	 */
	public void setCodeProfile(String codeProfile) {
		this.codeProfile = codeProfile;
	}


	/**
	 * @return the descriptionProfile
	 */
	public String getDescriptionProfile() {
		return descriptionProfile;
	}


	/**
	 * @param descriptionProfile the descriptionProfile to set
	 */
	public void setDescriptionProfile(String descriptionProfile) {
		this.descriptionProfile = descriptionProfile;
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
		else
			result = prime * result + codeProfile.hashCode();
		
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
		Profile other = (Profile) obj;
		if (codeProfile == null) {
			if (other.codeProfile != null)
				return false;
		} else if (!codeProfile.equals(other.codeProfile))
			return false;
		return true;
	}
	
	

}
