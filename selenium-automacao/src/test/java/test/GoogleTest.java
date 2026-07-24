package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    private WebDriver driver;
    private final String urlBase = "https://www.google.com/";
    private final String caminhoDriver = "/home/atom/Documents/QA/JAVA/JAVA-Selenium/SELENIUM/selenium-automacao/src/test/java/resource/chromedriver-v150";

    private void iniciar() {
        System.setProperties("webdriver.chrome.driver", caminhoDriver);
    }

    @Test
    public void devePesquisarNoGoogle() {
        iniciar();
    }

}
