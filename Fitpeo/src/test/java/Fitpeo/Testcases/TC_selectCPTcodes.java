package Fitpeo.Testcases;

import org.testng.annotations.Test;

import Fitpeo.objectclass.Fitpeoassignment;

public class TC_selectCPTcodes extends Baseclass {

	@Test
	public void SelectCPTCodes() throws InterruptedException {
		try {
			
		Fitpeoassignment fpo=new Fitpeoassignment(driver);

		fpo.clickRevenueCalculator();
		fpo.scrollTillcheckboxes();
		
		fpo.clickcheckboxone();
		fpo.clickcheckboxtwo();
		fpo.clickcheckboxthree();
		fpo.clickcheckboxfour();
		fpo.scrollTillslider();
		
		System.out.println("CPT codes are Selected");
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
