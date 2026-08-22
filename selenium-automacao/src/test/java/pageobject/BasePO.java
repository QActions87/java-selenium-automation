package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Method para obter título da página após entrar no sistema. */
    public String obterTituloDaPaginaDeLogado() {
        return driver.getTitle();
    }
    /**
     *  Method para escrever em campo Web Element de 'input' e dar um TAB ao final. */
    public void escrever(WebElement input, String texto) {
        input.clear(); // Limpa o texto existente no campo HTML.
        input.sendKeys(texto + Keys.TAB); // Digita o novo valor (mesmo que seja "").
    }
}















