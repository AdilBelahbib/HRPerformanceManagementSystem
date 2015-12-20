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

import com.echallenge.model.BAP;
import com.echallenge.model.Collaborateur;
import com.echallenge.model.Encadrant;
import com.echallenge.model.Feedback;
import com.echallenge.model.QualificationGlobale;
import com.echallenge.model.QualificationTheme;
import com.echallenge.util.HibernateUtil;

@Path("/feedbacks")
public class FeedbackService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Feedback getFeedbackById(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Feedback feedback = null;

		try {
			session.beginTransaction();
			feedback = (Feedback) session.get(Feedback.class, new Long(id));

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return feedback;
	}

	@SuppressWarnings("unchecked")
	@Path("/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Feedback> getFeedbackByCollaborateur(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Feedback> feedbacks = null;

		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

			if (collaborateur != null) {
				feedbacks = session.createQuery("from Feedback feed WHERE feed.collaborateur = :collaborateur")
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

		return feedbacks;
	}

	@SuppressWarnings("unchecked")
	@Path("/encadrant/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Feedback> getFeedbackByEncadrant(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Feedback> feedbacks = null;

		try {
			session.beginTransaction();
			Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));

			if (encadrant != null) {
				feedbacks = session.createQuery(" select feed from Feedback feed, Encadrant enc"
						+ " where enc = :encadrant" + " AND feed IN elements(enc.feedbacks)")
						.setEntity("encadrant", encadrant).list();
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

		return feedbacks;
	}

	@Path("/qualificationglobale/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public QualificationGlobale calculerQualifacationGlobale(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		QualificationGlobale qualificationGlobale = null;

		try {
			session.beginTransaction();
			Feedback feedback = (Feedback) session.get(Feedback.class, new Long(id));

			if (feedback != null) {
				int nombreThemesQualifies = 0;
				int totalPoidsObtenu = 0;
				double noteGlobale = 0;

				for (QualificationTheme qt : feedback.getQualificationsTheme()) {
					nombreThemesQualifies++;
					totalPoidsObtenu += qt.getQualification().ordinal();
				}

				if (nombreThemesQualifies != 0)
					noteGlobale = ((double) totalPoidsObtenu / (double) nombreThemesQualifies);

				qualificationGlobale = new QualificationGlobale();
				qualificationGlobale.setNombreThemesQualifies(nombreThemesQualifies);
				qualificationGlobale.setTotalPoidsObtenu(totalPoidsObtenu);
				qualificationGlobale.setNoteGlobale(noteGlobale);

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

		return qualificationGlobale;
	}

	@SuppressWarnings("unchecked")
	@Path("/bap/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Feedback> getFeedbackByBAP(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Feedback> feedbacks = null;

		try {
			session.beginTransaction();
			BAP bap = (BAP) session.get(BAP.class, new Long(id));

			if (bap != null) {
				feedbacks = session.createQuery("select feed" + " from Feedback feed, BAP bap" + " WHERE bap = :bap"
						+ " AND feed IN elements(bap.feedbacks)").setEntity("bap", bap).list();
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

		return feedbacks;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Feedback modifierFeedback(Feedback feedback) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(feedback);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return feedback;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Feedback ajouterFeedback(Feedback feedback) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(feedback);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return feedback;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Feedback supprimerFeedback(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Feedback feedback = null;

		try {
			session.beginTransaction();
			feedback = (Feedback) session.get(Feedback.class, new Long(id));
			session.delete(feedback);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return feedback;
	}

}
