package cucumberTests.PedasysWrittenTest.testRunner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseFile {
		public static WebDriver driver;
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static String getProp(String Property) {
		Properties prop=new Properties();
		 FileInputStream fis;
		try {
			fis = new FileInputStream("G:\\Selenium2021\\PedasysWrittenTest\\Data.properties");
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String prop1=prop.getProperty(""+Property+"");
		
		return prop1;
	}
	
	public static void isURLWorking(String url){

		HttpURLConnection huc = null;
		int respCode = 200;
		boolean working=true;
	
		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			if(respCode >= 400){
				System.out.println(url +" is not working. Response code is "+ respCode);
			}
			else{
				System.out.println(url +" is working. Response code is "+ respCode);	}

			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

			}
		
		
		
		

}
