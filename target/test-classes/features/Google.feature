@Google

Feature: Pesquisa no google

	Background:
		Given que acesso o site do google
	
	
	@Run
	Scenario: Acesso site GloboEsporte
		When pesquiso pelo site "https://www.globo.com/"
		And acesso o primeiro site retornado do globo
		And clico no link para o GloboEsporte
		Then valido o logo do site Globo Esporte
		
	@Run
	Scenario: Acesso site Folha de São Paulo
		When pesquiso pelo site "https://www.uol.com.br/"
		And acesso o primeiro site retornado do UOL
		And clico no link para a Folha de São Paulo
		Then valido a existência do link Mundo