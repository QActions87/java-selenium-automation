package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class    LoginPO extends BasePO {
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

    // Method para obter mensagem do span:
    public String obterMensagem() {
        return spanMensagem.getText();
    }

    // Função que executa a ação de entrar:

    /**
     * Méthod que tenta executar a ação de entrar no sistema:
     * @param email Email para tentativa de entrada.
     * @param senha Senha para tentativa de entrada.
     */
    public void executarAcaoDeLogar (String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        btnEntrar.click();
    }

}
