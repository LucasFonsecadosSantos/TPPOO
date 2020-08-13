OLA PROFESSOR!

Para a execucao da simulacao, basta compilar o codigo e na chamada do objeto,
passar como argumento o arquivo de entrada. Para tal, escrevemos um script bash
entao basta executar:

$ ./compile.sh
para compilar e depois:

$ ./init.sh <nome_arquivo_entrada>.txt
para executar a simulacao informando o arquivo de entrada.

O arquivo de entrada e parseado pela aplicacao, entao devera seguir rigorosamente
o padrao definido:

[INICIO-ATENDENTE]
<nome_atendente>,<nivel>
...
[FIM-ATENDENTE]

[INICIO-ELEITOR]
<nome_eleitor>,<numero_titulo_eleitor>,<tipo_eleitor>,<tipo_atendimento>
...
[FIM-ELEITOR]





As definicoes de dados sao:
<nome_atendente> 	= Uma string de qualquer tamanho
<nivel>			= Experiente ou Iniciante
<nome_eleitor>		= Uma string de qualquer tamanho
<numero_titulo_eleitor>	= Um numero de qualquer tamanho
<tipo_eleitor>		= prioritario ou comum
<tipo_atendimento>	= votar ou justificar


Enviamos junto ao trabalho um arquivo denominado input.txt com um exemplo de entrada
que pode ser utilizado.

A saida com as estatisticas sao geradas na pasta /build/data do projeto.

A documentacao javadoc foi gerada na pasta /docs.

Para compilar sem o uso do script bash, e necessario fazer compilacao recursiva via terminal linux
com o seguinte comando:

$ javac /dev/**/*.java

e para execucao do codigo objeto sem o uso do script por nos escrito, e necessario:
$ java /dev/Main <args>

Agradecemos desde ja!
Qualquer coisa entre em contato:
lucas.santos3@estudante.ufla.br
maureliocfh@gmail.com

GITHUBS: 	github.com/LucasFonsecaDosSantos
		github.com/maureliofs
