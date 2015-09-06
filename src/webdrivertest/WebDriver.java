package webdrivertest;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class WebDriver extends TestBase {
  @Test
  public void testGoogleJunit4WDriver() throws Exception {
	  driver.get("https://www.google.com.ua/");
		driver.findElement(By.id("lst-ib")).sendKeys("обучение собак");
		driver.findElement(By.name("btnG")).click();


  }

}