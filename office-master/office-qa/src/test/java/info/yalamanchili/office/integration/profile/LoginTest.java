/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.integration.profile;

import info.yalamanchili.office.integration.AbstractOfficeTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

public class LoginTest extends AbstractOfficeTest {

    protected static FirefoxDriver driver;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testUserLogin() {
        assertTrue(login(USER, USER));
    }

    @Test
    public void testAdminLogin() {
        assertTrue(login(ADMIN, ADMIN));
    }

    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void loginFailureTest() {
        login("user", "incorrectpassword");
    }

    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
