package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "encadrant")
public class Encadrant extends Utilisateur{
	/**La liste des évaluations faites par l'encadrant
	 * N.B: Nous pouvons en sortir les objectifs de l'encadrant*/
	private Set<Feedback> feedbacks;
	
	public Encadrant() {
		super();
		this.feedbacks = new HashSet<Feedback>();
	}

	public Encadrant(Long id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.feedbacks = new HashSet<Feedback>();
	}


	/**
	 * @return the feedbacks
	 */
	@XmlElementWrapper(name = "feedbacks")
	@XmlElement
	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	/**
	 * @param feedbacks the feedbacks to set
	 */
	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

}
