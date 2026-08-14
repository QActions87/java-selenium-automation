package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO{

    @FindBy(id = "btn-adicionar")
    private WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    private WebElement linkVoltar;


    /**
     * Construtor com parâmetro:
     * Construtor base para criação da fábrica de elementos:
     *
     * @param driver driver da página atual.
     */
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
}

























