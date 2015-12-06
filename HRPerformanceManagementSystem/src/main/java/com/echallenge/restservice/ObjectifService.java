package com.echallenge.restservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.echallenge.model.Collaborateur;
import com.echallenge.model.FicheObjectifs;
import com.echallenge.model.Objectif;
import com.echallenge.util.HibernateUtil;

@Path("/objectifs")
public class ObjectifService {
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif getObjectifById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Objectif objectif = (Objectif) session.get(Objectif.class, new Long(id));
		
		session.getTransaction().commit();
		return objectif;
	}
	
	@Path("ficheobjectifscourants/bycollaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs getFicheObjectifsCourantsByCollaborateur(@PathParam("id") int id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));
		
		FicheObjectifs ficheObjectifs = null;
		
		if(collaborateur != null)
		{
			ficheObjectifs = (FicheObjectifs) session.createQuery(
					"from FicheObjectifs fiche"
					+ " WHERE fiche.collaborateur = :collaborateur"
					+ " ORDER BY fiche.dateFicheObjectifs DESC")
					.setEntity("collaborateur", collaborateur).setMaxResults(1).uniqueResult();
		}
		
		session.getTransaction().commit();
		return ficheObjectifs;
	}
	
	@SuppressWarnings("unchecked")
	@Path("ficheobjectifs/bycollaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<FicheObjectifs> getFicheObjectifsByCollaborateur(@PathParam("id") int id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));
		
		List<FicheObjectifs> fichesObjectifs = null;
		
		if(collaborateur != null)
		{
			fichesObjectifs = session.createQuery(
					"from FicheObjectifs fiche"
					+ " WHERE fiche.collaborateur = :collaborateur"
					+ " ORDER BY fiche.dateFicheObjectifs DESC")
					.setEntity("collaborateur", collaborateur).list();
		}
		
		session.getTransaction().commit();
		return fichesObjectifs;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif modifierObjectif(Objectif objectif) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(objectif);

		session.getTransaction().commit();

		return objectif;
	}
	
	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif supprimerObjectif(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Objectif objectif = (Objectif) session.get(Objectif.class, new Long(id));
		session.delete(objectif);

		session.getTransaction().commit();

		return objectif;
	}
}
