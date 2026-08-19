package builder;

public class ProdutoBuilder {
    // Valores padrão:
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private String quantidade = "1";
    private String valor = "1.0";
    private String data = "17/08/2026";

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

}

























