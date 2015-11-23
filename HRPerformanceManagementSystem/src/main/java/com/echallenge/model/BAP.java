package com.echallenge.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BAP extends Bilan{
	/**La fiche des objectifs du collaborateur*/
	private FicheObjectifs ficheObjectifsRediges;
	/**La fiche des évaluations du collaborateur*/
	private FicheEvaluations ficheEvaluations;
	/**Les feedbacks concernant l'utilisateur*/
	private Set<Feedback> feedbacks;	
	/**Les statuts du BAP sont énumérés dans l'enum. 'StatusBAP'*/
	private StatutBAP statut;
	
	public BAP() {
		super();
		this.feedbacks = new HashSet<Feedback>();
	}

	public BAP(Long id, Date dateBilan, FicheObjectifs ficheObjectifsTraites, FicheObjectifs ficheObjectifsRediges,
			FicheEvaluations ficheEvaluations, Set<Feedback> feedbacks, StatutBAP statut) {
		super(id, dateBilan, ficheObjectifsTraites);
		this.ficheObjectifsRediges = ficheObjectifsRediges;
		this.ficheEvaluations = ficheEvaluations;
		this.feedbacks = feedbacks;
		this.statut = statut;
	}

	/**
	 * @return the ficheObjectifsRediges
	 */
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
	 * @return the statut
	 */
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
