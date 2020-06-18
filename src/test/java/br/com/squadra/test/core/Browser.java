package br.com.squadra.test.core;

import br.com.squadra.test.exceptions.BrowserInvalidoException;

public class Browser {

	private final static String PATH_CHROMEDRIVER_WIN = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
	private final static String PATH_FIREFOXDRIVER_WIN = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe";
	private final static String PATH_IEDRIVER_WIN = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\IEDriverServer.exe";
	private final static String PATH_EDGEDRIVER_WIN = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe";
	private final static String PATH_CRHOMEDRIVER_LINUX = System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver";
	private final static String PATH_FIREFOXDRIVER_LINUX = System.getProperty("user.dir") + "//src//test//resources//drivers//geckodriver";
	private final static String PATH_IEDRIVER_LINUX = System.getProperty("user.dir") + "//src//test//resources//drivers//IEDriverServer";
	private final static String PATH_EDGEDRIVER_LINUX = System.getProperty("user.dir") + "//src//test//resources//drivers//MicrosoftWebDriver";
	
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
				return new Browser("chrome", "webdriver.chrome.driver", PATH_CHROMEDRIVER_WIN);
			} else if (navegador.equals("firefox")) {
				return new Browser("firefox", "webdriver.gecko.driver", PATH_FIREFOXDRIVER_WIN);
			} else if (navegador.equals("MicrosoftEdge")) {
				return new Browser("MicrosoftEdge", "webdriver.edge.driver", PATH_EDGEDRIVER_WIN);
			} else if (navegador.equals("internet explorer")) {
				return new Browser("internet explorer", "webdriver.ie.driver", PATH_IEDRIVER_WIN);
			}
		}else{
			if (navegador.equals("chrome") || navegador.equals("googlechrome")) {
				return new Browser("chrome", "webdriver.chrome.driver", PATH_CRHOMEDRIVER_LINUX);
			} else if (navegador.equals("firefox")) {
				return new Browser("firefox", "webdriver.gecko.driver", PATH_FIREFOXDRIVER_LINUX);
			} else if (navegador.equals("MicrosoftEdge")) {
				return new Browser("MicrosoftEdge", "webdriver.edge.driver", PATH_EDGEDRIVER_LINUX);
			} else if (navegador.equals("internet explorer")) {
				return new Browser("internet explorer", "webdriver.ie.driver", PATH_IEDRIVER_LINUX);
			}
		}
		
		throw new BrowserInvalidoException();
	}
}
