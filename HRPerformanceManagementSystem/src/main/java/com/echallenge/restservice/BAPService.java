package com.echallenge.restservice;

import java.util.Calendar;
import java.util.Date;
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

import com.echallenge.model.BAP;
import com.echallenge.model.Collaborateur;
import com.echallenge.model.Evaluation;
import com.echallenge.model.FicheObjectifs;
import com.echallenge.model.ManagerRh;
import com.echallenge.model.Objectif;
import com.echallenge.model.StatutBAP;
import com.echallenge.util.HibernateUtil;

@Path("/baps")
public class BAPService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BAP getBAPById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		BAP bap = (BAP) session.get(BAP.class, new Long(id));
		
		session.getTransaction().commit();
		return bap;
	}
	
	@SuppressWarnings("unchecked")
	@Path("/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<BAP> getBapByCollaborateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

		List<BAP> baps = null;

		if(collaborateur != null)
		{
			baps = session.createQuery(
					" select bap from BAP bap"
					+ " where bap.collaborateur = :collaborateur"
					+ " ORDER BY bap.dateBilan DESC")
					.setEntity("collaborateur", collaborateur)
					.list();
		}

		session.getTransaction().commit();
		return baps;
	}
	
	@Path("/courant/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BAP getBapCourantByCollaborateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

		BAP bap = null;

		if(collaborateur != null)
		{
			bap = (BAP) session.createQuery(
					"select bap from BAP bap"
					+ " where bap.collaborateur = :collaborateur"
					+ " AND (bap.statut = 'EN_COURS' OR bap.statut = 'EN_ATTENTE')"
					+ " ORDER BY bap.dateBilan DESC")
					.setEntity("collaborateur", collaborateur).setMaxResults(1)
					.uniqueResult();
		}

		session.getTransaction().commit();
		return bap;
	}
	
	@SuppressWarnings("unchecked")
	@Path("/managerrh/statut/{id}/{statut}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<BAP> getBapByManagerRhAndStatut(@PathParam("id") int id, @PathParam("statut") String statut) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		ManagerRh manager = (ManagerRh) session.get(ManagerRh.class, new Long(id));

		List<BAP> baps = null;

		if(manager != null)
		{
			baps = session.createQuery(
					"select bap from BAP bap, ManagerRh manager"
					+ " where manager = :manager"
					+ " AND bap.collaborateur IN elements(manager.collaborateurs)"
					+ " AND (bap.statut = 'EN_COURS' OR bap.statut = 'EN_ATTENTE')"
					+ " ORDER BY bap.dateBilan DESC")
					.setEntity("manager", manager)
					.list();
		}

		session.getTransaction().commit();
		return baps;
	}
	
	@Path("/valider")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BAP validerFicheEvaluations(BAP bap) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		double noteFinale = 0;
		
		FicheObjectifs ficheObjectifs = new FicheObjectifs();
		ficheObjectifs.setAutorisationAcces(false);
		ficheObjectifs.setDateFicheObjectifs(new Date());
		
		for(Evaluation evaluation : bap.getFicheEvaluations().getEvaluations())
		{
			noteFinale += (evaluation.getResultat() * ((double)evaluation.getPoids()/100));
			
			if(evaluation.getObjectif().getAvancementObjectif() < 100)
			{
				Objectif objectif = new Objectif();
				objectif.setDescriptionObjectif(evaluation.getObjectif().getDescriptionObjectif());
				objectif.setMesureObjectif(evaluation.getObjectif().getMesureObjectif());
				objectif.setAvancementObjectif(evaluation.getObjectif().getAvancementObjectif());
				
				ficheObjectifs.getObjectifs().add(objectif);
			}
		}
		
		bap.getCollaborateur().getFicheObjectifs().add(ficheObjectifs);
		session.update(bap.getCollaborateur());
		
		bap.getFicheEvaluations().setNoteFinale(noteFinale);
		
		session.update(bap.getFicheEvaluations());
		
		bap.setFicheObjectifsRediges(ficheObjectifs);
		session.update(bap);

		session.getTransaction().commit();
				
		return bap;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BAP modifierBAP(BAP bap) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(bap);

		session.getTransaction().commit();

		return bap;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BAP ajouterBAP(BAP bap) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		BAP nouveauBap = new BAP();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 1);
		
		nouveauBap.setDateBilan(cal.getTime());
		nouveauBap.setStatut(StatutBAP.EN_ATTENTE);
		nouveauBap.setCollaborateur(bap.getCollaborateur());
		nouveauBap.setFicheEvaluations(bap.getFicheEvaluations());
		nouveauBap.setFicheObjectifsTraites(bap.getFicheObjectifsRediges());
		
		session.save(nouveauBap);

		session.getTransaction().commit();

		return bap;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BAP supprimerBAP(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		BAP bap = (BAP) session.get(BAP.class, new Long(id));
		session.delete(bap);

		session.getTransaction().commit();

		return bap;
	}
}
