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
public class ControleDeProdutoTest extends BaseTest{
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
    /*
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
    */
    // Suite de testes negativos:
    // Testando implementação do pattern Builder:
    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        // 1º Click no botão 'Criar':
        controleDeProdutoPage.buttonCriar.click();
        // 2º Click no botão 'Criar':
        controleDeProdutoPage.buttonCriar.click();
        // Instanciando builder para preencher os dados na tela:
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        // Chamando o method 'builder' a partir da instância produtoBuilder do Builder para efetuar o cadastro:

        // Cenários de testes:
        // 1º Cenário:Testando se o produto é adicionado sem código:
        produtoBuilder
                .adicionarNome("")
                .builder();
        // Validação do título do modal:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        //-----------------------------------------------------------------------------------

        // 2º Cenário: Testando se o produto é adicionado sem quantidade declarada:
        produtoBuilder
                .adicionarQuantidade(null)
                .builder();
        // Validação do título do modal:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // 1º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        // 2º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        //-----------------------------------------------------------------------------------

        // 3º Cenário: Testando se o produto é adicionado sem nome declarado:
        produtoBuilder
                .adicionarNome("")
                .adicionarQuantidade(13)
                .adicionarValor(59.90)
                .builder();
        // Validação do título do modal:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // 1º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        // 2º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        //-----------------------------------------------------------------------------------

        // 4º Cenário: Testando se o produto é adicionado sem valor declarado:
        produtoBuilder
                .adicionarNome("Machado")
                .adicionarQuantidade(13)
                .adicionarValor(null)
                .builder();
        // Validação do título do modal:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // 1º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        // 2º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        //-----------------------------------------------------------------------------------

        // 5º Cenário: Testando se o produto é adicionado sem data declarada:
        produtoBuilder
                .adicionarValor(19.75)
                .adicionarQuantidade(13)
                .adicionarData("")
                .builder();
        // Validação do título do modal:
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        // 1º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
        // 2º click para sair do modal para não atrapalhar o próximo test:
        controleDeProdutoPage.btnSair.click();
    }
}












