package com.juaracoding.kelompok2.steps.management.divisi.filteringdata;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.pages.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PositiveFiteringDivisiDefinition {

    private WebDriver driver;
    private FilteringDivisiPage filteringDivisiPage;

    @Before
    public void setup() {
        // Initialize driver and page object before each scenario
        driver = DriverSingleton.getDriver();
        filteringDivisiPage = new FilteringDivisiPage(driver);
    }

    @When("User searches for divisi with name {string}")
    public void userSearchesForDivisiWithName(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
    }

    @And("User clicks the search button")
    public void userClicksTheSearchButton() {
        filteringDivisiPage.clickSearchButton();
    }

    @Then("Divisi with name {string} should be found")
    public void divisiWithNameShouldBeFound(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
        boolean found = filteringDivisiPage.isDivisiFound(divisiName);
        Assert.assertTrue(found, "Divisi '" + divisiName + "' was not found.");
    }

    @And("User clicks the reset button")
    public void userClicksTheResetButton() {
        filteringDivisiPage.clickResetButton();
    }

    @Then("Divisi with name {string} should not be found")
    public void divisiWithNameShouldNotBeFound(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
        boolean found = filteringDivisiPage.isDivisiFound(divisiName);
        Assert.assertFalse(found, "Divisi '" + divisiName + "' should not be found after reset.");
    }

    @When("User selects {string} rows per page")
    public void userSelectsRowsPerPage(String rowsCount) {
        filteringDivisiPage.selectRowsPerPage(rowsCount);
    }

    @Then("The number of rows displayed should be {string}")
    public void theNumberOfRowsDisplayedShouldBe(String expectedCount) {
        int displayedCount = filteringDivisiPage.getDisplayedRowCount();
        Assert.assertEquals(displayedCount, Integer.parseInt(expectedCount), "The number of rows displayed does not match the expected count.");
    }
}
