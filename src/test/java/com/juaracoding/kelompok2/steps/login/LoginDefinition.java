package com.juaracoding.kelompok2.steps.login;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.pages.dashboard.DashboardPage;
import com.juaracoding.kelompok2.pages.login.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginDefinition {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @Before()
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

        @Given("I am on the admin login page")
    public void goToSignInPage(){
        loginPage.openPage();
    }

    @When("In admin login page I enter email {string}")
    public void enterUsername(String email){
        loginPage.fillEmail(email);
    }

    @And("In admin login page I enter password {string}")
    public void enterPassword(String password){
        loginPage.fillPassword(password);
    }

    @And("In admin login page I click login button")
    public void clickLogin(){
        loginPage.clickMasukButton();
    }

    @Then("I succesfully admin login and get {string}")
    public void successfullyLogin(String expectedHadir){
        String pageTitle = dashboardPage.getHadirTitle();
        Assert.assertEquals(pageTitle, expectedHadir);
    }
}

