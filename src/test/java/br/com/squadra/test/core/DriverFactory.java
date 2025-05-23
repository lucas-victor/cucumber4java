package br.com.squadra.test.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import br.com.squadra.test.exceptions.BrowserInvalidoException;

public class DriverFactory {

	private static WebDriver driver;

	private final static String EXEC_MODE = "normal"; //Altere normal ou headless // headless só chrome e firefox
	private final static String CHOSEN_BROWSER = BrowserType.CHROME; //Altere para rodar com chrome, firefox, IE, edge

	private DriverFactory() {
	};
	//retorna driver
	public static WebDriver getDriver() {

		if (driver == null) {
			try {
				
				switch (CHOSEN_BROWSER) {
				case "chrome":
					getDriverForName(BrowserType.CHROME);
					break;
				case "firefox":	
					getDriverForName(BrowserType.FIREFOX);
					break;
				case "internet explorer":
					getDriverForName(BrowserType.IE);
					break;
				case "MicrosoftEdge":
					getDriverForName(BrowserType.EDGE);
					break;
				default:
					System.out.println("Driver inválido, escolha um driver válido. [chrome, firefox, edge, internet explorer]");
					break;
				}		
				
			} catch (BrowserInvalidoException e) {
				System.out.println("Browser inválido.");
			}
			// driver.manage().window().maximize();
			
		}
		//implicty wait 100 sec because vpn.
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return driver;
	}
	
	private static void getDriverForName(String browserType) throws BrowserInvalidoException {
		Browser browser = Browser.validaBrowser(browserType);		
		System.setProperty(browser.getPropriedadeDriver(), browser.getPathDriver());
		definirDriver(browser.getNome(), EXEC_MODE);
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
