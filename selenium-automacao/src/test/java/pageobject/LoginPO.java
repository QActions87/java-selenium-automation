package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    // Mapeia a caixa de texto para inserir email Com Page Factory:
    @FindBy(id = "email")
    public WebElement inputEmail;

    // Mapeia a caixa de texto para inserir senha Com Page Factory:
    @FindBy(id = "senha")
    public WebElement inputSenha;

    // Mapeia o botão Entrar com Page Factory:
    @FindBy(id = "btn-entrar")
    public WebElement btnEntrar;

    /**
     * Construtor com parâmetro:
     * invocação do construtor canônico para criação da instância filha::
     * @param driver driver da página atual.
     */
    protected LoginPO(WebDriver driver) {
        super(driver);
    }
}
