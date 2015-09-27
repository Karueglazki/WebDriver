package webdrivertest;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	protected WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		LoggingPreferences logs = new LoggingPreferences();
//		logs.enable(LogType.BROWSER, Level.OFF);
//		logs.enable(LogType.CLIENT, Level.SEVERE);
//		logs.enable(LogType.DRIVER, Level.WARNING);
//		logs.enable(LogType.PERFORMANCE, Level.INFO);
		logs.enable(LogType.SERVER, Level.ALL);

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

//		WebDriver driver = new FirefoxDriver(desiredCapabilities);
	    driver = new FirefoxDriver(desiredCapabilities);
	    baseUrl = "http://presentain.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    Logs logs2 = driver.manage().logs();
	    LogEntries logEntries = logs2.get(LogType.DRIVER);

	    for (LogEntry logEntry : logEntries) {
	        System.out.println(logEntry.getMessage());
	    }
	  }

	@After
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

}
