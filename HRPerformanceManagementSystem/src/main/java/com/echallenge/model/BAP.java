package com.echallenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bap")
public class BAP extends Bilan{
	/**La fiche des objectifs du collaborateur*/
	private FicheObjectifs ficheObjectifsRediges;
	/**La fiche des évaluations du collaborateur*/
	private FicheEvaluations ficheEvaluations;
	/**La nouvelle fiche des évaluations initialisée du collaborateur*/
	private FicheEvaluations ficheEvaluationsInitialisee;
	/**Les feedbacks concernant l'utilisateur*/
	private Set<Feedback> feedbacks;	
	/**Les statuts du BAP sont énumérés dans l'enum. 'StatusBAP'*/
	private StatutBAP statut;
	private int nombreRejet;
	
	public BAP() {
		super();
		this.feedbacks = new HashSet<Feedback>();
	}

	/**
	 * @return the ficheObjectifsRediges
	 */
	@XmlElement
	public FicheObjectifs getFicheObjectifsRediges() {
		return ficheObjectifsRediges;
	}

	/**
	 * @param ficheObjectifsRediges the ficheObjectifsRediges to set
	 */
	public void setFicheObjectifsRediges(FicheObjectifs ficheObjectifsRediges) {
		this.ficheObjectifsRediges = ficheObjectifsRediges;
	}

	/**
	 * @return the ficheEvaluations
	 */
	@XmlElement
	public FicheEvaluations getFicheEvaluations() {
		return ficheEvaluations;
	}

	/**
	 * @param ficheEvaluations the ficheEvaluations to set
	 */
	public void setFicheEvaluations(FicheEvaluations ficheEvaluations) {
		this.ficheEvaluations = ficheEvaluations;
	}

	/**
	 * @return the ficheEvaluationsInitialisee
	 */
	public FicheEvaluations getFicheEvaluationsInitialisee() {
		return ficheEvaluationsInitialisee;
	}

	/**
	 * @param ficheEvaluationsInitialisee the ficheEvaluationsInitialisee to set
	 */
	public void setFicheEvaluationsInitialisee(FicheEvaluations ficheEvaluationsInitialisee) {
		this.ficheEvaluationsInitialisee = ficheEvaluationsInitialisee;
	}

	/**
	 * @return the statut
	 */
	@XmlElement
	public StatutBAP getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(StatutBAP statut) {
		this.statut = statut;
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

	/**
	 * @return the nombreRejet
	 */
	public int getNombreRejet() {
		return nombreRejet;
	}

	/**
	 * @param nombreRejet the nombreRejet to set
	 */
	public void setNombreRejet(int nombreRejet) {
		this.nombreRejet = nombreRejet;
	}
	
	
	
}
