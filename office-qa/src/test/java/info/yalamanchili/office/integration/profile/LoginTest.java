package info.yalamanchili.office.integration.profile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
//TODO get/set this from pom system property

    public static final String officeURL = "http://localhost:9090/office-web/office.html";
    protected static FirefoxDriver driver;
    
    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }
    
    @Test
    public void testLogin() {
        driver.get(officeURL);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement usernameTB = driver.findElement(By.id("gwt-debug-usernameTb"));
        usernameTB.sendKeys("user");
        WebElement passwordTB = driver.findElement(By.id("gwt-debug-passwordTb"));
        passwordTB.sendKeys("user");
        WebElement loginB = driver.findElement(By.id("gwt-debug-loginB"));
        loginB.click();
        WebElement welcomeUserE = (new WebDriverWait(driver, 3)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("gwt-debug-welcomeL"));
            }
        });
        assertNotNull(welcomeUserE);
    }
    
    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
