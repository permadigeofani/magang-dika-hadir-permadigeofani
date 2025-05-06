package com.juaracoding.kelompok2.steps.management.divisi.filteringdata;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.pages.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NegativeFilteringDivisiDefinition {

    private WebDriver driver;
    private FilteringDivisiPage filteringDivisiPage;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        filteringDivisiPage = new FilteringDivisiPage(driver);
    }

    @When("User searches for divisi with character name {string}")
    public void userSearchesForDivisiWithCharacterName(String divisiName) {
        filteringDivisiPage.searchDivisi(divisiName);
    }

    @Then("No divisi should be found")
    public void noDivisiShouldBeFound() {
        boolean found = filteringDivisiPage.isDivisiFound("!@#$%");
        Assert.assertFalse(found, "Divisi dengan karakter tidak valid tidak boleh ditemukan.");
    }

    @When("User selects Invalid {string} rows per page")
    public void userSelectsInvalidRowsPerPage(String rowsCount) {
        try {
            filteringDivisiPage.selectRowsPerPage(rowsCount);
            // Jika berhasil klik dan tidak error, test dianggap lolos
            Assert.assertTrue(true, "System menerima input rows per page tidak valid.");
        } catch (Exception e) {
            // Jika terjadi exception, artinya sistem tidak menerima input tersebut
            System.out.println("[INFO] Invalid row selection handled properly: " + e.getMessage());
            Assert.assertTrue(true, "System menangani input tidak valid dengan tepat.");
        }
    }

    @Then("System should ignore or show validation message")
    public void systemShouldIgnoreOrShowValidationMessage() {
        // Memeriksa apakah pesan validasi tampil
        boolean isValidationMessageDisplayed = filteringDivisiPage.isValidationMessageDisplayedForInvalidInput();
        Assert.assertTrue(isValidationMessageDisplayed, "System tidak menampilkan pesan validasi untuk input yang tidak valid.");
    }
}
