package main.java.List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {

    List<Item> listaItems = new ArrayList<>();

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        listaItems.add(item);
    }

    public void removerItem(String nome) {
        List<Item> removerItem = new ArrayList<>();

        for (Item item : listaItems) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                removerItem.add(item);
            }
        }
        listaItems.removeAll(removerItem);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : listaItems) {
            total = total + item.getValor() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens() {
        System.out.println(listaItems);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        boolean continuar = true;


        while (continuar) {

            System.out.println("""
                    Digite a ação desejada:
                    
                    1 - Adicionar um item;
                    2 - Remover um item;
                    3 - Valor total de compra;
                    4 - Exibir itens no carrinho;
                    0 - Sair.
                    """);

            int opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do item: ");
                    String nome = sc.next();
                    System.out.println("Digite valor do item: ");
                    double preco = sc.nextDouble();
                    System.out.println("Digite quantidade do item: ");
                    int quantidade = sc.nextInt();
                    carrinho.adicionarItem(nome, preco, quantidade);
                    break;
                case 2:
                    System.out.println("Digite o nome do item que deseja remover: ");
                    String nomeRemover = sc.next();
                    carrinho.removerItem(nomeRemover);
                    break;
                case 3:
                    System.out.println("O valor total dos itens no carrinho é: " + carrinho.calcularValorTotal());
                    break;
                case 4:
                    System.out.println("Os itens da lista são: ");
                    carrinho.exibirItens();
                    break;
                case 0:
                    System.out.println("Sua sessão será encerrada...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Valor não conhecido, tente novamente!");
                    break;
            }
        }
    }
}
