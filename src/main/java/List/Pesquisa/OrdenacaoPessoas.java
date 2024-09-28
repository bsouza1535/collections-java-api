package main.java.List.Pesquisa;

import java.util.*;

public class OrdenacaoPessoas {

    private List<Pessoa> pessoasList;

    public OrdenacaoPessoas() {
        this.pessoasList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        this.pessoasList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoasList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoasList);
        Collections.sort(pessoasPorAltura, new ordenarPessoasPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
        boolean continuar = true;

        while (continuar) {

            System.out.println("""
                    Digite a ação desejada:
                    
                    1 - Adicionar pessoa;
                    2 - Ordenar pessoas por idade;
                    3 - Ordenar pessoas por altura;
                    0 - Sair.
                    """);

            int opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do pessoa: ");
                    String nome = sc.next();
                    System.out.println("Digite a idade da pessoa: ");
                    int idade = sc.nextInt();
                    System.out.println("Digite a altura da pessoa: ");
                    double altura = sc.nextDouble();
                    ordenacaoPessoas.adicionarPessoa(nome, idade, altura);
                    break;
                case 2:
                    System.out.println("Ordenando lista de pessoas por idade:");
                    System.out.println(ordenacaoPessoas.ordenarPorIdade());
                    break;
                case 3:
                    System.out.println("Ordenando lista de pessoas por altura: ");
                    System.out.println(ordenacaoPessoas.ordenarPorAltura());
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