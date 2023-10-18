package aadyahome.website;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchingProduct {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://aadyaa.com/");
    }

    @Test
    public void navigateToAadyaWebsite() {
       
    	WebElement popup1=driver.findElement(By.xpath("(//a[@class='qsk-popup__close'])[1]"));
		popup1.click();
		
        WebElement search =  driver.findElement(By.xpath("//a[@href=\"/search\"]"));
		search.click();
		 
		WebElement searchBox=driver.findElement(By.xpath("//input[@type=\"search\"]"));
		searchBox.sendKeys("Silver Mangalsutra",Keys.ENTER);
		
		
		
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

