package test; // Define a qual pacote esta classe pertence dentro da estrutura de pastas do projeto

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test; // Importa a anotação @Test do JUnit para indicar que o method é um teste automatizado
import org.openqa.selenium.support.ui.WebDriverWait; // Importa a classe de espera explícita do Selenium, responsável por pausar a execução até uma condição ser atendida
import pageobject.GooglePO;

@SuppressWarnings("ALL")
public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes() {
        // Instância do Obj GooglePO:
        googlePage = new GooglePO(driver);
    }

    // Anotação do JUnit que identifica este method como um caso de teste executável
    @Test
    public void TC001_devePesquisarNoGoogle() {
        // Mapeia a caixa de texto de busca do Google através do atributo 'name="q"' do HTML:
        //WebElement inputPesquisa = driver.findElement(By.name("q"));
        // Digita a palavra "café" no campo de busca e emula o pressionamento da tecla ENTER para submeter a pesquisa:
        // googlePage.inputPesquisa.sendKeys("café" + Keys.ENTER);
        //Chamando o method abstraído na classe GooglePO:
        googlePage.pesquisar("café");

        // Cria a instância de espera explícita configurada para aguardar até 10 segundos no Selenium 3:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Pausa a execução até o elemento com a classe CSS 'iAIpCb' ficar visível e extrai o texto visível contido nele:
        //String elementoSubtitulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("iAIpCb"))).getText();
        String resultado = googlePage.obterTextoSubtitulo();

        // Realiza a asserção do teste, validando se a String capturada contém o termo esperado "Bebida":
        //assertTrue(elementoSubtitulo, elementoSubtitulo.contains("Bebida"));
        Assert.assertTrue(resultado, resultado.contains("Bebida"));
    }
}
