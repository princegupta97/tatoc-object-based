package tatoc;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.jetty.websocket.common.extensions.fragment.FragmentExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.*;
import org.testng.asserts.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class TestMainObject 
{
	WebDriver driver;
	Assertion asser;
	greenBox greenBox;
	FrameSwitching frameSwitching;
	ActionDrag actionDrag;
	LaunchPopUp launchPopUp;
	GenerateToken token;
	public TestMainObject()
	{
		System.setProperty("webdriver.chrome.driver","/home/princegupta/Downloads/chromedriver");
		driver = new ChromeDriver();
		asser = new Assertion(driver);
		greenBox = new greenBox(driver);
		frameSwitching = new FrameSwitching(driver);
		actionDrag = new ActionDrag(driver);
		launchPopUp = new LaunchPopUp(driver);
		token = new GenerateToken(driver);
	}


	@Test
	public void basiccourse() 
	{
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		asser.putAssertion();
		
	}

	@Test(dependsOnMethods= {"basiccourse"})
	public void greenbox() 
	{
		Assert.assertEquals(asser.returnParameterByClass("greenbox"), true);
		greenBox.returnParameterByClassName("greenbox").click();
 		asser.putAssertion();

	}

	@Test(dependsOnMethods= {"greenbox"})
	public void frame() 
	{
		frameSwitching.changeFromOneFrameToAnotherFrane("main");
		Assert.assertEquals(asser.returnParameterById("answer"), true);

		String color1 = greenBox.returnParameterById("answer").getAttribute("class");
		boolean f = true;
		while(f)
		{		
			frameSwitching.changeFromOneFrameToAnotherFrane("child");
			String color2 = greenBox.returnParameterById("answer").getAttribute("class");
			if(color1.equals(color2))
			{
				f = false;
			}
			else {
				driver.switchTo().defaultContent();
				frameSwitching.changeFromOneFrameToAnotherFrane("main");
				frameSwitching.performClickByLinkText("Repaint Box 2");


			}
		}
		driver.switchTo().defaultContent();
		frameSwitching.changeFromOneFrameToAnotherFrane("main");
		frameSwitching.performClickByLinkText("Proceed");
		asser.putAssertion();
	}


	@Test(dependsOnMethods= {"frame"})
	public void actiondrag() 
	{
		Assert.assertEquals(asser.returnParameterByXPath(".//*[@id='dragbox']"),true);
		Assert.assertEquals(asser.returnParameterByXPath(".//*[@id='dropbox']"),true);
		WebElement from = greenBox.returnParameterByXpath(".//*[@id='dragbox']");
		WebElement to = greenBox.returnParameterByXpath(".//*[@id='dropbox']");
		actionDrag.perfromAction(from, to);
		frameSwitching.performClickByLinkText("Proceed");
		asser.putAssertion();

	}


	@Test(dependsOnMethods= {"actiondrag"})
	public void launchpopup() 
	{
		frameSwitching.performClickByLinkText("Launch Popup Window");
		launchPopUp.launchWindowandHandle();

		frameSwitching.performClickByLinkText("Proceed");

		asser.putAssertion();
	}


	@Test(dependsOnMethods= {"launchpopup"})
	public void token() 
	{
		frameSwitching.performClickByLinkText("Generate Token");
		token.generateToken();
		frameSwitching.performClickByLinkText("Proceed");
		asser.putAssertion();
	}


}
