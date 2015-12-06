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
import com.echallenge.model.Formation;
import com.echallenge.model.Formation;
import com.echallenge.util.HibernateUtil;

@Path("/formations")
public class FormationService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Formation getFormationById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Formation formation = (Formation) session.get(Formation.class, new Long(id));

		session.getTransaction().commit();
		return formation;
	}

	@SuppressWarnings("unchecked")
	@Path("/bycollaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Formation> getFormationByCollaborateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

		List<Formation> formations = null;

		if(collaborateur != null)
		{
			formations = session.createQuery(
					"from Formation form WHERE form.collaborateur = :collaborateur")
			.setEntity("collaborateur", collaborateur)
			.list();
		}

		session.getTransaction().commit();
		return formations;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Formation modifierFormation(Formation formation) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(formation);

		session.getTransaction().commit();

		return formation;
	}

	@Path("/ajouter")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Formation ajouterFormation(Formation formation) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(formation);

		session.getTransaction().commit();

		return formation;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Formation supprimerFormation(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Formation formation = (Formation) session.get(Formation.class, new Long(id));
		session.delete(formation);

		session.getTransaction().commit();

		return formation;
	}

}
