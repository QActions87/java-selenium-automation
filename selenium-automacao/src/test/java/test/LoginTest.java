package test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobject.LoginPO;

import static org.junit.Assert.assertEquals;
// Orientação do JUnit para que os testes sejam executados em ordem numérica crescente:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
    // Atributo:
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTeste() {
        // Instância do Obj LoginPO:
        loginPage = new LoginPO(driver);
    }

    // 1º Caso de Teste:
    // Anotação do JUnit que identifica este method como um caso de teste executável
    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    // 2º Caso de Teste:
    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    // 3º Caso de Teste:
    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    // 4º Caso de Teste:
    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    // 5º Caso de Teste:
    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    // 6º Caso de Teste:
    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta() {
        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    // 7º Caso de Teste:
    @Test
    public void TC007_deveLogarNoSistemaComEmailCorretoESenhaCorreta() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }
}