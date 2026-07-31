package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {
    // Mapeia a caixa de texto de busca do Google através do atributo 'name="q"' do HTML Com Page Factory:
    @FindBy(name = "q")
    public WebElement inputPesquisa;

    /**
     * Construtor para criação da página do Google:
     * @param driver driver da página do Google.
     */
    protected GooglePO(WebDriver driver) {
        super(driver);
    }
}
