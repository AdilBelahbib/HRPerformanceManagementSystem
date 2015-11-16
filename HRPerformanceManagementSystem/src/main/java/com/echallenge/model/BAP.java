package com.echallenge.model;

import java.util.Date;

public class BAP extends Bilan{
	/**La fiche des objectifs du collaborateur*/
	private FicheObjectifs ficheObjectifsRediges;
	/**La fiche des évaluations du collaborateur*/
	private FicheEvaluations ficheEvaluations;
	/**Le feedback concernant l'utilisateur*/
	private Feedback feedback;	
	/**Les statuts du BAP sont énumérées dans l'enum. 'StatusBAP'*/
	private StatutBAP statut;

	public BAP(int id, Date dateBilan, FicheObjectifs ficheObjectifsTraites, FicheObjectifs ficheObjectifsRediges,
			FicheEvaluations ficheEvaluations, Feedback feedback, StatutBAP statut) {
		super(id, dateBilan, ficheObjectifsTraites);
		this.ficheObjectifsRediges = ficheObjectifsRediges;
		this.ficheEvaluations = ficheEvaluations;
		this.feedback = feedback;
		this.statut = statut;
	}

	/**
	 * @return the ficheObjectifs
	 */
	public FicheObjectifs getFicheObjectifs() {
		return ficheObjectifsRediges;
	}

	/**
	 * @param ficheObjectifs the ficheObjectifs to set
	 */
	public void setFicheObjectifs(FicheObjectifs ficheObjectifs) {
		this.ficheObjectifsRediges = ficheObjectifs;
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
	 * @return the feedback
	 */
	public Feedback getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
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
	
}
