package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class greenBox 
{
	WebDriver driver;
	public greenBox(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement returnParameterByClassName(String find )
	{
		return driver.findElement(By.className(find));
	}
	
	public WebElement returnParameterById(String find )
	{
		return driver.findElement(By.id(find));
	}
	public WebElement returnParameterByXpath(String find )
	{
		return driver.findElement(By.xpath(find));
	}
}
