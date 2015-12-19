package com.echallenge.test;

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.echallenge.model.Administrateur;
import com.echallenge.model.BAP;
import com.echallenge.model.Collaborateur;
import com.echallenge.model.Encadrant;
import com.echallenge.model.Entete;
import com.echallenge.model.Evaluation;
import com.echallenge.model.Feedback;
import com.echallenge.model.FicheEvaluations;
import com.echallenge.model.FicheObjectifs;
import com.echallenge.model.ManagerRh;
import com.echallenge.model.Objectif;
import com.echallenge.model.Qualification;
import com.echallenge.model.QualificationTheme;
import com.echallenge.model.StatutBAP;
import com.echallenge.model.Theme;
import com.echallenge.util.HibernateUtil;

public class HibernateMappingTest {


	@Test
	public void savingAndGettingUsersTest() {
		
		Administrateur admin = new Administrateur();
		admin.setEmail("admin@mail.com");
		admin.setPrenom("prenomAdmin");
		admin.setNom("nomAdmin");
		admin.setMotDePasse("motDePasseAdmin");
		
		ManagerRh manager = new ManagerRh();
		manager.setEmail("manager@mail.com");
		manager.setPrenom("prenomManager");
		manager.setNom("nomManager");
		manager.setMotDePasse("motDePasseManager");
		
		Encadrant encadrant = new Encadrant();
		encadrant.setEmail("encadrant@mail.com");
		encadrant.setPrenom("prenomEncadrant");
		encadrant.setNom("nomEncadrant");
		encadrant.setMotDePasse("motDePasseEncadrant");
		
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setEmail("collaborateur@mail.com");
		collaborateur.setPrenom("prenomCollaborateur");
		collaborateur.setNom("nomCollaborateur");
		collaborateur.setMotDePasse("motDePasseCollaborateur");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//Save the different users
		session.save(admin);
		session.save(manager);
		session.save(encadrant);
		session.save(collaborateur);
		session.getTransaction().commit();
		
		//Get the same users
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		admin = (Administrateur) session.get(Administrateur.class, admin.getId());
		manager = (ManagerRh) session.get(ManagerRh.class, manager.getId());
		encadrant = (Encadrant) session.get(Encadrant.class, encadrant.getId());
		collaborateur = (Collaborateur) session.get(Collaborateur.class, collaborateur.getId());

		session.getTransaction().commit();

		Assert.assertNotNull("ADMIN IS NULL", admin);
		Assert.assertNotNull("ManagerRh IS NULL", admin);
		Assert.assertNotNull("Encadrant IS NULL", admin);
		Assert.assertNotNull("Collaborateur IS NULL", admin);

	}
	
	@Test
	public void objectifsTest()
	{
		ManagerRh manager = new ManagerRh();
		manager.setEmail("manager2@mail.com");
		manager.setPrenom("prenomManager2");
		manager.setNom("nomManager2");
		manager.setMotDePasse("motDePasseManager2");
		
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setEmail("collaborateur2@mail.com");
		collaborateur.setPrenom("prenomCollaborateur2");
		collaborateur.setNom("nomCollaborateur2");
		collaborateur.setMotDePasse("motDePasseCollaborateur2");
		
		Objectif obj1 = new Objectif();
		obj1.setDescriptionObjectif("Objectif 1");
		obj1.setAvancementObjectif(5.66);
		obj1.setMesureObjectif("Mesuré par blabla");
		
		Objectif obj2 = new Objectif();
		obj2.setDescriptionObjectif("Objectif 2");
		obj2.setAvancementObjectif(115.66);
		obj2.setMesureObjectif("Mesuré par blabla 2 :D");
		
		FicheObjectifs ficheObjectifs = new FicheObjectifs();
		ficheObjectifs.setAutorisationAcces(true);
		ficheObjectifs.setDateFicheObjectifs(new Date());
		ficheObjectifs.getObjectifs().add(obj1);
		ficheObjectifs.getObjectifs().add(obj2);
		collaborateur.getFicheObjectifs().add(ficheObjectifs);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//Save the different users
		session.save(manager);
		session.save(collaborateur);
		session.save(ficheObjectifs);
		
		session.getTransaction().commit();
		
		//Get the same collaborator
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		collaborateur = (Collaborateur) session.get(Collaborateur.class, collaborateur.getId());
		int size = collaborateur.getFicheObjectifs().size();
		session.getTransaction().commit();

		Assert.assertNotNull("FICHE OBJECTIFS EST NULLE", collaborateur.getFicheObjectifs());
		Assert.assertEquals("objectifsTest: ficheObjectif du collaborateur", 1, size);
		
	}
	
	@Test
	public void evaluationsTest()
	{
		Encadrant encadrant = new Encadrant();
		encadrant.setEmail("encadrant3@mail.com");
		encadrant.setPrenom("prenomEncadrant");
		encadrant.setNom("nomEncadrant");
		encadrant.setMotDePasse("motDePasseEncadrant");
		
		ManagerRh manager = new ManagerRh();
		manager.setEmail("manager3@mail.com");
		manager.setPrenom("prenomManager2");
		manager.setNom("nomManager2");
		manager.setMotDePasse("motDePasseManager2");
		
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setEmail("collaborateur3@mail.com");
		collaborateur.setPrenom("prenomCollaborateur2");
		collaborateur.setNom("nomCollaborateur2");
		collaborateur.setMotDePasse("motDePasseCollaborateur2");		
		
		Objectif obj1 = new Objectif();
		obj1.setDescriptionObjectif("Objectif 1");
		obj1.setAvancementObjectif(5.66);
		obj1.setMesureObjectif("Mesuré par blabla");
		
		Objectif obj2 = new Objectif();
		obj2.setDescriptionObjectif("Objectif 2");
		obj2.setAvancementObjectif(115.66);
		obj2.setMesureObjectif("Mesuré par blabla 2 :D");
		
		FicheObjectifs ficheObjectifs = new FicheObjectifs();
		ficheObjectifs.setAutorisationAcces(true);
		ficheObjectifs.setDateFicheObjectifs(new Date());
		ficheObjectifs.getObjectifs().add(obj1);
		ficheObjectifs.getObjectifs().add(obj2);
		collaborateur.getFicheObjectifs().add(ficheObjectifs);
		
		FicheEvaluations ficheEvaluations = new FicheEvaluations();
		ficheEvaluations.setAutorisationAcces(true);
		ficheEvaluations.setDateEvaluation(new Date());
		
		Evaluation e1 = new Evaluation();
		e1.setObjectif(obj1);
		e1.setPoids(5);
		e1.setResultat(15.3);
		
		Evaluation e2 = new Evaluation();
		e2.setObjectif(obj2);
		e2.setPoids(52);
		e2.setResultat(215.3);
		
		ficheEvaluations.getEvaluations().add(e1);
		ficheEvaluations.getEvaluations().add(e2);
		
		collaborateur.getFichesEvaluations().add(ficheEvaluations);

		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//Save the different users
		session.save(encadrant);
		session.save(manager);
		session.save(collaborateur);
		session.save(ficheObjectifs);
		session.save(ficheEvaluations);
		
		session.getTransaction().commit();
		
		//Get the same collaborator
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		collaborateur = (Collaborateur) session.get(Collaborateur.class, collaborateur.getId());
		//encadrant = (Encadrant) session.get(Encadrant.class, encadrant.getId());
		
		int sizeFicheEvaluation = collaborateur.getFichesEvaluations().size();

		int sizeEvaluations = collaborateur.getFichesEvaluations().iterator().next().getEvaluations().size();
		session.getTransaction().commit();

		Assert.assertNotNull("FICHE EVALUATION EST NULLE", collaborateur.getFichesEvaluations());
		Assert.assertEquals("evaluationsTest: sizeFicheEvaluation", 1, sizeFicheEvaluation);
		Assert.assertEquals("evaluationsTest: sizeEvaluations", 2, sizeEvaluations);
		
	}
	
	@Test
	public void bapTest()
	{
		ManagerRh manager = new ManagerRh();
		manager.setEmail("manager5@mail.com");
		manager.setPrenom("prenomManager2");
		manager.setNom("nomManager2");
		manager.setMotDePasse("motDePasseManager2");
		
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setEmail("collaborateur5@mail.com");
		collaborateur.setPrenom("prenomCollaborateur2");
		collaborateur.setNom("nomCollaborateur2");
		collaborateur.setMotDePasse("motDePasseCollaborateur2");
		
		Encadrant encadrant = new Encadrant();
		encadrant.setEmail("encadrant5@mail.com");
		encadrant.setPrenom("prenomEncadrant");
		encadrant.setNom("nomEncadrant");
		encadrant.setMotDePasse("motDePasseEncadrant");
		
		Objectif obj1 = new Objectif();
		obj1.setDescriptionObjectif("Objectif 1");
		obj1.setAvancementObjectif(5.66);
		obj1.setMesureObjectif("Mesuré par blabla");
		
		Objectif obj2 = new Objectif();
		obj2.setDescriptionObjectif("Objectif 2");
		obj2.setAvancementObjectif(115.66);
		obj2.setMesureObjectif("Mesuré par blabla 2 :D");
		
		Objectif obj3 = new Objectif();
		obj3.setDescriptionObjectif("Objectif 3");
		obj3.setAvancementObjectif(5.66);
		obj3.setMesureObjectif("Mesuré par blabla 3");
		
		Objectif obj4 = new Objectif();
		obj4.setDescriptionObjectif("Objectif 4");
		obj4.setAvancementObjectif(115.66);
		obj4.setMesureObjectif("Mesuré par blabla 4 :D");
		
		Objectif obj5 = new Objectif();
		obj5.setDescriptionObjectif("Objectif 5");
		obj5.setAvancementObjectif(5.66);
		obj5.setMesureObjectif("Mesuré par blabla 5");
		
		Objectif obj6 = new Objectif();
		obj6.setDescriptionObjectif("Objectif 6");
		obj6.setAvancementObjectif(115.66);
		obj6.setMesureObjectif("Mesuré par blabla 6 :D");
		
		
		FicheObjectifs ficheObjectifs = new FicheObjectifs();
		ficheObjectifs.setAutorisationAcces(true);
		ficheObjectifs.setDateFicheObjectifs(new Date());
		ficheObjectifs.getObjectifs().add(obj1);
		ficheObjectifs.getObjectifs().add(obj2);
		
		FicheObjectifs ficheObjectifs2 = new FicheObjectifs();
		ficheObjectifs2.setAutorisationAcces(false);
		ficheObjectifs2.setDateFicheObjectifs(new Date());
		ficheObjectifs2.getObjectifs().add(obj5);
		ficheObjectifs2.getObjectifs().add(obj6);
		
		FicheEvaluations ficheEvaluations = new FicheEvaluations();
		ficheEvaluations.setAutorisationAcces(true);
		ficheEvaluations.setDateEvaluation(new Date());
		
		Evaluation e1 = new Evaluation();
		e1.setObjectif(obj1);
		e1.setPoids(5);
		e1.setResultat(15.3);
		
		Evaluation e2 = new Evaluation();
		e2.setObjectif(obj2);
		e2.setPoids(52);
		e2.setResultat(215.3);
		
		ficheEvaluations.getEvaluations().add(e1);
		ficheEvaluations.getEvaluations().add(e2);
		
		collaborateur.getFichesEvaluations().add(ficheEvaluations);
		
		
		Entete en1 = new Entete();
		en1.setDateDebutIntervention(new Date());
		en1.setDateFinIntervention(new Date());
		en1.setNombreJoursValorises(20);
		en1.setRole("Rien");
		
		Entete en2 = new Entete();
		en2.setDateDebutIntervention(new Date());
		en2.setDateFinIntervention(new Date());
		en2.setNombreJoursValorises(25);
		en2.setRole("Rien 2");
		
		QualificationTheme qt1 = new QualificationTheme();
		qt1.setQualification(Qualification.A_DEVELOPPER);
		qt1.setTheme(Theme.CONCEPTION);
		qt1.setRemarque("Une remarque");
		
		QualificationTheme qt2 = new QualificationTheme();
		qt2.setQualification(Qualification.SELON_ATTENTE);
		qt2.setTheme(Theme.GESTION_DE_PROJET);
		
		QualificationTheme qt3 = new QualificationTheme();
		qt3.setQualification(Qualification.CRITIQUE);
		qt3.setTheme(Theme.GESTION_DE_RELATION_CLIENT);
		qt3.setRemarque("Une remarque 3");
		
		QualificationTheme qt4 = new QualificationTheme();
		qt4.setQualification(Qualification.SELON_ATTENTE);
		qt4.setTheme(Theme.POLYVALENCE);
		
		
		Feedback f1 = new Feedback();
		f1.setEntete(en1);
		f1.setValidation(true);
		f1.setRemarqueGenerale("Ceci est une remarque");
		f1.getQualificationsTheme().add(qt1);
		f1.getQualificationsTheme().add(qt2);
		f1.getQualificationsTheme().add(qt3);
		
		Feedback f2 = new Feedback();
		f2.setEntete(en2);
		f2.setValidation(false);
		f2.setRemarqueGenerale("Ceci est une remarque 2");
		f2.getQualificationsTheme().add(qt4);
		
		
		BAP bap = new BAP();
		bap.setDateBilan(new Date());
		bap.setFicheEvaluations(ficheEvaluations);
		bap.setFicheObjectifsTraites(ficheObjectifs);
		bap.setFicheObjectifsRediges(ficheObjectifs2);
		bap.setStatut(StatutBAP.EN_COURS);
		bap.getFeedbacks().add(f1);
		bap.getFeedbacks().add(f2);
				
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//Save the different users
		session.save(manager);
		session.save(collaborateur);
		session.save(encadrant);
		session.save(ficheObjectifs);
		session.save(ficheEvaluations);
		session.save(bap);
		
		session.getTransaction().commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		collaborateur = (Collaborateur) session.get(Collaborateur.class, collaborateur.getId());

		bap = (BAP) session.get(BAP.class, bap.getId());
		
		int sizeFeedback = bap.getFeedbacks().size();
		int sizeQT = -1;
		Entete entete = null;

		
		Iterator<Feedback> iter = bap.getFeedbacks().iterator();
		
		while(iter.hasNext())
		{
			Feedback fb = iter.next();
			if(fb.getRemarqueGenerale().equals("Ceci est une remarque"))
			{
				sizeQT = fb.getQualificationsTheme().size();
				entete = fb.getEntete();
			}
		}
		
		session.getTransaction().commit();

		Assert.assertEquals("bapTest: sizeFeedback", 2, sizeFeedback);
		Assert.assertEquals("bapTest: sizeQT", 3, sizeQT);
		Assert.assertNotNull("ENTETE NULLE", entete);

	}


}
