package com.bases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ScreenshotBaseClassLogin {
  public static WebDriver driver;
    ChromeOptions options;

    public static void initilaization(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver= new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
    }

    public static void close() {

        driver.quit();
    }


public void failed (String getMethodName){

    File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try{
        File f = new File("C:/Workspace/GenerateLogs/src/main/resources/ScreenShot/"+getMethodName+"_"+System.currentTimeMillis()+".jpg");
        if(f.exists()){
                f.delete();
        }
        FileUtils.copyFile(sourceFile,new File("C:/Workspace/GenerateLogs/src/main/resources/ScreenShot/"+getMethodName+"_"+System.currentTimeMillis()+".jpg"));
    }catch (Exception e){
        e.printStackTrace();
    }

}





}
