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

import com.echallenge.model.Encadrant;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/encadrants")
public class EncadrantService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Encadrant> getAllEncadrants() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Encadrant> encadrants = session.createQuery("from Encadrant").list();

		session.getTransaction().commit();
		return encadrants;
	}
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Encadrant getEncadrantById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));
		
		session.getTransaction().commit();
		return encadrant;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Encadrant modifierEncadrant(Encadrant encadrant) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Encadrant encadrantPersiste = (Encadrant) session.get(Encadrant.class, encadrant.getId());

		if (!encadrant.getMotDePasse().equals(encadrantPersiste.getMotDePasse()))
			encadrant.setMotDePasse(Security.get_SHA_1_SecurePassword(encadrant.getMotDePasse()));

		session.update(encadrant);

		session.getTransaction().commit();

		return encadrant;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Encadrant ajouterEncadrant(Encadrant encadrant) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		encadrant.setMotDePasse(Security.get_SHA_1_SecurePassword(encadrant.getMotDePasse()));

		session.save(encadrant);

		session.getTransaction().commit();

		return encadrant;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Encadrant supprimerEncadrant(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));
		session.delete(encadrant);

		session.getTransaction().commit();

		return encadrant;
	}
}
