package br.com.squadra.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import br.com.squadra.test.core.Report;

public class ConsultaPlatPage extends BasePage {

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
	// Arvore de plataformas
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
	// tabela de resultado ID
	private String XPATH_PANEL_RESULT = "//*[@class=\"pi pi-minus\"]";
	private String XPATH_TABELA_RESULT_OCS_ID = "//*[@id=\"ui-panel-0-content\"]";
	// Tabelas de resultados CPF CNJP
	private String XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_1 = "//*[@id=\"ui-tabpanel-0\"]";
	private String XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_2 = "//*[@id=\"ui-tabpanel-1\"]";
	private String XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_3 = "//*[@id=\"ui-tabpanel-2\"]";
	private String XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_4 = "//*[@id=\"ui-tabpanel-3\"]";
	private String XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_5 = "//*[@id=\"ui-tabpanel-4\"]";
	// Abas CPF CNPJ
	private String XPATH_OCS_CPFCNPJ_ABA_1 = "//*[@id=\"ui-tabpanel-0-label\"]/span";
	private String ID_OCS_CPFCNPJ_ABA_2 = "ui-tabpanel-2-label";
	private String ID_OCS_CPFCNPJ_ABA_3 = "ui-tabpanel-3-label";
	private String ID_OCS_CPFCNPJ_ABA_4 = "ui-tabpanel-4-label";
	private String ID_OCS_CPFCNPJ_ABA_5 = "ui-tabpanel-5-label";
	// tabela de resultado msisdn
	private String XPATH_TABELA_RESULT_VMS04_MSISDN = "//*[@id=\"ui-panel-0-content\"]/div";
	// tabela de resultado imsi
	private String XPATH_TABELA_RESULT_LSMS01_IMSI = "//*[@id=\"ui-panel-0-content\"]/div";

	public ConsultaPlatPage() {

	}

	public void acessaTelaInicial() {
		getDSL().getPageWithToken(URL_INICIO);

	}

	public void clicarMenuConsulta() {
		// getDSL().digitar(XPATH_CAMPO_PESQUISA, site);
		getDSL().mouseHoverClickXpath(XPATH_MENU_CONSULTA);
	}

	public void selecionaRadioButton(String opcaoRadio) {
		if (opcaoRadio.equalsIgnoreCase("id")) {
			getDSL().clicar(XPATH_RADIO_ID);
		} else if (opcaoRadio.equalsIgnoreCase("msisdn") 
				|| opcaoRadio.equalsIgnoreCase("imsi")
				|| opcaoRadio.equalsIgnoreCase("terminal")) {
			getDSL().clicar(XPATH_RADIO_MSISDN_IMSI_TERMINAL);
		} else {
			getDSL().clicar(XPATH_RADIO_CPF_CNPJ);
		}
	}

	public void digitarTerminal(String terminal) {
		// driver.findElement(By.name()).sendKeys(terminal);
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

	// verifica se a panel abriu
	public void verificaExibiraDados() {
		// getDSL().verificarNaoApareceuNaTela(XPATH_PANEL_RESULT);
	}

	// pega texto tabela page.
	public String getTextResultTable(String xpath) {
		return getDSL().getResultTable(xpath);
	}

	// escreve arquivo e retorna nome
	public String writeFileResult(String fileName, String text) {
		return getDSL().writeFile(fileName, text);
	}

	public void validaInformacoesOcsHuawei(String idOrCpf) {

		if (idOrCpf.equalsIgnoreCase("id")) {

			// pega texto da tabela do site.
			String conteudoTabela = getDSL().getResultTable(XPATH_TABELA_RESULT_OCS_ID);
			// salva arquivo com conteudo passado
			String nomeArqResultAtual = getDSL().writeFile("resultIdOCS01", conteudoTabela);
			// faz assert de 2 arquivos, resultado esperado e resultado atual.
			getDSL().assertTwoFileResults("resultIdOCS01_13-07-2020_20.03.46.txt", nomeArqResultAtual);

		} else if (idOrCpf.equalsIgnoreCase("cpf") || idOrCpf.equalsIgnoreCase("cnpj")) {

			// pega texto da tabela do site.
			String nomeArqResultAtualAba1 = getDSL().writeResultTableFileXpath("resultCpfCnpjOCS01Aba1", XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_1);
			// clica na aba 2
			getDSL().clicarId(ID_OCS_CPFCNPJ_ABA_2);
			String nomeArqResultAtualAba2 = getDSL().writeResultTableFileXpath("resultCpfCnpjOCS01Aba2", XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_2);
			// clica na aba 3
			getDSL().clicarId(ID_OCS_CPFCNPJ_ABA_3);
			String nomeArqResultAtualAba3 = getDSL().writeResultTableFileXpath("resultCpfCnpjOCS01Aba3", XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_3);
			// clica na aba 4
			getDSL().clicarId(ID_OCS_CPFCNPJ_ABA_4);
			String nomeArqResultAtualAba4 = getDSL().writeResultTableFileXpath("resultCpfCnpjOCS01Aba4", XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_4);
			// clica na aba 5
			getDSL().clicarId(ID_OCS_CPFCNPJ_ABA_5);
			String nomeArqResultAtualAba5 = getDSL().writeResultTableFileXpath("resultCpfCnpjOCS01Aba5", XPATH_TABELA_RESULT_OCS01_CPFCNJP_ABA_5);

			// Valida resultados
			getDSL().assertTwoFileResults("resultCpfCnpjOCS01Aba1", nomeArqResultAtualAba1);
			getDSL().assertTwoFileResults("resultCpfCnpjOCS01Aba2", nomeArqResultAtualAba2);
			getDSL().assertTwoFileResults("resultCpfCnpjOCS01Aba3", nomeArqResultAtualAba3);
			getDSL().assertTwoFileResults("resultCpfCnpjOCS01Aba4", nomeArqResultAtualAba4);
			getDSL().assertTwoFileResults("resultCpfCnpjOCS01Aba5", nomeArqResultAtualAba5);

		} else {
			// gravar MSISDN
		}

	}

	public void validaInformacoesConsulta(String result) {
		String nomeArqResultAtual = "";
		
		if (result.startsWith("msisdn")) {
			
			if (result.equalsIgnoreCase("msisdn_1")) {
				nomeArqResultAtual = getDSL().writeResultTableFileXpath("resultMsisdnVMS04", XPATH_TABELA_RESULT_VMS04_MSISDN);
				getDSL().assertTwoFileResults("resultMsisdnVMS04", nomeArqResultAtual);
			
			}else if(result.equalsIgnoreCase("msisdn_2")) {
				nomeArqResultAtual = getDSL().writeResultTableFileXpath("resultMsisdnVMS04_2", XPATH_TABELA_RESULT_VMS04_MSISDN);
				getDSL().assertTwoFileResults("resultMsisdnVMS04_2", nomeArqResultAtual);
			}
				
		} else if (result.startsWith("imsi")) {

			nomeArqResultAtual = getDSL().writeResultTableFileXpath("resultImsiLSMS01", XPATH_TABELA_RESULT_LSMS01_IMSI);
			getDSL().assertTwoFileResults("resultImsiLSMS01", nomeArqResultAtual);
			
		} else if (result.startsWith("terminal")) {
			//Falta implementar, não estava na demanda.		
		}
	}

//	public void acessarPrimeiroSiteRetornadoUOL() {
//		getDSL().esperarAteExistente(XPATH_PRIMEIRO_ITEM_RETORNADO_UOL, 5000).clicar(XPATH_PRIMEIRO_ITEM_RETORNADO_UOL);
//	}
}
