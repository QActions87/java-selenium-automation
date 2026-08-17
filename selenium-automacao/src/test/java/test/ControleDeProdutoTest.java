package test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobject.ControleDeProdutoPO;
import pageobject.LoginPO;

import static org.junit.Assert.assertEquals;

// Orientação do JUnit para que os testes sejam executados em ordem numérica crescente:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{
    // Atributos:
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void prepararTeste() {
        // Instância do Obj LoginPO para logar:
        loginPage = new LoginPO(driver);
        // Invocando ação de logar a partir da instância 'loginPage':
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        // Instância do Obj ControleDeProdutoPO:
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        // assertEquals para validar que estamos na tela Controle de Produtos:
        assertEquals("Controle de Produtos", loginPage.obterTituloDaPaginaDeLogado());
    }
    // Casos de Teste:
    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        // 1º Click no botão 'Criar':
        controleDeProdutoPage.buttonCriar.click();
        // 2º Click no botão 'Criar':
        controleDeProdutoPage.buttonCriar.click();
        // Capturando o título do modal, após clicar em Criar:
        String titulo = controleDeProdutoPage.tituloModal.getText();
        // Validação do título do modal:
        assertEquals("Produto", titulo);
        // 1º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        // 2º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
    }

    @Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        // 1º Click no botão 'Criar':
        controleDeProdutoPage.buttonCriar.click();
        // 2º Click no botão 'Criar':
        controleDeProdutoPage.buttonCriar.click();
        // Inputs para cadastrar produto:
        controleDeProdutoPage.cadastrarProduto("", "Machado", 13, 21.00, "17/08/2026");
        // Capturando a mensagem do span:
        String mensagem = controleDeProdutoPage.spanMensagem.getText();
        // Validação do título do modal:
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }
}












