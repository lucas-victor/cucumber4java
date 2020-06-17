package br.com.squadra.test.pages;

public class HomePage extends BasePage {
	
	private String URL_INICIO = "";
	private String SAIR = "";
	private String XPATH_CAMPO_PESQUISA = "//input[@class='gLFyf gsfi']";
	private String XPATH_PRIMEIRO_ITEM_RETORNADO_GLOBO = "//h3[contains(text(),'globo.com')]";
	private String XPATH_PRIMEIRO_ITEM_RETORNADO_UOL = "//h3[contains(text(),'UOL - O melhor conteúdo')]";
	
	public HomePage() {
		
	}
	
	public void acessaTelaInicial() {
		getDSL().visitarPagina(URL_INICIO);
	}
	
	public void pesquisarSiteLancenet(String site) {
		getDSL().digitar(XPATH_CAMPO_PESQUISA, site);
	}
	
	public void acessarPrimeiroSiteRetornadoGlobo() {
		getDSL().esperarAteExistente(XPATH_PRIMEIRO_ITEM_RETORNADO_GLOBO, 5000)
				.clicar(XPATH_PRIMEIRO_ITEM_RETORNADO_GLOBO);
	}
	
	public void acessarPrimeiroSiteRetornadoUOL() {
		getDSL().esperarAteExistente(XPATH_PRIMEIRO_ITEM_RETORNADO_UOL, 5000)
				.clicar(XPATH_PRIMEIRO_ITEM_RETORNADO_UOL);
	}
 
}
