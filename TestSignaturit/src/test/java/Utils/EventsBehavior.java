package Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.relevantcodes.extentreports.ExtentReports;

public class EventsBehavior {
	static String resulDone = "Done";
	static String resulSkip = "Skip";
	static String resulInfo = "Info";
	static String resulNotDone = "Not Done";
	static WebDriverWait wait;

	//Set text field 
	public static boolean SetTextByIdXpath(WebDriver driver, ExtentReports logger, String property, String text, String coments) {
		wait = new WebDriverWait(driver, 1);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			driver.findElement(By.xpath(Properties(property))).sendKeys(text);
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e1) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}
	//Set text fields index 
		public static boolean SetTextByIdXpathIndex(WebDriver driver, ExtentReports logger, String property, String text, String coments, int index) {
			wait = new WebDriverWait(driver, 1);
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
				driver.findElements(By.xpath(Properties(property))).get(index).sendKeys(text);
				logger.log(LogStatus.PASS, coments, resulDone);
				return true;
			} catch (Exception e1) {
				logger.log(LogStatus.FAIL, coments, resulNotDone);
				return false;
			}
		}

	//Click to button
	public static boolean ClickToButton(WebDriver driver, ExtentReports logger, String property, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			driver.findElement(By.xpath(Properties(property))).click();
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e2) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}

	//Click to button sin reporte
	public static boolean ClickToButton(WebDriver driver, String property) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			driver.findElement(By.xpath(Properties(property))).click();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}

	//Click to button
	public static boolean SubmitButton(WebDriver driver, ExtentReports logger, String property, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			driver.findElement(By.xpath(Properties(property))).submit();
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e2) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}

	//Click to List obj
	public static boolean ClickToListObj(WebDriver driver, ExtentReports logger, String property, int index, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			List<WebElement> allLinks = driver.findElements(By.xpath(Properties(property)));
			allLinks.get(index).click();
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e2) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}

	//Click to List obj
	public static boolean ClickToListObjText(WebDriver driver, ExtentReports logger, String property, String text, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			List<WebElement> allLinks = driver.findElements(By.xpath(Properties(property)));
			for (int i = 0; i < allLinks.size(); i++) {
				if (allLinks.get(i).getText().contains(text)) {
					allLinks.get(i).click();
				}
			}
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e2) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}

	//Click to List obj
	public static boolean ClickToListObjWithoutResport(WebDriver driver, String property, int index, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			List<WebElement> allLinks = driver.findElements(By.xpath(Properties(property)));
			allLinks.get(index).click();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}

	//DobleClick to button
	public static boolean DobleClickToButton(WebDriver driver, ExtentReports logger, String property, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			driver.findElement(By.xpath(Properties(property))).click();
			driver.findElement(By.xpath(Properties(property))).click();
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e2) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}

	//Click to Links and short test Link
	public static boolean ClickToLink(WebDriver driver, ExtentReports logger, String link, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));
			driver.findElement(By.linkText(link)).click();
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(link)));
				driver.findElement(By.partialLinkText(link)).click();
				return true;
			} catch (Exception e1) {
				logger.log(LogStatus.FAIL, coments, resulNotDone);
				return false;
			}
		}
	}

	//Select dropdown values text
	public static boolean SelectValueDropdown(WebDriver driver, ExtentReports logger, String property, String text, String coments) {
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(Properties(property))));
			dropdown.selectByVisibleText(text);
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}

	//Select dropdown values dimension 
	public static boolean SelectValueDropdown(WebDriver driver, ExtentReports logger, String property, int index, String coments) {
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(Properties(property))));
			dropdown.selectByIndex(index);
			logger.log(LogStatus.PASS, coments, resulDone);
			return true;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
	}
	
	public static boolean SelectValueDropdownWithoutReport(WebDriver driver, String property, int index, String coments) {
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(Properties(property))));
			dropdown.selectByIndex(index);
			
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	//wait a few sec
	public static void WaitForSec(WebDriver driver, int segundos) {
		synchronized (driver) {
			try {
				driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
				driver.wait(segundos * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//Click to check box
	public static boolean ClickToCheckBox(WebDriver driver, ExtentReports logger, String property, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			WebElement check = driver.findElement(By.xpath(Properties(property)));
			if (!check.isSelected()) {
				check.click();
				logger.log(LogStatus.PASS, coments, resulDone);
				return true;
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
		return false;
	}

	//search property
	public static String Properties(String properties) {
		String property = ".//*[@" + properties + "]";
		return property;
	}

	// Obtener el obj
	public static WebElement GetObject(WebDriver driver, String property) {
		WaitForSec(driver, 1);
		return driver.findElement(By.xpath(Properties(property)));
	}

	// Objener el objs
	public static List<WebElement> GetObjects(WebDriver driver, String property) {
		WaitForSec(driver, 1);
		return driver.findElements(By.xpath(Properties(property)));
	}

	// Objener el objs por index 
	public static WebElement GetObject(WebDriver driver, String property, int index) {
		WaitForSec(driver, 1);
		List<WebElement> objes = driver.findElements(By.xpath(Properties(property)));
		return objes.get(index);
	}

	// Validar que el obj se muestre
	public static boolean IsShowObject(WebDriver driver, String property) {
		WaitForSec(driver, 1);
		try {
			driver.findElement(By.xpath(Properties(property))).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// Validar que el obj se muestre filtrado por id
	public static boolean IsShowObjectById(WebDriver driver, String property) {
		WaitForSec(driver, 1);
		try {
			driver.findElement(By.id(property)).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// Seleccionar radio button por property
	public static boolean SelectRadioButton(WebDriver driver, ExtentReports logger, String property, String text, String coments) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			List<WebElement> radioButton = driver.findElements(By.xpath(Properties(property)));
			for (int i = 0; i < radioButton.size(); i++) {
				if (radioButton.get(i).getText().equals(text)) {
					radioButton.get(i).click();
					logger.log(LogStatus.PASS, coments, resulDone);
					return true;
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
		return false;
		//logger.log(LogStatus.FAIL, coments,"KO");
	}

	//Seleccionar radio button
	public static boolean SelectRadioButton(WebDriver driver, ExtentReports logger, String property, String coments) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			if (!driver.findElement(By.xpath(Properties(property))).isSelected()) {
				driver.findElement(By.xpath(Properties(property))).click();
				logger.log(LogStatus.PASS, coments, resulDone);
				return true;
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
			return false;
		}
		logger.log(LogStatus.FAIL, coments, resulNotDone);
		return false;
	}

	//search property
	public static boolean Exist(WebDriver driver, String property) {
		try {
			if (driver.findElement(By.xpath(Properties(property))).isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	//Verificar texto de link
	public static boolean VerificateTextLink(WebDriver driver, String obj) {
		wait = new WebDriverWait(driver, 1);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(obj)));
			driver.findElement(By.linkText(obj));
			return true;
		} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(obj)));
				driver.findElement(By.partialLinkText(obj));
				return true;
			} catch (Exception e1) {
				return false;
			}
		}
	}

	//Verificar texto en pantalla
	public static boolean VerificateTextScreen(WebDriver driver, String property, String text) {
		wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Properties(property))));
			List<WebElement> properties = driver.findElements(By.xpath(Properties(property)));
			for (int i = 0; i < properties.size(); i++) {
				String proper = properties.get(i).getText();
				if (proper.contains(text)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	//Validar el resultado esperado
	public static void ValidateResult(WebDriver driver, ExtentReports logger, String text, String coments) {
		if (text.equals("pass")) {
			logger.log(LogStatus.PASS, coments, resulDone);
		} else if (text.equals("fail")) {
			logger.log(LogStatus.FAIL, coments, resulNotDone);
		} else if (text.equals("skip")) {
			logger.log(LogStatus.SKIP, coments, resulSkip);
		} else {
			logger.log(LogStatus.INFO, coments, resulInfo);
		}
	}

	//Posicionarse encima del obj
	public static void Hover(WebDriver driver, String property) {
		try {
			WebElement getmenu = driver.findElement(By.xpath(Properties(property))); //xpath the parent
			Actions action = new Actions(driver);
			WaitForSec(driver, 1);
			action.moveToElement(getmenu).build().perform();
		} catch (Exception e) {
		}
	}

	//Posicionarse encima del obj BOOLEAN 
	public static boolean HoverBoolean(WebDriver driver, String property) {
		try {
			WebElement getmenu = driver.findElement(By.xpath(Properties(property))); //xpath the parent
			Actions action = new Actions(driver);
			action.moveToElement(getmenu).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Cerrar ventana emergente
	public static void AceptEmergentWindows(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	//Limpiar monto
	public static String CleanAmount(String elem) {
		String all = "";
		// System.out.println("Cadena: " +elem);
		Pattern pat = Pattern.compile("\\d+(?:[.,]\\d+)?|Free");
		Matcher m = pat.matcher(elem);
		while (m.find()) {
			//System.out.println(m.group(0));
			//   System.out.println(" -  Coincidencia: " + m.group(0));
			all += m.group(0);
		}
		//System.out.println("Resultado: " + all);
		//  System.out.println("");
		return all;
	}

	//Obtener un numero random
	public static int GetNumberRandom(long range) {
		//long range = 11111111L;
		Random r = new Random();
		int number = (int) (r.nextDouble() * range);
		return number;
	}
	
	//Obtener un numero random
	public static int GetNumberRandom(int top,int range) {
		//long range = 11111111L;
		Random r = new Random();
		int number = (int) (r.nextInt(top))+range;
		return number;
	}
		
	//Obtener fecha con posibilidad de sumarle dias 26/07/2018 11:28
	public static String GetCalendar(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		sdf.setTimeZone(TimeZone.getDefault());
		String result = sdf.format(calendar.getTime());
		return result;
	}
	//Leer captcha
/*	public static String ReadCaptcha(WebDriver driver, String property )throws IOException{
		 String imageUrl=driver.findElement(By.id(property)).getAttribute("src");
		// System.out.println("Image source path : \n"+ imageUrl);
		 URL url = new URL(imageUrl);
		 Image image = ImageIO.read(url);
		 String text = new OCR().recognizeCharacters((RenderedImage) image);
		// System.out.println("Text From Image : \n"+ s);
		// System.out.println("Length of total text : \n"+ s.length());
		 return text;
	 }*/
	
	public static boolean StartConnection() {
		boolean verify = false;
		ConnectionDB.getConnection();
		try {
			if (!ConnectionDB.getConnection().isClosed()) {
				verify= true;
			}else {
			    verify = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			verify =  false;
		}
		return verify;
	}
	
	public static String GetRowDatabase(String query, int row) throws SQLException{
		String field = null;
		ResultSet rs = ConnectionDB.StatementQuery().executeQuery(query);
		if (rs.next()) {
			  field = rs.getString(row);
		}
		return field;
	}
	
	public static String GetRowDatabase(String query) throws SQLException{
		String field = null;
		ResultSet rs = ConnectionDB.StatementQuery().executeQuery(query);
		if (rs.next()) {
			  field = rs.getString(1);
		}
		return field;
	}
	
	// Limitar String por la derecha o izquierda 
	public static String LimitStringRightOrLeft(String cadena, int rigth, int left) {
		return cadena.substring(rigth, cadena.length()-left);
	}
}

