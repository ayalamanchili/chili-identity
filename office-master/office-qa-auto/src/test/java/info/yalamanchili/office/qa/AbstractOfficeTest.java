/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa;

import info.chili.commons.PropertyFileLoader;
import java.util.Properties;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    
    @BeforeSuite (description="load property files")
    public void loadEnvironmentVariables(){
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
    
    @BeforeTest(description="Launches the Portal")
    public void launchURL() throws Exception {        
        System.out.println("Enter launchURL: " + new Date());
        
        browser = properties.getProperty("browser").toLowerCase();
        switch (browser) {
            case "firefox": 
                driver = new FirefoxDriver();                
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
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id(elementId));
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
    
    @AfterTest(description="Closes the Portal Page")
    public void endSession(){
        System.out.println("Enter EndSession: " + new Date());
        driver.close();
        driver.quit();
        System.out.println("Exit EndSession: " + new Date());
    }   
    
}
