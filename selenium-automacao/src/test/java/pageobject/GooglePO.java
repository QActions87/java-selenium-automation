package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

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
