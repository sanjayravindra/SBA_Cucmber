package stepDefs;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.*;



public class StepDefinition {
		
		WebDriver driver;
		
		@Given("^Browser is launched and user is on application page$")
		public void set_up() throws Throwable {
			
			
			
		/***************************** Block of code to execute in Chrome Browser***************************/   
			try {
				
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Cucumber\\Driver\\geckodriver.exe");
	    		FirefoxBinary firefoxBinary = new FirefoxBinary();
	    		firefoxBinary.addCommandLineOptions("--headless");
	    	    FirefoxProfile profile=new FirefoxProfile();
	    	    //profile.setPreference("marionette.logging", "TRACE");
	    		FirefoxOptions firefoxOptions = new FirefoxOptions();
	    		firefoxOptions.setBinary(firefoxBinary);
	    		firefoxOptions.setProfile(profile);
	    	    driver=new FirefoxDriver(firefoxOptions);
				 			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		   
		    driver.get("http://webapps.tekstac.com/CucumberHostelFeeCalc/");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/**************************************************************************************************/
		
			/**************************** Code to execute in Firefox **************************************/
			/*driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://apps.qa2qe.cognizant.e-box.co.in/CucumberHostelFeeCalc/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
		/*****************************************************************************************************/	
			
		    
		}
		
		@When("^User Enters student name,\"([^\"]*)\",\"([^\"]*)\"$")
		public void enter_details(String student_type, String no_of_rooms) throws Throwable {
		   //Please fill the required codes
		   driver.findElement(By.id("name")).sendKeys("Sowmya");
		   driver.findElement(By.xpath("//input[@name='type'])[1]")).sendKeys(student_type);
		   driver.findElement(By.id("number")).sendKeys(no_of_rooms);
		}
		
		@When("^User clicks on the calculate fee  button$")
		public void submit_details() throws Throwable {
		    //Please fill the required codes
		    driver.findElement(By.id("getFee")).click();
		}
		
		@Then("^\"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" should be correctly displayed$")
		public void verify_details(String college_fee, String hostel_fee, String additional_fee,String total_fee) throws Throwable {
		   //Please fill the required codes
		   String collegeFee = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		   String hostelFee = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		   String additionalFee = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
		   String totalFee = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText();
		   Assert.assertEquals(collegeFee,college_fee);
		   Assert.assertEquals(hostelFee,hostel_fee);
		   Assert.assertEquals(additionalFee,additional_fee);
		   Assert.assertEquals(totalFee,total_fee);
		   
		}
		
		@After
		public void tearDown() {
			
			driver.close();
		}
}
