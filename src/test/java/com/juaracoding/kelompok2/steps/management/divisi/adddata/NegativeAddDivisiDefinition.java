package com.juaracoding.kelompok2.steps.management.divisi.adddata;

import com.juaracoding.kelompok2.drivers.DriverSingleton;

import com.juaracoding.kelompok2.pages.divisi.AddDivisiPage;


import com.juaracoding.kelompok2.pages.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NegativeAddDivisiDefinition {


    private WebDriver driver;
    private AddDivisiPage addDivisiPage;
    private FilteringDivisiPage filteringDivisiPage;

    @Before
    public void setup() {
        // Setup driver dan page objects sebelum setiap scenario
        driver = DriverSingleton.getDriver();
        addDivisiPage = new AddDivisiPage(driver);
        filteringDivisiPage = new FilteringDivisiPage(driver);
    }

    @And("User leaves divisi name empty")
    public void userLeavesDivisiNameEmpty() {
        addDivisiPage.clearNamaDivisi();
    }


    @Then("The divisi {string} should not be added")
    public void theDivisiShouldNotBeAdded(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
        filteringDivisiPage.clickSearchButton();
        boolean isFound = filteringDivisiPage.isDivisiFound(divisiName);
        Assert.assertFalse(isFound, "Divisi '" + divisiName + "' seharusnya tidak muncul di hasil pencarian.");
    }

    @And("The divisi {string} already exists in the system")
    public void theDivisiAlreadyExistsInTheSystem(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
        filteringDivisiPage.clickSearchButton();
    }

    @Then("An error message should appear indicating the divisi {string} already exists")
    public void anErrorMessageShouldAppearIndicatingTheDivisiAlreadyExists(String divisiName) {
        boolean isErrorDisplayed = addDivisiPage.isErrorMessageDuplicateDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message for duplicate divisi name should appear.");
    }

    @Then("An error or validation message should appear for invalid characters")
    public void anErrorOrValidationMessageShouldAppearForInvalidCharacters() {
        boolean isValidationDisplayed = addDivisiPage.isValidationMessageDisplayedForInvalidFormat();
        Assert.assertTrue(isValidationDisplayed, "Validation message for invalid characters should appear.");

    }

    @Then("An error or validation message should appear for invalid name format")
    public void anErrorOrValidationMessageShouldAppearForInvalidNameFormat() {
        boolean isValidationDisplayed = addDivisiPage.isValidationMessageDisplayedForInvalidFormat();
        Assert.assertTrue(isValidationDisplayed, "Validation message for invalid name format should appear.");
    }
}