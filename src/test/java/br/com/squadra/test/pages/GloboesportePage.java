package br.com.squadra.test.pages;

public class GloboesportePage extends BasePage {
	
	private String XPATH_LOGO_GLOBOESPORTE = "//div[@id='glb-topo']//div[2]//a[@class='logo-area']";

	
	public GloboesportePage() {
		
	}
	
	public void validarConteudoTitulo() {
		getDSL().validarConteudo(XPATH_LOGO_GLOBOESPORTE, "globoesporte.com");
	}
	
 
}
