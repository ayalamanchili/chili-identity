/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa;

import info.chili.commons.PropertyFileLoader;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 *
 * @author sadipanB
 */
public abstract class AbstractOfficeTest {

    protected static Properties properties = null;
    protected static Properties uimapper = null;

    public static WebDriver driver;
    public static WebDriverWait wait;
    static String browser;
    boolean loginPassed;
    public File srcFile;

    @BeforeSuite(description = "load property files")
    public void loadEnvironmentVariables() {
        System.out.println("Enter loadEnvironment: " + new Date());

        if (properties == null) {
            properties = PropertyFileLoader.loadProperties("/test.properties");
            System.out.println(properties.toString());
        }

        if (uimapper == null) {
            uimapper = PropertyFileLoader.loadProperties("/uimapping.properties");
        }

        System.out.println("Exit loadEnvironment: " + new Date());
    }

    @BeforeTest(description = "Launches the Portal")
    public void launchURL() throws Exception {
        System.out.println("Enter launchURL: " + new Date());

        browser = properties.getProperty("browser").toLowerCase();
        switch (browser) {
            case "firefox":
                File firebug_path = new File("C:\\Selenium 2.48.2\\Firebug\\firebug-1.9.0.xpi");
                FirefoxProfile firefoxprofile = new FirefoxProfile();
                firefoxprofile.addExtension(firebug_path);
                driver = new FirefoxDriver(firefoxprofile);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome_driver"));
                driver = new ChromeDriver();
                break;
            case "internetexplorer":
                System.setProperty("webdriver.ie.driver", properties.getProperty("ie_driver"));
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                break;
            default:
        }

        driver.get(properties.getProperty("root_url"));
        wait = new WebDriverWait(driver, Long.parseLong(properties.getProperty("wait_period")));

        System.out.println("Exit launchURL: " + new Date());
    }

    public boolean login(String username, String password) {

        loginPassed = true;

        WebElement usernameTB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-usernameTb")));
        usernameTB.clear();
        usernameTB.sendKeys(username);

        WebElement passwordTB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-passwordTb")));
        passwordTB.clear();
        passwordTB.sendKeys(password);

        WebElement loginB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-loginB")));
        loginB.click();

        driver.manage().window().maximize();

        try {
            waitForElement("gwt-debug-welcomeL");
        } catch (Exception e) {
            System.out.println(" Login exception - " + e.getMessage());
            loginPassed = false;
        }

        return loginPassed;
    }

    public boolean logout() {

        WebElement logoutB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-logoutCL")));
        logoutB.click();

        //wait until login screen reappears
        WebElement loginB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-loginB")));

        return true;
    }

    public void waitForTime(long sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public void waitForElement(String elementId) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id(elementId));
            }
        });
    }

    public void fluentWaitForElementId(String locator) {
        (new FluentWait<>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(05, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    public void fluentWaitForElementXpath(String locator) {
        (new FluentWait<>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(05, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void fluentWaitForElementLinkText(String locator) {
        (new FluentWait<>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(05, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
    }

    public void waitForElementXpath(String elementXpath) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(elementXpath));
            }
        });
    }

    public void waitForStaleness(WebElement ele) {
        try {
            wait.until(ExpectedConditions.stalenessOf(ele));
        } catch (Exception e) {
            System.out.println("Staleness Error: " + e.getMessage());
        }
    }

    public void waitForLoader() {
        By loader = By.cssSelector("div.raDiv");
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    public void takeScreenshot(String screenshot) throws IOException {
        DateFormat df = new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
        Date d = new Date();
        String time = df.format(d);

        srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,
                new File("C:\\codebase\\Screenshots\\" + screenshot + time + ".png"));
    }

    @AfterTest(description = "Closes the Portal Page")
    public void endSession() {
        System.out.println("Enter EndSession: " + new Date());
        driver.close();
        driver.quit();
        System.out.println("Exit EndSession: " + new Date());
    }
}
