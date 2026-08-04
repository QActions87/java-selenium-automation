package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePO extends BasePO {
    // Mapeia a caixa de texto de busca do Google através do atributo 'name="q"' do HTML Com Page Factory:
    @FindBy(name = "q")
    public WebElement inputPesquisa;
    // Mapeia o subtítulo que aparece no span:
    @FindBy(className = "iAIpCb")
    public WebElement spanResultadoPesquisa;

    /**
     * Construtor para criação da página do Google:
     * @param driver driver da página do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    // Criamos um method que encapsula a espera e a ação!
    public String obterTextoSubtitulo() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // O wait aguarda o WebElement mapeado pelo @FindBy ficar visível
        return wait.until(ExpectedConditions.visibilityOf(spanResultadoPesquisa)).getText();
    }

    // Method que abstrai a forma de pesquisar a palavra:
    public void pesquisar(String texto) {
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }
}




















