package com.juaracoding.kelompok2.pages.divisi;

import com.juaracoding.kelompok2.drivers.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteDivisiPage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@role='menu']//li[@role='menuitem' and contains(text(), 'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//h2[text()='Hapus Divisi']/following::p[1]")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//h2[text()='Hapus Divisi']/following::button[.='Ya']")
    private WebElement yaButton;

    @FindBy(xpath = "//h2[text()='Hapus Divisi']/following::button[.='Tidak']")
    private WebElement tidakButton;

    @FindBy(id = "errorNonExistentDivisi")
    private WebElement errorNonExistentDivisi;

    @FindBy(css = "div.MuiSnackbarContent-message")
    private WebElement successDeleteMessage;

    public DeleteDivisiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickThreeDotButton(String divisiName) {
        String xpath = "//tr[.//h6[contains(normalize-space(), '" + divisiName + "')]]//button[@aria-label='action']";
        Utils.clickElement(driver, By.xpath(xpath));
    }

    public void clickDelete() {
        Utils.clickElement(driver, deleteButton);
    }

    public String getDeleteConfirmationText() {
        return confirmationMessage.getText();
    }

    public void clickYa() {
        Utils.clickElement(driver, yaButton);
    }

    public void clickTidak() {
        Utils.clickElement(driver, tidakButton);
    }

    public boolean errorNonExistentDivisiDisplayed() {
        return Utils.isElementVisible(driver, By.id("errorNonExistentDivisi"));
    }

    public boolean isDivisiListed(String divisiName) {
        String xpath = "//td[contains(.,'" + divisiName + "')]";
        return Utils.isElementVisible(driver, By.xpath(xpath));
    }

    public String getSuccessDeleteMessage() {
        WebElement messageElement = Utils.waitUntilVisible(driver, By.cssSelector("div.MuiSnackbarContent-message"));
        return messageElement != null ? messageElement.getText() : null;
    }
}
