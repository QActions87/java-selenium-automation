package test; // Define a qual pacote esta classe pertence dentro da estrutura de pastas do projeto

import static org.junit.Assert.assertTrue; // Importa o método de asserção estático assertTrue do JUnit para validar condições verdadeiras
import java.util.Collections; // Importa a utilidade Collections para criar listas imutáveis
import org.junit.Test; // Importa a anotação @Test do JUnit para indicar que o método é um teste automatizado
import org.openqa.selenium.By; // Importa a classe By, usada para definir estratégias de localização de elementos (id, name, className, etc.)
import org.openqa.selenium.Keys; // Importa a enumeração Keys, usada para simular o pressionamento de teclas do teclado (ex: ENTER, TAB, BACK_SPACE)
import org.openqa.selenium.WebDriver; // Importa a interface principal do Selenium para controle do navegador
import org.openqa.selenium.WebElement; // Importa a interface que representa um elemento HTML manipulável na página web
import org.openqa.selenium.chrome.ChromeDriver; // Importa a implementação do driver específica para o Google Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Importa a classe de configurações e argumentos personalizados para o Google Chrome
import java.time.Duration; // Importa a classe Duration do Java (java.time), usada para definir intervalos de tempo de forma clara
import org.openqa.selenium.support.ui.ExpectedConditions; // Importa a classe de condições esperadas do Selenium, usada para verificar estados de elementos (visibilidade, clique, etc.)
import org.openqa.selenium.support.ui.WebDriverWait; // Importa a classe de espera explícita do Selenium, responsável por pausar a execução até uma condição ser atendida

public class GoogleTest {

    // Atributo privado para armazenar e reutilizar a instância do navegador nos testes
    private WebDriver driver;

    // Constante com a URL base do site que será acessado pela automação
    private final String urlBase = "https://www.google.com/";

    // Constante com o caminho relativo até o binário do ChromeDriver (a partir da raiz do projeto)
    private final String caminhoDriver = "src/test/java/resource/chromedriver-v150";

    // Método auxiliar privado responsável por configurar e inicializar a sessão do navegador
    private void iniciar() {
        // Registra a propriedade do sistema informando ao Selenium o local exato do ChromeDriver
        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        // Instancia a classe de opções para passar argumentos de execução ao Chrome
        ChromeOptions options = new ChromeOptions();

        // Define o caminho relativo do binário do Chrome baixado para rodar no ambiente Linux
        options.setBinary("src/test/java/resource/chrome-linux64/chrome");

        // Desativa a camada de isolamento do Chrome para evitar conflitos de execução em sistemas Linux
        options.addArguments("--no-sandbox");

        // Supera limitações de memória compartilhada temporária (/dev/shm) no ambiente Linux
        options.addArguments("--disable-dev-shm-usage");

        // ----------------------------------------------------------------------------------
        // Configurações para ocultar sinalizadores de automação e evitar avisos de robô
        // ----------------------------------------------------------------------------------

        // Oculta a flag 'navigator.webdriver' do motor Blink do navegador
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Remove a barra amarela/cinza de aviso "O Chrome está sendo controlado por software de teste"
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // Desativa a extensão de automação do Chrome
        options.setExperimentalOption("useAutomationExtension", false);

        // ----------------------------------------------------------------------------------

        // Instancia o ChromeDriver aplicando todas as configurações e abrindo a janela do navegador
        driver = new ChromeDriver(options);

        // Maximiza a janela do navegador para garantir a visibilidade total dos elementos em tela
        driver.manage().window().maximize();

        // Envia o comando para o navegador carregar o endereço da URL base
        driver.get(urlBase);
    }

    // Anotação do JUnit que identifica este método como um caso de teste executável
    @Test
    public void devePesquisarNoGoogle() {
        // Executa a rotina de inicialização do navegador para iniciar o fluxo de teste
        iniciar();

        // Mapeia a caixa de texto de busca do Google através do atributo 'name="q"' do HTML
        WebElement inputPesquisa = driver.findElement(By.name("q"));

        // Digita a palavra "café" no campo de busca e emula o pressionamento da tecla ENTER para submeter a pesquisa
        inputPesquisa.sendKeys("café" + Keys.ENTER);

        // Cria a instância de espera explícita configurada para aguardar até 10 segundos no Selenium 3
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Pausa a execução até o elemento com a classe CSS 'iAIpCb' ficar visível e extrai o texto visível contido nele
        String elementoSubtitulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("iAIpCb"))).getText();

        // Realiza a asserção do teste, validando se a String capturada contém o termo esperado "Bebida"
        assertTrue(elementoSubtitulo, elementoSubtitulo.contains("Bebida"));

        // Fecha o navegador
        driver.quit();
    }

}