package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class GenerateToken 
{
	WebDriver driver;
	public GenerateToken(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void generateToken()
	{
		String token = driver.findElement(By.cssSelector("#token")).getText();

		String split = token.substring(7);
		Cookie token1 = new Cookie("Token", split);
		driver.manage().addCookie(token1);

	}

}
