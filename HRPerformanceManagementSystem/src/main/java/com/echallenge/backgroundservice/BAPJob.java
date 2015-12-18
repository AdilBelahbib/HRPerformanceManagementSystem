package com.echallenge.backgroundservice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.echallenge.model.BAP;
import com.echallenge.model.StatutBAP;
import com.echallenge.util.HibernateUtil;

public class BAPJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Calendar moisSuivant = Calendar.getInstance();
		moisSuivant.setTime(new Date());
		moisSuivant.add(Calendar.MONTH, 1);

		Calendar debutDuMois = Calendar.getInstance();
		debutDuMois.setTime(new Date());
		debutDuMois.set(Calendar.DAY_OF_MONTH, debutDuMois.getActualMinimum(Calendar.DAY_OF_MONTH));

		Calendar finDuMois = Calendar.getInstance();
		finDuMois.setTime(new Date());
		finDuMois.set(Calendar.DAY_OF_MONTH, finDuMois.getActualMaximum(Calendar.DAY_OF_MONTH));

		@SuppressWarnings("unchecked")
		List<BAP> bapProches = session
				.createQuery("from BAP WHERE dateBap between :dateactuelle and :datelimite and statut = 'EN_ATTENTE'")
				.setDate("dateactuelle", new Date()).setDate("datelimite", moisSuivant.getTime()).list();

		@SuppressWarnings("unchecked")
		List<BAP> bapEnCours = session
				.createQuery("from BAP WHERE dateBap between :debutmois and :finmois and statut = 'EN_COURS'")
				.setDate("debutmois", debutDuMois.getTime()).setDate("finmois", finDuMois.getTime()).list();

		System.out.println(
				"======= SUIVANT: " + new Date().toString() + " -> " + moisSuivant.getTime().toString() + "=========");

		for (BAP bap : bapProches) {
			/*********************************************/
			/********* NOTIFIER LES MANAGERS RH **********/
			/*********************************************/
			System.out.println(bap.getId() + " : " + bap.getDateBilan().toString());
			bap.setStatut(StatutBAP.EN_COURS);
			session.update(bap);
		}

		System.out.println("======= END NEXT =========");

		System.out.println(
				"======= ACTUAL: " + debutDuMois.getTime().toString() + " -> " + finDuMois.getTime().toString() + "=========");

		for (BAP bap : bapEnCours) {
			/*********************************************/
			/********* NOTIFIER LES MANAGERS RH **********/
			/*********************************************/
			System.out.println(bap.getId() + " : " + bap.getDateBilan().toString());
		}

		System.out.println("======= END ACTUAL =========");

		session.getTransaction().commit();
		System.out.println("============== END ==============");

	}

}