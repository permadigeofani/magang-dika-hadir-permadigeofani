package com.juaracoding.kelompok2.drivers.strategies;

import com.juaracoding.kelompok2.drivers.managers.ChromeDriverManager;
import com.juaracoding.kelompok2.drivers.managers.FirefoxDriverManager;
import com.juaracoding.kelompok2.drivers.utils.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverStrategyImplementer implements IDriverStrategy {

    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }
}