package test; // Define a qual pacote esta classe pertence dentro da estrutura de pastas do projeto

import static org.junit.Assert.assertTrue;
import java.util.Collections; // Importa a utilidade Collections para criar listas imutáveis
import org.junit.Test; // Importa a anotação @Test do JUnit para indicar que o método é um teste automatizado
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver; // Importa a interface principal do Selenium para controle do navegador
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Importa a implementação do driver específica para o Google Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Importa a classe de configurações e argumentos personalizados para o Google Chrome
import java.time.Duration; // Importa a classe Duration do Java (java.time), usada para definir intervalos de tempo (ex: Duration.ofSeconds(10)) de forma moderna e clara
import org.openqa.selenium.support.ui.ExpectedConditions;// Importa a classe de condições esperadas do Selenium, que contém métodos prontos para verificar o estado de um elemento (ex: se está visível, clicável, etc.)
import org.openqa.selenium.support.ui.WebDriverWait; // Importa a classe de espera explícita do Selenium, responsável por fazer o driver aguardar até que uma determinada condição seja atendida antes de prosseguir


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

        WebElement inputPerquisa = driver.findElement(By.name("q"));
        inputPerquisa.sendKeys("café" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Aguarda o elemento estar visível antes de pegar o texto
        String elementoSubtitulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("iAIpCb"))).getText();

        assertTrue(elementoSubtitulo, elementoSubtitulo.contains("Bebida"));

    }

}