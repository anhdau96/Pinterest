/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author SaiBack
 */
public class MyDriver {

    private WebDriver driver;

    public WebDriver getDriver() {
//        System.setProperty("phantomjs.binary.path", "phantomjs.exe");
//        List<String> cliArgsCap = new ArrayList<>();
//        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//        cliArgsCap.add("--web-security=true");
//        cliArgsCap.add("--ssl-protocol=any");
//        cliArgsCap.add("--ignore-ssl-errors=true");
//        cliArgsCap.add("--load-images=false");
//        capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, false);
//        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
//        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
//        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"phantomjs.exe");
//        driver = new PhantomJSDriver(capabilities);

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setJavascriptEnabled(true);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(caps);
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
