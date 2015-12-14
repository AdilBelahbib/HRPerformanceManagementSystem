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

import com.echallenge.model.Administrateur;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/administrateurs")
public class AdministrateurService {
	
	@Path("/test")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Administrateur addTestAdministrateur() {
		Administrateur administrateur = new Administrateur();
		administrateur.setEmail("hamza@mail.com");
		administrateur.setMotDePasse(Security.get_SHA_1_SecurePassword("motDePasse"));
		administrateur.setNom("TANJI");
		administrateur.setPrenom("Hamza");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(administrateur);
		session.getTransaction().commit();
		
		return administrateur;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Administrateur getAdministrateurById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Administrateur administrateur = (Administrateur) session.get(Administrateur.class, new Long(id));
		
		session.getTransaction().commit();
		return administrateur;
	}

	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Administrateur modifierAdministrateur(Administrateur administrateur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String mdp = (String) session.createQuery("select admin.motDePasse from Administrateur admin WHERE admin = :admin")
				.setEntity("admin", administrateur).uniqueResult();
		
		if(!administrateur.getMotDePasse().equals(mdp))
			administrateur.setMotDePasse(Security.get_SHA_1_SecurePassword(administrateur.getMotDePasse()));
			
		session.update(administrateur);

		session.getTransaction().commit();

		return administrateur;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Administrateur ajouterAdministrateur(Administrateur administrateur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		administrateur.setMotDePasse(Security.get_SHA_1_SecurePassword(administrateur.getMotDePasse()));

		session.save(administrateur);

		session.getTransaction().commit();

		return administrateur;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Administrateur supprimerAdministrateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Administrateur administrateur = (Administrateur) session.get(Administrateur.class, new Long(id));
		session.delete(administrateur);

		session.getTransaction().commit();

		return administrateur;
	}

}
