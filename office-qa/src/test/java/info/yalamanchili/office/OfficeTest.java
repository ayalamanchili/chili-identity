/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ayalamanchili
 */
public class OfficeTest {

    protected final static String ADMIN = "adminadmin";
    protected final static String USER = "useruser";
    protected static WebDriver driver;

    @BeforeClass
    public static void init() {
        //TODO externalize the browser drivers
        driver = new FirefoxDriver();
    }

    public boolean login(String username, String password) {
        driver.get(TestUtils.getRootURL());
        WebElement usernameTB = driver.findElement(By.id("gwt-debug-usernameTb"));
        usernameTB.sendKeys(username);
        WebElement passwordTB = driver.findElement(By.id("gwt-debug-passwordTb"));
        passwordTB.sendKeys(password);
        WebElement loginB = driver.findElement(By.id("gwt-debug-loginB"));
        loginB.click();
        (new WebDriverWait(driver, 3)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("gwt-debug-welcomeL"));
            }
        });
        return true;
    }

    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
