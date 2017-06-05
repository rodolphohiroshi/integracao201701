# 1. Introdução

## 1.1 Prosósito
O objetivo deste documento é descrever o planejamento das atividades para a execução dos testes da iteração do sistema, os itens a serem testados, as estratégias a serem tomadas e os critérios de aceitação dos testes.

## 1.2 Escopo
Esse documento aborda os testes unitários, de configuração, regressão, performance e de sistema, para o tipo de teste de funcionalidade.

## 1.3 Público Alvo
O público alvo deste documento são todas as pessoas envolvidas com o desenvolvimento do software, principalmente aquelas ligadas à gerenciamento de qualidade e testes.

# 2. Itens de Teste

| Item     | Artefato    | Versão |
| --------|---------|-------|
| 1  | Sistema   |1.0    |

# 3. Critérios de Sucesso
Esse tópico descreve o critério minimo de sucesso para aceitação do conjunto de testes executados, i.e., é necessário alcançar todos os critérios estabelecidos para alcançar o objetivo específico do teste. Cada critério de sucesso é estabelecido por artefato ou item de teste, sua fase, entre outros. A estratégia usada para cada item de teste, assim como seu critério de sucesso, é  definida pelos desenvolvedores do software.


# 4. Requisitos de Teste

### Teste do Sistema
Verificar e testar os requisitos funcionais descritos no documento: CID-10 Escopo e requisitos do projeto
    
# 5. Estratégias de Teste
A Estratégia de Teste apresenta a abordagem recomendada para o teste do software. A seção anterior dos Requisitos de Teste descrevia o que será testado; esta descreve como será testado. As principais considerações para a estratégia de teste são as técnicas a serem utilizadas e o critério para saber quando o teste está concluído.  A estratégia de teste a seguir é genérica por natureza e foi desenvolvida para ser aplicada aos requisitos listados na seção 4 deste documento.

## 5.1 Teste do Sistema
Os testes do sistema devem ter foco em quaisquer requisitos de destino que possam ser rastreados diretamente para casos de uso (ou funções de negócios) e regras de negócios. A meta desse teste é verificar a adequada aceitação, o processamento e a recuperação dos dados, e a implementação apropr(e seus processos internos) interagindo com o aplicativo por meiada das regras de negócios. Esse tipo de teste baseia-se em técnicas de caixa preta, ou seja, verificar o sistema interagindo com sistemas externo por meio da chamada de métodos e verificar os resultados retornados para as entradas fornecidas. A seguir é identificado um esboço do teste recomendado para cada aplicativo:

### Objetivo do Teste
Assegurar a navegação correta do aplicativo, além da entrada, processamento e recuperação de dados.
	
### Técnica
Executar cada função, utilizando dados válidos e inválidos, para verificar o seguinte:
* Os resultados esperados ocorrerão quando forem usados dados válidos.
* As mensagens de erro / aviso apropriadas sejam exibidas quando dados inválidos forem utilizados.
* Cada regra de negócio será adequadamente aplicada.

### Critérios de Conclusão
* Todos os testes planejados foram executados.
* Todos os defeitos identificados foram tratados.
