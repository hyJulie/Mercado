package modelo;

import utils.Utils;

/**
 * A classe Produto representa um item disponivel para compra em um mercado.
 */
public class Produto {
    //toda vez que a pesssoa adicionar um produto o contador aumenta, vai gerar tipo um id para cada produto
    private static int count = 1;

    /**
     * Atributos de um produto.
     * - id: ID do produto
     * - nome: Nome do produto
     * - preco: Preco do produto
     */
    private int id;
    private String nome;
    private Double preco;

    /**
     * Construtor da classe Produto.
     *
     * @param nome  O nome do produto.
     * @param preco O preco do produto.
     */
    public Produto(String nome, Double preco) {
        this.id = count;
        this.nome = nome;
        this.preco = preco;
        Produto.count += 1;
    }

    /**
     * Obtem o ID do produto.
     *
     * @return O ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o nome do produto.
     *
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtem o preco do produto.
     *
     * @return O preco do produto.
     */
    public Double getPreco() {
        return preco;
    }
    /**
     * Define o preco do produto.
     *
     * @param preco O novo preco do produto.
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    /**
     * Retorna uma representacao em formato de String do produto, incluindo ID, nome e preco formatado.
     *
     * @return Uma String formatada com as informacoes do produto.
     */
    public String toString(){
        return "id: " + this.getId() +
                "\nNome: " + this.getNome()+
                "\nPreço: " + Utils.doubleToString(this.getPreco());
    }
}
