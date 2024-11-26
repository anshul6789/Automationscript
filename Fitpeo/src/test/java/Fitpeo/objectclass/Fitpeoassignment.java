package Fitpeo.objectclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fitpeoassignment {

	WebDriver ldriver;
	public Fitpeoassignment(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
 
	@FindBy(xpath="//div[@class='MuiBox-root css-70qvj9']/a/div[contains(text(), 'Revenue Calculator')]")
	WebElement revenuecalculator;
	
	@FindBy(xpath="//div[@class='MuiBox-root css-79elbk']/h4[contains(text(), 'Medicare Eligible Patients')]")
	WebElement slidersection;//scroll till here

	@FindBy(xpath="//div[@class='MuiBox-root css-j7qwjs']/span/span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']")
	WebElement adjustslider;
	
	@FindBy(xpath="//input[@type='range']")
	WebElement slider;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement inputbox;
	
	@FindBy(xpath="//div[@class='MuiBox-root css-j7qwjs']/span/span[@class='MuiSlider-rail css-3ndvyc']")
	WebElement sliderwidth;  
	
	
	@FindBy(xpath="//div[@class='MuiBox-root css-rfiegf']/div/div/p[contains(text(),'CPT-99091')]")
	WebElement scrolltillcheckboxes;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-rfiegf']/div/div/label/span[1])[1]")
	WebElement checkboxone;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-rfiegf']/div/div/label/span[1])[2]")
	WebElement checkboxtwo;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-rfiegf']/div/div/label/span[1])[3]")
	WebElement checkboxthree;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-rfiegf']/div/div/label/span[1])[8]")
	WebElement checkboxfour;
	
	@FindBy(xpath="//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao']/p[4]")
	WebElement textvalue;
	
	
	 
	public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
   

    // Method to click the revenue calculator with WebDriverWait applied
    public void clickRevenueCalculator() {
        waitForElementToBeVisible(revenuecalculator, 10); // Wait for element to be visible
        revenuecalculator.click(); // Click the element
    }
	
    public void scrollTillslider() {
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].scrollIntoView(true);", slidersection);
    }
   

    public void setSliderApproxValue(int targetValue) throws InterruptedException {
        // Get slider width in pixels
        int sliderWidth = sliderwidth.getSize().getWidth();
        System.out.println("Slider Width: " + sliderWidth);

        // Get current slider value from 'aria-valuenow'
        String currentValue = slider.getAttribute("aria-valuenow");
        System.out.println("Current Slider Value: " + currentValue);

        // Parse the current value
        int current = Integer.parseInt(currentValue);

        int valueRange = 2000; // Maximum - Minimum (2000 - 0)

        // Calculate pixels per value
        double pixelsPerValue = (double) sliderWidth / valueRange;
        System.out.println("Pixels Per Value: " + pixelsPerValue);

        // Calculate the xOffset 
        int xOffset = (int) ((targetValue - current) * pixelsPerValue);
        System.out.println("Calculated xOffset: " + xOffset);

        // Use Actions to drag the slider by xOffset
        Actions act = new Actions(ldriver);
        act.dragAndDropBy(adjustslider, xOffset, 0).perform();

        Thread.sleep(2000);

        // Verify and print the new slider value
        String updatedValue = slider.getAttribute("aria-valuenow");
        System.out.println("Updated Slider Value: " + updatedValue);

        if (Integer.parseInt(updatedValue) == targetValue) {
            System.out.println("Slider successfully set to: " + targetValue);
        } else {
            System.out.println("Slider set approximately to: " + updatedValue);
        }
    }

    
    



    public void setSliderexactvalue(int targetValue) throws InterruptedException {
        // Get the current slider value from 'aria-valuenow'
        String currentValue = slider.getAttribute("aria-valuenow");
       
        int current = Integer.parseInt(currentValue);
        int steps = targetValue - current;
        System.out.println("Steps to move: " + steps);
       
        if (steps == 0) {
            System.out.println("Slider is already at the target value: " + targetValue);
            return;
        }
       
         Thread.sleep(1000);
        // Use Actions to move the slider
        Actions actions = new Actions(ldriver);
     
        for (int i = 0; i < Math.abs(steps); i++) {
            if (steps >0) {
                          actions.sendKeys(Keys.ARROW_RIGHT).perform();
           	               Thread.sleep(1000);
        
            } else if (steps < 0) {
            	  
                           actions.sendKeys(Keys.ARROW_LEFT).perform(); 
                            Thread.sleep(1000);
              
            }else {
            	              break;
            }
                             Thread.sleep(100); 
        }

        // Verify the updated slider value
        String updatedValue = slider.getAttribute("aria-valuenow");
        System.out.println("Slider updated to: " + updatedValue);

        if (Integer.parseInt(updatedValue) == targetValue) {
            System.out.println("Slider successfully set to target value: " + targetValue);
        } else {
            System.out.println("Failed to set slider to target value. Current value: " + updatedValue);
        }
    }


    	

  public void clearslider() throws InterruptedException {
	  // Click on the input field to focus
	    inputbox.click();

	    // Clear the input field using backspace
	    String currentValue = inputbox.getAttribute("value");
	    Actions actions = new Actions(ldriver);

	  for (int i = 0; i < currentValue.length(); i++) {
	        actions.sendKeys(Keys.BACK_SPACE).perform();  // Remove each character
	        Thread.sleep(200);  // Optional delay for smoother clearing
	    }

   	}
 
   public void setslidervalue(String value) throws InterruptedException {
	  inputbox.sendKeys(value);
	  Thread.sleep(3000);
	 
   }
   

public String getslidervalue() {
   return   slider.getAttribute("aria-valuenow");
   
}

public void scrollTillcheckboxes() {
    JavascriptExecutor js = (JavascriptExecutor) ldriver;
    js.executeScript("arguments[0].scrollIntoView(true);", scrolltillcheckboxes );
    }

 public void clickcheckboxone() {
	  waitForElementToBeVisible(checkboxone, 3); 
	  checkboxone.click();
  }
  
  public void clickcheckboxtwo() {
	  waitForElementToBeVisible(checkboxtwo, 3); 
	  checkboxtwo.click();
  }
  
  public void clickcheckboxthree() {
	  waitForElementToBeVisible(checkboxthree, 3); 
	  checkboxthree.click();
  }  
   
  public void clickcheckboxfour() {
	  waitForElementToBeVisible(checkboxfour, 3); 
	  checkboxfour.click();
  }
  
  public String gettextvalue() {
	  return textvalue.getText();
  }
	
	
	
}
    

	
	

