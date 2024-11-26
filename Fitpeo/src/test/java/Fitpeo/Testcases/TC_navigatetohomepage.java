package Fitpeo.Testcases;

import org.testng.annotations.Test;

import Fitpeo.objectclass.Fitpeoassignment;
import junit.framework.Assert;

public class TC_navigatetohomepage extends Baseclass{

	
	@Test
	public void navigatetohomepage() {
	    try {
	        Fitpeoassignment fpo = new Fitpeoassignment(driver);
	        System.out.println("Navigated To the Fitpeo Home Page");

	        String exppageTitle = "Remote Patient Monitoring (RPM) - fitpeo.com";
	        String actpageTitle = driver.getTitle();
	        
	        // Validate the page title
	        Assert.assertEquals( "Page title does not match!" ,actpageTitle, exppageTitle);
	        
	        System.out.println("Actual Page Title: " + actpageTitle);
	        System.out.println("Expected Page Title: " + exppageTitle);

	        Thread.sleep(2000);
	        System.out.println("____________________________________________");
	        
	    } catch (InterruptedException e) {
	        System.err.println("Thread was interrupted during sleep: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.err.println("An error occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
}
