
# 🛒 Automação de Testes de UI - Controle de Produtos

![Java](https://api.devicons.dev.br/icon?icons=Linux%2CIdea%2CJava%2CSelenium%2CMaven&size=48&theme=dark&perline=30)

Projeto de automação de testes funcionais de interface do usuário (UI) desenvolvido para a tela de Controle de Produtos do sistema web. O projeto utiliza **Java, Selenium WebDriver, JUnit 4** e os padrões de projeto **Page Object Model (POM)** e **Test Data Builder**.

## 🏛️ Arquitetura do Projeto
Estrutura com foco exclusivo nos componentes da suíte de Controle de Produtos:
```

selenium-automacao/
└── src/
    └── test/
        └── java/
            ├── builder/
            │   └── ProdutoBuilder.java
            ├── pageobject/
            │   ├── BasePO.java
            │   └── ControleDeProdutoPO.java
            └── test/
                ├── BaseTest.java
                └── ControleDeProdutoTest.java

```

## 🧩 Padrões de Projeto Aplicados
**Page Object Model (POM):** Mapeamento dos elementos web (@FindBy) e comportamentos da página em ControleDeProdutoPO, herdando as ações utilitárias da BasePO.

**Test Data Builder Pattern:** A classe ProdutoBuilder implementa uma interface fluente para a criação flexível de dados de teste, fornecendo valores padrão pré-configurados e permitindo alterar apenas os atributos necessários em cada cenário.

**Inheritance & Base Setup:** Lógica de inicialização do driver e encerramento de sessão centralizadas em BaseTest.

## 📋 Cenários de Teste Mapeados
Os testes são ordenados sequencialmente via @FixMethodOrder(MethodSorters.NAME_ASCENDING):

| ID | Tipo | Descrição do Cenário | Validação Esperada |
| :--- | :--- | :--- | :--- |
| **TC001** | Positivo | Abertura e fechamento do modal de cadastro via botão "Criar" | Título do modal é exibido como `"Produto"` |
| **TC003** | Negativo | Tentativa de cadastro com campo **Código** vazio | Mensagem de erro no `span`: `"Todos os campos são obrigatórios para o cadastro!"` |
| **TC003** | Negativo | Tentativa de cadastro com **Quantidade** não informada (`null`) | Mensagem de erro no `span`: `"Todos os campos são obrigatórios para o cadastro!"` |
| **TC003** | Negativo | Tentativa de cadastro com campo **Nome** vazio | Mensagem de erro no `span`: `"Todos os campos são obrigatórios para o cadastro!"` |
| **TC003** | Negativo | Tentativa de cadastro com campo **Valor** não informado (`null`) | Mensagem de erro no `span`: `"Todos os campos são obrigatórios para o cadastro!"` |
| **TC003** | Negativo | Tentativa de cadastro com campo **Data** vazio | Mensagem de erro no `span`: `"Todos os campos são obrigatórios para o cadastro!"` |


> **Nota Técnica:** O projeto lida com uma limitação conhecida da aplicação (bug de interface que exige duplo clique no primeiro acionamento dos botões "Criar" e "Sair") através de acionamentos mapeados no TC001.

## 🛠️ Tecnologias e Dependências
**Linguagem:** Java 21

**Framework de Testes:** JUnit 4.13.2

**Automação Web:** Selenium WebDriver 3.141.59

**Gerenciador de Dependências:** Apache Maven

**Build Plugins:** maven-compiler-plugin (v3.11.0) e maven-surefire-plugin (v3.2.5)

## 🚀 Como Executar os Testes
Pré-requisitos
Java JDK 21 instalado e configurado nas variáveis de ambiente.

Apache Maven instalado.

## Execução via Terminal
1. Navegue até a pasta raiz do projeto:
```
cd selenium-automacao
```
2. Execute a suíte de testes do ControleDeProdutoTest:
```
mvn clean test -Dtest=ControleDeProdutoTest
```
