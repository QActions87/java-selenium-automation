package test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pageobject.ControleDeProdutoPO;
import pageobject.LoginPO;

// Orientação do JUnit para que os testes sejam executados em ordem numérica crescente:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{
    // Atributos:
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void prepararTeste() {
        // Instância do Obj LoginPO:
        loginPage = new LoginPO(driver);
        // Invocando ação de logar a partir da instância 'loginPage':
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        // Instância do Obj ControleDeProdutoPO:
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
    }
}
