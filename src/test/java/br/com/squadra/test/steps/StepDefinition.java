package br.com.squadra.test.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.squadra.test.core.DbManager;
import br.com.squadra.test.core.Report;
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
	private Report report = new Report();
	private TestRule tr = new TestRule();
	private DbManager db = DbManager.getDbManagerSql();

	
	@Given("que acesso o site do google")
	public void acessoOpen() throws IOException {
		loginPage.acessarPaginaPrincipal();

		report.writeReport("Teste google acesso write...");
		report.getScreenShot("testeAcessoGoogle");
		
//		String result = db.executeQueryWithResult("select * from produtos");
//		report.writeReport("Query executada: select * from produtos" );
//		report.writeReport(result);
//		
//		db.writeFileResult("teste", "teste escreve arq");
//		
//		db.assertFilesResult("19-06-2020-11.59.46.txt", "19-06-2020-11.59.46.txt");
		
//		String resultExp = db.readFileResults("src/test/java/queryResultsExpected/" + "19-06-2020-11.59.46.txt");
//		String resultAct = db.readFileResults("target/report-html/queryResultsActual/" + "19-06-2020-11.59.46.txt");
//		
//		Assert.assertEquals(resultExp, resultAct);
//		//Assert.assertEquals("", "teste");
		
		db.assertFilesResults("19-06-2020-11.59.46.txt", "19-06-2020-11.59.46.txt");
	}

	@When("pesquiso pelo site {string}")
	public void pesquisoSiteLancenet(String site) {
		homePage.pesquisarSiteLancenet(site);
		report.writeReport("Teste pesquiso pelo site...");
		report.getScreenShot("testePesquisaSite");
	}

	@Then("acesso o primeiro site retornado do globo")
	public void acessoPrimeiroSiteRetornadoGlobo() {
		homePage.acessarPrimeiroSiteRetornadoGlobo();
		report.writeReport("Teste acesso o primeiro site retornado...");
		report.getScreenShot("testeAcessoSite");
	}

	@When("acesso o primeiro site retornado do UOL")
	public void acessoPrimeiroSiteRetornadoUOL() {
		 homePage.acessarPrimeiroSiteRetornadoUOL();
	}

	@When("clico no link para o GloboEsporte")
	public void clicoLinkGloboEsporte() {
		 globoPage.clicarLinkGloboesporte();
		 report.writeReport("Teste acesso GloboEsporte...");
		 report.getScreenShot("testeAcessoGloboEsporte");
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
	}
}
