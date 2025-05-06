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

public class PositiveAddDivisiDefinition {

    private WebDriver driver;
    private AddDivisiPage addDivisiPage;
    private FilteringDivisiPage filteringDivisiPage;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        addDivisiPage = new AddDivisiPage(driver);
        filteringDivisiPage = new FilteringDivisiPage(driver);
    }

    @When("User clicks on the Tambahkan button to add divisi")
    public void userClicksOnTheTambahkanButtonToAddDivisi() {
        addDivisiPage.clickTambahkanButton();
    }

    @And("User inputs {string} into the Nama Divisi field")
    public void userInputsIntoTheNamaDivisiField(String divisiName) {
        addDivisiPage.inputNamaDivisi(divisiName);
    }

    @And("User clicks on the Tambah button")
    public void userClicksOnTheTambahButton() {
        addDivisiPage.clickTambahButton();
    }

    @And("The success message after add new divisi should display {string}")
    public void theSuccessMessageAfterAddNewDivisiShouldDisplay(String expectedMessage) {
        String actualMessage = addDivisiPage.getSuccessAddDivisiMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Pesan sukses tambah tidak sesuai atau tidak muncul.");


    }

    @Then("The divisi {string} should be added successfully")
    public void theDivisiShouldBeAddedSuccessfully(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
        filteringDivisiPage.clickSearchButton();
        boolean isFound = filteringDivisiPage.isDivisiFound(divisiName);
        Assert.assertTrue(isFound, "Divisi '" + divisiName + "' should appear in search results.");
    }
}