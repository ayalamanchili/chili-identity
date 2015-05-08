/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa;

import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Sadipan.B
 */
public class StaticContentsTest extends AbstractOfficeTest  {
    
    @Test(description="Verifies the page title",groups="StaticContents")
    public void testPageTitle(){
        System.out.println("Enter testTitle: " + new Date());
        
        String expectedTitle = "System Soft Office";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        
        System.out.println("Exit testTitle: " + new Date());
    } 
    
    @Test(description="Verifies the page footer",groups="StaticContents")
    public void testFooter(){
        System.out.println("Enter testFooter: " + new Date());
        
        String expectedFooter = "System Soft Office";
        String actualFooter = driver.getTitle();
        
        Assert.assertEquals(actualFooter,expectedFooter);        
        System.out.println("Exit testFooter: " + new Date());
    }        
    
}
