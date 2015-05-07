/**
 * System Soft Technologies Copyright (C) 2013 sadipan.b@sstech.us
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 *
 * @author sadipanB
 */
public abstract class AbstractOfficeTest {

    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "http://71.100.103.92/office-web/";    
    public boolean loginPassed;

    public final String ADMIN = "sbhattacharjee";
    public final String USER = "sbhattacharjee";

    @BeforeTest(description="Launches the Portal")
    @Parameters("browser")
    public void setBaseURL(String browser) throws Exception {        
        System.out.println("Enter BaseURL: " + new Date());
        
        if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        else if(browser.equalsIgnoreCase("chrome")) {        
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        
        driver.get(baseURL);
        wait = new WebDriverWait(driver, 10);
        
        System.out.println("Exit BaseURL: " + new Date());
    }
            
    public boolean login(String username, String password) {
        System.out.println("Enter Login: " + new Date());
        
        WebElement usernameTB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-usernameTb")));
        usernameTB.clear();
        usernameTB.sendKeys(username);
        
        WebElement passwordTB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-passwordTb")));
        passwordTB.clear();
        passwordTB.sendKeys(password);
        
        WebElement loginB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-loginB")));
        loginB.click();
        
        loginPassed = true;
        try {
            waitForElement("gwt-debug-welcomeL");            
        } catch (Exception e) {            
            System.out.println("Login exception: " + e.getMessage());
            loginPassed = false;
        }
        
        System.out.println("Exit Login: " + new Date());
        return loginPassed;
    }
    
    public boolean logout() {        
        System.out.println("Enter Logout: " + new Date());
        
        WebElement logoutB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-logoutCL")));
        logoutB.click();
        
        //wait until login screen reappears
        WebElement loginB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-loginB")));
        
        System.out.println("Exit Logout: " + new Date());
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
