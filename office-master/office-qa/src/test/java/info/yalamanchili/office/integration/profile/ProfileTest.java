/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.profile;

import info.yalamanchili.office.integration.TestUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author yalamanchili
 */
public class ProfileTest {

    protected static FirefoxDriver driver;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testUserLogin() {
    }

    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
