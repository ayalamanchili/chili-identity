/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author yalamanchili
 */
public class TestUtils {

    public static void waitFor(WebDriver driver, long sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
}
