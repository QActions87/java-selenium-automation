package builder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.ControleDeProdutoPO;

public class ProdutoBuilder {
    // Valores padrão:
    public String codigo = "00001";
    public String nome = "Produto Padrão";
    public String quantidade = "1";
    public String valor = "1.0";
    public String data = "17/08/2026";
    private ControleDeProdutoPO controleDeProdutoPO;

    // Construtor recebendo o driver:
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {

        this.controleDeProdutoPO = controleDeProdutoPO;
    }
    // Métodos fluentes que retornam a própria instância:
    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(String quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(String valor) {
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    public void builder() {
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, produtoBuilder.codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, produtoBuilder.nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, produtoBuilder.quantidade);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, produtoBuilder.valor);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, produtoBuilder.data);
        controleDeProdutoPO.btnSalvar.click();
    }
}

























