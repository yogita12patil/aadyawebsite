package aadyahome.website;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckOut {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
     
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4000));
        
        driver.get("https://aadyaa.com/search?q=Silver+Mangalsutra"); 
    }

    @Test
    public void checkoutProcess() {
       
    	WebElement popup1=driver.findElement(By.xpath("(//a[@class='qsk-popup__close'])[1]"));
		popup1.click();
		
		
        // Navigate to the product page
        WebElement productLink = driver.findElement(By.linkText("Silver Mangalsutra")); 
        productLink.click();
        
        

        // Click the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")); 
        addToCartButton.click();
        
       // WebElement popup11=driver.findElement(By.xpath("(//a[@class='qsk-popup__close'])[1]"));
		//popup11.click();
        
        // Locate and click the checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[13]")); 
        checkoutButton.click();

        // Fill in the required information in the checkout form
        
        WebElement emailField = driver.findElement(By.id("email")); 
        emailField.sendKeys("yogitabirnale6@gmail.com");

        
        WebElement countryDropdown = driver.findElement(By.id("Select0"));
        // Create a Select object for the dropdown.
        Select select = new Select(countryDropdown);
        // Select the country by its visible text. 
        select.selectByVisibleText("YourCountry");
        // You can also select the country by  value.
         select.selectByValue("India"); 
        
        WebElement firstNameField = driver.findElement(By.id("TextField1")); 
        firstNameField.sendKeys("Yogita");

        WebElement lastNameField = driver.findElement(By.id("TextField2")); 
        lastNameField.sendKeys("Patil");

        WebElement companyField = driver.findElement(By.id("TextField3"));
        companyField.sendKeys("Append");
        
      
        WebElement addressField = driver.findElement(By.id("shipping-address1-options")); 
        addressField.sendKeys("Katraj");
        
        WebElement address2Field  = driver.findElement(By.id("TextField4")); 
        address2Field.sendKeys("D2,702,LakeTown");
        
        WebElement cityField  = driver.findElement(By.id("TextField5")); 
        cityField.sendKeys("Pune");
        
        
        WebElement stateDropdown = driver.findElement(By.id("Select1"));
        // Create a Select object for the dropdown.
        Select select1 = new Select(stateDropdown);
        // Select the country by its visible text. 
        select1.selectByVisibleText("State");
        // You can also select the country by  value.
         select1.selectByValue("Maharastra"); 
        
         WebElement postalCodeField  = driver.findElement(By.id("TextField6")); 
         postalCodeField.sendKeys("411037");
         
         WebElement phoneField  = driver.findElement(By.id("TextField7")); 
         phoneField.sendKeys("9766028948");

         
         WebElement saveInfoCheckbox = driver.findElement(By.id("save_shipping_information"));

         // Check the checkbox if it's not already checked.
         if (!saveInfoCheckbox.isSelected()) {
             saveInfoCheckbox.click();
         }
         
         
         WebElement ContinuetoshippingButton = driver.findElement(By.xpath("(//a[@class='QT4by _1fragemf4 rqC98 hodFu _7QHNJ VDIfJ j6D1f janiy'])[1]")); // Replace with the actual button identifier
         ContinuetoshippingButton.click();
         
        // Perform any other actions, such as selecting payment method and submitting the order

        // Add assertions or verifications to ensure the process was successful
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
