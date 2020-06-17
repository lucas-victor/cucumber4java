package br.com.squadra.test.pages;

import br.com.squadra.test.core.DSL;

public class BasePage {

	private DSL dsl = new DSL();
	protected String XPATH_UIBLOCK = "//div[contains(@class,'ui-block')]";
	protected String X_PATH_TEXTBLOCK = "//span[contains(@class,'blocked-text')]";
	
	
	protected DSL getDSL() {
		return dsl;
	}
	
	public void fecharBrowser() {
		try {
			getDSL().fecharNavegador();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	protected void esperarPaginaCarregar() {
		dsl.esperarAteInvisivel(XPATH_UIBLOCK);
		dsl.esperarAteInvisivel(X_PATH_TEXTBLOCK);
	}
}
