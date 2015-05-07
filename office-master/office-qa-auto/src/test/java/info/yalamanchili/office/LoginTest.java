/**
 * System Soft Technologies Copyright (C) 2013 sadipan.b@sstech.us
 */
package info.yalamanchili.office;

import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class LoginTest extends AbstractOfficeTest {


    @Test(description="test consultant login",groups="login")
    public void testUserLogin() {
        assertTrue(login(USER, USER),"User Login Error");
    }

    @Test(description="test employee login",groups="login",dependsOnGroups="startup")
    public void testAdminLogin() {
        assertTrue(login(ADMIN, ADMIN),"Admin Login Error");
    }

    @Test(description="test login failure",groups="login")
    public void loginFailureTest() {
        assertTrue(login("user", "incorrectpassword"),"Login Failure Error");
    }

    @Test(description="test logout",groups="logout",dependsOnGroups="empcreate")
    public void testLogout(){
        assertTrue(logout(),"Logout Error");
    }
    
    @Test(description="Verifies the page title",groups="startup")
    public void testHome(){
//        waitForTime(2000);
        System.out.println("Enter testHome: " + new Date());
        String expectedTitle = "System Soft Office";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Exit testHome: " + new Date());
    }    
}
