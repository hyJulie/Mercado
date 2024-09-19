package main;

import modelo.Produto;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A classe Mercado representa um sistema de compras em um mercado.
 *
 * Esta classe permite que os usuarios cadastrem produtos, listem produtos disponiveis,
 * comprem produtos e visualizem o carrinho de compras.
 */
public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    /**
     * Metodo principal (main) onde o programa é iniciado.
     *
     * @param args Os argumentos da linha de comando (nao sao usados neste programa).
     */
    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }
    /**
     * Exibe o menu principal das operacoes disponiveis.
     */
    private static void menu(){

        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------Bem-Vindo(a) ao Mercado Le Marchê -------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar    |");
        System.out.println("|   Opção 2 - Listar       |");
        System.out.println("|   Opção 3 - Comprar      |");
        System.out.println("|   Opção 4 - Carrinho     |");
        System.out.println("|   Opção 5 - Sair         |");

        int option = input.nextInt();


        switch (option){
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                comprarProdutos();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                System.out.println("Volte Sempre!");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                menu();
                break;
        }
    }

    /**
     * Metodo para cadastrar os Produtos
     */
    private static void cadastrarProdutos(){
        System.out.println("Nome do Produto: ");
        String nome = input.next();

        System.out.println("Preço do Produto: ");
        Double preco = input.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + " Cadastrado com Sucesso!");
        menu();
    }

    /**
     * Metodo para listar os produtos cadastrados.
     */
    private static void listarProdutos(){
        if (produtos.size() > 0){
            System.out.println("Lista de produtos! \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }


    /**
     * Metodo para comprar produtos e adicionar ao carrinho.
     */
    private static void comprarProdutos(){
        if (produtos.size() > 0){
            System.out.println("Código do Produto: \n");

            System.out.println("----------------Produtos Disponíveis----------------");
            for (Produto p : produtos){
                System.out.println(p + "\n");
            }
            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Produto p : produtos){
                if (p.getId() == id){
                    int qtd = 0;
                    try{
                        qtd = carrinho.get(p);
                        //checa se o produto ja esta no carrinho, incrementa a quantidade
                        carrinho.put(p, qtd +1);
                    }catch (NullPointerException e){
                        //se o produto for o primeiro no carrinho
                        carrinho.put(p, 1);
                    }
                     System.out.println(p.getNome() + " Adicionado ao carrinho.");
                    isPresent = true;

                    if (isPresent) {
                       System.out.println("Deseja adicionar outro produto ao carrinho? ");
                       System.out.println("Digite 1 para sim, ou 0 para finalizar a compra. \n");
                       int option = Integer.parseInt(input.next());

                       if (option == 1){
                           comprarProdutos();
                       }else {
                           finalizarCompra();
                       }
                    }

                }else {
                    System.out.println("Produto não encontrado.");
                    menu();
                }
            }
        }else {
            System.out.println("Não existem produtos cadastrados!");
            menu();
        }
    }

    /**
     * Mostra os produtos no carrinho de compras.
     */
    private static void verCarrinho(){
        System.out.println("---Produtos no seu Carrinho---");
        if (carrinho.size() > 0){
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        }else {
            System.out.println("Carrinho Vazio!");
        }

        menu();
    }

    /**
     * Finaliza a compra, calcula o valor total e limpa o carrinho.
     */
    private static void finalizarCompra(){
        Double valorDaCompra = 0.0;
        System.out.println("Seus Produtos: ");

        for (Produto p : carrinho.keySet()){
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quantidade: " + qtd);
            System.out.println("--------------------");
        }
        System.out.println("O valor da sua Compra é: " + Utils.doubleToString(valorDaCompra));
        carrinho.clear();
        System.out.println("Obrigada pela preferência!");
        menu();
    }
}
