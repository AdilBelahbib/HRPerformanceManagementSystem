package com.echallenge.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.echallenge.model.Utilisateur;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.Security;

@Path("/utilisateurs")
public class UtilisateurService {
	static final String api_version = "1.01A rev.18729";

	@Path("auth/{email}/{mdp}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilisateur authentification(@PathParam("email") String email, @PathParam("mdp") String mdp) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Utilisateur utilisateur = (Utilisateur) session
				.createQuery(
						"from Utilisateur as utilisateur where utilisateur.email = ? AND utilisateur.motDePasse = ?")
				.setString(0, email).setString(1, Security.get_SHA_1_SecurePassword(mdp)).uniqueResult();
		
		session.getTransaction().commit();
		return utilisateur;
	}

}