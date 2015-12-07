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
import com.echallenge.model.ManagerRh;
import com.echallenge.model.StatutBAP;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/collaborateurs")
public class CollaborateurService {

	@Path("/test")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collaborateur addTestCollaborateur() {
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setEmail("belahbib@mail.com");
		collaborateur.setMotDePasse(Security.get_SHA_1_SecurePassword("motDePasse"));
		collaborateur.setNom("BELAHBIB");
		collaborateur.setPrenom("Adil");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ManagerRh manager = (ManagerRh) session.get(ManagerRh.class, new Long(151));
		collaborateur.setManagerRh(manager);
		session.save(collaborateur);
		session.getTransaction().commit();

		return collaborateur;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getAllCollaborateurs() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Collaborateur> collaborateurs = session.createQuery("from Collaborateur").list();

		session.getTransaction().commit();
		return collaborateurs;
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

	@Path("/byencadrant/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getCollaborateurByEncadrant(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));

		List<Collaborateur> collaborateurs = session
				.createQuery("select distinct col from Collaborateur as col"
						+ " join col.fichesEvaluations as fiche"
						+ " join fiche.evaluations as eval"
						+ " where eval.encadrant = :encadrant")
				.setEntity("encadrant", encadrant).list();

		session.getTransaction().commit();
		return collaborateurs;
	}

	@Path("/bymanagerrh/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getCollaborateurByManagerRh(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ManagerRh managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));
		List<Collaborateur> collaborateurs = null;

		if (managerRh != null) {
			collaborateurs = session.createQuery("from Collaborateur as col" + " where col.managerRh = :managerRh")
					.setEntity("managerRh", managerRh).list();
		}

		session.getTransaction().commit();
		return collaborateurs;
	}

	@Path("/bybapstatut/{statut}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getCollaborateurByBapStatut(@PathParam("statut") StatutBAP statut) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Collaborateur> collaborateurs = null;

		collaborateurs = session.createQuery(
				"select distinct col"
				+ " from Collaborateur as col, BAP as bap"
				+ " where bap.ficheObjectifsTraites IN elements(col.ficheObjectifs)"
				+ " AND bap.statut = :statut")
				.setString("statut", statut.name())
				.list();

		session.getTransaction().commit();
		return collaborateurs;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collaborateur modifierCollaborateur(Collaborateur collaborateur) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateurPersiste = (Collaborateur) session.get(Collaborateur.class, collaborateur.getId());

		if (!collaborateur.getMotDePasse().equals(collaborateurPersiste.getMotDePasse()))
			collaborateur.setMotDePasse(Security.get_SHA_1_SecurePassword(collaborateur.getMotDePasse()));

		session.update(collaborateur);

		session.getTransaction().commit();

		return collaborateur;
	}

	//@Path("/ajouter")
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
