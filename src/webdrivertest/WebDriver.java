package webdrivertest;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class WebDriver extends TestBase {

  @Test
  public void testWindowPopup()
  {
	  driver.get("http://presentain.com/");
      //Save the WindowHandle of Parent Browser Window
      String parentWindowId = driver.getWindowHandle();

      //Clicking Help Button will open Help Page in a new Popup Browser Window
      WebElement helpButton = driver.findElement(By.cssSelector(".social li a i.fa-facebook"));
      helpButton.click();
      System.out.println(driver.getTitle());

      for (String winHandle : driver.getWindowHandles()) {
    	    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    	}
      
      //Close the Help Popup Window
      driver.close();

      //Move back to the Parent Browser Window
      driver.switchTo().window(parentWindowId);

      //Verify the driver context is in Parent Browser Window
      assertTrue(driver.getTitle().equals("Present. Engage. Grow. - Presentain"));
  }
}