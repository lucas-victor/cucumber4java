package br.com.squadra.test.core;

import static br.com.squadra.test.core.DriverFactory.fecharDriver;
import static br.com.squadra.test.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	private Integer ESPERA_PADRAO = 30;

	public DSL() {

	}

	public DSL visitarPagina(String url) {
		getDriver().get(url);
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

	private WebElement getElemento(String xpath) {
		esperaAteExistente(xpath);
		return getDriver().findElement(By.xpath(xpath));
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

	public DSL clicar(String xpath) {
		this.clicarElemento(xpath);
		return this;
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
		(new WebDriverWait(getDriver(), ESPERA_PADRAO))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
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
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
}