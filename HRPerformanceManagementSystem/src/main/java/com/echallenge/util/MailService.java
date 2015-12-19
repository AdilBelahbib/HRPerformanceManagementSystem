package com.echallenge.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailService{
	
	public static void test()
	{
		System.out.println("TESTING I ...");
		
		try {
			InternetAddress.parse("to-email@gmail.com");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test2()
	{
		System.out.println("TESTING II ...");
	}

}