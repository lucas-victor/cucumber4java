package br.com.squadra.test.steps;

import static br.com.squadra.test.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.squadra.test.core.Report;
import br.com.squadra.test.pages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	LoginPage loginPage = new LoginPage();
	private Report report = new Report();
	private TakesScreenshot ss;
	private Scenario scenario;


	
	public TestRule() {
		
	}
	
	@After
	public void fecharBrowser(Scenario cenario) throws IOException {
		report.getScreenShot(cenario);
		loginPage.fecharBrowser(); 
	}

	@Before
	public void iniciliazarCenario(Scenario scenario) {
		this.scenario = scenario;
		this.ss = (TakesScreenshot) getDriver();
	}

	public Scenario getScenario() {
		return this.scenario;
	}
	
}
