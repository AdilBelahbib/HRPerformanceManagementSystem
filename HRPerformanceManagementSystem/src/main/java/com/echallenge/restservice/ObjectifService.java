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
import com.echallenge.model.Encadrant;
import com.echallenge.model.Evaluation;
import com.echallenge.model.FicheEvaluations;
import com.echallenge.model.FicheObjectifs;
import com.echallenge.model.Objectif;
import com.echallenge.util.HibernateUtil;

@Path("/objectifs")
public class ObjectifService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif getObjectifById(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Objectif objectif = null;

		try {
			session.beginTransaction();
			objectif = (Objectif) session.get(Objectif.class, new Long(id));

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return objectif;
	}

	@SuppressWarnings("unchecked")
	@Path("ficheobjectifs/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<FicheObjectifs> getFicheObjectifsByCollaborateur(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<FicheObjectifs> fichesObjectifs = null;

		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

			if (collaborateur != null) {
				fichesObjectifs = session
						.createQuery(" select fiche from FicheObjectifs fiche, Collaborateur col"
								+ " where col = :collaborateur" + " AND fiche IN elements(col.ficheObjectifs)"
								+ " ORDER BY fiche.dateFicheObjectifs DESC")
						.setEntity("collaborateur", collaborateur).list();
			}

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return fichesObjectifs;
	}

	@Path("ficheobjectifs/encours/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs getFicheObjectifsEnAttente(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		FicheObjectifs ficheObjectifs = null;

		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

			if (collaborateur != null) {
				ficheObjectifs = (FicheObjectifs) session
						.createQuery(" select bap.ficheObjectifsTraites from BAP bap, Collaborateur col"
								+ " where bap.collaborateur = col AND col = :collaborateur"
								+ " AND (bap.statut = 'EN_COURS' OR bap.statut = 'EN_ATTENTE')")
						.setEntity("collaborateur", collaborateur).setMaxResults(1).uniqueResult();
			}

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return ficheObjectifs;
	}

	@Path("/link/encadrant/{idObjectif}/{idencadrant}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation linkObjectifToEncadrant(@PathParam("idObjectif") int idObjectif,
			@PathParam("idencadrant") int idEncadrant) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Evaluation evaluation = null;

		try {
			session.beginTransaction();
			Objectif objectif = (Objectif) session.get(Objectif.class, new Long(idObjectif));
			Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(idEncadrant));

			if ((objectif != null) && (encadrant != null)) {
				evaluation = new Evaluation();
				evaluation.setObjectif(objectif);
				evaluation.setPoids(1);
				evaluation.setResultat(0.0);
				evaluation.setEncadrant(encadrant);

				session.save(evaluation);

				FicheEvaluations ficheEvaluations = (FicheEvaluations) session
						.createQuery("SELECT bap.ficheEvaluationsInitialisee from BAP bap"
								+ " JOIN bap.ficheObjectifsRediges fiche"
								+ " WHERE :objectif IN elements(fiche.objectifs)")
						.setEntity("objectif", objectif).setMaxResults(1).uniqueResult();

				ficheEvaluations.getEvaluations().add(evaluation);
				session.update(ficheEvaluations);
			}

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return evaluation;
	}

	@Path("/ficheobjectifs")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs ajouterFicheObjectifs(FicheObjectifs ficheObjectifs) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(ficheObjectifs);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return ficheObjectifs;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif ajouterObjectif(Objectif objectif) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(objectif);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return objectif;
	}

	@Path("/ficheobjectifs/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs modifierFicheObjectifs(FicheObjectifs ficheObjectifs) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(ficheObjectifs);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return ficheObjectifs;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif modifierObjectif(Objectif objectif) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(objectif);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return objectif;
	}

	@Path("/ficheobjectifs/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs supprimerFicheObjectifs(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		FicheObjectifs ficheObjectifs = null;

		try {
			session.beginTransaction();
			ficheObjectifs = (FicheObjectifs) session.get(FicheObjectifs.class, new Long(id));
			session.delete(ficheObjectifs);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return ficheObjectifs;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif supprimerObjectif(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Objectif objectif = null;

		try {
			session.beginTransaction();
			objectif = (Objectif) session.get(Objectif.class, new Long(id));
			session.delete(objectif);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return objectif;
	}
}
