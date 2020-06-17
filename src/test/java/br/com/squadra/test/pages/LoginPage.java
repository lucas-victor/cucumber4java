package br.com.squadra.test.pages;

public class LoginPage extends BasePage{
	
	private String URL_LOGIN = "";
	private String CAMPO_USUARIO = "";          
	private String CAMPO_SENHA =  "";                           
	private String BOTAO_ENTRAR = "";
	private String URL_GOOGLE = "https://www.google.com/";
	
	public LoginPage() {
		
	}

	public void acessarPaginaLogin() {
		getDSL().visitarPagina(URL_LOGIN);
	}
	
	public void acessarPaginaPrincipal() {
		getDSL().visitarPagina(URL_GOOGLE);
	}
	
	private void setUsuario(String usuario) {
		getDSL().inserirCampo(CAMPO_USUARIO, usuario);
	}
	
	private void setSenha(String senha) {
		getDSL().inserirCampo(CAMPO_SENHA, senha);
	}
	
	public void efetuarLogin(String usuario, String senha) {
		if (!estaEmLogin()) {
			getDSL().visitarPagina(URL_LOGIN);
		}
		setUsuario(usuario);
		setSenha(senha);
		getDSL().clicarBotao(BOTAO_ENTRAR);
	}
	
	public boolean estaEmLogin() {
		return getDSL().getEndereco().equals(URL_LOGIN);
	}

}
