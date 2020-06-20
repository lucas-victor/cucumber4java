$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Google.feature");
formatter.feature({
  "name": "Pesquisa no google",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Google"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que acesso o site do google",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.acessoOpen()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Acesso site GloboEsporte",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Google"
    },
    {
      "name": "@Run"
    }
  ]
});
formatter.step({
  "name": "pesquiso pelo site \"https://www.globo.com/\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.pesquisoSiteLancenet(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "acesso o primeiro site retornado do globo",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.acessoPrimeiroSiteRetornadoGlobo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no link para o GloboEsporte",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.clicoLinkGloboEsporte()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido o logo do site Globo Esporte",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.validoConteudoTituloGloboEsporte()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que acesso o site do google",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.acessoOpen()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Acesso site Folha de São Paulo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Google"
    },
    {
      "name": "@Run"
    }
  ]
});
formatter.step({
  "name": "pesquiso pelo site \"https://www.uol.com.br/\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.pesquisoSiteLancenet(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "acesso o primeiro site retornado do UOL",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.acessoPrimeiroSiteRetornadoUOL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no link para a Folha de São Paulo",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.clicoLinkFolha()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido a existência do link Mundo",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.validoLinkMundo()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});