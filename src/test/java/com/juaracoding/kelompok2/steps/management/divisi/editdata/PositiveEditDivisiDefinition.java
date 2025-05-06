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

public class PositiveEditDivisiDefinition {


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

    @When("User clicks the three dot button for divisi {string}")
    public void userClicksTheThreeDotButtonForDivisi(String divisiName) {
        editDivisiPage.clickThreeDotButton(divisiName);
    }

    @And("User clicks the \"Edit\" button")
    public void userClicksTheEditButton() {
        editDivisiPage.clickEditButton();
    }

    @And("User edits the divisi name to {string}")
    public void userEditsTheDivisiNameTo(String newDivisiName) {
        editDivisiPage.inputNamaDivisi(newDivisiName);
    }

    @And("User clicks the \"Simpan\" button")
    public void userClicksTheSimpanButton() {
        editDivisiPage.clickSimpan();
    }

    @Then("The success message after editing should display {string}")
    public void theSuccessMessageAfterEditingShouldDisplay(String expectedMessage) {
        String actualMessage = editDivisiPage.getSuccessEditMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Pesan sukses edit tidak sesuai atau tidak muncul.");

    }

}