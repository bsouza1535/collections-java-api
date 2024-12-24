package main.java.Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoConvidados {

    Set<Convidado> convidadosSet;

    public ConjuntoConvidados() {
        this.convidadosSet = new HashSet<>();
    }

    public void addConvidado(String nome, int codigoDoConvite) {
        this.convidadosSet.add(new Convidado(nome, codigoDoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        for (Convidado convidado : this.convidadosSet) {
            if (convidado.getCodigoDoConvite() == codigoConvite) {
                convidadoParaRemover = convidado;
                break;
            }
        }
        convidadosSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return this.convidadosSet.size();
    }

    public void exibirConvidados(){
        System.out.println(this.convidadosSet);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConjuntoConvidados conjunto = new ConjuntoConvidados();
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                    Digite a ação desejada:
                    
                    1 - Adicionar um convidado;
                    2 - Remover um convidado;
                    3 - Contar quantidade de convidados na lista;
                    4 - Exibir convidados;
                    0 - Sair.
                    """);

            int opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do Convidado: ");
                    String nome = sc.next();
                    System.out.println("Digite o codigo do Convidado: ");
                    int codigoDoConvite = sc.nextInt();
                    conjunto.addConvidado(nome, codigoDoConvite);
                    break;
                case 2:
                    System.out.println("Digite o código do Convidado que deseja remover: ");
                    int codigoDoConviteParaRemover = sc.nextInt();
                    conjunto.removerConvidadoPorCodigoConvite(codigoDoConviteParaRemover);
                    break;
                case 3:
                    System.out.println("O número de convidados na lista é: " + conjunto.contarConvidados());
                    break;
                case 4:
                    System.out.println("Os convidados na lista são: ");
                    conjunto.exibirConvidados();
                    break;
                case 0:
                    System.out.println("Saindo da lista de Convidados...");
                    continuar = false;
                    break;
                default:
                    break;
            }
        }
    }
}
