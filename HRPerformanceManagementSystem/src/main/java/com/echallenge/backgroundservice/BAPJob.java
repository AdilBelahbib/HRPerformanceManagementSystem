package com.echallenge.backgroundservice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.echallenge.model.BAP;
import com.echallenge.model.StatutBAP;
import com.echallenge.util.HibernateUtil;

public class BAPJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("before");
		//BAPJob.sendMailSSL();
		System.out.println("after");
		
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		Calendar moisSuivant = Calendar.getInstance();
//		moisSuivant.setTime(new Date());
//		moisSuivant.add(Calendar.MONTH, 1);
//
//		Calendar debutDuMois = Calendar.getInstance();
//		debutDuMois.setTime(new Date());
//		debutDuMois.set(Calendar.DAY_OF_MONTH, debutDuMois.getActualMinimum(Calendar.DAY_OF_MONTH));
//
//		Calendar finDuMois = Calendar.getInstance();
//		finDuMois.setTime(new Date());
//		finDuMois.set(Calendar.DAY_OF_MONTH, finDuMois.getActualMaximum(Calendar.DAY_OF_MONTH));
//
//		@SuppressWarnings("unchecked")
//		List<BAP> bapProches = session
//				.createQuery("from BAP WHERE dateBap between :dateactuelle and :datelimite and statut = 'EN_ATTENTE'")
//				.setDate("dateactuelle", new Date()).setDate("datelimite", moisSuivant.getTime()).list();
//
//		@SuppressWarnings("unchecked")
//		List<BAP> bapEnCours = session
//				.createQuery("from BAP WHERE dateBap between :debutmois and :finmois and statut = 'EN_COURS'")
//				.setDate("debutmois", debutDuMois.getTime()).setDate("finmois", finDuMois.getTime()).list();
//
//		for (BAP bap : bapProches) {
//			/*********************************************/
//			/********* NOTIFIER LES MANAGERS RH **********/
//			/*********************************************/
//			System.out.println(bap.getId() + " : " + bap.getDateBilan().toString());
//			bap.setStatut(StatutBAP.EN_COURS);
//			session.update(bap);
//		}
//
//		for (BAP bap : bapEnCours) {
//			/*********************************************/
//			/********* NOTIFIER LES MANAGERS RH **********/
//			/*********************************************/
//			System.out.println(bap.getId() + " : " + bap.getDateBilan().toString());
//		}
//
//
//		session.getTransaction().commit();
	}
	
	private static void sendMailSSL()
	{
		String recipientslist = "aa@fff.ccc,sss@ff.cc,sss@gg.cc";
		System.out.println("INSIDE");
		try {
			System.out.println(InternetAddress.parse(recipientslist).toString());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}