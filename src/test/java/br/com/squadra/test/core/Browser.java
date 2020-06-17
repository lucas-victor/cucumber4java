package br.com.squadra.test.core;

import br.com.squadra.test.exceptions.BrowserInvalidoException;

public class Browser {

	private static String pathChromeDriverWin = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
	private static String pathFirefoxDriverWin = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe";
	private static String pathIeDriverWin = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\IEDriverServer.exe";
	private static String pathEdgeDriverWin = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe";
	private static String pathChromeDriverLinux = System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver";
	private static String pathFirefoxDriverLinux = System.getProperty("user.dir") + "//src//test//resources//drivers//geckodriver";
	private static String pathIeDriverLinux = System.getProperty("user.dir") + "//src//test//resources//drivers//IEDriverServer";
	private static String pathEdgeDriverLinux = System.getProperty("user.dir") + "//src//test//resources//drivers//MicrosoftWebDriver";
	
	private String nome;
	private String propriedadeDriver;
	private String pathDriver;

	public Browser(String nome, String propriedadeDriver, String pathDriver) {
		this.nome = nome;
		this.propriedadeDriver = propriedadeDriver;
		this.pathDriver = pathDriver;
	}

	public String getNome() {
		return nome;
	}

	public String getPropriedadeDriver() {
		return propriedadeDriver;
	}

	public String getPathDriver() {
		return pathDriver;
	}

	public static Browser validaBrowser(String navegador) throws BrowserInvalidoException {
		String osname = System.getProperty("os.name");

		if (osname.toLowerCase().contains("windows")) {

			if (navegador.equals("chrome") || navegador.equals("googlechrome")) {
				return new Browser("chrome", "webdriver.chrome.driver", pathChromeDriverWin);
			} else if (navegador.equals("firefox")) {
				return new Browser("firefox", "webdriver.gecko.driver", pathFirefoxDriverWin);
			} else if (navegador.equals("MicrosoftEdge")) {
				return new Browser("MicrosoftEdge", "webdriver.edge.driver", pathEdgeDriverWin);
			} else if (navegador.equals("internet explorer")) {
				return new Browser("internet explorer", "webdriver.ie.driver", pathIeDriverWin);
			}
		}else{
			if (navegador.equals("chrome") || navegador.equals("googlechrome")) {
				return new Browser("chrome", "webdriver.chrome.driver", pathChromeDriverLinux);
			} else if (navegador.equals("firefox")) {
				return new Browser("firefox", "webdriver.gecko.driver", pathFirefoxDriverLinux);
			} else if (navegador.equals("MicrosoftEdge")) {
				return new Browser("MicrosoftEdge", "webdriver.edge.driver", pathEdgeDriverLinux);
			} else if (navegador.equals("internet explorer")) {
				return new Browser("internet explorer", "webdriver.ie.driver", pathIeDriverLinux);
			}
		}
		
		throw new BrowserInvalidoException();
	}
}
