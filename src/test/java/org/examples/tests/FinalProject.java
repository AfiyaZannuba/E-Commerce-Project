package org.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FinalProject {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

//        LOGIN TO THE SITE
        driver.get("http://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("input-email")).sendKeys("afiya@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("afiya@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

//        GOING TO PRODUCTS PAGE
       WebElement Products =  driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
       WebElement ProductsLink =  driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
       Actions actions = new Actions(driver);
       actions.moveToElement(Products).click(ProductsLink).build().perform();

//       ADDING MACBOOK AIR AND MACBOOK PRO TO THE CART
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();

        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();


//        PERFORMING VALIDATION OF PRODUCT NAMES
       String Product1 =  driver.findElement(By.xpath("(//a[contains(@href, 'product_id=44')])[4]")).getText();
        String Product2 =  driver.findElement(By.xpath("(//a[contains(@href, 'product_id=45'))])[4]")).getText();

        if(Product1.equals("Macbook Air")) {
            System.out.println("Product1 name is displayed correctly");
        } else{
            System.out.println("You chose the wrong product, please choose Macbook Air");
        }

        if(Product2.equals("Macbook Pro")){
            System.out.println("Product2 name is displayed correctly");
        }else{
            System.out.println("You chose the wrong product, please choose Macbook Pro");
        }

        //Validating the total amount displayed

        String total = driver.findElement(By.xpath("(//table[@class=\"table table-bordered\"])[3]//tr[4]//td[2]")).getText();
        if(total.equals("$3,202.00")){
            System.out.println("Eligible for reimbursement ");
        }else{
            System.out.println("Total Amount doesn't match with the bill");
        }

        driver.findElement(By.xpath("//a[text()='Checkout']")).click();
        driver.quit();

    }
}
