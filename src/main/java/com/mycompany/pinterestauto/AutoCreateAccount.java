/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import model.Account;
import dbcontroller.AccountController;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author SaiBack
 */
public class AutoCreateAccount {

    public static void main(String[] args) {
        AutoCreateAccount account = new AutoCreateAccount();
        for (int i = 0; i < 17; i++) {
            String randomAcc = account.randomAcc();
            account.createAccount(String.valueOf(System.currentTimeMillis()) + "@" + randomAcc + ".com", "Tshirt1234");
        }
//        account.createAccount("1494046367650@ijvbljyaxnmdpgu.com", "Tshirt1234");
    }

    public String randomAcc() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public void createAccount(String acc, String password) {
        TorBrower myDriver = new TorBrower(); //su dung tor
        FirefoxDriver driver = myDriver.getTorDriver();
//        MyDriver myDriver = new MyDriver(); // Su dung chrome 
//        WebDriver driver = myDriver.getDriver(); // Su dung chrome 
        driver.get("https://www.pinterest.com/");
        WebElement userName = driver.findElement(By.name("id"));
        userName.sendKeys(acc);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(password);
        WebElement submit = driver.findElement(By.cssSelector("button[class='red SignupButton active']"));
        submit.submit();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AutoCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement age = driver.findElement(By.name("age"));
        WebElement fullName = driver.findElements(By.tagName("input")).get(0);
        fullName.sendKeys("Sun Tshirt");
        age.sendKeys("25");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        WebElement register = driver.findElement(By.cssSelector("button[class='red comeOnInButton active']"));
        register.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AutoCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement skipContent = driver.findElement(By.cssSelector("button[class='noButtonStyles active']"));
            skipContent.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            List<WebElement> findElements = driver.findElements(By.cssSelector("div[class='item']"));
            for (int i = 0; i < 5; i++) {
                findElements.get(i).click();
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement done = driver.findElement(By.cssSelector("button[class='Button Module btn hasText hidden nuxModalPickerInterestButton primary rounded']"));
            done.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("div[class='optionalSkip']")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("button[class='Button Module btn confirm hasText rounded']")).click();
        } catch (Exception ex) {

        }
        driver.get("https://developers.pinterest.com/tools/access_token/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[class='primary four columns']")).click();
        driver.findElement(By.cssSelector("input[class='eight columns']")).getText();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AutoCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<String> windowHandles = driver.getWindowHandles();
        String fisrt = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            try {
                if (!windowHandle.equals(fisrt)) {
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.findElements(By.tagName("button")).get(1).click();
                    driver.close();
                }
            } catch (Exception ex) {

            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AutoCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.switchTo().window(fisrt);
        String token = driver.findElements(By.tagName("input")).get(4).getAttribute("value");
//        myDriver.quitDriver();
        myDriver.quitTor();
//        FileController controller = new FileController();
        AccountController ac = new AccountController();
        ac.create(new Account(0, acc, password, token, "0", "0"));
//        controller.writeAccountToFile(acc, password, token);

    }

//    public String getToken(String user, String password) {
//        MyDriver myDriver = new MyDriver();
//        WebDriver driver = myDriver.getDriver();
//        driver.get("https://www.pinterest.com/");
//        WebElement userName = driver.findElement(By.name("id"));
//        userName.sendKeys("tshirt@sunmmo123.com");
//        WebElement pass = driver.findElement(By.name("password"));
//        pass.sendKeys("Tshirt1234");
//        WebElement submit = driver.findElement(By.cssSelector("button[class='red SignupButton active']"));
//        submit.submit();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AutoCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return token;
//    }
}
