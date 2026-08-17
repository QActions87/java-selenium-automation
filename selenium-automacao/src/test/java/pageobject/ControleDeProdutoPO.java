package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO{
    // Capturando botão 'Criar':
    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;
    // Capturando botão Voltar:
    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;
    // Captura o título do modal (Tela após clicar no botão 'Criar'):
    @FindBy(css = "div.modal-header>h4.modal-title")
    public WebElement tituloModal;

    // Mapeando os campos do modal de cadastro de produto:
    // Mapeando campo 'Código':
    @FindBy(id = "codigo")
    public WebElement inputCodigo;
    // Mapeando campo 'Nome':
    @FindBy(id = "nome")
    public WebElement inputNome;
    // Mapeando campo 'Quantidade':
    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;
    // Mapeando campo 'Valor':
    @FindBy(id = "valor")
    public WebElement inputValor;
    // Mapeando campo 'Valor':
    @FindBy(id = "data")
    public WebElement inputData;
    // Mapeando botão 'Salvar':
    @FindBy(id = "btn-salvar")
    public WebElement btnSalvar;
    // Mapeando botão 'Sair':
    @FindBy(id = "btn-sair")
    public WebElement btnSair;

    /**
     * Construtor com parâmetro:
     * Construtor base para criação da fábrica de elementos:
     *
     * @param driver driver da página atual.
     */
    public ControleDeProdutoPO(WebDriver driver) {

        super(driver);
    }
    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data) {
        inputCodigo.clear();
        inputCodigo.sendKeys(codigo + Keys.TAB);
    }
}

























