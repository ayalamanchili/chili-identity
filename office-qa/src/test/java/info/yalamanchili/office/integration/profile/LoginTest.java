package info.yalamanchili.office.integration.profile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

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
        System.out.println(driver.getPageSource().toString());
        assertTrue(driver.getPageSource().contains("Welcome user"));
    }

    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
