package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reading_LumaData 
{
	Properties pro;
	public Reading_LumaData()  
	{
		File file=new File("D:\\mastaniworkspace\\HybridFramework_Team33\\Configuration\\Data.properties");
		
		try {
			FileInputStream fis=new FileInputStream(file);
			 pro=new Properties();
			pro.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	//registration
	public String getFirstName()
	{
		String fName=pro.getProperty("FirstName");
		return fName;
	}
	public String getLastName()
	{
		String LName=pro.getProperty("LastName");
		return LName;
	}
	public String getEmailAdd()
	{
		String EmailAdd=pro.getProperty("Email");
		return EmailAdd;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getcnfrmPassword()
	{
		String cpassword=pro.getProperty("confirmpassword");
		return cpassword;
	}
	
	

}
