package test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pageobject.ControleDeProdutoPO;
import pageobject.LoginPO;

// Orientação do JUnit para que os testes sejam executados em ordem numérica crescente:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{

    private ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void prepararTeste() {
        // Instância do Obj LoginPO:
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
    }
}
