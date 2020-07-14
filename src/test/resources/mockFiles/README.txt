Configurar as respostas esperadas para o teste automatizado.

1 - Rodar o insert na "sis.tbmockreplyconfig" com o script "InsertTbMockReplyForAutTest.sql".
2 - Configurar os elementos de rede "LSMS01" e "VMS04" para o MockAdapter "MockQueryAdapter".
3 - O elemento de rede OCS01 deverá ter o MockAdapter "FileMockQueryAdapter".
4 - Copiar os arquivos de resposta subscribers_CPF e subscribers_ID para o diretório do servidor "/appl-sis-2/sis/bitelas"
5 - limpar o cache e dar o play no projeto de automação.


Melhorias a serem feitas:
1 - Criar uma classe que faça todos esses passos de forma automatica antes do start da bateria de testes.
2 - Criar uma classe para manipulação do banco de dados. Execução de querys, aplicação de dump/restore da posição inicial da base de dados.
