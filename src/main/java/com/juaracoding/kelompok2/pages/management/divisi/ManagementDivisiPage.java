package com.juaracoding.kelompok2.pages.management.divisi;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.drivers.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagementDivisiPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ManagementDivisiPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    // Locator for divisi title
    @FindBy(xpath = "//p[contains(text(),'Divisi')]")
    private WebElement titleDivisi;

    @FindBy(css = "#search")
    private WebElement searchField;


    @FindBy(css = "#__next > div > div > div > div.MuiBox-root.css-76jx17 > div > div > div > div.MuiBox-root.css-1pbadgm > button")
    private WebElement txtTambahkan;
    // Locator for divisi table row containing the divisi name
    private By divisiTableRow = By.xpath("//table//tbody//td[contains(text(), '{DIVISI_NAME}')]");


    public void openPage() {
        driver.get(Constants.URLDIVISI);
    }


    public String getTitleDivisi() {
        return titleDivisi.getText();
    }

    public String getTxtTambahkan() {
        return txtTambahkan.getText();
    }


    public boolean isDivisiListed(String divisiName) {
        try {
            WebElement divisiElement = driver.findElement(By.xpath(divisiTableRow.toString().replace("{DIVISI_NAME}", divisiName)));
            return divisiElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
