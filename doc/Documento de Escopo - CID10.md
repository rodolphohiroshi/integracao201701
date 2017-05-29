CID-10
Escopo e requisitos do projeto

# 1.Visão geral

1. 1.Descrição e histórico do projeto

Projeto proposto durante a disciplina de Integração de Aplicações do curso de Engenharia de Software – UFG.

1. 2.Escopo do projeto

Desenvolver um módulo em Java que permita realizar buscas na tabela CID-10, para encontrar o código de uma doença, bem como sua descrição, presentes na CID-10.

1. 3.Requisitos de alto nível

No novo módulo:

- A busca pode ser feita apenas por parte do código, parte da descrição ou de ambos. Por exemplo, a busca por &quot;dengue&quot; deve trazer todas as entradas da CID-10 que contêm &quot;dengue&quot; como parte da descrição. Nesse caso, as entradas cujos códigos são A90 e A91. Por outro lado, se a entrada inclui &quot;90&quot; e &quot;dengue&quot;, então apenas a entrada de código A90 é a resposta correta para a consulta. Observe que não é necessário fornecer nem o código nem a descrição completa.
- O módulo  **cid10.jar**  deve incluir o código que implementa a busca e os dados propriamente ditos sobre os quais a busca é realizada. Ou seja, os arquivos que contêm a CID10 deverão estar embutidos nesse arquivo jar.
- O módulo  **cid10.jar**  deve incluir a classe CID10 que deve conter os métodos públicos  **load**  e  **unload**. O primeiro carrega e mantém em RAM os códigos e eventuais estruturas para a busca eficiente e o segundo remove da memória RAM qualquer índice e/ou dados para busca eficiente (cache). O método relevante dessa classe é o método  **search** , que recebe como argumento um vetor de sequências de caracteres (**String[]**). Esse método retorna  **null**  caso a entrada fornecida não identifique algum código correspondente e, caso contrário, um vetor de sequências de caracteres, contendo tantas entradas quanto os códigos localizados. A resposta sempre é o código seguido de um espaço em branco seguido da descrição. Por exemplo, um retorno possível é **A90 Dengue (dengue clássico)**, ou seja, o código A90 seguido de espaço que é seguido da descrição correspondente ao código A90.

1. 4.Requisitos Funcionais

- RF1 : A busca pode ser feita apenas por parte do código, parte da descrição ou de ambos, não é necessário fornecer nem o código nem a descrição completa.
- RF2: O módulo cid10.jar deve incluir o código que implementa a busca e os dados propriamente ditos sobre os quais a busca é realizada.
- RF3: O módulo cid10.jar deve incluir a classe CID10 que deve conter o método público load() que carrega e mantém em RAM – através de um ArrayList de String – os códigos e eventuais estruturas para a busca eficiente.
- RF4: O módulo cid10.jar deve incluir a classe CID10 que deve conter o método público unload() que remove da memória RAM qualquer índice e/ou dados para busca eficiente (cache).
- RF5: Método search(), que recebe como argumento um vetor de sequências de caracteres (String[]). Esse método retorna null caso a entrada fornecida não identifique algum código correspondente e, caso contrário, um vetor de sequências de caracteres, contendo tantas entradas quanto os códigos localizados. A resposta sempre é o código seguido de um espaço em branco seguido da descrição.
- RF6: O método load() deve ser chamado antes de utilizar o método search(), caso contrário uma exceção em tempo de execução será lançada, indicando que o método search() foi chamado em hora irregular.

1. 5.Resultados finais

Embora seja um projeto acadêmico, há possibilidade de utilização desse módulo por outros sistemas que queiram realizar buscas junto ao DATASUS (Departamento de Informática do SUS) na tabela CID-10.

Um provável sistema a utilizar esse módulo é o [Barramento SUS](https://github.com/kyriosdata/db/wiki/Barramento-SUS).

1. 6.Partes afetadas

 Quaisquer outros sistemas que quiserem utilizar este software como ferramenta para consulta de dados da tabela CID-10, assim como a própria tabela CID-10.

# 2.Aprovação e autoridade para proceder

Aprovamos o projeto como descrito acima e autorizamos a equipe a prosseguir.

| Nome | Título | Data |
| --- | --- | --- |
| Erik Raphael | Desenvolvedor e Analista de processos | |
| Erivan Barbosa | Gerente e Desenvolvedor | |
| Henrique Cardoso | Testador e Desenvolvedor | |
| Igor Queiroz | Desenvolvedor e Engenheiro de Requisitos | |
| Osmar Cavalcante | Desenvolvedor | |
| Rodolpho Hiroshi | Desenvolvedor e Gerente de Configuração | |

|   |   |   |   |   |   |   |   |   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Aprovado por e-mail |   |   | Data |   | Aprovado por e-mail |   |   | Data |
| Erik Raphael |   |   | |   | Igor Queiroz |   |   | |
| Erivan Barbosa |   |   | |   | Osmar Cavalcante |   |   |   |
| Henrique Cardoso |   |   | |   | Rodolpho Hiroshi |   |   | |
