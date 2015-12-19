package com.echallenge.backgroundservice;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.echallenge.util.MailService;



public class BAPJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("ggggg");
		MailService.test2();
		MailService.test();
	}

}