package tatoc;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchPopUp 
{
	WebDriver driver;
	greenBox box;
	
	public LaunchPopUp(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		box = new greenBox(driver);
	}
	public void launchWindowandHandle()
	{
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		box.returnParameterById("name").sendKeys("Prince");
		driver.findElement(By.id("submit")).click();

		driver.switchTo().window(parentWindowHandler); 

	}

}
