package com.echallenge.restservice;

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

import com.echallenge.model.BIP;
import com.echallenge.model.Collaborateur;
import com.echallenge.model.Formation;
import com.echallenge.util.HibernateUtil;

@Path("/bips")
public class BIPService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BIP getBIPById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		BIP bip = (BIP) session.get(BIP.class, new Long(id));
		
		session.getTransaction().commit();
		return bip;
	}
	
	@SuppressWarnings("unchecked")
	@Path("/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<BIP> getBapByCollaborateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

		List<BIP> bips = null;

		if(collaborateur != null)
		{
			bips = session.createQuery(
					" select bip from BIP bip , Collaborateur col"
					+ " where col = :collaborateur"
					+ " AND bip.ficheObjectifsTraites IN elements(col.ficheObjectifs)"
					+ " ORDER BY bip.dateBilan DESC")
					.setEntity("collaborateur", collaborateur)
					.list();
		}

		session.getTransaction().commit();
		return bips;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BIP modifierBIP(BIP bip) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(bip);

		session.getTransaction().commit();

		return bip;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BIP ajouterBIP(BIP bip) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		bip.setDateBilan(new Date());
		
		session.save(bip);

		session.getTransaction().commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(bip.getFicheObjectifsTraites());
		session.getTransaction().commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for(Formation formation: bip.getFormations())
			session.update(formation);
		session.getTransaction().commit();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(bip.getCollaborateur());
		session.getTransaction().commit();

		return bip;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BIP supprimerBIP(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		BIP bip = (BIP) session.get(BIP.class, new Long(id));
		session.delete(bip);

		session.getTransaction().commit();

		return bip;
	}
}
