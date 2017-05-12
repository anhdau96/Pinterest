/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author SaiBack
 */
public class TorBrower {

    FirefoxDriver driver;
    FirefoxBinary binary;

    public FirefoxDriver getTorDriver() {
        File torProfileDir = new File("Tor Browser\\Browser\\TorBrowser\\Data\\Browser\\profile.default");
        binary = new FirefoxBinary(new File("Tor Browser\\Browser\\firefox.exe"));
        FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);
        torProfile.setPreference("webdriver.load.strategy", "unstable");

        try {
            binary.startProfile(torProfile, torProfileDir, "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "127.0.0.1");
        profile.setPreference("network.proxy.socks_port", 9150);
        profile.setPreference("browser.privatebrowsing.autostart", true);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", true);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        profile.setPreference("places.history.enabled", false);
        profile.setPreference("privacy.clearOnShutdown.offlineApps", true);
        profile.setPreference("privacy.clearOnShutdown.passwords", true);
        profile.setPreference("privacy.clearOnShutdown.siteSettings", true);
        profile.setPreference("privacy.sanitize.sanitizeOnShutdown", true);
        profile.setPreference("signon.rememberSignons", false);
        profile.setPreference("network.cookie.lifetimePolicy", 2);
        profile.setPreference("network.dns.disablePrefetch", true);
        profile.setPreference("network.http.sendRefererHeader", 0);
        profile.setPreference("network.proxy.socks_remote_dns", true);
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver(profile);
        return driver;
    }

    public void quitTor() {
        binary.quit();
        driver.quit();
    }
}
