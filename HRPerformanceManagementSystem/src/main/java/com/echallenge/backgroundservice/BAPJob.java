package com.echallenge.backgroundservice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.echallenge.model.BAP;
import com.echallenge.model.ManagerRh;
import com.echallenge.model.StatutBAP;
import com.echallenge.util.HibernateUtil;
import com.echallenge.util.MailService;

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

		for (BAP bap : bapProches) {
			bap.setStatut(StatutBAP.EN_COURS);
			session.update(bap);
			
			ManagerRh manager = (ManagerRh) session.createQuery(
					"from ManagerRh manager, BAP bap WHERE bap = :bap AND bap.collaborateur IN elements(manager.collaborateurs)")
					.setEntity("bap", bap).setMaxResults(1).uniqueResult();
			
			try {
				MailService.sendEmail(manager.getEmail(), "BAP du collaborateur "+bap.getCollaborateur().getNom()+" "+bap.getCollaborateur().getPrenom()+" s'approche", "Bonjour, le BAP relatif au collaborateur: "+bap.getCollaborateur().getNom()+" "+bap.getCollaborateur().getPrenom()+" aura lieu le mois prochain.");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable t) {
				// TODO Auto-generated catch block
				t.printStackTrace();
			}
			
		}

		for (BAP bap : bapEnCours) {
			ManagerRh manager = (ManagerRh) session.createQuery(
					"from ManagerRh manager, BAP bap WHERE bap = :bap AND bap.collaborateur IN elements(manager.collaborateurs)")
					.setEntity("bap", bap).setMaxResults(1).uniqueResult();
			
			try {
				MailService.sendEmail(manager.getEmail(), "BAP du collaborateur "+bap.getCollaborateur().getNom()+" "+bap.getCollaborateur().getPrenom()+" est en cours", "Bonjour, le BAP relatif au collaborateur: "+bap.getCollaborateur().getNom()+" "+bap.getCollaborateur().getPrenom()+" doit être réalisé pendant ce mois.");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable t) {
				// TODO Auto-generated catch block
				t.printStackTrace();
			}
		}

		session.getTransaction().commit();
	}

}