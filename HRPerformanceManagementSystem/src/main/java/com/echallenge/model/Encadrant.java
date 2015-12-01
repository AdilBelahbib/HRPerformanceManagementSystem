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
	private Set<Evaluation> evaluations;
	private Set<Feedback> feedbacks;
	
	public Encadrant() {
		super();
		this.evaluations = new HashSet<Evaluation>();
		this.feedbacks = new HashSet<Feedback>();
	}

	public Encadrant(Long id, String email, String motDePasse, String nom, String prenom, Profile profile,
			Set<Evaluation> evaluations, Set<Feedback> feedbacks) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.evaluations = evaluations;
		this.feedbacks = feedbacks;
	}

	public Encadrant(Long id, String email, String motDePasse, String nom, String prenom, Profile profile) {
		super(id, email, motDePasse, nom, prenom, profile);
		this.evaluations = new HashSet<Evaluation>();
		this.feedbacks = new HashSet<Feedback>();
	}

	
	/**
	 * @return the evaluations
	 */
	@XmlElementWrapper(name = "evaluations")
	@XmlElement
	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	/**
	 * R�cuperer la liste des objectifs de l'encadrant
	 * @return La liste des objectifs �valu�s
	 */
	public Set<Objectif> getObjectifs() {
		HashSet<Objectif> result = new HashSet<Objectif>();
	    for (Evaluation evaluation : this.evaluations) {
	        result.add(evaluation.getObjectif());
	    }
	    return result;
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
