package Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReportResults {
	private static String basePath = System.getProperty("user.dir") + File.separator;
	private static int contador = 1;
	private static final Log LOG = LogFactory.getLog(ReportResults.class);

	//Validate the step and return result
	public static boolean ValidateStep(boolean verify, ExtentReports logger, String coments, boolean validate) {
		if (verify) {
			if (validate) {
				logger.log(LogStatus.PASS, coments, "Done");
				return true;
			} else {
				logger.log(LogStatus.FATAL, coments, " Not Done");
				CreatePrintScreen(logger);
				return false;
			}
		} else {
			logger.log(LogStatus.FATAL, coments, " Not Done");
			CreatePrintScreen(logger);
			return false;
		}
	}

	//Validate the step and return result
	public static boolean ValidateStep(boolean verify, ExtentReports logger, String coments) {
		return ValidateStep(verify, logger, coments, true);
	}

	private static void CreatePrintScreen(ExtentReports logger) {
		BufferedImage pantalla;
		try {
			Robot robot = new Robot();
			pantalla = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			File file = new File(basePath + "report" + File.separator + "captura" + contador + ".png");
			ImageIO.write(pantalla, "png", file);
			logger.attachScreenshot(file.getCanonicalPath());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error(e.getCause());
		} contador++;
	}
}
