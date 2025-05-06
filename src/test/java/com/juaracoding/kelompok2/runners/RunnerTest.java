package com.juaracoding.kelompok2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/md",

        },
        glue = {
                "com.juaracoding.kelompok2.steps",
                "com.juaracoding.kelompok2.hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        }
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}