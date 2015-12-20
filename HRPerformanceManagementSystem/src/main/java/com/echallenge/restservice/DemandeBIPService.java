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
import com.echallenge.model.ManagerRh;
import com.echallenge.util.HibernateUtil;

@Path("/demandebips")
public class DemandeBIPService {

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP getDemandeBIPById(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		DemandeBIP demandeBIP = null;

		try {
			session.beginTransaction();
			demandeBIP = (DemandeBIP) session.get(DemandeBIP.class, new Long(id));

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIP;
	}

	@SuppressWarnings("unchecked")
	@Path("/collaborateur/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DemandeBIP> getDemandeBIPByCollaborateur(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<DemandeBIP> demandeBIPs = null;

		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.get(Collaborateur.class, new Long(id));

			if (collaborateur != null) {
				demandeBIPs = session.createQuery("from DemandeBIP dem WHERE dem.collaborateur = :collaborateur")
						.setEntity("collaborateur", collaborateur).list();
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIPs;
	}

	@SuppressWarnings("unchecked")
	@Path("/managerrh/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DemandeBIP> getDemandeBIPByManagerRh(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<DemandeBIP> demandeBIPs = null;

		try {
			session.beginTransaction();
			ManagerRh manager = (ManagerRh) session.get(ManagerRh.class, new Long(id));

			if (manager != null) {
				demandeBIPs = session
						.createQuery("select dem from DemandeBIP dem, ManagerRh manager"
								+ " WHERE manager = :manager AND dem.collaborateur IN elements(manager.collaborateurs)")
						.setEntity("manager", manager).list();
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIPs;
	}

	@SuppressWarnings("unchecked")
	@Path("/encadrant/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DemandeBIP> getDemandeBIPByEncadrant(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<DemandeBIP> demandeBIPs = null;

		try {
			session.beginTransaction();
			Encadrant encadrant = (Encadrant) session.get(Encadrant.class, new Long(id));

			if (encadrant != null) {
				demandeBIPs = session.createQuery("from DemandeBIP dem WHERE dem.encadrant = :encadrant")
						.setEntity("encadrant", encadrant).list();
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIPs;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP modifierDemandeBIP(DemandeBIP demandeBIP) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(demandeBIP);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIP;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP ajouterDemandeBIP(DemandeBIP demandeBIP) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(demandeBIP);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIP;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DemandeBIP supprimerDemandeBIP(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		DemandeBIP demandeBIP = null;

		try {
			session.beginTransaction();

			demandeBIP = (DemandeBIP) session.get(DemandeBIP.class, new Long(id));
			session.delete(demandeBIP);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return demandeBIP;
	}

}
