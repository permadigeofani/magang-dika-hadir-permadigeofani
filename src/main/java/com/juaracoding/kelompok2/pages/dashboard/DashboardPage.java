package com.juaracoding.kelompok2.pages.dashboard;

import com.juaracoding.kelompok2.drivers.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "[alt='Logo Hadir']")
    private WebElement hadirTitle;

    @FindBy(css = ".css-old1by > div:nth-of-type(4) .MuiTypography-root")
    private WebElement managementMenu;

    @FindBy(css = ".css-old1by > div:nth-of-type(4) .feather")
    private WebElement managementDropDown;

    @FindBy(css = ".css-old1by > .MuiBox-root div:nth-of-type(4) .MuiTypography-root")
    private WebElement divisiMenu;

    public void openPage() {
        driver.get(Constants.URLDASHBOARD);
    }

    public String getHadirTitle() {
        return hadirTitle.getText();
    }

    public String getManagementMenu() {
        return managementMenu.getText();
    }

    public void clickManagementMenu(){
        managementDropDown.click();
    }

    public void clickDivisiMenu(){
        divisiMenu.click();
    }

    public void navigateToDivisionPage() {
        clickManagementMenu();
        clickDivisiMenu();
    }
}
