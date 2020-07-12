package br.com.squadra.test.core;

import static br.com.squadra.test.core.DriverFactory.fecharDriver;
import static br.com.squadra.test.core.DriverFactory.getDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

public class DSL {

	private final static Integer ESPERA_PADRAO = 30;
	private final static String TOKEN_CONSULTA_PLATAFORMAS = "\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsIkF1dGgiOnsiZW1haWwiOiJwZWRyby5jb3N0YUBzcXVhZHJhLmNvbS5iciIsImxvZ2luIjoicGVkcm8iLCJuYW1lIjoicGVkcm8iLCJwcm9maWxlIjoiQURNSU5JU1RSQURPUiAtIEFETUlOSVNUUkFET1IiLCJyb2xlcyI6WyJST0xFX1JBU1RSRUFCSUxJREFERV9WSUVXIiwiUk9MRV9SRVNQT1NUQV9WSUVXX1VQREFURSIsIlJPTEVfUkVTUE9TVEFfRVNQRUNJRklDQV9WSUVXX1VQREFURSIsIlJPTEVfRUxFTUVOVE9fUkVERV9WSUVXX1VQREFURSIsIlJPTEVfQVVESVRPUklBX1ZJRVciLCJST0xFX01BUEVBTUVOVE9fVklFV19VUERBVEUiLCJST0xFX0NPTkZJR1VSQUNBT19ISVNUT1JJQ09fVklFV19VUERBVEUiLCJST0xFX0xJTVBBX0NBQ0hFX1ZJRVdfVVBEQVRFIiwiUk9MRV9QRVJGSUxfVklFV19VUERBVEUiLCJST0xFX0hMUl9HVEhMUl9PQ0NGX1ZJRVdfVVBEQVRFIiwiUk9MRV9TUEFfR1RUX0dUU19NQVRfVklFV19VUERBVEUiLCJST0xFX0NOX1BSRUZJWF9HVFRfVklFV19VUERBVEUiLCJST0xFX1RQX0NTUE9fUlNUX0xETl9MRElfVklFV19VUERBVEUiLCJST0xFX1RQX0NTUE9fUlNUX0xESV9WSUVXX1VQREFURSIsIlJPTEVfVFBfQ1NQT19SU1RfTEROX1ZJRVdfVVBEQVRFIiwiUk9MRV9WUE5fSURfVklFV19VUERBVEUiLCJST0xFX1NBX0FQTl9QRFBJRF9WSUVXX1VQREFURSIsIlJPTEVfQ05fT0NDRl9WSUVXX1VQREFURSIsIlJPTEVfUkVURU5DQU9fSExSX1ZJRVdfVVBEQVRFIiwiUk9MRV9SRVRFTkNBT19DTl9QUkVGSVhPX1ZJRVdfVVBEQVRFIiwiUk9MRV9HVFRfT1BfU0VSVl9OQU1FX1ZJRVdfVVBEQVRFIiwiUk9MRV9ST1VfUExBTk9fQ05fVklFV19VUERBVEUiLCJST0xFX1JFVEVOQ0FPX0NOX1ZJRVdfVVBEQVRFIiwiUk9MRV9QQVJTRVJfU0VSVl9BUFJPVl9WSUVXX1VQREFURSIsIlJPTEVfUEFSU0VSX1BBUkFNX1ZJRVdfVVBEQVRFIiwiUk9MRV9DQVBUQ0hBX1ZJRVciLCJST0xFX0hMUiBOb2tpYV9WSUVXIiwiUk9MRV9TbWFydEtleSBIdWF3ZWlfVklFVyIsIlJPTEVfU01TQyBBY2lzaW9uX1ZJRVciLCJST0xFX1VEUiBOb2tpYV9WSUVXIiwiUk9MRV9WTVMgTm92aXRlY2hfVklFVyIsIlJPTEVfUENSRiBIdWF3ZWlfVklFVyIsIlJPTEVfT0NTIEh1YXdlaV9WSUVXIiwiUk9MRV9JTl9WSUVXIiwiUk9MRV9OR04gUjJfVklFVyIsIlJPTEVfSU1TX1ZJRVciLCJST0xFX1Ryb3BpY29fVklFVyIsIlJPTEVfQU1fTkdOUjJfVklFVyJdfX0.eyJwcm9maWxlIjoiQURNSU5JU1RSQURPUiAtIEFETUlOSVNUUkFET1IiLCJyb2xlcyI6WyJST0xFX1JBU1RSRUFCSUxJREFERV9WSUVXIiwiUk9MRV9SRVNQT1NUQV9WSUVXX1VQREFURSIsIlJPTEVfUkVTUE9TVEFfRVNQRUNJRklDQV9WSUVXX1VQREFURSIsIlJPTEVfRUxFTUVOVE9fUkVERV9WSUVXX1VQREFURSIsIlJPTEVfQVVESVRPUklBX1ZJRVciLCJST0xFX01BUEVBTUVOVE9fVklFV19VUERBVEUiLCJST0xFX0NPTkZJR1VSQUNBT19ISVNUT1JJQ09fVklFV19VUERBVEUiLCJST0xFX0xJTVBBX0NBQ0hFX1ZJRVdfVVBEQVRFIiwiUk9MRV9QRVJGSUxfVklFV19VUERBVEUiLCJST0xFX0hMUl9HVEhMUl9PQ0NGX1ZJRVdfVVBEQVRFIiwiUk9MRV9TUEFfR1RUX0dUU19NQVRfVklFV19VUERBVEUiLCJST0xFX0NOX1BSRUZJWF9HVFRfVklFV19VUERBVEUiLCJST0xFX1RQX0NTUE9fUlNUX0xETl9MRElfVklFV19VUERBVEUiLCJST0xFX1RQX0NTUE9fUlNUX0xESV9WSUVXX1VQREFURSIsIlJPTEVfVFBfQ1NQT19SU1RfTEROX1ZJRVdfVVBEQVRFIiwiUk9MRV9WUE5fSURfVklFV19VUERBVEUiLCJST0xFX1NBX0FQTl9QRFBJRF9WSUVXX1VQREFURSIsIlJPTEVfQ05fT0NDRl9WSUVXX1VQREFURSIsIlJPTEVfUkVURU5DQU9fSExSX1ZJRVdfVVBEQVRFIiwiUk9MRV9SRVRFTkNBT19DTl9QUkVGSVhPX1ZJRVdfVVBEQVRFIiwiUk9MRV9HVFRfT1BfU0VSVl9OQU1FX1ZJRVdfVVBEQVRFIiwiUk9MRV9ST1VfUExBTk9fQ05fVklFV19VUERBVEUiLCJST0xFX1JFVEVOQ0FPX0NOX1ZJRVdfVVBEQVRFIiwiUk9MRV9QQVJTRVJfU0VSVl9BUFJPVl9WSUVXX1VQREFURSIsIlJPTEVfUEFSU0VSX1BBUkFNX1ZJRVdfVVBEQVRFIiwiUk9MRV9DQVBUQ0hBX1ZJRVciLCJST0xFX0hMUiBOb2tpYV9WSUVXIiwiUk9MRV9TbWFydEtleSBIdWF3ZWlfVklFVyIsIlJPTEVfU01TQyBBY2lzaW9uX1ZJRVciLCJST0xFX1VEUiBOb2tpYV9WSUVXIiwiUk9MRV9WTVMgTm92aXRlY2hfVklFVyIsIlJPTEVfUENSRiBIdWF3ZWlfVklFVyIsIlJPTEVfT0NTIEh1YXdlaV9WSUVXIiwiUk9MRV9JTl9WSUVXIiwiUk9MRV9OR04gUjJfVklFVyIsIlJPTEVfSU1TX1ZJRVciLCJST0xFX1Ryb3BpY29fVklFVyIsIlJPTEVfQU1fTkdOUjJfVklFVyJdLCJpc3MiOiJTcU9pU2lzQXRpdmFjYW8iLCJub21lIjoicGVkcm8iLCJleHAiOjE1OTc2MDQ1MzAsImxvZ2luIjoicGVkcm8iLCJlbWFpbCI6InBlZHJvLmNvc3RhQHNxdWFkcmEuY29tLmJyIn0.Z0iO8Qu47wY-wrzim90RgpjMQFyy_LFHtqhY0Rz3J_Y\"";
	private final static String QUERY_ACTUAL_RESULT_PATH = "target/report-html/actualQueryResults/";
	private final static String QUERY_EXPECTED_RESULT_PATH = "src/test/java/expectedQueryResults/";
	private final static String QUERY_ACTUAL_RESULT_PATH_LINUX = "target//report-html//actualQueryResults//";
	private final static String QUERY_EXPECTED_RESULT_PATH_LINUX = "src//test//java//expectedQueryResults//";
	
	private DbManager db = new DbManager();
	protected Report report = new Report();
	
	public DSL() {

	}

	public DSL visitarPagina(String url) {
		getDriver().get(url);
		return this;
	}

	public DSL getPageWithToken(String url) {
		getDriver().get(url);
		LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
		local.setItem("token", TOKEN_CONSULTA_PLATAFORMAS);
		getDriver().navigate().refresh();
		return this;
	}

	public DSL mouseHoverClickXpath(String xpath) {
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xpath));
		action.moveToElement(we).moveToElement(getDriver().findElement(By.xpath(xpath))).click().build().perform();
		return this;
	}

	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public void clicarLinkXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public DSL inserirCampo(String xpath, String valor) {
		WebElement campo = encontrar(xpath);
		campo.sendKeys(valor);
		return this;
	}

	public String getEndereco() {
		return getDriver().getCurrentUrl();
	}

	public void esperaAteExistente(String xpath) {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public void esperaAteExistenteId(String id) {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}
	
	public void esperaAteExistenteCSS(String css) {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
	}

	private WebElement getElemento(String xpath) {
		esperaAteExistente(xpath);
		return getDriver().findElement(By.xpath(xpath));
	}
	
	private WebElement getElementoId(String id) {
		esperaAteExistenteId(id);
		return getDriver().findElement(By.id(id));
	}
	
	private WebElement getElementoCSS(String css) {
		esperaAteExistenteCSS(css);
		return getDriver().findElement(By.cssSelector(css));
	}

	private Object executarJavascript(String codigo, Object... parametros) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(codigo, parametros);
	}

	private DSL scrollAteElemento(WebElement elemento) {
		executarJavascript("arguments[0].scrollIntoView(true);", elemento);
		return this;
	}

	private WebElement clicarElemento(String xpath) {
		WebElement elemento = null;
		try {
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			elemento.click();
		} catch (WebDriverException e) {
			scrollAteElemento(getElemento(xpath));
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			try {
				elemento.click();
			} catch (ElementClickInterceptedException cl) {
				elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
						.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
				elemento.click();
			}

		}
		return elemento;
	}
	
	private WebElement clicarElementoId(String id) {
		WebElement elemento = null;
		try {
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			elemento.click();
		} catch (WebDriverException e) {
			scrollAteElemento(getElementoId(id));
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			try {
				elemento.click();
			} catch (ElementClickInterceptedException cl) {
				elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
						.until(ExpectedConditions.visibilityOfElementLocated((By.id(id))));
				elemento.click();
			}

		}
		return elemento;
	}
	
	private WebElement clicarElementoCSS(String css) {
		WebElement elemento = null;
		try {
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
			elemento.click();
		} catch (WebDriverException e) {
			scrollAteElemento(getElementoCSS(css));
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
			try {
				elemento.click();
			} catch (ElementClickInterceptedException cl) {
				elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
						.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(css))));
				elemento.click();
			}

		}
		return elemento;
	}

	public DSL clicar(String xpath) {
		this.clicarElemento(xpath);
		return this;
	}
	
	public DSL clicarId(String id) {
		this.clicarElemento(id);
		return this;
	}
	
	public DSL clicarCSS(String css) {
		this.clicarElementoCSS(css);
		return this;
	}
	
	public void verificarNaoApareceuNaTela(String xpath) {
		boolean tela = getDriver().findElement(By.xpath(xpath)).isDisplayed();
		if (!tela) {
			Assert.assertEquals("", "objeto nÃ£o apareceu na tela, verificar!");
		}
	}
	
	public String getTexto(String xpath) {
		WebElement textField = getElemento(xpath);
		String texto;
		try {
			texto = textField.getText().trim();
		} catch (WebDriverException e) {
			textField = getElemento(xpath);
			texto = textField.getText().trim();
		}
		return texto;
	}

	public String getAtributo(String xpath, String atributo) {
		WebElement textField = getElemento(xpath);
		String texto;
		try {
			texto = textField.getAttribute(atributo).trim();
		} catch (WebDriverException e) {
			textField = getElemento(xpath);
			texto = textField.getAttribute(atributo).trim();
		}
		return texto;
	}

	public void fecharNavegador() throws InterruptedException {
		fecharDriver();
	}

	public DSL esperarAteUrlConter(String string) {
		WebDriverWait wait = new WebDriverWait(getDriver(), ESPERA_PADRAO);
		wait.until(ExpectedConditions.urlContains(string));
		return this;
	}

	public void clicarBotao(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public void selecionarCombo(String xpath, String valor) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarRadio(String xpath) {
		clicarRadio(By.xpath(xpath));
	}

	public DSL esperarAteClicavel(String xpath) {
		(new WebDriverWait(getDriver(), ESPERA_PADRAO)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return this;
	}

	public DSL esperarAteExistente(String xPath) {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		espera.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPath))));
		return this;
	}

	public DSL esperarAteExistente(String xPath, Integer tempo) {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), tempo);
		espera.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPath))));
		return this;
	}

	public DSL esperarAteInvisivel(String xPath) {
		WebDriverWait esperaUm = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		WebDriverWait esperaTodos = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		List<WebElement> elementos = getDriver().findElements(By.xpath(xPath));
		esperaTodos.until(ExpectedConditions.invisibilityOfAllElements(elementos));
		esperaUm.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
		return this;
	}

	private WebElement encontrar(String campo) {
		esperarAteExistente(campo);
		return getDriver().findElement(By.xpath(campo));
	}

	public void validarConteudo(String xpath, String valor) {
		Assert.assertEquals(valor, getDriver().findElement(By.xpath(xpath)).getText());
	}

	public DSL digitar(String xpath, String texto) {
		WebElement elemento = encontrar(xpath);
		elemento.clear();
		elemento.sendKeys(texto + Keys.ENTER);
		return this;
	}
	
	public DSL digitarName(String name, String texto) {
		WebElement elemento = getDriver().findElement(By.name(name));
		elemento.clear();
		elemento.sendKeys(texto + Keys.ENTER);
		return this;
	}
	
	public DSL digitarId(String id, String texto) {
		WebElement elemento = getDriver().findElement(By.id(id));
		elemento.clear();
		elemento.sendKeys(texto + Keys.ENTER);
		return this;
	}

	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}

	public void addToken(String token) {
		LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
		local.setItem("token", token);
		getDriver().navigate().refresh();
	}

	//escreve arquivo e salva
	public String writeFile(String fileName, String text) {
		return db.writeFileResult(fileName, text);
	}
	
	public String readFileExpected(String fileName) {
		String fullPathFile = QUERY_EXPECTED_RESULT_PATH + fileName;
		return db.readFileResult(fullPathFile);
	}
	
	public String readFileActual(String fileName) {
		String fullPathFile = QUERY_ACTUAL_RESULT_PATH + fileName;
		return db.readFileResult(fullPathFile);
	}
	
	//METODOS QUE DEVERÃO ABSTRAIDOS...
	public String getResultTable(String xpath) {
		// pega todas as tags tr dentro do painel.
		WebElement tabela = getDriver().findElement(By.xpath(xpath));
		List<WebElement> linhasTabela = tabela.findElements(By.cssSelector("tr"));
		//List<String> listaCompletaStr = new ArrayList<String>();
		String file = "";
		//Reporter.addStepLog("Dados verificados na tela: ");
		// Itera nas tags tr para fazer o assert no resultado.
		if (linhasTabela.isEmpty()) {
			//Assert.assertEquals(resultTabela.get(0).toString(), "");
			//System.out.println("tabela vazia");
			//listaCompletaStr.add("");
			file = "";
		} else {
			//int count = 0;
			for (WebElement element : linhasTabela) {
				String result = element.getText();
				System.out.println("resultAct: " + result);
				file = result + "\n";
				
				//System.out.println("resultExp: " + resultTabela.get(count).toString());
				//listaCompletaStr.add(result);
				//Reporter.addStepLog(result);
				//Assert.assertEquals(resultTabela.get(count).toString(), result);
				//count++;
			}
		}
		
		return file;
	}
	
	public void assertTwoFileResults(String fileNameExp, String fileNameAct) {
		db.assertTwoFileResults(fileNameExp, fileNameAct);
	}
	
	public void validaResultadoOCSid() {

		List<String> resultTabela = new ArrayList<String>();
		resultTabela.add("MSISDN 5588988343305");
		resultTabela.add("Documento (CPF/CNPJ/PASSAPORTE) 10979451701");
		resultTabela.add("Original ID 1-1DY4WGGF");
		resultTabela.add("ID da Conta 1-1J1IZLL5OCS");
		resultTabela.add("Plano Principal 5001");
		resultTabela.add("ID do Plano Suplementar 1200001");
		resultTabela.add("Data de EfetivaÃ§Ã£o do plano suplementar 15/04/2020 14:48:43");
		resultTabela.add("Data de ExpiraÃ§Ã£o do plano suplementar 31/12/2036 21:00:00");
		resultTabela.add("ID do Plano Suplementar 2200018");
		resultTabela.add("Data de EfetivaÃ§Ã£o do plano suplementar 15/04/2020 14:48:43");
		resultTabela.add("Data de ExpiraÃ§Ã£o do plano suplementar 31/12/2036 21:00:00");
		resultTabela.add("ID do Plano Suplementar 2200004");
		resultTabela.add("Data de EfetivaÃ§Ã£o do plano suplementar 15/04/2020 14:48:43");
		resultTabela.add("Data de ExpiraÃ§Ã£o do plano suplementar 31/12/2036 21:00:00");
		resultTabela.add("ID do Plano Suplementar 2200003");
		resultTabela.add("Data de EfetivaÃ§Ã£o do plano suplementar 15/04/2020 14:48:43");
		resultTabela.add("Data de ExpiraÃ§Ã£o do plano suplementar 31/12/2036 21:00:00");
		resultTabela.add("ID do Plano Suplementar 2200001");
		resultTabela.add("Data de EfetivaÃ§Ã£o do plano suplementar 15/04/2020 14:48:43");
		resultTabela.add("Data de ExpiraÃ§Ã£o do plano suplementar 31/12/2036 21:00:00");
		resultTabela.add("ID do Plano Suplementar 1200001");
		resultTabela.add("ID do Plano Suplementar 2200001");

		// pega todas as tags tr dentro do painel.
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id=\"ui-panel-0-content\"]"));
		List<WebElement> linhasTabela = tabela.findElements(By.cssSelector("tr"));

		//Reporter.addStepLog("Dados verificados na tela: ");
		report.addStepLog("Dados verificados na tela: ");
		// Itera nas tags tr para fazer o assert no resultado.
		if (linhasTabela.isEmpty()) {
			Assert.assertEquals(resultTabela.get(0).toString(), "");
		} else {
			int count = 0;
			for (WebElement element : linhasTabela) {
				String result = element.getText();
				System.out.println("resultAct: " + result);
				System.out.println("resultExp: " + resultTabela.get(count).toString());

				//Reporter.addStepLog(result);
				report.addStepLog(result);
				Assert.assertEquals(resultTabela.get(count).toString(), result);
				count++;
			}
		}
		
	}
	
	
	
	
}