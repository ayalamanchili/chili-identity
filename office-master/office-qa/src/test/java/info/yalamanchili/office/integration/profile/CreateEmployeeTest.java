/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.profile;

import info.yalamanchili.office.integration.AbstractOfficeTest;
import static info.yalamanchili.office.integration.profile.LoginTest.driver;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ayalamanchili
 */
public class CreateEmployeeTest extends AbstractOfficeTest {

    protected static FirefoxDriver driver;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testCreateEmployee() {
        assertTrue(login(driver, ADMIN, ADMIN));
    }

    @AfterClass
    public static void destroy() {
        driver.kill();
    }
}
