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

import com.echallenge.model.ManagerRh;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/managersrh")
public class ManagerRhService {

	@SuppressWarnings("unchecked")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ManagerRh> getAllManagerRh() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ManagerRh> managersRh = null;

		try {
			session.beginTransaction();
			managersRh = session.createQuery("from ManagerRh").list();

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return managersRh;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh getManagerRhById(@PathParam("id") int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ManagerRh managerRh = null;

		try {
			session.beginTransaction();
			managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return managerRh;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh modifierManagerRh(ManagerRh managerRh) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			String mdp = (String) session.createQuery("select ma.motDePasse from ManagerRh ma WHERE ma = :manager")
					.setEntity("manager", managerRh).uniqueResult();

			if (!managerRh.getMotDePasse().equals(mdp))
				managerRh.setMotDePasse(Security.get_SHA_1_SecurePassword(managerRh.getMotDePasse()));

			session.update(managerRh);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return managerRh;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh ajouterManagerRh(ManagerRh managerRh) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			managerRh.setMotDePasse(Security.get_SHA_1_SecurePassword(managerRh.getMotDePasse()));

			session.save(managerRh);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return managerRh;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ManagerRh supprimerManagerRh(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ManagerRh managerRh = null;

		try {
			session.beginTransaction();

			managerRh = (ManagerRh) session.get(ManagerRh.class, new Long(id));
			session.delete(managerRh);

		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}

		return managerRh;
	}
}
