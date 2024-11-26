package Fitpeo.Testcases;

import org.testng.annotations.Test;

import Fitpeo.objectclass.Fitpeoassignment;

public class TC_updateslidervalue extends Baseclass{

	
	
	@Test
	public void adjusttheslider() {
	    try {
	        Fitpeoassignment fpo = new Fitpeoassignment(driver);

	        fpo.clickRevenueCalculator();
	        fpo.scrollTillslider();
	        
	        fpo.setSliderApproxValue(820);
	        
	        fpo.setSliderexactvalue(820);
	        
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
