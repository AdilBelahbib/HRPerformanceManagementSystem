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
import com.echallenge.model.DemandeBIP;
import com.echallenge.model.Encadrant;
import com.echallenge.util.HibernateUtil;

@Path("/demandebips")
public class DemandeBIPService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP getDemandeBIPById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		DemandeBIP demandeBIP = (DemandeBIP) session.get(DemandeBIP.class, new Long(id));

		session.getTransaction().commit();
		return demandeBIP;
	}

	@SuppressWarnings("unchecked")
	@Path("/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DemandeBIP> getDemandeBIPByCollaborateur(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

		List<DemandeBIP> demandeBIPs = null;

		if(collaborateur != null)
		{
			demandeBIPs = session.createQuery(
					"from DemandeBIP dem WHERE dem.collaborateur = :collaborateur")
			.setEntity("collaborateur", collaborateur)
			.list();
		}

		session.getTransaction().commit();
		return demandeBIPs;
	}
	
	@SuppressWarnings("unchecked")
	@Path("/encadrant/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DemandeBIP> getDemandeBIPByEncadrant(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));

		List<DemandeBIP> demandeBIPs = null;

		if(encadrant != null)
		{
			demandeBIPs = session.createQuery(
					"from DemandeBIP dem WHERE dem.encadrant = :encadrant")
			.setEntity("encadrant", encadrant)
			.list();
		}

		session.getTransaction().commit();
		return demandeBIPs;
	}
	
	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP modifierDemandeBIP(DemandeBIP demandeBIP) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.saveOrUpdate(demandeBIP);

		session.getTransaction().commit();

		return demandeBIP;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP ajouterDemandeBIP(DemandeBIP demandeBIP) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(demandeBIP);

		session.getTransaction().commit();

		return demandeBIP;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP supprimerDemandeBIP(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		DemandeBIP demandeBIP = (DemandeBIP) session.get(DemandeBIP.class, new Long(id));
		session.delete(demandeBIP);

		session.getTransaction().commit();

		return demandeBIP;
	}

}
