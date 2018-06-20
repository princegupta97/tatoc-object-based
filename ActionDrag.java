package tatoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionDrag 
{
	WebDriver driver;
	
	public ActionDrag(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void perfromAction(WebElement from,WebElement to)
	{
		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(from)

				.moveToElement(to)

				.release(to)

				.build();

		dragAndDrop.perform();

	}

}
