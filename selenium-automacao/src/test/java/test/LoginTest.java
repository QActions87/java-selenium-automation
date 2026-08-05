package test;

import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.LoginPO;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTeste() {
        // Instância do Obj LoginPO:
        loginPage = new LoginPO(driver);
    }

    // Anotação do JUnit que identifica este method como um caso de teste executável
    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.escrever(loginPage.inputEmail, "");
        loginPage.escrever(loginPage.inputSenha, "");
        loginPage.btnEntrar.click();
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);

    }
}