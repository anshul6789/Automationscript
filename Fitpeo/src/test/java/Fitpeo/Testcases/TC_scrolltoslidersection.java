package Fitpeo.Testcases;

import org.testng.annotations.Test;

import Fitpeo.objectclass.Fitpeoassignment;

public class TC_scrolltoslidersection extends Baseclass{


	@Test
	public void scrolltoslidersection() throws InterruptedException {
	    try {
	        Fitpeoassignment fpo = new Fitpeoassignment(driver);
	        
	        // Navigating to the revenue calculator
	        fpo.clickRevenueCalculator();
	        System.out.println("Navigated to the Revenue Calculator page.");
	        
	        // Scroll until the slider section
	        fpo.scrollTillslider();
	        System.out.println("Scrolled to the slider section.");
	       
	        System.out.println("____________________________________________");
	        
	    } catch (Exception e) {
	        System.err.println("An error occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	 
	}

	
}
