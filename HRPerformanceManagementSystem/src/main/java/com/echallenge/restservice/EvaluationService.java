package com.echallenge.restservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.echallenge.model.Collaborateur;
import com.echallenge.model.Evaluation;
import com.echallenge.model.FicheEvaluations;
import com.echallenge.util.HibernateUtil;

@Path("/evaluations")
public class EvaluationService {
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation getEvaluationById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Evaluation evaluation = (Evaluation) session.get(Evaluation.class, new Long(id));

		session.getTransaction().commit();
		return evaluation;
	}
	
	@Path("ficheevaluationscourantes/bycollaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheEvaluations getFicheEvaluationsCourantesByCollaborateur(@PathParam("id") int id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));
		
		FicheEvaluations ficheEvaluations = null;
		
		if(collaborateur != null)
		{
			ficheEvaluations = (FicheEvaluations) session.createQuery(
					"from FicheEvaluations fiche"
					+ " WHERE fiche.collaborateur = :collaborateur"
					+ " ORDER BY fiche.dateEvaluation DESC")
					.setEntity("collaborateur", collaborateur).setMaxResults(1).uniqueResult();
		}
		
		session.getTransaction().commit();
		return ficheEvaluations;
	}
	
	@SuppressWarnings("unchecked")
	@Path("ficheevaluations/bycollaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<FicheEvaluations> getFicheEvaluationsByCollaborateur(@PathParam("id") int id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));
		
		List<FicheEvaluations> fichesObjectifs = null;
		
		if(collaborateur != null)
		{
			fichesObjectifs = session.createQuery(
					"from FicheEvaluations fiche"
					+ " WHERE fiche.collaborateur = :collaborateur"
					+ " ORDER BY fiche.dateEvaluation DESC")
					.setEntity("collaborateur", collaborateur).list();
		}
		
		session.getTransaction().commit();
		return fichesObjectifs;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation modifierEvaluation(Evaluation evaluation) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(evaluation);

		session.getTransaction().commit();

		return evaluation;
	}
	
	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation supprimerEvaluation(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Evaluation evaluation = (Evaluation) session.get(Evaluation.class, new Long(id));
		session.delete(evaluation);

		session.getTransaction().commit();

		return evaluation;
	}
}
