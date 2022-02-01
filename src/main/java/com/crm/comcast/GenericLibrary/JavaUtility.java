package com.crm.comcast.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class contains generic method with respect to java
 * 
 * @author Nagarjun!!
 *
 */
public class JavaUtility {
	/**
	 * This method will generate a random number and returns it to the caller
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}

	/**
	 * This method will return the current date to the caller
	 * 
	 * @return
	 */
	public String getCurrentDate() {
		Date date = new Date();
		String currentdate = date.toString();

		return currentdate;
	}

	/**
	 * This method will return date in specified format to the caller
	 * 
	 * @return
	 */
	public String getFinalDate() {
		Date ndate = new Date();
		String d = ndate.toString();
		String[] dsp = d.split(" ");
		String yyyy = dsp[5];
		String dd = dsp[2];
		String mm = dsp[1];
		String today = yyyy + "-" + mm + "-" + dd;

		return today;

	}

}
