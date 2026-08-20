package test;

import builder.ProdutoBuilder;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobject.ControleDeProdutoPO;
import pageobject.LoginPO;

import static org.junit.Assert.assertEquals;

// Orientação do JUnit para que os testes sejam executados em ordem numérica crescente:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    // Atributos:
    String mensagem = "Todos os campos são obrigatórios para o cadastro!";
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
    /**
     * Rodar toda a suite para não ocorrer erro por conta do bug que a
     * aplicção tem: da primeira vez que o botão 'Criar' e 'Sair'
     * são acionados, precisam de 2 clicks. Apenas da 1ª vez.*/
    // Suite de Testes Positivos:
    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        // 1º e 2º Click no botão 'Criar' (Bug da aplicação: exige 2 cliques na primeira abertura da sessão):
        controleDeProdutoPage.buttonCriar.click();
        controleDeProdutoPage.buttonCriar.click();

        // Capturando o título do modal, após clicar em Criar:
        String titulo = controleDeProdutoPage.tituloModal.getText();
        // Validação do título do modal:
        assertEquals("Produto", titulo);

        // 1º e 2º click no botão 'Sair' (Bug da aplicação: exige 2 cliques no primeiro fechamento):
        controleDeProdutoPage.btnSair.click();
        controleDeProdutoPage.btnSair.click();
    }

    // Suite de testes negativos:
    // Testando implementação do pattern Builder:
    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        // Instanciando builder para preencher os dados na tela:
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        // Cenários de testes:
        // 1º Cenário: Testando se o produto é adicionado sem código:
        // Click no botão 'Criar' (A partir da 2ª abertura na mesma janela, 1 clique é suficiente):
        controleDeProdutoPage.buttonCriar.click();

        produtoBuilder
                .adicionarCodigo("")
                .builder();

        // Validação da mensagem de erro do span:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // Click para sair do modal (1 clique é suficiente após a 1ª execução):
        controleDeProdutoPage.btnSair.click();
        // -----------------------------------------------------------------------------------

        // 2º Cenário: Testando se o produto é adicionado sem quantidade declarada:
        controleDeProdutoPage.buttonCriar.click();

        produtoBuilder
                .adicionarQuantidade(null)
                .builder();

        // Validação da mensagem de erro do span:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // Click para sair do modal:
        controleDeProdutoPage.btnSair.click();
        // -----------------------------------------------------------------------------------

        // 3º Cenário: Testando se o produto é adicionado sem nome declarado:
        controleDeProdutoPage.buttonCriar.click();

        produtoBuilder
                .adicionarNome("")
                .adicionarQuantidade(13)
                .adicionarValor(59.90)
                .builder();

        // Validação da mensagem de erro do span:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // Click para sair do modal:
        controleDeProdutoPage.btnSair.click();
        // -----------------------------------------------------------------------------------

        // 4º Cenário: Testando se o produto é adicionado sem valor declarado:
        controleDeProdutoPage.buttonCriar.click();

        produtoBuilder
                .adicionarNome("Machado")
                .adicionarQuantidade(13)
                .adicionarValor(null)
                .builder();

        // Validação da mensagem de erro do span:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // Click para sair do modal:
        controleDeProdutoPage.btnSair.click();
        // -----------------------------------------------------------------------------------

        // 5º Cenário: Testando se o produto é adicionado sem data declarada:
        controleDeProdutoPage.buttonCriar.click();

        produtoBuilder
                .adicionarValor(19.75)
                .adicionarQuantidade(13)
                .adicionarData("")
                .builder();

        // Validação da mensagem de erro do span:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // Click para sair do modal:
        controleDeProdutoPage.btnSair.click();
    }
}












