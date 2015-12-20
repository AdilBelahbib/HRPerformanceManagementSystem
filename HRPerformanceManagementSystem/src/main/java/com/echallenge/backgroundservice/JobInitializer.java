package com.echallenge.backgroundservice;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Servlet implementation class JobInitializer
 */
public class JobInitializer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

//		try {
//			JobDetail job = JobBuilder.newJob(BAPJob.class).withIdentity("bapjob", "group1").build();
//
//			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("bapjobtrigger", "group1")
//					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever())
//					.build();
//
//	        String key = "org.quartz.impl.StdSchedulerFactory.KEY";
//	        ServletContext servletContext = config.getServletContext();
//	        StdSchedulerFactory factory = (StdSchedulerFactory) servletContext.getAttribute(key);
//	        Scheduler scheduler = factory.getScheduler("MyQuartzScheduler");
//			
//			scheduler.start();
//			scheduler.scheduleJob(job, trigger);
//			
//		} catch (SchedulerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
