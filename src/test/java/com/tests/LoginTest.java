package com.tests;

import com.bases.ScreenshotBaseClassLogin;
import com.utils.ScreenShotCustomListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(ScreenShotCustomListener.class)
public class LoginTest  extends ScreenshotBaseClassLogin {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    @BeforeMethod
    public void setUp(){
       logger.info(">>>>>>>>>>>>>>>>>START DRIVER<<<<<<<<<<<<<<<<<<<<<<<<<");
       initilaization();
       logger.info("launching the chrome browser");
   }
   @Test
   public void testInvalidLogin() throws InterruptedException {
       logger.info("entering the url for invalid login");
       logger.warn("Just warning message");
       logger.fatal("fatal message");
     //  logger.debug("this is debug message ");
       driver.findElement(By.id("login-username")).sendKeys("satyamsingh28389@gmail.co");
       driver.findElement(By.id("login-password")).sendKeys("Noc@123");
       driver.findElement(By.id("js-login-btn")).click();
       logger.info("click on login button after adding invalid username and password");

       WebElement errorMessage= driver.findElement(By.className("notification-box-description"));
       new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(errorMessage));

//        String errorString= driver.findElement(By.className("notification-box-description")).getText();
//        Assert.assertEquals(errorString,"Your email, password, IP address or location did not match");
       logger.info("After invalid login getting the error message" +errorMessage.getText());
       Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not");
   }
   @Test
    public void tesValidLogin() throws InterruptedException {
        driver.get("https://app.vwo.com/#/login");
       logger.info("entering the url for valid login");
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys("satyam@neert.com");
        driver.findElement(By.id("login-password")).sendKeys("Noc@1235");
        driver.findElement(By.id("js-login-btn")).click();
       logger.info("click on login button after adding valid username and password");
        //Thread.sleep(3000);
        //new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("https://app.vwo.com/#/dashboard?accountId=1129170"));
        // Assert.assertEquals(driver.getTitle(),"Dashboard");
        // Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/dashboard");
    }
   @AfterMethod
    public void tearDown(){
       close();
       logger.info(">>>>>>>>>>>>>>>>>CLOSED DRIVER<<<<<<<<<<<<<<<<<<<<<<<<<" );
   }


}
