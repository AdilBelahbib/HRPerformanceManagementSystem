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

import com.echallenge.model.Collaborateur;
import com.echallenge.model.ManagerRh;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/collaborateurs")
public class CollaborateurService {
	
	@Path("/test")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collaborateur addTestCollaborateur() {
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setEmail("belahbib@mail.com");
		collaborateur.setMotDePasse(Security.get_SHA_1_SecurePassword("motDePasse"));
		collaborateur.setNom("BELAHBIB");
		collaborateur.setPrenom("Adil");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ManagerRh manager = (ManagerRh)session.get(ManagerRh.class, new Long(151));
		collaborateur.setManager(manager);
		session.save(collaborateur);
		session.getTransaction().commit();
		
		return collaborateur;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collaborateur getCollaborateurById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));
		
		session.getTransaction().commit();
		return collaborateur;
	}

	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collaborateur modifierCollaborateur(Collaborateur collaborateur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Collaborateur collaborateurPersiste = (Collaborateur)session.get(Collaborateur.class, collaborateur.getId());
		
		if(!collaborateur.getMotDePasse().equals(collaborateurPersiste.getMotDePasse()))
			collaborateur.setMotDePasse(Security.get_SHA_1_SecurePassword(collaborateur.getMotDePasse()));
			
		session.update(collaborateur);

		session.getTransaction().commit();

		return collaborateur;
	}

	@Path("/ajouter")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collaborateur ajouterCollaborateur(Collaborateur collaborateur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		collaborateur.setMotDePasse(Security.get_SHA_1_SecurePassword(collaborateur.getMotDePasse()));

		session.save(collaborateur);

		session.getTransaction().commit();

		return collaborateur;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collaborateur supprimerCollaborateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));
		session.delete(collaborateur);

		session.getTransaction().commit();

		return collaborateur;
	}

}
