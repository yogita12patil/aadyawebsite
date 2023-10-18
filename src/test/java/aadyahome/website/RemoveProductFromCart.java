package aadyahome.website;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveProductFromCart {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
        
        driver.get("https://aadyaa.com/search?q=Silver+Mangalsutra"); 
      
    }

    @Test
    public void removeProductFromCart() {
        // Locate and click on the cart icon (assumes it's an element with an "id" attribute)
      //  WebElement cartIcon = driver.findElement(By.id("cartIconId"));
      //  cartIcon.click();
        
    	WebElement popup1=driver.findElement(By.xpath("(//a[@class='qsk-popup__close'])[1]"));
		popup1.click();
        
		   // Navigate to the product page
        WebElement productLink = driver.findElement(By.linkText("Silver Mangalsutra")); 
        productLink.click();
        
        

        // Click the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")); 
        addToCartButton.click();
        
		
    	//WebElement cartIcon=driver.findElement(By.xpath("(//a[@class='relative'])[1]"));
    	//cartIcon.click();
    	
    	

        // Locate the remove button for the product you want to remove and click it
       // WebElement removeButton = driver.findElement(By.id("removeButtonId"));
        //removeButton.click();

    	WebElement removeButton = driver.findElement(By.xpath("(//a[@class='link text-xs'])[1]"));
        removeButton.click();
    	
        
        
        // You can also add assertions to verify that the product is removed successfully
        // For example, you can check if a message is displayed indicating a successful removal.
        // WebElement confirmationMessage = driver.findElement(By.id("confirmationMessageId"));
        //Assert.assertTrue(confirmationMessage.getText().contains("Product removed successfully"));
    }

    @AfterTest
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
