package br.com.squadra.test.pages;

public class GloboPage extends BasePage {
	
	private String XPATH_LINK_GLOBOESPORTE = "//ul[@id='home-menu']//li[2]//div[@class='home-analytics-area home-analytics-id-T']//span[1]";

	
	public GloboPage() {
		
	}
	
	public void clicarLinkGloboesporte() {
		getDSL().clicar(XPATH_LINK_GLOBOESPORTE);
	}
	
 
}
