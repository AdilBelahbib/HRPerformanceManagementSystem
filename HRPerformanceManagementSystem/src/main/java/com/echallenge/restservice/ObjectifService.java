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
import com.echallenge.model.Evaluation;
import com.echallenge.model.FicheObjectifs;
import com.echallenge.model.Formation;
import com.echallenge.model.Objectif;
import com.echallenge.model.Projet;
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
	
	@Path("ficheobjectifscourants/collaborateur/{id}")
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
					" select fiche from FicheObjectifs fiche, Collaborateur col"
					+ " where col = :collaborateur"
					+ " AND fiche IN elements(col.ficheObjectifs)"
					+ " ORDER BY fiche.fichesEvaluations DESC")
					.setEntity("collaborateur", collaborateur).setMaxResults(1).uniqueResult();
		}
		
		session.getTransaction().commit();
		return ficheObjectifs;
	}
	
	@SuppressWarnings("unchecked")
	@Path("ficheobjectifs/collaborateur/{id}")
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
					" select fiche from FicheObjectifs fiche, Collaborateur col"
					+ " where col = :collaborateur"
					+ " AND fiche IN elements(col.ficheObjectifs)"
					+ " ORDER BY fiche.fichesEvaluations DESC")
					.setEntity("collaborateur", collaborateur).list();
		}
		
		session.getTransaction().commit();
		return fichesObjectifs;
	}
	
	@Path("/link/ficheobjectif/{idobjectif}/{idficheobjectif}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs linkObjectifToFicheObjectifs(@PathParam("idobjectif") int idObjectif,@PathParam("idficheobjectif") int idFicheObjectif)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Objectif objectif = (Objectif) session.get(Objectif.class, new Long(idObjectif));
		FicheObjectifs ficheObjectifs = (FicheObjectifs) session.get(FicheObjectifs.class, new Long(idFicheObjectif));
				
		if((objectif != null) && (ficheObjectifs != null))
		{
			ficheObjectifs.getObjectifs().add(objectif);
			session.update(ficheObjectifs);
		}
		
		session.getTransaction().commit();
		return ficheObjectifs;
	}
	
	@Path("/link/encadrant/{idObjectif}/{idencadrant}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Evaluation linkObjectifToEncadrant(@PathParam("idObjectif") int idObjectif,@PathParam("idencadrant") int idEncadrant)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Objectif objectif = (Objectif) session.get(Objectif.class, new Long(idObjectif));
		Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(idEncadrant));
		Evaluation evaluation = null;
		
		if((objectif != null) && (encadrant != null))
		{
			evaluation = new Evaluation();
			evaluation.setObjectif(objectif);
			evaluation.setPoids(1);
			evaluation.setResultat(0.0);
			
			encadrant.getEvaluations().add(evaluation);
			session.update(encadrant);
		}
		
		session.getTransaction().commit();
		return evaluation;
	}
	
	@Path("/link/formation/{idobjectif}/{idformation}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Formation linkObjectifToFormation(@PathParam("idobjectif") int idObjectif,@PathParam("idformation") int idFormation)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Objectif objectif = (Objectif) session.get(Objectif.class, new Long(idObjectif));
		Formation formation = (Formation) session.get(Formation.class, new Long(idFormation));
				
		if((objectif != null) && (formation != null))
		{
			formation.getObjectifs().add(objectif);
			session.update(formation);
		}
		
		session.getTransaction().commit();
		return formation;
	}
	
	@Path("/link/projet/{idobjectif}/{idprojet}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Projet linkObjectifToProjet(@PathParam("idobjectif") int idObjectif,@PathParam("idprojet") int idProjet)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Objectif objectif = (Objectif) session.get(Objectif.class, new Long(idObjectif));
		Projet projet = (Projet) session.get(Projet.class, new Long(idProjet));
				
		if((objectif != null) && (projet != null))
		{
			projet.getObjectifs().add(objectif);
			session.update(projet);
		}
		
		session.getTransaction().commit();
		return projet;
	}
	
	@Path("/ficheobjectifs")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs ajouterFicheObjectifs(FicheObjectifs ficheObjectifs) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(ficheObjectifs);

		session.getTransaction().commit();

		return ficheObjectifs;
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Objectif ajouterObjectif(Objectif objectif) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(objectif);

		session.getTransaction().commit();

		return objectif;
	}
	
	@Path("/ficheobjectifs/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs modifierFicheObjectifs(FicheObjectifs ficheObjectifs) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(ficheObjectifs);

		session.getTransaction().commit();

		return ficheObjectifs;
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
	
	@Path("/ficheobjectifs/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FicheObjectifs supprimerFicheObjectifs(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		FicheObjectifs ficheObjectifs = (FicheObjectifs) session.get(FicheObjectifs.class, new Long(id));
		session.delete(ficheObjectifs);

		session.getTransaction().commit();

		return ficheObjectifs;
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