package com.juaracoding.kelompok2.steps.management.divisi.deletedata;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.pages.divisi.DeleteDivisiPage;

import com.juaracoding.kelompok2.pages.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NegativeDeleteDivisiDefinition {

        private WebDriver driver;
        private FilteringDivisiPage filteringDivisiPage;
        private DeleteDivisiPage deleteDivisiPage;

        @Before
        public void setup() {
            driver = DriverSingleton.getDriver();
            filteringDivisiPage = new FilteringDivisiPage(driver);
            deleteDivisiPage = new DeleteDivisiPage(driver);
        }

        @And("User cancels deletion by clicking Tidak")
        public void userCancelsDeletionByClickingTidak() {deleteDivisiPage.clickTidak();}

        @Then("Divisi {string} should still be listed")
        public void divisiShouldStillBeListed(String divisiName) {
            boolean isDivisiListed = deleteDivisiPage.isDivisiListed(divisiName);
            Assert.assertTrue(isDivisiListed, "Divisi '" + divisiName + "' was not found after cancellation.");
        }

        @When("User tries to delete a non-existing divisi {string}")
        public void userTriesToDeleteANonExistingDivisi(String divisiName) {
            deleteDivisiPage.clickThreeDotButton(divisiName);
            deleteDivisiPage.clickDelete();
        }

        @Then("An error or not found message should appear")
        public void anErrorOrNotFoundMessageShouldAppear() {
            boolean errorDisplayed = deleteDivisiPage.errorNonExistentDivisiDisplayed();
            Assert.assertTrue(errorDisplayed, "Error message for non-existent divisi was not displayed.");
        }
    }
