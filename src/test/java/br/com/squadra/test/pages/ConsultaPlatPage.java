package br.com.squadra.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

public class ConsultaPlatPage extends BasePage{

	private String URL_INICIO = "http://10.121.216.69:7003/sisativacao/#/home";
	private String SAIR = "";
	private String XPATH_CAMPO_PESQUISA = "//input[@class='gLFyf gsfi']";
	private String XPATH_PRIMEIRO_ITEM_RETORNADO_GLOBO = "//h3[contains(text(),'globo.com')]";
	private String XPATH_PRIMEIRO_ITEM_RETORNADO_UOL = "//h3[contains(text(),'UOL - O melhor conteúdo')]";
	private String XPATH_MENU_CONSULTA = "//*[@id=\"slide-out\"]/li[5]/a";
	private String XPATH_RADIO_ID = "//*[@id=\"radio_IDAssinante\"]/div/div[2]";
	private String XPATH_RADIO_MSISDN_IMSI_TERMINAL = "//*[@id=\"radio_MSISDN/IMSI/Terminal\"]/div/div[2]";
	private String XPATH_RADIO_CPF_CNPJ = "//*[@id=\"radio_CPF/CNPJ\"]/div/div[2]";
	private String NAME_CAMPO_TERMINAL = "terminal";
	private String CSS_TREE_GSM = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > div > span.ui-tree-toggler.pi.pi-fw.ui-unselectable-text.pi-caret-right";
	private String CSS_TREE_GSM_OCSHUAWEI = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > ul > p-treenode:nth-child(7) > li > div > span.ui-tree-toggler.pi.pi-fw.ui-unselectable-text.pi-caret-right";
	private String CSS_TREE_GSM_OCSHUAWEI_OCS01 = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > ul > p-treenode:nth-child(7) > li > ul > p-treenode > li > div > div > div";
	private String CSS_TREE_GSM_VMSnovitech = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > ul > p-treenode:nth-child(5) > li > div > span.ui-tree-toggler.pi.pi-fw.ui-unselectable-text.pi-caret-right";
	private String CSS_TREE_GSM_VMSnovitech_VMS04 = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > ul > p-treenode:nth-child(5) > li > ul > p-treenode > li > div > div > div";
	private String CSS_TREE_GSM_SMARTKEYHUAWEI = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > ul > p-treenode:nth-child(2) > li > div > span.ui-tree-toggler.pi.pi-fw.ui-unselectable-text.pi-caret-right";
	private String CSS_TREE_GSM_SMARTKEYHUAWEI_LSMS01 = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(1) > li > ul > p-treenode:nth-child(2) > li > ul > p-treenode:nth-child(1) > li > div > div > div";
	private String CSS_TREE_FIXA = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(2) > li > div > span.ui-tree-toggler.pi.pi-fw.ui-unselectable-text.pi-caret-right";
	private String CSS_TREE_FIXA_IMS = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(2) > li > ul > p-treenode:nth-child(2) > li > div > span.ui-tree-toggler.pi.pi-fw.ui-unselectable-text.pi-caret-right";
	private String CSS_TREE_FIXA_IMS_SAM01 = "body > app-root > div > app-consulta-plataforma-list > div > div > div > div > div.col-sm-3.col-md-3.container > app-filtro-consulta > div > div > div.card-body.elementoAltura > form > p-tree > div > ul > p-treenode:nth-child(2) > li > ul > p-treenode:nth-child(2) > li > ul > p-treenode > li > div > div > div";
	private String ID_BOTAO_PESQUISAR = "pesquisar";
	private String XPATH_PANEL_RESULT = "//*[@class=\"pi pi-minus\"]";
	private String XPATH_TABELA_RESULT_OCS_ID = "//*[@id=\"ui-panel-0-content\"]";

	
	public ConsultaPlatPage() {
		
	}
	
	public void acessaTelaInicial() {
		getDSL().getPageWithToken(URL_INICIO);
		
	}
	
	public void clicarMenuConsulta(String site) {
		//getDSL().digitar(XPATH_CAMPO_PESQUISA, site);
		getDSL().mouseHoverClickXpath(XPATH_MENU_CONSULTA);
	}
	
	public void selecionaRadioButton(String opcaoRadio) {
		if (opcaoRadio.equalsIgnoreCase("id")) {
			getDSL().clicar(XPATH_RADIO_ID);
		} else if (opcaoRadio.equalsIgnoreCase("msisdn") || opcaoRadio.equalsIgnoreCase("imsi") || opcaoRadio.equalsIgnoreCase("terminal")) {
			getDSL().clicar(XPATH_RADIO_MSISDN_IMSI_TERMINAL);
		} else {
			getDSL().clicar(XPATH_RADIO_CPF_CNPJ);
		}	
	}
	
	public void preencheTerminal(String terminal) {
		//driver.findElement(By.name()).sendKeys(terminal);
		getDSL().digitarName(NAME_CAMPO_TERMINAL, terminal);
	}
	
	public void selecionaPlataforma(String plataforma) {
		
		switch (plataforma) {
		case "OCS Huawei OCS01":
			getDSL().clicarCSS(CSS_TREE_GSM);
			getDSL().clicarCSS(CSS_TREE_GSM_OCSHUAWEI);
			getDSL().clicarCSS(CSS_TREE_GSM_OCSHUAWEI_OCS01);
			break;
		
		case "VMS Novitech VMS04":
			getDSL().clicarCSS(CSS_TREE_GSM);
			getDSL().clicarCSS(CSS_TREE_GSM_VMSnovitech);
			getDSL().clicarCSS(CSS_TREE_GSM_VMSnovitech_VMS04);
			break;
		
		case "SmartKeyHuawei LSMS01":
			getDSL().clicarCSS(CSS_TREE_GSM);
			getDSL().clicarCSS(CSS_TREE_GSM_SMARTKEYHUAWEI);
			getDSL().clicarCSS(CSS_TREE_GSM_SMARTKEYHUAWEI_LSMS01);
			break;
		
		case "IMS SAM01":
			getDSL().clicarCSS(CSS_TREE_FIXA);
			getDSL().clicarCSS(CSS_TREE_FIXA_IMS);
			getDSL().clicarCSS(CSS_TREE_FIXA_IMS_SAM01);
			break;

		default:
			break;
		}
		
	}
	
	public void clicarBotaoPesquisar() {
		getDSL().clicarId(ID_BOTAO_PESQUISAR);
	}
	
	//verifica se a panel abriu
	public void verificaExibiraDados() {
		getDSL().verificarNaoApareceuNaTela(XPATH_PANEL_RESULT);
	}
	
	//pega texto tabela page.
	public String getTextResultTable(String xpath) {
		return getDSL().getResultTable(xpath);
	}
	
	//escreve arquivo e retorna nome
	public String writeFileResult(String fileName, String text) {
		return getDSL().writeFile(fileName, text);
	}
	
	public void validaInformacoesOcsHuawei(String idOrCpf) {
		//getDSL().validaResultadoOCSid();
		String result = getDSL().getResultTable(XPATH_TABELA_RESULT_OCS_ID);
		String resultFileName = getDSL().writeFile("resultOcsID", result);
		
				
	}
	
	
	
	public void acessarPrimeiroSiteRetornadoUOL() {
		getDSL().esperarAteExistente(XPATH_PRIMEIRO_ITEM_RETORNADO_UOL, 5000)
				.clicar(XPATH_PRIMEIRO_ITEM_RETORNADO_UOL);
	}
}
