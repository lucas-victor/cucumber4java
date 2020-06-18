package br.com.squadra.test.core;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;

import br.com.squadra.test.exceptions.BrowserInvalidoException;

public class DriverFactory {

	private static WebDriver driver;


	private final static String EXEC_MODE = "normal"; //Altere normal ou headless // headless só chrome e firefox
	private final static String CHOSEN_BROWSER = BrowserType.CHROME; //Altere para rodar com chrome, firefox, IE, edge

	private DriverFactory() {
	};

	public static WebDriver getDriver() {

		if (driver == null) {
			try {
				
				switch (CHOSEN_BROWSER) {
				case "chrome":
					Browser chrome = Browser.validaBrowser(BrowserType.CHROME);		
					System.setProperty(chrome.getPropriedadeDriver(), chrome.getPathDriver());			
					definirDriver(chrome.getNome(), EXEC_MODE);
					break;
				case "firefox":
					Browser firefox = Browser.validaBrowser(BrowserType.FIREFOX);		
					System.setProperty(firefox.getPropriedadeDriver(), firefox.getPathDriver());			
					definirDriver(firefox.getNome(), EXEC_MODE);
					break;
				case "internet explorer":
					Browser iE = Browser.validaBrowser(BrowserType.IE);		
					System.setProperty(iE.getPropriedadeDriver(), iE.getPathDriver());			
					definirDriver(iE.getNome(), EXEC_MODE);
					break;
				case "MicrosoftEdge":
					Browser edge = Browser.validaBrowser(BrowserType.EDGE);		
					System.setProperty(edge.getPropriedadeDriver(), edge.getPathDriver());			
					definirDriver(edge.getNome(), EXEC_MODE);
					break;

				default:
					break;
				}		
				
			} catch (BrowserInvalidoException e) {
				System.out.println("Browser inválido.");
			}
			// driver.manage().window().maximize();
		}

		return driver;
	}

	private static void definirDriver(String browserType, String modoExec) throws BrowserInvalidoException {

		if (modoExec.equalsIgnoreCase("headless")) {
			if (browserType == "chrome" || browserType == "googlechrome") {

				// Ativa o modo headless browser
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else if (browserType == "firefox") {

				// Ativa o modo headless browser
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			}

			else if (browserType == "internet explorer") {
				// IE não tem headless oficial.
				driver = new InternetExplorerDriver();
			}

			else if (browserType == "MicrosoftEdge") {
				// Falta implementar headless no edge
				// EdgeOptions options = new EdgeOptions();
				driver = new EdgeDriver();
			} else
				throw new BrowserInvalidoException();
		} else {
			if (browserType == "chrome" || browserType == "googlechrome") {
				driver = new ChromeDriver();
			}

			else if (browserType == "firefox") {
				driver = new FirefoxDriver();
			}

			else if (browserType == "internet explorer") {
				driver = new InternetExplorerDriver();
			}

			else if (browserType == "MicrosoftEdge") {
				driver = new EdgeDriver();
			} else
				throw new BrowserInvalidoException();
		}

	}

	
	public static void fecharDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
