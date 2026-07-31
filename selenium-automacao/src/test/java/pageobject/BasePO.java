package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas Pages Objects.
 * Todas as classes PO devem herdar desta.
 */
public abstract class BasePO {
    /** Driver base que será usado pelas classes PO */
    protected WebDriver driver;

    /**
     *  Construtor com parâmetro:
     * Construtor base para criação da fábrica de elementos:
     * @param driver driver da página atual.
     */
    protected BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}















