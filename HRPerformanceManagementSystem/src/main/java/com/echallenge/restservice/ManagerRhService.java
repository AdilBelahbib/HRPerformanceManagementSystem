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
import com.echallenge.model.ManagerRh;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/managersrh")
public class ManagerRhService {
	
	@Path("/test")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh addTestManagerRh() {
		ManagerRh managerRh = new ManagerRh();
		managerRh.setEmail("tanji@mail.com");
		managerRh.setMotDePasse(Security.get_SHA_1_SecurePassword("motDePasse"));
		managerRh.setNom("TANJI");
		managerRh.setPrenom("Hamza");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(managerRh);
		session.getTransaction().commit();

		return managerRh;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ManagerRh> getAllManagerRh() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<ManagerRh> managersRh = session.createQuery("from ManagerRh").list();

		session.getTransaction().commit();
		return managersRh;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh getManagerRhById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		ManagerRh managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));
		
		session.getTransaction().commit();
		return managerRh;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh modifierManagerRh(ManagerRh managerRh) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		ManagerRh managerRhPersiste = (ManagerRh) session.get(ManagerRh.class, managerRh.getId());

		if (!managerRh.getMotDePasse().equals(managerRhPersiste.getMotDePasse()))
			managerRh.setMotDePasse(Security.get_SHA_1_SecurePassword(managerRh.getMotDePasse()));

		session.update(managerRh);

		session.getTransaction().commit();

		return managerRh;
	}

	@Path("/ajouter")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh ajouterManagerRh(ManagerRh managerRh) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		managerRh.setMotDePasse(Security.get_SHA_1_SecurePassword(managerRh.getMotDePasse()));

		session.save(managerRh);

		session.getTransaction().commit();

		return managerRh;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh supprimerManagerRh(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		ManagerRh managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));
		session.delete(managerRh);

		session.getTransaction().commit();

		return managerRh;
	}
}
