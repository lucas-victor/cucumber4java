package br.com.squadra.test.pages;

public class UolPage extends BasePage {
	
	private String XPATH_LINK_FOLHA = "//a//span[contains(text(),'Folha')]";

	
	public UolPage() {
		
	}
	
	public void clicarLinkFolha() {
		getDSL().clicar(XPATH_LINK_FOLHA);
	}
	
 
}
