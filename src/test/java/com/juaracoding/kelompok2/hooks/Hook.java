package com.juaracoding.kelompok2.hooks;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.drivers.utils.BrowserType;
import com.juaracoding.kelompok2.drivers.utils.Utils;
import io.cucumber.java.*;

import java.net.MalformedURLException;

public class Hook {

    @BeforeAll
    public static void initialize() throws MalformedURLException {
        DriverSingleton.getDriver(BrowserType.CHROME);

    }
    @BeforeStep
    public void beforeStep() {
        Utils.delay(1);
    }

    @AfterStep
    public void afterStep() {
        Utils.delay(1);
    }

    @AfterAll
    public static void finalTeardown() {
        DriverSingleton.quitDriver();

    }
}
