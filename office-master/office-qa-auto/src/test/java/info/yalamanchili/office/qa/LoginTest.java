/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.qa;

import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class LoginTest extends AbstractOfficeTest {


//    @Test(description="test consultant login",groups="login",dependsOnGroups="StaticContents")
    public void testUserLogin() {
        System.out.println("Enter UserLogin: " + new Date());
        String userId = properties.getProperty("user_id");
        String userPwd = properties.getProperty("user_pwd");        
        assertTrue(login(userId, userPwd),"Error:Could not login as user ");
        System.out.println("Exit UserLogin: " + new Date());
    }

    @Test(description="test admin login",groups="login",dependsOnGroups="StaticContents")
    public void testAdminLogin() {
        System.out.println("Enter AdminLogin: " + new Date());
        String adminId = properties.getProperty("admin_id");
        String adminPwd = properties.getProperty("admin_pwd");        
        assertTrue(login(adminId, adminPwd),"Error:Could not login as admin ");
        System.out.println("Exit AdminLogin: " + new Date());
    }

//    @Test(description="test login failure",groups="login",dependsOnGroups="StaticContents")
    public void testLoginFailure() {
        System.out.println("Enter loginFailure: " + new Date());
        assertTrue(!login("user", "incorrectpassword"),"Eror:Login allowed with incorrect credential ");
        System.out.println("Exit loginFailure: " + new Date());
    }

    @Test(description="test logout",groups="logout",dependsOnGroups="tasks")
    public void testLogout(){
        System.out.println("Enter logout: " + new Date());
        assertTrue(logout(),"Error:Could not logout - ");
        System.out.println("Exit logout: " + new Date());        
    }
    
}
