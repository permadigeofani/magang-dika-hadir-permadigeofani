package com.juaracoding.kelompok2.drivers.utils;

public class BrowserType {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    // mencegah instantiate
    private BrowserType() {
        throw new UnsupportedOperationException("This is a constant class and cannot be instantiate");
    }
}