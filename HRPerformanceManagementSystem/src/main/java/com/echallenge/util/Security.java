package com.echallenge.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class Security {
	
	public static String get_SHA_1_SecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        String salt = Security.getSalt();
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            //md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	private static String getSalt()
    {
        //Always use a SecureRandom generator
        SecureRandom sr;
		try {
			sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
			//Create array for salt
	        byte[] salt = new byte[16];
	        //Get a random salt
	        sr.nextBytes(salt);
	        //return salt
	        return salt.toString();
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
    }
}
