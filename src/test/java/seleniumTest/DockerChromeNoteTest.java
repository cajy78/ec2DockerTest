package seleniumTest;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DockerChromeNoteTest {
	RemoteWebDriver driver;
	
	@Test
	public void dockerTest() throws Throwable
	{
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setBrowserName("chrome");
		desiredCapabilities.setPlatform(Platform.LINUX);
		
		driver = new RemoteWebDriver(new URL("http://35.175.134.222:4444/wd/hub"), desiredCapabilities);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
