package com.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.Reading_LumaData;



public class Luma_BaseClass
{
	public Logger log;
	//to implement common functionality for test cases
		//open application//close application//screenshots
	Reading_LumaData rl=new Reading_LumaData();
	public String Fname=rl.getFirstName();
	public String LName=rl.getLastName();
	public String EmailAdd=rl.getEmailAdd();
	public String password=rl.getPassword();
	public String cpassword=rl.getcnfrmPassword();
	
		public static WebDriver driver;
		@BeforeClass
		@Parameters({"browser","url"})
		public void openApplication(String br,String URL)
		{
			if(br.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(br.equals("edge"))
			{
				driver=new EdgeDriver();
			}
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			log=Logger.getLogger("HybridFramework_Team33");
			PropertyConfigurator.configure("log4j.properties");
		}
		public String captureScreen(String tname) 
		{
			 String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
			 TakesScreenshot screenshot=((TakesScreenshot) driver);
			 File source=screenshot.getScreenshotAs(OutputType.FILE);
			 //screenshot//project directory
			 String destination=System.getProperty("user.dir")+"\\Screenshot\\"+tname+"_"+timestamp+".png";
			 try
			 {
				 FileUtils.copyFile(source, new File(destination));
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			return destination;
			
		}
		
		
//		@AfterClass
//		public void closeApplication()
//		{
//			driver.close();
//		}

}
