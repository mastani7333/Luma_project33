package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Registration_POM 
{
	//divide into 3 parts
	//constructor
	public static  WebDriver driver;
	public Luma_Registration_POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Identified the webelements in the page
	@FindBy(xpath="(//a[text()='Create an Account'])[1]")
	WebElement linkcreateAcc;
	@FindBy(id="firstname")
	WebElement txtFirstName;
	@FindBy(id="lastname")
	WebElement txtLastName;
	@FindBy(id="email_address")
	WebElement txtEmailAdd;
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpass;
	@FindBy(id="password-confirmation")
	WebElement txtcnfmpass;
	@FindBy(xpath="//butto[@class='action submit primary']")
	WebElement btnCreateAcc;
	//create corresponding actions
	public void click_createAcc_Link()
	{
		linkcreateAcc.click();
	}
	public void setFirstName(String Fname)
	{
		txtFirstName.sendKeys(Fname);
		
	}
	public void setLastName(String Lname)
	{
		txtLastName.sendKeys(Lname);
	}
	public void setEmail_Add(String email)

	{
		txtEmailAdd.sendKeys(email);
	}
	public void setPass(String pass)
	{
		txtpass.sendKeys(pass);
	}
	public void setcnfm_pass(String cpass)
	{
		txtcnfmpass.sendKeys(cpass);
	}
	public void click_CreateAcc_btn()
	{
		btnCreateAcc.click();
	}
	
	
	
	
	
	
	
	

}
