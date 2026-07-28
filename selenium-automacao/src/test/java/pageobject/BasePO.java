package pageobject;

import org.openqa.selenium.WebDriver;

/**
 * Classe base para criação das novas Pages Objects.
 * Todas as classes PO devem herdar desta.
 */
public abstract class BasePO {
    /** Driver base que será usado pelas PO */
    protected WebDriver Driver;

}
