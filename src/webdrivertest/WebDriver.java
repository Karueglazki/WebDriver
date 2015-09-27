package webdrivertest;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class WebDriver extends TestBase {
  @Test
  public void testGoogleJunit4WDriver() throws Exception {
	driver.get("https://www.google.com.ua/");
	driver.findElement(By.id("lst-ib")).sendKeys("обучение собак");
	driver.findElement(By.name("btnG")).click();
//	WebElement weblink= driver.findElement(By.xpath("//*[@id='rso']//a"));
//	Actions builder = new Actions(driver);
//	builder.contextClick(weblink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();


  }

}