package TestCases;

import org.openqa.selenium.WebDriver;

public class CerrarAplicacion {
public static void Execute(WebDriver driver){
		
		driver.close();
		driver.quit();
	}
}
