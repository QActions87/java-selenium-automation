package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO{
    // Capturando botão 'Criar':
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;
    // Capturando botão Voltar:
    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;
    // Captura o título do modal (Tela após clicar no botão 'Criar'):
    @FindBy(css = "div.modal-header>h4.modal-title")
    public WebElement tituloModal;


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

























