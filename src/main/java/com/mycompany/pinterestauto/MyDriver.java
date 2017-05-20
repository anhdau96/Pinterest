/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author SaiBack
 */
public class MyDriver {

    private WebDriver driver;

    public WebDriver getDriver() {
        //String pathToExtension = "C:\\Users\\SaiBack\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gjknjjomckknofjidppipffbpoekiipm\\4.4.1_0";
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("extension.crx"));
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        //caps.setJavascriptEnabled(false);
        
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(caps);
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
