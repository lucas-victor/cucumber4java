package br.com.squadra.test.steps;

import java.io.IOException;
import br.com.squadra.test.core.DSL;

import br.com.squadra.test.core.DbManager;
import br.com.squadra.test.core.Report;
import br.com.squadra.test.pages.ConsultaPlatPage;
import br.com.squadra.test.pages.FolhaPage;
import br.com.squadra.test.pages.GloboPage;
import br.com.squadra.test.pages.GloboesportePage;
import br.com.squadra.test.pages.HomePage;
import br.com.squadra.test.pages.LoginPage;
import br.com.squadra.test.pages.UolPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private UolPage uolPage = new UolPage();
	private GloboPage globoPage = new GloboPage();
	private GloboesportePage globoesportePage = new GloboesportePage();
	private FolhaPage folhaPage = new FolhaPage();
	private ConsultaPlatPage consultaPage = new ConsultaPlatPage();
	private Report report = new Report();
	private TestRule tr = new TestRule();
	private DbManager db = DbManager.getDbManagerSql();

	@Given("que acesso o site do google")
	public void acessoOpen() throws IOException {
		loginPage.acessarPaginaPrincipal();

		// escreve no relatorio
		report.addStepLog("Teste google acesso write...");
		// tira screeshot da tela e salvo o print em arquivo e insere no relatorio
		report.getScreenShot("testeAcessoGoogle");

		// Executa query, imprime no relatorio nome e conteudo do arquivo.
		//String fileName = db.executeQueryWithResultFile("selectAll", "select * from produtos");
		
		// escreve no relatorio o conteudo do arquivo salvo no diretorio.
		//report.writeReportSql(fileName);
		
		//faz assert dos 2 arquivos, esperado e atual.
		//db.assertTwoFilesResults("selectAll_21-06-2020_00.50.54.txt", fileName);

	}

	@When("pesquiso pelo site {string}")
	public void pesquisoSiteLancenet(String site) {
		homePage.pesquisarSiteLancenet(site);
		report.addStepLog("Teste pesquiso pelo site...");
		report.getScreenShot("testePesquisaSite");
		
		// executa query e retorna resultado em string
		//String resultSql = db.executeQueryGetResult("select descricao from produtos");

		//report.writeReport(resultSql);
	}

	@Then("acesso o primeiro site retornado do globo")
	public void acessoPrimeiroSiteRetornadoGlobo() {
		homePage.acessarPrimeiroSiteRetornadoGlobo();
		report.getScreenShot("testeAcessoSite");

		// Executa query e salva o arquivo na pasta do relatorio
		//String fileName = db.executeQueryWithResultFile("SelNomePreco", "select nome, preco from produtos");
		
		// escreve no relatorio o conteudo do arquivo salvo no diretorio.
		//report.writeReportSql(fileName);
		
		//faz assert dos 2 arquivos, esperado e atual.
		//db.assertTwoFilesResults("SelNomePreco_21-06-2020_00.41.48.txt", fileName);
	}

	@When("acesso o primeiro site retornado do UOL")
	public void acessoPrimeiroSiteRetornadoUOL() {
		homePage.acessarPrimeiroSiteRetornadoUOL();
		
		//só executa a query, sem retorno.
		//db.executeQuery("select * from produtos");
		
		
	}

	@When("clico no link para o GloboEsporte")
	public void clicoLinkGloboEsporte() {
		globoPage.clicarLinkGloboesporte();
		report.getScreenShot("testeAcessoGloboEsporte");

		// Executa query e salva o arquivo na pasta do relatorio
		//String fileName = db.executeQueryWithResultFile("SelIdPreco", "select id, nome from produtos");
		
		// escreve no relatorio o conteudo do arquivo salvo no diretorio.
		//report.writeReportSql(fileName);
		
		//faz assert dos 2 arquivos, esperado e atual.
		//db.assertTwoFilesResults("SelIdPreco_21-06-2020_00.41.54.txt", fileName);
	}

	@When("clico no link para a Folha de São Paulo")
	public void clicoLinkFolha() {
		uolPage.clicarLinkFolha();
	}

	@Then("valido o logo do site Globo Esporte")
	public void validoConteudoTituloGloboEsporte() {
		globoesportePage.validarConteudoTitulo();
	}

	@Then("valido a existência do link Mundo")
	public void validoLinkMundo() {
		folhaPage.validarLinkMundo();
		consultaPage.selecionaPlataforma("id");
		
	}
	
	
	//Teste consulta plataformas...
	
	@Given("que estou logado no site")
	public void queEstouLogadoNoSite() {
	    consultaPage.acessaTelaInicial();
	}

	@Given("acesso o menu Consulta Plataformas")
	public void acessoOMenuConsultaPlataformas() {
	    consultaPage.clicarMenuConsulta();
	}

	@When("preencho os dados da tela com ID {string}")
	public void preenchoOsDadosDaTelaComID(String id) {
		consultaPage.selecionaRadioButton("id");
	    consultaPage.digitarTerminal(id);
	}

	@When("seleciono a plataforma {string}")
	public void selecionoAPlataforma(String plataforma) {
	    consultaPage.selecionaPlataforma(plataforma);
	}

	@When("clico no botao Pesquisar")
	public void clicoNoBotaoPesquisar() {
		report.getScreenShot("dadosParaConsulta");
	    consultaPage.clicarBotaoPesquisar();
	}

	@Then("devo ver os dados exibidos")
	public void devoVerOsDadosExibidos() {
	    consultaPage.verificaExibiraDados();
	}

	@Then("validar as informacoes da OCS Huawei OCS{int} {string}")
	public void validarAsInformacoesDaOCSHuaweiOCS(Integer int1, String string) {
	    consultaPage.validaInformacoesOcsHuawei("id");
	}
	
	
}
