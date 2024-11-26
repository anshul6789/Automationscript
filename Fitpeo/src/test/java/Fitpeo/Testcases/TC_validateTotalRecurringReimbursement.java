package Fitpeo.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Fitpeo.objectclass.Fitpeoassignment;

public class TC_validateTotalRecurringReimbursement extends Baseclass{


	@Test
	public void validateTotalRecurringReimbursement() throws InterruptedException {
		try {
		Fitpeoassignment fpo=new Fitpeoassignment(driver);

		fpo.clickRevenueCalculator();
		fpo.scrollTillcheckboxes();
		
		fpo.clickcheckboxone();
		fpo.clickcheckboxtwo();
		fpo.clickcheckboxthree();
		fpo.clickcheckboxfour();
		fpo.scrollTillslider();
		
		fpo.clearslider();
		Thread.sleep(1000);
		
		fpo.setslidervalue("820");
		Thread.sleep(1000);
		
		fpo.scrollTillcheckboxes();
		Thread.sleep(2000);
		String actvalue=fpo.gettextvalue();
		
		String expvalue = "Total Recurring Reimbursement for all Patients Per Month: $110700";

		String normalizedActValue = actvalue.replaceAll("\\s+", " ").trim();
		String normalizedExpValue = expvalue.replaceAll("\\s+", " ").trim();

		// Compare normalized values
		Assert.assertEquals(normalizedActValue, normalizedExpValue, "Values do not match!");

	    System.out.println("actualValue: " + normalizedActValue);
		System.out.println( "expectedValue: " + normalizedExpValue );
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
