#Recursos humanos 

##Resumo:
O trabalho foi desenvolvido usando-se Java e Java Swing, estruturado seguindo os critérios cobrados da atividade. O código foi pensado e organizado utilizando o padrão arquitetural MVC (Model-View-Controller) para garantir uma divisão clara entre a interface gráfica e as regras de negócio do sistema.

##Descrição:
O Protótipo foi elaborado se baseando cona classe `Funcionario`, que atua como a estrutura principal de dados (Entidade) do sistema. Este modelo foi projetado para representar de forma completa um colaborador no ambiente corporativo, contendo atributos essenciais como Nome, CPF, Cargo, Salário, Departamento e Tipo de Contrato (CLT, PJ, Estágio). Além disso, o modelo já vem preparado com regras para controlar o estado do funcionário (se ele está ativo ou inativo) e a atribuição de benefícios opcionais, como Vale Transporte, Vale Refeição e Plano de Saúde, utilizando métodos modificadores (Setters) e de acesso (Getters) para garantir a segurança dos dados.



##função:
A principal função do sistema é gerenciar o ciclo de vida dos colaboradores dentro de uma empresa. Isso inclui cadastrar novos funcionários, realizar buscas rápidas através do CPF, listar todos os cadastrados, filtrar apenas os funcionários que estão trabalhando atualmente (ativos) e desativar aqueles que foram desligados.

##Com o que foi contruido(tecnologias):
* **Linguagem:** Java (Lógica e POO)
* **Interface Gráfica:** Java Swing (para o desenvolvimento das telas e componentes visuais)
* **Armazenamento:** `ArrayList` (para salvar os dados temporariamente em memória durante a execução)

##Finalidade:
A finalidade deste projeto é fornecer uma ferramenta prática e intuitiva para o departamento de Recursos Humanos. O sistema busca evitar erros comuns de gestão, como o cadastro de CPFs duplicados, e oferece um controle seguro dos benefícios e do status de cada trabalhador de forma organizada.


## Guia e explicação:

O sistema foi dividido em pacotes para organizar as responsabilidades de cada classe. Abaixo está a explicação de como a lógica de negócios foi estruturada:

### 1. O Modelo de Dados (`package model`)
* **`Funcionario.java`**: É a classe que define o objeto Funcionario. Ela usa o conceito de **Encapsulamento** (atributos `private`), o que significa que os dados não podem ser alterados diretamente sem passar por validações. Por exemplo, o método `setSalario(double salario)` possui uma regra que impede que um salário seja negativo (`if (salario >= 0)`).

### 2. O Coração do Sistema (`package service`)
* **`GerenciadorFuncionarios.java`**: Esta classe controla as ações do sistema usando um `ArrayList` para armazenar os funcionários na memória do computador.
    * `cadastrarFuncionario`: Antes de salvar, ele chama o método `validarCpf`. Se o CPF já existir no sistema, ele recusa o cadastro, garantindo que não existam funcionários duplicados.
    * `buscarPorCpf`: Percorre a lista usando um laço `for`. Se encontrar o CPF digitado, retorna o funcionário correspondente.
    * `desativarFuncionario`: Em vez de deletar o funcionário do banco de dados (o que apagaria o histórico dele), o sistema simplesmente muda o atributo `ativo` para `false`. Isso é chamado de **Exclusão Lógica**.
    * `filtrarAtivos`: Cria uma lista separada contendo apenas os colaboradores que estão com o status ativo, facilitando a emissão de relatórios para o RH.

### 3. Execução e Testes
* **`TesteGerenciador.java`**: É uma classe de teste de caixa preta que criamos para simular o comportamento do sistema antes mesmo da tela ficar pronta. Ela instância o gerenciador, cria três funcionários de teste (João, Eleno e Enzo), testa a busca por CPF e a desativação lógica.
* **`Main.java`**: É o ponto de entrada oficial do sistema. A única função dela é disparar a `TelaPrincipal()` (construída em Java Swing) para o usuário final.



## Instruções de uso:

Para rodar e testar este projeto na sua máquina local, siga os passos abaixo:

1. **Clonar o Repositório:** Faça o clone deste projeto do GitHub para a sua máquina ou baixe o arquivo ZIP do código.
2. **Abrir na IDE:** Abra a pasta do projeto em uma IDE Java de sua preferência (como Eclipse, IntelliJ IDEA ou NetBeans).
3. **Executar a Aplicação:** * Para testar a lógica do sistema via terminal, execute o arquivo `src/TesteGerenciador.java`.
   * Para abrir o sistema com a interface gráfica (Janela), execute o arquivo `Main.java` localizado na raiz da pasta `src`.


## Vídeo (Pitch) do projeto:
Fizemos um pitch em vídeo para apresentar o código e quem fez o que, o link estará aqui no **README.md** e como um **.txt** no repositório.

**Link do vídeo:** https://www.youtube.com/watch?v=v3M3i6vdkX8
