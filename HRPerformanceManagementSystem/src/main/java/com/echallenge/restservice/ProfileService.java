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

import com.echallenge.model.Profile;
import com.echallenge.util.HibernateUtil;

@Path("/profiles")
public class ProfileService {

	@SuppressWarnings("unchecked")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Profile> getAllProfiles() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Profile> profiles = null;

		try {
			session.beginTransaction();
			profiles = session.createQuery("from Profile").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return profiles;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Profile getProfileById(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Profile profile = null;

		try {
			session.beginTransaction();
			profile = (Profile) session.get(Profile.class, new Long(id));

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return profile;
	}

	@Path("/code/{code}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Profile getProfileCode(@PathParam("code") String code) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Profile profile = null;

		try {
			session.beginTransaction();
			profile = (Profile) session.createQuery("from Profile profile WHERE profile.codeProfile = :code")
					.setString("code", code).uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return profile;
	}

	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Profile modifierProfile(Profile profile) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(profile);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return profile;
	}

	@Path("/ajouter")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Profile ajouterProfile(Profile profile) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(profile);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return profile;
	}

	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Profile supprimerProfile(@PathParam("id") int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Profile profile = null;

		try {
			session.beginTransaction();
			profile = (Profile) session.get(Profile.class, new Long(id));
			session.delete(profile);

			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return profile;
	}

}
