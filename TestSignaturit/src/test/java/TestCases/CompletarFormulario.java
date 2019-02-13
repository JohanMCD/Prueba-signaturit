package TestCases;

import org.openqa.selenium.WebDriver;
import Utils.EventsBehavior;

public class CompletarFormulario {
	
	//Variable
	static String nombre = "Jose";
	static String apellido = "Perez";
	static String nombreEmpresa = "testqa s.a";
	static String cargoEmpresa = "manager";
	static String telefono = "+34000000000";
	static String email = "Perez@test.es";
	static String passwork = "abc123";
	
	//Objectos 
	static String link = "href='/es/register/business'";
	static String nombreObj = "id='register_first_name'";
	static String apellidoObj = "id='register_last_name'";
	static String nombreEmpresaObj = "id='register_company'";
	static String cargo = "id='register_job_title'";
	static String telefonoObj = "id='register_phone'";
	static String emailObj =  "id='register_email'";
	static String passworkObj = "id='register_password'";
	static String checkBoxPolitica = "class='info-links-checkbox'";
	static String botonRegistarte =  "id='register_submit'";
	
	public static void Execute(WebDriver driver){
		
		//Hacer clic en link "Consigue una aqui"
		EventsBehavior.GetObject(driver, link ).click();
		
		//Poner nombre 
		EventsBehavior.GetObject(driver, nombreObj).sendKeys(nombre);
		
		//Poner apellido
		EventsBehavior.GetObject(driver, apellidoObj).sendKeys(apellido);
		
		//Poner nombre de la empresa 
		EventsBehavior.GetObject(driver, nombreEmpresaObj).sendKeys(nombreEmpresa);
		
		//Poner el cargo en la empresa
		EventsBehavior.GetObject(driver,cargo ).sendKeys(cargoEmpresa);
		
		//Poner el numero de telefono de la empresa
		EventsBehavior.GetObject(driver,telefonoObj ).sendKeys(telefono);
	
		//Poner el email de la empresa 
		EventsBehavior.GetObject(driver, emailObj).sendKeys(email);
	
		//Poner el passwork
		EventsBehavior.GetObject(driver, passworkObj).sendKeys(passwork);
		
		//Hacer clic en "Acepto la política de privacidad y condiciones de contratación"
		EventsBehavior.GetObject(driver, checkBoxPolitica ).click();
		
		//Hacer clic en "Acepto la política de privacidad y condiciones de contratación"
		EventsBehavior.GetObject(driver, botonRegistarte).submit();
		
		//Esperar
		EventsBehavior.WaitForSec(driver, 8);
	}
}
