@ConsultaCPFCNPJ @ConsultaALL
Feature: Realiza consulta por CPF e CNPJ no portal Consulta Plataformas 
  Como um usuario
  eu quero realizar uma consulta por CPF CNPJ
  no portal Consulta Plataformas.

Background:
	 Given que estou logado no site
	 
  @ConsultaCPFCNPJ
  Scenario Outline: Realiza consulta por CPF com sucesso
    And acesso o menu Consulta Plataformas
    When preencho os dados da tela com CPF <cpf>
    And seleciono a plataforma <plataforma>
    And clico no botao Pesquisar
    Then devo ver os dados exibidos
    And validar as informacoes da OCS Huawei OCS01 <cpfresult>
  
   Examples: 
    |  							cpf  			  	|     plataforma        |   		cpfresult	      |
    | "07800568710" 				  		|  "OCS Huawei OCS01"		|       "cpf"   				|
 		| "07800568710" 				  		|  "OCS Huawei OCS01"		|       "cpf"   				|

  
  @ConsultaCPFCNPJ
  Scenario Outline: Realiza consulta por CNPJ com sucesso
    And acesso o menu Consulta Plataformas
    When preencho os dados da tela com CNPJ <cnpj>
    And seleciono a plataforma <plataforma>
    And clico no botao Pesquisar
    Then devo ver os dados exibidos
    And validar as informacoes da OCS Huawei OCS01 <cnpjresult>
  
   Examples: 
      |  cnpj  							    |     plataforma        |  	 cnpjresult       |
      | "12345678901234"        |  "OCS Huawei OCS01"		|       "cnpj"     	  |
