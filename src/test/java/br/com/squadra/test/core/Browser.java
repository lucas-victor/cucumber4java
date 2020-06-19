package br.com.squadra.test.core;

import br.com.squadra.test.exceptions.BrowserInvalidoException;

public class Browser {

	private final static String CHROMEDRIVER_PATH_WIN = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe";
	private final static String FIREFOXDRIVER_PATH_WIN = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\geckodriver.exe";
	private final static String IEDRIVER_PATH_WIN = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\IEDriverServer.exe";
	private final static String EDGEDRIVER_PATH_WIN = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\MicrosoftWebDriver.exe";
	private final static String CRHOMEDRIVER_PATH_LINUX = System.getProperty("user.dir") + "//src//test//java//drivers//chromedriver";
	private final static String FIREFOXDRIVER_PATH_LINUX = System.getProperty("user.dir") + "//src//test//java//drivers//geckodriver";
	private final static String IEDRIVER_PATH_LINUX = System.getProperty("user.dir") + "//src//test//java//drivers//IEDriverServer";
	private final static String EDGEDRIVER_PATH_LINUX = System.getProperty("user.dir") + "//src//test//java//drivers//MicrosoftWebDriver";
	
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
				return new Browser("chrome", "webdriver.chrome.driver", CHROMEDRIVER_PATH_WIN);
			} else if (navegador.equals("firefox")) {
				return new Browser("firefox", "webdriver.gecko.driver", FIREFOXDRIVER_PATH_WIN);
			} else if (navegador.equals("MicrosoftEdge")) {
				return new Browser("MicrosoftEdge", "webdriver.edge.driver", EDGEDRIVER_PATH_WIN);
			} else if (navegador.equals("internet explorer")) {
				return new Browser("internet explorer", "webdriver.ie.driver", IEDRIVER_PATH_WIN);
			}
		}else{
			if (navegador.equals("chrome") || navegador.equals("googlechrome")) {
				return new Browser("chrome", "webdriver.chrome.driver", CRHOMEDRIVER_PATH_LINUX);
			} else if (navegador.equals("firefox")) {
				return new Browser("firefox", "webdriver.gecko.driver", FIREFOXDRIVER_PATH_LINUX);
			} else if (navegador.equals("MicrosoftEdge")) {
				return new Browser("MicrosoftEdge", "webdriver.edge.driver", EDGEDRIVER_PATH_LINUX);
			} else if (navegador.equals("internet explorer")) {
				return new Browser("internet explorer", "webdriver.ie.driver", IEDRIVER_PATH_LINUX);
			}
		}
		
		throw new BrowserInvalidoException();
	}
}
