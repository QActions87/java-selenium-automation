# Introdução à Automação de UI com Java e Selenium

![Java](https://api.devicons.dev.br/icon?icons=Linux%2CIdea%2CJava%2CSelenium%2CMaven&size=48&theme=dark&perline=30)

Este repositório contém o projeto de automação de **testes de interface do usuário (UI)**, desenvolvido como etapa introdutória e consolidativa dos conceitos fundamentais de testes automatizados Web com **Java**, **Selenium 3** e **JUnit 4**.

## 📌 Arquitetura & Padrões de Projeto
O projeto adota o padrão **Page Object Model (POM)** integrado ao **Page Factory do Selenium**, promovendo o reuso de código, facilitando a manutenção e garantindo o isolamento entre a regra do teste e o mapeamento da interface.

```
src/
└── test/
    └── java/
        ├── pageobject/
        │   ├── BasePO.java       # Classe base para inicialização do PageFactory
        │   └── GooglePO.java     # Mapeamento de elementos e ações da página do Google
        └── test/
            ├── BaseTest.java     # Configuração do WebDriver e Hooks do JUnit (@BeforeClass/@AfterClass)
            └── GoogleTeste.java  # Execução dos cenários de teste e asserções
```

## 🧱 Componentes Principais
**1. Infraestrutura Base de Testes (BaseTest.java)**
Gerenciamento do WebDriver: Centraliza a inicialização do navegador Chrome, definição de binaries locais para ambiente Linux e aplicação de argumentos com ChromeOptions (ex: --no-sandbox, --disable-dev-shm-usage).

Bypass de Detecção de Robô: Configuração de opções experimentais do Chrome para remoção de avisos de automação (AutomationControlled e excludeSwitches).

Ciclo de Vida: Utiliza ganchos @BeforeClass e @AfterClass para garantir reutilização performática da sessão do navegador dentro do contexto de execução da suíte.

**2. Abstração do Page Object (BasePO.java)**
Inicialização Preguiçosa (Lazy Evaluation): Abstrai a chamada do PageFactory.initElements(driver, this) no construtor protegido, permitindo que todas as subclasses mapeiem seus elementos via anotação @FindBy.

**3. Encapsulamento de Ações & Mapeamento (GooglePO.java)**
Mapeamento limpo de WebElements (@FindBy(name = "q"), @FindBy(className = "iAIpCb")).

Encapsulamento de Espera Explícita: Método obterTextoSubtitulo() utiliza WebDriverWait em conjunto com ExpectedConditions.visibilityOf() para aguardar o tempo dinâmico de resposta da aplicação antes de interagir.

Abstração de Ação: Método pesquisar(String texto) para automatizar o envio de texto e pressão do ENTER.

**4. Execução dos Casos de Teste (GoogleTeste.java)**
Execução orientada a valor de negócio, mantendo as asserções (Assert.assertTrue) limpas e desacopladas da lógica de localização de elementos.

## 💻 Tecnologias e Ferramentas
Linguagem: **Java 8+**

Framework de Automacao: **Selenium WebDriver (v3.x)**

Framework de Testes: **JUnit 4**

Driver Web: **ChromeDriver**

Gerenciador de Dependências: **Apache Maven**


## ⚙️ Como Executar o Projeto

1. Clonar o Repositório:
```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Garantir as Permissões do Driver (Linux):
```
chmod +x src/test/java/resource/chromedriver-v150
chmod +x src/test/java/resource/chrome-linux64/chrome
```

3. Executar via Terminal (Maven):
```
mvn test
```

