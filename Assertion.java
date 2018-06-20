package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertion 
{
	WebDriver driver;
	
	Assertion(WebDriver driver)
	{
		this.driver = driver;
	}
	public void putAssertion()
	{
		Assert.assertNotEquals("http://10.0.1.86/tatoc/error", driver.getCurrentUrl());
	}
	
	public boolean returnParameterById(String id )
	{
		return driver.findElement(By.id(id)).isDisplayed();
	}
	
	public boolean returnParameterByClass(String clas )
	{
		return driver.findElement(By.className(clas)).isDisplayed();
	}
	
	public boolean returnParameterByXPath(String path )
	{
		return driver.findElement(By.xpath(path)).isDisplayed();
	}


}
