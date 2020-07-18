@ConsultaMSISDN_IMSI_TER @ConsultaALL
Feature: Realiza consulta por MSISDN-IMSI-TERMINAL no portal Consulta Plataformas 
  Como um usuario
  eu quero realizar uma consulta por MSISDN, IMSI e TERMINAL
  no portal Consulta Plataformas.

Background:
	 Given que estou logado no site
	 
  @ConsultaMSISDN_IMSI_TER
  Scenario Outline: Realiza consulta por MSISDN com sucesso
    And acesso o menu Consulta Plataformas
    When preencho os dados da tela com MSISDN <msisdn>
    And seleciono a plataforma <plataforma>
    And clico no botao Pesquisar 
    Then devo ver os dados exibidos
    And validar as informacoes da consulta <msisdnresult>
  
   Examples: 
      |  			 msisdn			  	  |		     plataforma		      	|     msisdnresult        |
      | "12345678901"           |		"VMS Novitech VMS04"			|      "msisdn_1"         |
      | "5534567890123"				  |		"VMS Novitech VMS04" 			|      "msisdn_2"         |

  
  @ConsultaMSISDN_IMSI_TER
  Scenario Outline: Realiza consulta por IMSI com sucesso
    And acesso o menu Consulta Plataformas
    When preencho os dados da tela com IMSI <imsi>
    And seleciono a plataforma <plataforma>
    And clico no botao Pesquisar
    Then devo ver os dados exibidos
    And validar as informacoes da consulta <imsiresult>
  
   Examples: 
      | 				 	imsi  				|       plataforma	         |   imsiresult      |
      | "724456789012345"       |		"SmartKeyHuawei LSMS01"  |    "imsi"         |
      
 
  @ignore
  Scenario Outline: Realiza consulta por TERMINAL com sucesso
    And acesso o menu Consulta Plataformas
    When preencho os dados da tela com TERMINAL <terminal>
    And seleciono a plataforma <plataforma>
    And clico no botao Pesquisar
    Then devo ver os dados exibidos
    And validar as informacoes da consulta <terminalresult>
  
   Examples: 
      | 				terminal    		 		|    plataforma   		|     terminalresult        |
      | "num 10 dig - 1234567890"   |			"Tropico"   	  |       "terminal"     		  |
      | "num 10 dig - 7244567890"   |			"VMP05"		  		|       "terminal"     		  |
