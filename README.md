# Sistema de Análise e Previsão do IPCA

<img src="SistemaAnalisePrevisaoIPCA\src\telas\menu.png">

<hr/>
<h3>Informações do Desenvolvedor</h3>
Analista e Desenvovedor de Software, graduado pela Faculdade de Tecnologia da Unicamp.
<br/>LinkedIn: <a href="https://wwww.linkedin.com/in/felipeferreira-systemsanalyst/">linkedin.com/in/felipeferreira-systemsanalyst/</a>


<hr/>
<h3>Sobre o Projeto</h3>

Projeto desenvolvido durante Iniciação Tecnológica na Graduação, sob orientação do Professor Dr. Ivan M. Ricarte.
Neste projeto foi desenvolvido um software que tem como principal finalidade, a análise das taxas mensais de IPCA que são disponibilizadas pelo Portal Brasileiro de Dados Abertos (dados.gov.br). Através deste, é possível consultar o variações do IPCA do ano atual e de retroativos, porém também calcular uma taxa estimada para o próximo mês, através do conceito de tendência (regressão linear), baseado nos últimos doze meses.
O Índice Nacional de Preços ao Consumidor Amplo (IPCA) é produzido pelo IBGE desde 1979. Desde junho de 1999, é o índice utilizado pelo Banco Central do Brasil para o acompanhamento dos objetivos estabelecidos no sistema de metas de inflação, sendo considerado o índice oficial de inflação do país.

<hr/>
<h3>Finalidade</h3>

Tendo isso em vista, o software pode auxiliar profissionais que trabalhem com economia ou até empresas em suas projeções e prevenções em relação à inflação. Isso é possibilitado pela consulta de taxas de IPCA retroativas e auxílio para prever a futura.

<hr/>
<h3>Apresentação do sistema</h3>

O software foi desenvolvido em linguagem Java, através da IDE NetBeans.

O sistema basicamente é composto por três módulos:
<ul>
<li>Consultar Históricos Mensais do IPCA</li>
<li>Consultar Previsão de Variação do IPCA</li>
<li>Mais Informações Sobre o IPCA</li>
</ul>

<hr/>
<h3>Menu Inicial</h3>

<img src="SistemaAnalisePrevisaoIPCA\src\telas\telainicial.png">

<hr/>
<h3>Consultar Históricos Mensais</h3>

Através do módulo <i>Consultar Históricos Mensais</i> é possível analisar a variação da taxa do IPCA mês a mês.

<img src="SistemaAnalisePrevisaoIPCA\src\telas\historicoipca.png">

Conforme a imagem acima, cada registro é referente a um mês/categoria apurado na consulta, o sistema exibe as seguintes colunas de informações:
<ul>
<li><b>Mês apurado:</b> Trata-se do mês de apuração das taxas do registro.</li>
<li><b>Categoria:</b> O IPCA é composto por diversas categorias de consumo social que serão citadas adiante, esta coluna informa a qual categoria pertencem as taxas do registro.</li>
<li><b>Variação de IPCA do Mês:</b> É a taxa efetiva de variação de IPCA do mês apurado.</li>
<li><b>Variação Acumulada no Ano:</b> Esta taxa trata-se da somatória das taxas de variação mensal do IPCA que se acumulam no ano de referência do registro. Esta taxa é contabilizada de janeiro a dezembro de cada ano, sendo reiniciado valor acumulado a cada novo ano.</li>
<li><b>Variação Acumulada em 12 Meses:</b> Esta taxa trata-se da somatória das taxas de variação mensal do IPCA que se acumularam nos últimos 12 meses referentes ao registro. Esta taxa tem a contabilização semelhante à citada anteriormente, porém há uma diferença no período, utilizando-se dos últimos 12 meses para somatória e não apenas o ano atual.</li>
<li><b>Peso Mensal:</b> Este peso trata-se do valor de ponderação utilizado para compor a média do Índice Geral de variação do IPCA.</li>
</ul>

Ao clicar em <i>Consultar</i>, o sistema acessa o Portal Brasileiro de Dados Abertos para obter as informações sobre o IPCA. É feito download de arquivo JSON disponibilizado pelo portal (<a href="http://dados.gov.br/dataset/ia-indice-nacional-de-precos-ao-consumidor-amplo-ipca/resource/007cdefd-a819-4841-90c1-c2b7bf8ffbfc?inner_span=True>">dados.gov.br</a>) via código-fonte, automaticamente. Esse arquivo fica salvo no diretório local temporário do Java e posteriormente é acessado para ser processado pelo sistema e exibido na interface.
Antes de fazer o download do arquivo, o sistema valida a data da última alteração disponível no site, para não desperdiçar processamento baixando o mesmo arquivo (sem nenhuma atualização) novamente.

<img src="SistemaAnalisePrevisaoIPCA\src\telas\dadosgov.png">

Ao realizar o download do arquivo pela primeira vez, o sistema gera um arquivo de texto no mesmo diretório local (diretório temporário do Java) para gravar a data da última atualização do arquivo local e comparar com a data da página da Web antes de realizar o download do arquivo novamente. Caso a data seja mais recente, o sistema sobrescreve o arquivo local, baixando o atualizado e também altera a data de última atualização do arquivo <i>.txt</i>. Caso não, o sistema apenas carrega as informações do arquivo local para a interface, economizando processamento.

Para tornar o processamento mais rápido e facilitar busca pelas informações desejadas, o sistema disponibiliza ao usuário alguns filtros de consulta:

<ul>
<li>
<b>Período:</b> Filtra os registros pelo mês de apuração. O software disponibiliza alguns períodos pré-definidos para o usuário, sendo: Mês anterior, ano atual, últimos 5 anos e últimos 10 anos. Caso o usuário deseje consultar um período diferente pode utilizar a opção <i>Informar data</i> que habilitará os campos de <i>Mês início</i> e <i>Mês término</i>. Caso não deseje filtrar a consulta por período de apuração, pode-se utilizar a opção <i>Histórico Completo</i> que trará todo conteúdo do arquivo.
</li>
<br/>
<img src="SistemaAnalisePrevisaoIPCA\src\telas\filtroperiodo.png">
<br/>
<br/>
<li>
<b>Categoria:</b> O IPCA mensurado pelo IBGE é subdividido em categorias de consumo social, sendo elas: Alimentação e bebidas, habitação, artigos de residência, vestuário, transportes, saúde e cuidados pessoais, despesas pessoais. A cada uma dessas taxas é aplicado um peso percentual, dando origem ao Índice Geral variação do IPCA apurado no mês.
</li>
<br/>
<img src="SistemaAnalisePrevisaoIPCA\src\telas\filtrocategoria.png">
</ul>

Através do botão <i>Gráfico</i>, o sistema permite que o usuário crie a visualização gráfica da consulta, podendo optar por um gráfico de <i>Barras</i> ou <i>Linhas</i>.
Há um pequeno detalhe na geração de gráficos: Quando o usuário não utiliza o filtro de <i>Categoria</i>, o sistema traz apenas uma barra/linha por categoria no gráfico, sendo referente à taxa efetiva de variação do IPCA de cada categoria de forma genérica. Já quando existe uma categoria filtrada, o sistema exibirá três linhas, sendo a Taxa Efetiva de Variação do IPCA do mês, a Taxa Acumulada no ano e a Taxa Acumulada nos últimos 12 meses exclusivamente da categoria filtrada, permitindo mais detalhes das informações do IPCA da categoria específica.

Exemplos de Gráfico <b>com categoria</b> filtrada:

<ul>
<li>
<b>Linhas:</b>
</li>
<br/>
<img src="SistemaAnalisePrevisaoIPCA\src\telas\linhascomcategoria.png">
<br/>
<br/>
<li>
<b>Barras:</b> 
</li>
<br/>
<img src="SistemaAnalisePrevisaoIPCA\src\telas\barrascomcategoria.png">
</ul>

<br/>
<br/>
Exemplos de Gráfico <b>sem categoria</b> filtrada:
<br/>
<ul>
<li>
<b>Linhas:</b>
</li>
<br/>
<img src="SistemaAnalisePrevisaoIPCA\src\telas\linhassemcategoria.png">
<br/>
<br/>
<li>
<b>Barras:</b> 
</li>
<br/>
<img src="SistemaAnalisePrevisaoIPCA\src\telas\barrassemcategoria.png">
</ul>

<hr/>
<h3>Consultar Previsão de Variação do IPCA</h3>

Através do módulo <i>Consultar Previsão de Variação do IPCA</i> é possível analisar a variação da taxa do IPCA mês a mês.

<img src="SistemaAnalisePrevisaoIPCA\src\telas\previsaoipca.png">

Neste módulo, o sistema utiliza o mesmo arquivo JSON local, obtido do Portal Brasileiro de Dados Abertos. O software processas as taxas efetivas de variação do Índice Geral do IPCA dos últimos 12 meses e utiliza o conceito de Regressão Linear matemático para gerar uma previsão do Índice Geral do próximo mês.
O cálculo é semelhante ao utilizado pela função <i>TENDÊNCIA()</i> do software <i>Microsoft Excel</i>, resultando nos mesmo valores desta função quando cálculados e comparados sob as mesmas condições.
Abaixo a implementação Java dos métodos responsável pelo cálculo de previsão:

<img src="SistemaAnalisePrevisaoIPCA\src\telas\metodo.png">

<hr/>
<h3>Mais Informações sobre o IPCA</h3>

O Último módulo do software, <i>Mais Informações Sobre o IPCA</i>, se trata de um texto explicativo da definição de IPCA, sua utilidade e funcionalidade estatística e social.

<img src="SistemaAnalisePrevisaoIPCA\src\telas\sobreipca.png">

<hr/>
<h3>Conclusão</h3>

O software criado foi um projeto impulsionado pela busca de uma ferramenta simples e eficiente, fazendo uso de dados abertos, que pudesse ser utilizada nas mais variadas áreas, indo de estudantes de economia a indústrias. Este projeto viabiliza consultas e previsões em torno de todas as informações sobre o IPCA disponibilizados pelo Portal Brasileiro de Dados Abertos, tudo isso através de um processamento eficiente e um ambiente de interface agradável e simples de utilizar.


