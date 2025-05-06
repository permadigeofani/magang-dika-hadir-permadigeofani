package com.juaracoding.kelompok2.drivers.strategies;

import org.openqa.selenium.WebDriver;

public interface IDriverStrategy {
    WebDriver setStrategy(String strategy);
}