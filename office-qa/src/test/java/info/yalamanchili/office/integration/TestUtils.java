/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration;

import info.yalamanchili.commons.PropertyFileLoader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author yalamanchili
 */
public class TestUtils {

    protected static Properties properties = null;

    public static void waitFor(WebDriver driver, long sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static String getRootURL() {
        if (properties == null) {
            properties = PropertyFileLoader.loadProperties("test");
            System.out.println(properties.toString());
        }
        return properties.getProperty("root_url");
    }

    public static boolean login(WebDriver driver, String username, String password) {
        driver.get(getRootURL());
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
}
