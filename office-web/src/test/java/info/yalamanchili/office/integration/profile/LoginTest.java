package info.yalamanchili.office.integration.profile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	protected static FirefoxDriver driver;

	@BeforeClass
	public static void init() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testLogin() {
		driver.get("http://localhost:9090/office-web/office.html");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@AfterClass
	public static void destroy() {
		driver.close();
	}
}
