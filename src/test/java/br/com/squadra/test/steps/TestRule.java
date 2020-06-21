package br.com.squadra.test.steps;

import static br.com.squadra.test.core.DriverFactory.getDriver;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

import br.com.squadra.test.core.DbManager;
import br.com.squadra.test.core.Report;
import br.com.squadra.test.pages.LoginPage;
import cucumber.api.Result.Type;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	LoginPage loginPage = new LoginPage();
	private Report report = new Report();
	private DbManager db = DbManager.getDbManagerSql();
	private TakesScreenshot ss;
	public Scenario scenario;

	public TestRule() {
	}

	@After
	public void fecharBrowser(Scenario cenario) throws IOException {
		report.getScreenShot(cenario);
		loginPage.fecharBrowser();

		// Configurar a string de conexão com o banco de dados SqlServer.
		// Gera backup do banco ao final de cada teste.
		// db.backupDbSql();
	}

	@Before
	public void iniciliazarCenario(Scenario scenario) {
		this.scenario = scenario;
		this.ss = (TakesScreenshot) getDriver();

		// Configurar a string de conexão com o banco de dados SqlServer.
		// Restaura a base no inicio de cada teste.
		// db.restoreDbSql();
	}

//	public Scenario getScenario() {
//		return scenario;
//	}

}
