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

import com.echallenge.model.Feedback;
import com.echallenge.model.QualificationTheme;
import com.echallenge.util.HibernateUtil;

@Path("/qualificationthemes")
public class QualificationThemeService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public QualificationTheme getQualificationThemeById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		QualificationTheme qualificationTheme = (QualificationTheme) session.get(QualificationTheme.class, new Long(id));

		session.getTransaction().commit();
		return qualificationTheme;
	}

	@SuppressWarnings("unchecked")
	@Path("/feedback/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<QualificationTheme> getQualificationThemeByFeedback(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Feedback feedback = (Feedback) session.get(Feedback.class, new Long(id));

		List<QualificationTheme> qualificationThemes = null;

		if(feedback != null)
		{
			qualificationThemes = session.createQuery(
					"select qt"
					+ " from QualificationTheme qt, Feedback feed"
					+ " WHERE feed = :feedback"
					+ " AND qt IN elements(feed.qualificationsTheme)")
			.setEntity("feedback", feedback)
			.list();
		}

		session.getTransaction().commit();
		return qualificationThemes;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public QualificationTheme modifierQualificationTheme(QualificationTheme qualificationTheme) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(qualificationTheme);

		session.getTransaction().commit();

		return qualificationTheme;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public QualificationTheme ajouterQualificationTheme(QualificationTheme qualificationTheme) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(qualificationTheme);

		session.getTransaction().commit();

		return qualificationTheme;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public QualificationTheme supprimerQualificationTheme(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		QualificationTheme qualificationTheme = (QualificationTheme) session.get(QualificationTheme.class, new Long(id));
		session.delete(qualificationTheme);

		session.getTransaction().commit();

		return qualificationTheme;
	}

}
