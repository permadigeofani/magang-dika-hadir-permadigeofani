package com.juaracoding.kelompok2.pages.login;

import com.juaracoding.kelompok2.drivers.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = ".MuiButton-root")
    private WebElement masukButton;


    public void openPage() {
        driver.get(Constants.URL);
    }

    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickMasukButton() {
        masukButton.click();
    }

    public void loginActivity(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickMasukButton();
    }
}
