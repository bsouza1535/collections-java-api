package main.java.Pesquisa;

import main.java.OperacoesBasicas.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoLivros {

    private List<Livro> listLivros;

    public CatalogoLivros() {
        this.listLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        listLivros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!listLivros.isEmpty()) {
            for (Livro livro : listLivros) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorTitulo(String titulo){
        List<Livro> livrosPorTitulo = new ArrayList<>();
        if (!listLivros.isEmpty()) {
            for (Livro livro : listLivros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livrosPorTitulo.add(livro);
                    break;
                }
            }
        }
        return livrosPorTitulo;
    }


    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorAnos = new ArrayList<>();
        if (!listLivros.isEmpty()) {
            for (Livro livro : listLivros) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    livrosPorAnos.add(livro);
                }
            }
        }
        return livrosPorAnos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CatalogoLivros catalogo = new CatalogoLivros();
        boolean continuar = true;


        while (continuar) {

            System.out.println("""
                    Digite a ação desejada:
                    
                    1 - Adicionar um item;
                    2 - Pesquisar livro por Autor;
                    3 - Pesquisar livro por Título;
                    4 - Pesquisar livro por intervalo de anos;
                    0 - Sair.
                    """);

            int opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.next();
                    System.out.println("Digite o autor do livro: ");
                    String autor = sc.next();
                    System.out.println("Digite o ano do livro: ");
                    int anoPublicacao = sc.nextInt();
                    catalogo.adicionarLivro(titulo, autor, anoPublicacao);
                    break;
                case 2:
                    System.out.println("Digite o autor do livro: ");
                    String pesquisa = sc.next();
                    System.out.println(catalogo.pesquisarPorAutor(pesquisa));
                    break;
                case 3:
                    System.out.println("Digite o título do livro: ");
                    String pesquisaTitulo = sc.next();
                    System.out.println(catalogo.pesquisarPorTitulo(pesquisaTitulo));
                    break;
                case 4:
                    System.out.println("Digite o ano inicial da pesquisa: ");
                    int anoInicial = sc.nextInt();
                    System.out.println("Digite o ano final: ");
                    int anoFinal = sc.nextInt();
                    System.out.println(catalogo.pesquisarPorIntervaloAnos(anoInicial, anoFinal));
                    break;
                case 0:
                    System.out.println("Sua sessão será encerrada...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Valor não conhecido, Tente novamente!");
                    break;
            }
        }
    }
}