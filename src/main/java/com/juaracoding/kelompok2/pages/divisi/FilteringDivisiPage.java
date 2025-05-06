package com.juaracoding.kelompok2.pages.divisi;

import com.juaracoding.kelompok2.drivers.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilteringDivisiPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/div/div[1]/form/div/div/div/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/div/div[1]/form/div/button[2]")
    private WebElement searchButton;

    @FindBy(xpath = "//button[contains(@class,'btn-reset')]")
    private WebElement resetButton;

    @FindBy(xpath = "//div[@role='combobox' and contains(@class, 'MuiSelect-select')]")
    private WebElement rowsPerPageDropDown;

    public FilteringDivisiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FilteringDivisiPage searchDivisi(String namaDivisi) {
        Utils.sendKeysToElement(driver, searchField, namaDivisi);
        return this;
    }

    public FilteringDivisiPage clickSearchButton() {
        Utils.clickElement(driver, searchButton);
        return this;
    }

    public FilteringDivisiPage clickResetButton() {
        Utils.clickElement(driver, resetButton);
        return this;
    }

    public FilteringDivisiPage selectRowsPerPage(String rowsCount) {
        Utils.clickElement(driver, rowsPerPageDropDown);
        Utils.waitUntilVisible(driver, By.xpath("//li[text()='" + rowsCount + "']")).click();
        return this;
    }

    public boolean isDivisiFound(String divisiName) {
        return Utils.waitUntilVisible(driver, By.xpath("//td[contains(.,'" + divisiName + "')]")) != null;
    }

    // Method to check for invalid input handling (rows per page)
    public boolean isValidationMessageDisplayedForInvalidInput() {
        try {
            WebElement validationMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message') or contains(text(), 'Invalid')]"));
            return validationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to count the number of rows displayed (optional method for validation)
    public int getDisplayedRowCount() {
        try {
            List<WebElement> rows = driver.findElements(By.xpath("//tr"));
            return rows.size(); // Returns number of rows
        } catch (NoSuchElementException e) {
            return 0; // If rows are not found, return 0
        }
    }
}
