package TestCases;

import org.openqa.selenium.WebDriver;

public class IniciarAplicacion {
	
	public static void Execute(WebDriver driver, String url){
		driver.get(url);
	}
}
