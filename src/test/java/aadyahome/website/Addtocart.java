package aadyahome.website;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Addtocart {

    WebDriver driver;

    @BeforeTest
    public void setup() {
     
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4000));
        
        driver.get("https://aadyaa.com/search?q=Silver+Mangalsutra"); 
    }

    @Test
    public void addToCartTest() {
    	
    	WebElement popup1=driver.findElement(By.xpath("(//a[@class='qsk-popup__close'])[1]"));
		popup1.click();
		
		
        // Navigate to the product page
        WebElement productLink = driver.findElement(By.linkText("Silver Mangalsutra")); 
        productLink.click();
        
        

        // Click the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")); 
        addToCartButton.click();
        
       
        // Wait for the cart page to load (you may need to implement a wait)
        // Use an assertion to check if the cart page is displayed
       // WebElement cartPageHeader = driver.findElement(By.xpath("//xpath/to/cart-page-header"));
      //  Assert.assertTrue(cartPageHeader.isDisplayed(), "Cart page is not displayed after clicking Add to Cart button"); 
      
         

        // Perform assertions to verify that the item is added to the cart
        WebElement cartItemCount = driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")); // Replace with the actual cart item count element
        //int itemCount = Integer.parseInt(cartItemCount.getText());
       // assert itemCount > 0 : "Item was not added to the cart.";
       // Assert.assertEquals(1,itemCount);
        
       String x= cartItemCount.getAttribute("value");
       Assert.assertEquals("1",x);
      
        
        //WebElement checkoutButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[16]")); 
        //checkoutButton.click();
    }

    // You can add more test methods for further testing scenarios

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
