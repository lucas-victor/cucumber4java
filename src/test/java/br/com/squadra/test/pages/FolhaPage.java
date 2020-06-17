package br.com.squadra.test.pages;

public class FolhaPage extends BasePage {
	
	private String XPATH_LINK_MUNDO = "//ul[@class='c-site-nav__list']//li[6]//a";

	
	public FolhaPage() {
		
	}
	
	public void validarLinkMundo() {
		esperarPaginaCarregar();
		getDSL().validarConteudo(XPATH_LINK_MUNDO, "mundo");
	}
	
 
}
