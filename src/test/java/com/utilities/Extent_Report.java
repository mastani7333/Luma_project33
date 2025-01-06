package com.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testcase.Luma_BaseClass;



public class Extent_Report implements ITestListener
{
public ExtentSparkReporter report;//provide information about document
	
	public ExtentReports extent;//provide info about users
	
	public ExtentTest test;//it will provide the status of testcases
	
	
	public void onStart(ITestContext context) 
	{
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		String repname="Luma_Test_report"+timestamp+".html";
		
		report=new ExtentSparkReporter("D:\\mastaniworkspace\\HybridFramework_Team33\\Test Reports\\"+repname);
		report.config().setDocumentTitle("Luma-Testing-Report");
		report.config().setReportName("Luma Registration & Login validation test");
		report.config().setTheme(Theme.STANDARD);
		
		//provide basic info user
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		
		extent.setSystemInfo("Hostname", "Local Host");
		extent.setSystemInfo("User", "mastani");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome,Edge");	
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	
	}
	
	
	
	public void onTestFailure(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));	
		try 
		{
			String imgpath= new Luma_BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));	
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush(); // ==> it will remove un-nessecary data
		
	}
	

}
