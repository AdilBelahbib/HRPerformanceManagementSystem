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

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getAllCollaborateurs() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
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

	@Path("/encadrant/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getCollaborateurByEncadrant(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));

		@SuppressWarnings("unchecked")
		List<Collaborateur> collaborateurs = session
				.createQuery("select distinct col from Collaborateur as col"
						+ " join col.fichesEvaluations as fiche"
						+ " join fiche.evaluations as eval"
						+ " where eval.encadrant = :encadrant")
				.setEntity("encadrant", encadrant).list();

		session.getTransaction().commit();
		return collaborateurs;
	}

	@SuppressWarnings("unchecked")
	@Path("/managerrh/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getCollaborateurByManagerRh(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ManagerRh managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));
		List<Collaborateur> collaborateurs = null;

		if (managerRh != null) {
			collaborateurs = session.createQuery(
					" select col from Collaborateur col, ManagerRh man"
					+ " where man = :managerrh"
					+ " AND col IN elements(man.collaborateurs)")
					.setEntity("managerRh", managerRh).list();
		}

		session.getTransaction().commit();
		return collaborateurs;
	}

	@SuppressWarnings("unchecked")
	@Path("/bapstatut/{idencadrant}/{statut}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Collaborateur> getCollaborateurByBapStatut(@PathParam("idencadrant") int id, @PathParam("statut") StatutBAP statut) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		ManagerRh managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));
		List<Collaborateur> collaborateurs = null;

		if (managerRh != null) {

		collaborateurs = session.createQuery(
				"select distinct col"
				+ " from Collaborateur as col, BAP as bap"
				+ " where bap.ficheObjectifsTraites IN elements(col.ficheObjectifs)"
				+ " AND bap.statut = :statut"
				+ " AND col.managerRh = :managerRh")
				.setString("statut", statut.name())
				.setEntity("managerRh", managerRh)
				.list();
		}

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
		
		String mdp = (String) session.createQuery("select col.motDePasse from Collaborateur col WHERE col = :collaborateur")
				.setEntity("collaborateur", collaborateur).uniqueResult();
		
		if (!collaborateur.getMotDePasse().equals(mdp))
			collaborateur.setMotDePasse(Security.get_SHA_1_SecurePassword(collaborateur.getMotDePasse()));

		session.update(collaborateur);

		session.getTransaction().commit();

		return collaborateur;
	}

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
