package com.juaracoding.kelompok2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/divisi",

        },
        glue = {
                "com.juaracoding.kelompok2.steps",
                "com.juaracoding.kelompok2.hooks"
        },
        plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", }
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}