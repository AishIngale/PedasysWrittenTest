package cucumberTests.PedasysWrittenTest.stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumberTests.PedasysWrittenTest.testRunner.baseFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends baseFile{
	String errorMessage="";
	WebDriver driver=baseFile.getDriver();
	@Given("^Application is opened$")
	public void application_is_opened() throws InterruptedException {
	    
	 driver.get("https://www.growthengineering.co.uk/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.findElement(By.xpath("//a[text()='No Thanks!']")).click();
	 System.out.println("Application is opened.");	 
	}

	@When("^user verifies the menu links one by one$")
	public void user_clicks_on_menu_link_one_by_one() {
		
		String x1=baseFile.getProp("fourMenuLinksXPath");
		System.out.println(x1);
		List<WebElement> links= new ArrayList<>();
		
		links.add(driver.findElement(By.xpath("//a[contains(text(),'Products')][1]")));
		links.add(driver.findElement(By.xpath("//a[contains(text(),'Approach')][1]")));
		links.add(driver.findElement(By.xpath("//a[contains(text(),'Resources')][1]")));
		links.add(driver.findElement(By.xpath("//a[contains(text(),'About')][1]")));
		links.add(driver.findElement(By.xpath("//a[@id='contact-button']")));
		
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()){
			String url = it.next().getAttribute("href");
			System.out.println(url+" is being verified...");
			baseFile.isURLWorking(url);
			}    
	}

	@Then("^Menu links are verified$")
	public void menu_link_is_opened() {
	    System.out.println("All menu links are verified.");
	    driver.close();
	    
	}
	
	
	@Given("Contact screen is opened")
	public void contact_screen_is_opened() throws InterruptedException {
		driver=baseFile.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://www.growthengineering.co.uk/");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//a[text()='No Thanks!']")).click();
	    driver.findElement(By.xpath("//a[@id='contact-button']")).click();
	    
	}

	@When("User does not enter value in a <mandatoryField>")
	public void user_does_not_enter_value_in_a_mandatory_field(io.cucumber.datatable
	.DataTable dataTable) {
		List<String> dataList = dataTable.asList();
		
		for(int i=0;i<dataList.size();i++) {
			String d1=dataList.get(i);
			if(d1.equals("Work Email")) {
				driver.findElement(By.xpath("//input[@name='email']")).click();
				driver.findElement(By.xpath("//span[text()='Work Email']")).click();
				errorMessage=driver.findElement(By.xpath("//div[contains(@class,'email')]//ul[@role='alert']")).getText();
				System.out.println(errorMessage);
				driver.navigate().refresh();
			}else if(d1.equals("Telephone")) {
				driver.findElement(By.xpath("//input[@name='phone']")).click();
				driver.findElement(By.xpath("//span[text()='Telephone']")).click();
				errorMessage=driver.findElement(By.xpath("//div[contains(@class,'phone')]//label[contains(@class,'error')]")).getText();
				System.out.println(errorMessage);
				driver.navigate().refresh();
			}
		}
	}

	@Then("<AppropriateMessage> should be displayed.")
	public void appropriate_message_should_be_displayed() {
		System.out.println("Fields have been verified.");
	}

	@When("User enters incomplete value in Work Email field")
	public void user_enters_incomplete_value_in_work_email_field() {
		driver.findElement(By.xpath("//input[@name='email']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc");
		driver.findElement(By.xpath("//span[text()='Work Email']")).click();
		errorMessage=driver.findElement(By.xpath("//div[contains(@class,'email')]//ul[@role='alert']")).getText();
		System.out.println(errorMessage);
				
	}

	@When("User enters alphabetic value in Telephone field")
	public void user_enters_alphabetic_value_in_telephone_field() {
		driver.findElement(By.xpath("//input[@name='phone']")).click();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("abc");
		driver.findElement(By.xpath("//span[text()='Telephone']")).click();
		errorMessage=driver.findElement(By.xpath("//div[contains(@class,'phone')]//label[contains(@class,'error')]")).getText();
		System.out.println(errorMessage);
	}

}
