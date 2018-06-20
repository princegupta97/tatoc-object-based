package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameSwitching 
{
	WebDriver driver;
	
	FrameSwitching(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void changeFromOneFrameToAnotherFrane(String frame)
	{
		driver.switchTo().frame(frame);
	}
	
	public void performClickByLinkText(String perform)
	{
		driver.findElement(By.linkText(perform)).click();
	}

}
