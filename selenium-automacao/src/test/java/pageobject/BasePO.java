package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas Pages Objects.
 * Todas as classes PO devem herdar desta.
 */
public abstract class BasePO {
    /** Driver base que será usado pelas classes PO */
    protected WebDriver Driver;

    // Construtor com parâmetro:
    protected BasePO(WebDriver driver) {
        this.Driver = driver;
        PageFactory.initElements(this.Driver, this);
    }

}















