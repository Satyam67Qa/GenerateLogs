package com.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProFromConfig  {

    private static final Logger logger = LogManager.getLogger(ReadProFromConfig.class);
    public static void main(String[] args) throws IOException {
        WebDriver driver = null;
        Properties properties = new Properties();
        String filename = System.getProperty("user.dir") + "/config.properties";
        properties.load(new FileInputStream(filename));
        String webApp = properties.getProperty("url");
        System.out.println(webApp);
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));

        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome"))
        {
             driver= new ChromeDriver();
             logger.info("launch the chrome");

        } else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            logger.info("launch the firefox");

        }else
        {
            System.out.println("no browser value is given");
            logger.warn("no browser value is given");
        }
        
        driver.get(webApp);
        logger.info("launch the VWO app .."+webApp);
        driver.findElement(By.id(properties.getProperty("username_login"))).clear();
        driver.findElement(By.id(properties.getProperty("username_login"))).sendKeys(properties.getProperty("username"));
        driver.findElement(By.id(properties.getProperty("password_login"))).sendKeys(properties.getProperty("password"));
        driver.findElement(By.id(properties.getProperty("button_login"))).click();

        driver.quit();
    }}
