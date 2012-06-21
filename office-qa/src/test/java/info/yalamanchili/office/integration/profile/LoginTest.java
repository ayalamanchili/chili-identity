package info.yalamanchili.office.integration.profile;

import info.yalamanchili.commons.PropertyFileLoader;
import info.yalamanchili.office.integration.TestUtils;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static info.yalamanchili.office.integration.TestUtils.*;

public class LoginTest {

    protected static FirefoxDriver driver;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testUserLogin() {
        assertTrue(TestUtils.login(driver, "user", "user"));
    }

    @Test
    public void testAdminLogin() {
        assertTrue(TestUtils.login(driver, "admin", "admin"));
    }

    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void loginFailureTest() {
        TestUtils.login(driver, "user", "incorrectpassword");
    }

    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
