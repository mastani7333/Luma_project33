package com.testcase;

import org.testng.annotations.Test;

import com.pageobject.Luma_Registration_POM;

public class TC_01_LumaRegistarion extends Luma_BaseClass
{
	 Luma_Registration_POM lr;
	 @Test
	public void LumaRegistration() throws InterruptedException
	{
		 lr=new Luma_Registration_POM(driver);
		lr.click_createAcc_Link();
		log.info("Luma create account clicking activity is completed");
		lr.setFirstName(Fname);
		log.info("Firstname entered sucessfully");
		lr.setLastName(LName);
		log.info("lastname entered sucessfully");
		lr.setEmail_Add(EmailAdd);
		log.info("email entered sucessfully");
		lr.setPass(password);
		log.info("password entered sucessfully");
		Thread.sleep(2000);
		lr.setcnfm_pass(cpassword);
		log.info("password confrmd");
		lr.click_CreateAcc_btn();
		log.info("create Account button is clickable");
		
	}
	

}
