package com.juaracoding.kelompok2.drivers.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager {
    public static WebDriver make() {
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--start-maximized");

        return new FirefoxDriver(options);
    }
}