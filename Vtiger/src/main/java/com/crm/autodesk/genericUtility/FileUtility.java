package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * @author Rahul
 *
 */
public class FileUtility {
	/**
	 * Used to read value by providing key from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyValue(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./data/commondata.properties");	
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
