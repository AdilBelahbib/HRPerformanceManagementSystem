package com.echallenge.backgroundservice;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.echallenge.util.MailService;

public class BAPJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			System.out.println("ggggg");
			MailService.test();
			System.out.println("after test");
		} catch (Exception e) {
			System.out.println("ERROR !!");
			throw new JobExecutionException(e);
		}

	}

}