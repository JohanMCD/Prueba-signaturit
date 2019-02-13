
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestCases.CerrarAplicacion;
import TestCases.CompletarFormulario;
import TestCases.IniciarAplicacion;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RunTest {

	WebDriver driver;
	static String url = "https://app.signaturit.com/es/login";
	
	//Inicar aplicacion q
	@BeforeTest
	public void  CofigurarEntorno(){
		
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Regresion (){
		
		//Iniciar aplicacion
		IniciarAplicacion.Execute(driver,url);
		
		//Completa formulario
		CompletarFormulario.Execute(driver);
		
		//Cerrar la aplicacion 
		CerrarAplicacion.Execute(driver);
	}
}
