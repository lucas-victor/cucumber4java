@ConsultaID @ConsultaALL
Feature: Realiza consulta por ID no portal Consulta Plataformas 
  Como um usuario
  eu quero realizar consultas por ID
  no portal Consulta Plataformas.
  
Background:
	 Given que estou logado no site
  
  @ConsultaID
  Scenario Outline: Realiza consulta por ID com sucesso
    And acesso o menu Consulta Plataformas
    When preencho os dados da tela com ID <id>
    And seleciono a plataforma <plataforma> 
    And clico no botao Pesquisar
    Then devo ver os dados exibidos
    And validar as informacoes da OCS Huawei OCS01 <idresult>
  
   Examples: 
    |  							id  					  	|     plataforma        |  idresult   |
    | "12345"     										|  "OCS Huawei OCS01"		|     "id"    |
 		| "12345678901234567890" 					|  "OCS Huawei OCS01"   |     "id"    |