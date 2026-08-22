package builder;

import pageobject.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela*/
public class ProdutoBuilder {
    // Valores padrão:
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "17/08/2026";
    private ControleDeProdutoPO controleDeProdutoPO;

    /** Construtor do ProdutoBuilder recebendo o driver da página de controle de produto */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {

        this.controleDeProdutoPO = controleDeProdutoPO;
    }
    // Métodos fluentes que retornam a própria instância:
    /**
     * Métodos que adiciona um código ao cadastro */
    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    /**
     * Métodos que adiciona um nome ao cadastro */
    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Métodos que adiciona uma quantidade ao cadastro */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Métodos que adiciona um valor ao cadastro */
    public ProdutoBuilder adicionarValor(Double valor) {
        this.valor = valor;
        return this;
    }

    /**
     * Métodos que adiciona uma data ao cadastro */
    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Métodos que constroi o produto no cadastro */
    public void builder() {
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
        controleDeProdutoPO.btnSalvar.click();
    }
}

























