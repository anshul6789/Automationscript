package Fitpeo.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Fitpeo.objectclass.Fitpeoassignment;

public class TC_validateslidervalue extends Baseclass{

	@Test
	public void validateslidervalue() throws InterruptedException {
		try {
		Fitpeoassignment fpo=new Fitpeoassignment(driver);

		fpo.clickRevenueCalculator();
		fpo.scrollTillslider();
		
		fpo.clearslider();
	    fpo.setslidervalue("560");
	
	    fpo.getslidervalue();
	    
	    String actualValue=fpo.getslidervalue();
	    String expectedValue="560";
	    
	    Assert.assertEquals(actualValue, expectedValue, "Slider value does not match the expected value!");
	    
		System.out.println("actual slider Value: " + actualValue);
		System.out.println( "expected slider Value: " + expectedValue );
	
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
