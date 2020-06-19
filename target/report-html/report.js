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
  "error_message": "java.lang.AssertionError: expected:\u003ctrue\u003e but was:\u003cfalse\u003e\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:835)\r\n\tat org.junit.Assert.assertEquals(Assert.java:120)\r\n\tat org.junit.Assert.assertEquals(Assert.java:146)\r\n\tat br.com.squadra.test.core.DbManager.assertFilesResults(DbManager.java:212)\r\n\tat br.com.squadra.test.steps.StepDefinition.acessoOpen(StepDefinition.java:53)\r\n\tat ✽.que acesso o site do google(file:src/test/resources/features/Google.feature:6)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.step({
  "name": "acesso o primeiro site retornado do globo",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.acessoPrimeiroSiteRetornadoGlobo()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "clico no link para o GloboEsporte",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.clicoLinkGloboEsporte()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "valido o logo do site Globo Esporte",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.validoConteudoTituloGloboEsporte()"
});
formatter.result({
  "status": "skipped"
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
  "error_message": "java.lang.AssertionError: expected:\u003ctrue\u003e but was:\u003cfalse\u003e\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:835)\r\n\tat org.junit.Assert.assertEquals(Assert.java:120)\r\n\tat org.junit.Assert.assertEquals(Assert.java:146)\r\n\tat br.com.squadra.test.core.DbManager.assertFilesResults(DbManager.java:212)\r\n\tat br.com.squadra.test.steps.StepDefinition.acessoOpen(StepDefinition.java:53)\r\n\tat ✽.que acesso o site do google(file:src/test/resources/features/Google.feature:6)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.step({
  "name": "acesso o primeiro site retornado do UOL",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.acessoPrimeiroSiteRetornadoUOL()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "clico no link para a Folha de São Paulo",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.clicoLinkFolha()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "valido a existência do link Mundo",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.validoLinkMundo()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});