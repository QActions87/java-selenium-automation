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