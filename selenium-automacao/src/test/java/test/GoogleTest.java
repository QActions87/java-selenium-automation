package test; // Define a qual pacote esta classe pertence dentro da estrutura de pastas do projeto

import org.junit.Test; // Importa a anotação @Test do JUnit para indicar que o método é um teste automatizado
import org.openqa.selenium.WebDriver; // Importa a interface principal do Selenium para controle do navegador
import org.openqa.selenium.chrome.ChromeDriver; // Importa a implementação do driver específica para o Google Chrome

public class GoogleTest {

    // Atributo para armazenar a instância do navegador (será usado nos métodos de teste)
    private WebDriver driver;

    // Constante que armazena a URL base da aplicação que será testada
    private final String urlBase = "https://www.google.com/";

    // Constante com o caminho absoluto onde o binário do ChromeDriver está localizado no seu sistema Linux
    private final String caminhoDriver = "/home/atom/Documents/QA/JAVA/JAVA-Selenium/SELENIUM/selenium-automacao/src/test/java/resource/chromedriver-v150";

    // Método auxiliar responsável por configurar o ambiente e abrir o navegador
    private void iniciar() {
        // Atribui a propriedade do sistema informando ao Selenium onde encontrar o binário do ChromeDriver
        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        // Inicializa o navegador Google Chrome (abre uma nova janela controlada pela automação)
        driver = new ChromeDriver();

        // Maximiza a janela do navegador para garantir que todos os elementos da página fiquem visíveis
        driver.manage().window().maximize();

        // Navega até a URL especificada na variável urlBase (no caso, a home do Google)
        driver.get(urlBase);
    }

    // Indica ao JUnit que este método público é um caso de teste executável
    @Test
    public void devePesquisarNoGoogle() {
        // Chama o método auxiliar de inicialização para abrir o navegador na página do Google
        iniciar();
    }

}