package com.juaracoding.kelompok2.steps;

import com.juaracoding.kelompok2.drivers.DriverSingleton;
import com.juaracoding.kelompok2.drivers.utils.Constants;
import com.juaracoding.kelompok2.pages.dashboard.DashboardPage;
import com.juaracoding.kelompok2.pages.login.LoginPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("User is on the Management Divisi page")
    public void userIsOnTheManagementDivisiPage() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        // Akses URL aplikasi
        driver.get(Constants.URL);

        // Login dengan kredensial
        loginPage.loginActivity("admin@hadir.com", "MagangSQA_JC@123");
        loginPage.clickMasukButton(); // Klik tombol masuk

        // Verifikasi berhasil masuk ke dashboard
        Assert.assertEquals(dashboardPage.getManagementMenu(), "Management", "Gagal masuk dashboard");

        // Navigasi ke halaman Divisi
        dashboardPage.clickManagementMenu(); // Klik menu Management
        dashboardPage.clickDivisiMenu(); // Klik menu Divisi
    }
}
