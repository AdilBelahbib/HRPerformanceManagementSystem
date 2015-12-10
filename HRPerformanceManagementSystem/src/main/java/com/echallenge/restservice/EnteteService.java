package com.echallenge.restservice;

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

import com.echallenge.model.Entete;
import com.echallenge.model.Feedback;
import com.echallenge.util.HibernateUtil;

@Path("/entetes")
public class EnteteService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Entete getEnteteById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Entete entete = (Entete) session.get(Entete.class, new Long(id));

		session.getTransaction().commit();
		return entete;
	}

	@Path("/feedback/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Entete getEnteteByFeedback(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Feedback feedback = (Feedback) session.get(Feedback.class, new Long(id));

		Entete entete = null;

		if(feedback != null)
		{
			entete = (Entete) session.createQuery(
					"select ent"
					+ " from Entete ent, Feedback feed"
					+ " WHERE feed = :feedback"
					+ " AND feed.entete = ent")
			.setEntity("feedback", feedback)
			.uniqueResult();
		}

		session.getTransaction().commit();
		return entete;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Entete modifierEntete(Entete entete) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(entete);

		session.getTransaction().commit();

		return entete;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Entete ajouterEntete(Entete entete) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(entete);

		session.getTransaction().commit();

		return entete;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Entete supprimerEntete(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Entete entete = (Entete) session.get(Entete.class, new Long(id));
		session.delete(entete);

		session.getTransaction().commit();

		return entete;
	}

}
