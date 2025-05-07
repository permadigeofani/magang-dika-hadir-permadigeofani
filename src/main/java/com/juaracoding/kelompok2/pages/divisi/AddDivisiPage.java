package com.juaracoding.kelompok2.pages.divisi;

import com.juaracoding.kelompok2.drivers.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDivisiPage {

    private WebDriver driver;

    // ========== LOCATORS ==========
    @FindBy(xpath = "//button[normalize-space(text())='Tambahkan']")
    private WebElement btnTambahkan;

    @FindBy(css = "input#name[name='name'][placeholder='Nama Divisi']")
    private WebElement inputNamaDivisi;

    @FindBy(xpath = "//div[contains(@class, 'MuiDialogActions-root')]//button[text()='Tambah']")
    private WebElement btnTambah;


    @FindBy(css = "button[normalize-space(text())='Batal']")
    private WebElement btnBatal;

    // Validation messages
    @FindBy(css = "div.MuiFormHelperText-root:contains('Nama Divisi is required')")
    private WebElement warningNamaDivisiRequired;

    @FindBy(css = "div.MuiSnackbarContent-message:contains('sudah ada')")
    private WebElement errorMessageDuplicate;

    @FindBy(css = "div.MuiFormHelperText-root:contains('format') or div.MuiFormHelperText-root:contains('karakter')")
    private WebElement validationMessageInvalidFormat;

    @FindBy(css = "div[role='alert'] div:contains('Berhasil Menambahkan Divisi')")
    private WebElement successMessage;

    // ========== CONSTRUCTOR ==========
    public AddDivisiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ========== ACTION METHODS ==========

    public void clickTambahkanButton() {
        Utils.clickElement(driver, btnTambahkan);
    }

    public void inputNamaDivisi(String namaDivisi) {
        Utils.sendKeysToElement(driver, inputNamaDivisi, namaDivisi);
    }

    public void clearNamaDivisi() {
        Utils.sendKeysToElement(driver, inputNamaDivisi, "");
    }

    public void clickTambahButton() {
        Utils.clickElement(driver, btnTambah);
    }

    public void clickBatalButton() {
        Utils.clickElement(driver, btnBatal);
    }

    // ========== VALIDATION METHODS ==========

    public boolean isWarningMessageDisplayed() {
        return Utils.isElementVisible(driver, By.cssSelector("div.MuiFormHelperText-root:contains('Nama Divisi is required')"));
    }

    public boolean isErrorMessageDuplicateDisplayed() {
        return Utils.isElementVisible(driver, By.cssSelector("div.MuiSnackbarContent-message:contains('sudah ada')"));
    }

    public boolean isValidationMessageDisplayedForInvalidFormat() {
        return Utils.isElementVisible(driver, By.cssSelector("div.MuiFormHelperText-root:contains('format') or div.MuiFormHelperText-root:contains('karakter')"));
    }

    public boolean isSuccessMessageDisplayed() {
        return Utils.isElementVisible(driver, By.cssSelector("div[role='alert'] div:contains('Berhasil Menambahkan Divisi')"));
    }

    public String getSuccessAddDivisiMessage() {
        try {
            WebElement message = Utils.waitUntilVisible(driver, By.xpath("//div[@role='alert']//div[contains(@class,'MuiSnackbarContent-message')]"));
            return message != null ? message.getText() : "";
        } catch (NoSuchElementException | TimeoutException e) {
            return "";
        }
    }
}
