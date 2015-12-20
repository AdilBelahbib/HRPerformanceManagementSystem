package com.echallenge.restservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		Evaluation evaluation = null;

		try {
			session.beginTransaction();
			evaluation = (Evaluation) session.get(Evaluation.class, new Long(id));

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return evaluation;
	}

	@Path("ficheevaluationscourantes/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheEvaluations getFicheEvaluationsCourantesByCollaborateur(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		FicheEvaluations ficheEvaluations = null;

		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

			if (collaborateur != null) {
				ficheEvaluations = (FicheEvaluations) session
						.createQuery(" select fiche from FicheEvaluations fiche, Collaborateur col"
								+ " where col = :collaborateur" + " AND fiche IN elements(col.fichesEvaluations)"
								+ " ORDER BY fiche.dateEvaluation DESC")
						.setEntity("collaborateur", collaborateur).setMaxResults(1).uniqueResult();
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return ficheEvaluations;
	}

	@SuppressWarnings("unchecked")
	@Path("ficheevaluations/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<FicheEvaluations> getFicheEvaluationsByCollaborateur(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<FicheEvaluations> fichesEvaluations = null;

		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

			if (collaborateur != null) {
				fichesEvaluations = session
						.createQuery(" select fiche from FicheEvaluations fiche, Collaborateur col"
								+ " where col = :collaborateur" + " AND fiche IN elements(col.fichesEvaluations)"
								+ " ORDER BY fiche.dateEvaluation DESC")
						.setEntity("collaborateur", collaborateur).list();
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return fichesEvaluations;
	}

	@Path("/ficheevaluations")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheEvaluations ajouterFicheEvaluations(FicheEvaluations ficheEvaluations) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(ficheEvaluations);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return ficheEvaluations;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation ajouterEvaluation(Evaluation evaluation) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(evaluation);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return evaluation;
	}

	@Path("/ficheevaluations/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheEvaluations modifierFicheEvaluations(FicheEvaluations ficheEvaluations) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(ficheEvaluations);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return ficheEvaluations;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation modifierEvaluation(Evaluation evaluation) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(evaluation);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return evaluation;
	}

	@Path("/ficheevaluations/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheEvaluations supprimerFicheEvaluations(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		FicheEvaluations ficheEvaluations = null;

		try {
			session.beginTransaction();
			ficheEvaluations = (FicheEvaluations) session.get(FicheEvaluations.class, new Long(id));
			session.delete(ficheEvaluations);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return ficheEvaluations;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation supprimerEvaluation(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Evaluation evaluation = null;

		try {
			session.beginTransaction();
			evaluation = (Evaluation) session.get(Evaluation.class, new Long(id));
			session.delete(evaluation);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return evaluation;
	}
}
