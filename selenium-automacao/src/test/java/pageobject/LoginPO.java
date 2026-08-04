package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    // Mapeia a caixa de texto de busca do Google através do atributo 'name="q"' do HTML Com Page Factory:
    @FindBy(id = "email")
    public WebElement inputEmail;

    /**
     * Construtor com parâmetro:
     * invocação do construtor canônico para criação da instância filha::
     * @param driver driver da página atual.
     */
    protected LoginPO(WebDriver driver) {
        super(driver);
    }
}
