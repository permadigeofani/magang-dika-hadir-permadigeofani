package com.juaracoding.kelompok2.steps.management.divisi.editdata;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.pages.divisi.EditDivisiPage;
import com.juaracoding.kelompok2.pages.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NegativeEditDivisiDefinition {

    private WebDriver driver;
    private FilteringDivisiPage filteringDivisiPage;
    private EditDivisiPage editDivisiPage;

    @Before
    public void setup() {
        // Initialize driver and page objects before each scenario
        driver = DriverSingleton.getDriver();
        filteringDivisiPage = new FilteringDivisiPage(driver);
        editDivisiPage = new EditDivisiPage(driver);
    }
    @Then("A validation message should appear for empty divisi name")
    public void aValidationMessageShouldAppearForEmptyDivisiName() {
        String actualMessage = editDivisiPage.getValidationMessageOfNamaDivisi();
        String expectedMessage = "Harap isi bidang ini.";
        Assert.assertEquals(actualMessage, expectedMessage, "Pesan validasi tidak sesuai atau tidak muncul.");
    }

    @Then("An error message should appear indicating the name already exists")
    public void anErrorMessageShouldAppearIndicatingTheNameAlreadyExists() {
        try {
            boolean warningDuplicateDisplayed = editDivisiPage.isWarningDuplicateEditDisplayed();
            Assert.assertTrue(warningDuplicateDisplayed, "Error message for duplicate divisi name was not displayed.");
        } catch (Exception e) {
            System.out.println("⚠️ Test failed on checking duplicate name error message: " + e.getMessage());
            // Boleh pakai Assert.fail jika tetap ingin tandai test gagal tapi tidak crash
            Assert.fail("Exception occurred during validation: " + e.getMessage());
        }
    }

}