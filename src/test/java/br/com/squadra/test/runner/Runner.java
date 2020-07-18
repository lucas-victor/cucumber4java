package br.com.squadra.test.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.squadra.test.core.DbManager;
import br.com.squadra.test.core.Report;
import br.com.squadra.test.pages.BasePage;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features/",
		glue = {"br.com.squadra.test.steps"},
		tags = {"@ConsultaALL", "~@ignore"}, //@Run
		plugin = {"pretty", "html:target/report-html/", "json:target:report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class Runner extends BasePage {
	
	@BeforeClass
	public static void before() {
		//limpa diretorio de arquivos gerados pelo teste.
		Report.getReport().limparPastas();
		
		//Restaura base de dados antes de iniciar a suite de testes.
		//DbManager.getDbManagerSql().restoreDbSql();	
	}
	
	@AfterClass
	public static void writeExtentReport() {
		//Zipa pasta de relatorios, backup.
		Report.getReport().zipFolder();
	}
}