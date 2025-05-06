package com.juaracoding.kelompok2.drivers.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static com.juaracoding.kelompok2.drivers.utils.Constants.TIMEOUT;

public class Utils {

    public static int testCount = 0;
    private static final Logger logger = Logger.getLogger(Utils.class.getName());
    private static final int MAX_RETRY = 3;

    public static WebDriverWait createWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static void delay(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void delayInMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void sendKeysToElement(WebDriver driver, WebElement element, String text) {
        waitUntilVisible(driver, element);
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(WebDriver driver, WebElement element) {
        waitUntilVisible(driver, element);
        element.click();
    }

    public static void clickElement(WebDriver driver, By xpath) {
        try {
            WebElement element = waitUntilVisible(driver, xpath);
            if (element != null) {
                element.click();
            } else {
                logger.severe("[Click Error] Element with xpath: " + xpath + " not found.");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            logger.severe("[Click Error] Unable to click element with xpath: " + xpath + " - " + e.getMessage());
        }
    }

    public static WebElement waitUntilVisible(WebDriver driver, By locator) {
        try {
            return createWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            logger.severe("[Wait Visible Error] Element not visible: " + locator);
            return null;
        }
    }

    private static void waitUntilVisible(WebDriver driver, WebElement element) {
        createWait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isElementVisible(WebDriver driver, By locator) {
        try {
            WebElement element = waitUntilVisible(driver, locator);
            return element != null && element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public static boolean waitUntilClickableAndClick(WebDriver driver, WebElement element) {
        WebDriverWait wait = createWait(driver);
        int retryCount = 0;

        while (retryCount <= MAX_RETRY) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                scrollToElement(driver, element);
                element.click();
                return true;
            } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
                retryCount++;
                logger.warning("[Retry] Click failed (" + retryCount + "): " + e.getMessage());
                delay(1);
            } catch (Exception e) {
                logger.severe("[Click Error] " + e.getMessage());
                break;
            }
        }

        logger.severe("Failed to click the element after " + MAX_RETRY + " attempts.");
        return false;
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            delayInMillis(500);
        } catch (Exception e) {
            logger.warning("[Scroll Error] Failed to scroll to element: " + e.getMessage());
        }
    }

    public static WebElement waitUntilClickable(WebDriver driver, WebElement element) {
        try {
            return createWait(driver).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            logger.severe("[Wait Clickable Error] Element is not clickable.");
            return null;
        }
    }

    public static boolean moveToAndClick(WebDriver driver, WebElement element) {
        try {
            scrollToElement(driver, element);
            WebDriverWait wait = createWait(driver);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            new Actions(driver).moveToElement(element).click().perform();
            return true;
        } catch (Exception e) {
            logger.severe("[moveToAndClick Error] " + e.getMessage());
            return false;
        }
    }

    public static boolean moveToElement(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = createWait(driver);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            new Actions(driver).moveToElement(element).click().perform();
            return true;
        } catch (Exception e) {
            logger.severe("[moveToElement Error] " + e.getMessage());
            return false;
        }
    }

    /**
     * Mengambil teks dari elemen (langsung).
     */
    public static String getElementText(WebElement element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            logger.severe("[Get Text Error] Gagal mengambil teks dari element - " + e.getMessage());
            return "";
        }
    }

    /**
     * Mengambil teks dari elemen berdasarkan locator.
     */
    public static String getText(WebDriver driver, By locator) {
        try {
            WebElement element = waitUntilVisible(driver, locator);
            return element != null ? element.getText().trim() : "";
        } catch (Exception e) {
            logger.severe("[Get Text Error] Gagal mengambil teks dari locator: " + locator + " - " + e.getMessage());
            return "";
        }
    }

    /**
     * Mengecek apakah teks tertentu muncul pada elemen.
     */
    public static boolean isTextPresent(WebDriver driver, By locator, String expectedText) {
        String actualText = getText(driver, locator);
        return actualText.contains(expectedText);
    }
}
