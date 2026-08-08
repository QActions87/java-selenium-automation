package pageobject;

import org.openqa.selenium.Keys;
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

    // Mapeia o Span com a mensagem com Page Factory:
    @FindBy(css = "form.form-login>div.alert>span#mensagem")
    public WebElement spanMensagem;
    /**
     * Construtor com parâmetro:
     * invocação do construtor canônico para criação da instância filha::
     * @param driver driver da página atual.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void escrever(WebElement input, String texto) {
        input.clear(); // 1. Limpa o texto existente no campo HTML.
        input.sendKeys(texto + Keys.TAB); // Digita o novo valor (mesmo que seja "").
    }

    // Method para obter mensagem do span:
    public String obterMensagem() {
        return spanMensagem.getText();
    }
}
