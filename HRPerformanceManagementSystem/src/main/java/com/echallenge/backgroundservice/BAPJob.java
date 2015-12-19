package com.echallenge.backgroundservice;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.echallenge.util.MailService;

public class BAPJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("EXECUTION STARTING ...");

//		try {
//			MailService.sendEmail("auranx@gmail.com", "Sujet", "Ceci est un mail de test envoyé le "+new Date().toString());
//		} catch (Throwable t) {
//			t.printStackTrace();
//		}

		System.out.println("EXECUTION ENDING");
	}

}