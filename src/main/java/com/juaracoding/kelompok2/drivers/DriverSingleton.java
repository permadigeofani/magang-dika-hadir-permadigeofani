package com.juaracoding.kelompok2.drivers;

import com.juaracoding.kelompok2.drivers.strategies.DriverStrategyImplementer;
import com.juaracoding.kelompok2.drivers.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = new DriverStrategyImplementer().setStrategy(browser);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.TIMEOUT));
            wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
            System.out.println("WebDriver initialized with browser: " + browser);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call getDriver(String browser) first.");
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            throw new IllegalStateException("WebDriverWait is not initialized. Call getDriver(String browser) first.");
        }
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
            System.out.println("WebDriver has been quit.");
        }
    }
}
