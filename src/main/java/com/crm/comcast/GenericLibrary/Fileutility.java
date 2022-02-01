package com.crm.comcast.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class provides generic methods to read data from property file
 * 
 * @author Suraj
 *
 */
public class Fileutility {

	/**
	 * This method will read data from property file and it will return the value
	 * 
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) {
		try {
			FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
			Properties pr = new Properties();
			pr.load(fis);
			String value = pr.getProperty(key);
			return value;
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		return key;
	}

}
